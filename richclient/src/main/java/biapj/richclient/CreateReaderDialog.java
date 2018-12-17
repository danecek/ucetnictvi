/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient;

import biapj.business.FacadeLocator;
import biapj.model.Address;
import biapj.util.LibException;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreateReaderDialog extends LibAbstractDialog {

    TextField addressTF;
    TextField nameTF;

    public CreateReaderDialog() {
        super("Create Reader");
    }

    @Override
    protected Node createContent() {
        GridPane gp = new GridPane();
        gp.add(nameTF = new TextField("Tom"), 0, 0);
        nameTF.textProperty().addListener(this);
        gp.add(addressTF = new TextField("Praha"), 0, 1);
        return gp;
    }

    @Override
    public void ok() {
        try {
            FacadeLocator.getInstance().createReader(nameTF.getText(),
                    new Address(addressTF.getText()));
            MainWindow.getInstance().refresh();
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);

        }
    }

    @Override
    public void validate() {
        boolean err = true;
        err = nameTF.getText().isEmpty();
        if (err) {
            errortext.setText("error");
        } else {
            errortext.setText("");
        }
        getDialogPane().lookupButton(ButtonType.OK).setDisable(err);
    }

}
