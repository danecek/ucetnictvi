package accounts.richclient;

import accounts.business.FacadeLocator;
import accounts.model.Account;
import accounts.model.AccountGroup;
import accounts.util.LibException;
import accounts.util.Messages;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreateAcountDialog extends LibAbstractDialog {

    private ComboBox skupinaCB;
    private TextField noTF;
    private TextField nameTF;
    private ObservableList<AccountGroup> groups;
    private List<Account> accounts;

    public CreateAcountDialog() throws LibException {
        super(Messages.Vytvor_ucet.cm());
        accounts = FacadeLocator.getInstance().getAllAccounts();
    }

    @Override
    protected Node createContent() {
        GridPane gp = new GridPane();
        groups = FXCollections.observableArrayList(AccountGroup.values());
        gp.add(new Label(Messages.Skupina.cm() + DEL), 0, 0);
        gp.add(skupinaCB = new ComboBox(groups), 1, 0);
        gp.add(new Label(Messages.Cislo.cm() + DEL), 0, 1);
        gp.add(noTF = new TextField(), 1, 1);
        gp.add(new Label(Messages.Nazev.cm() + DEL), 0, 2);
        gp.add(nameTF = new TextField(), 1, 2);

        nameTF.textProperty().addListener(this);
        noTF.textProperty().addListener(this);
        skupinaCB.setOnAction((Event t) -> {
            validate();
        });
        return gp;
    }

    @Override
    public void ok() {
        try {
            FacadeLocator.getInstance().createReader((AccountGroup) skupinaCB.getValue(),
                    Integer.parseInt(noTF.getText()),
                    nameTF.getText());
            MainWindow.getInstance().refresh();
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);

        }
    }

    @Override
    public void validate() {
        String message = "";

        if (nameTF.getText().isBlank()) {
            message = "prazdne jmeno";
        }

        try {
            int no = Integer.parseInt(noTF.getText());
            AccountGroup g = (AccountGroup) skupinaCB.getValue();
            if (g != null) {
                for (Account a : accounts) {
                    if (a.getNumber().equals(g.toString() + no)) {
                        message = "duplicitni cislo uctu";
                    }

                }
            }
        } catch (NumberFormatException ne) {
            message = "neplatne cislo";
        }
        if (skupinaCB.getValue() == null) {
            message = "neplatna skupina";
        }

        errortext.setText(message.isEmpty() ? "" : Messages.Chyba.cm() + ": " + message);
        getDialogPane().lookupButton(ButtonType.OK).setDisable(!message.isBlank());
    }

}
