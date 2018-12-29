package accounts.richclient;

import accounts.business.FacadeLocator;
import accounts.model.Account;
import accounts.util.LibException;
import accounts.util.Messages;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public final class AccountPane extends TitledPane {

    private ObservableList<Account> accounts = FXCollections.observableArrayList();
    TableView<Account> tableView;

    public AccountPane() {
        super(Messages.Ucty.cm(), null);
        setContent(tableView = createContent());
    }

    class ReadersRowFactory implements Callback<TableView<Account>, TableRow<Account>> {

        @Override
        public TableRow<Account> call(TableView<Account> p) {
            TableRow<Account> tr = new TableRow<>();
            tr.setOnMouseClicked((MouseEvent t) -> {
                System.out.println(accounts.get(tr.getIndex()));
            });
            return tr;
        }

    }

    private TableView<Account> createContent() {
        TableView<Account> tw = new TableView<>();
        TableColumn<Account, Object> idCol = new TableColumn<>(Messages.Id.cm());
        TableColumn<Account, Object> skupinaCol = new TableColumn<>(Messages.Skupina.cm());
        TableColumn<Account, Object> cisloCol = new TableColumn<>(Messages.Cislo.cm());
        TableColumn<Account, Object> nameCol = new TableColumn<>(Messages.Jmeno.cm());
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        skupinaCol.setCellValueFactory(new PropertyValueFactory<>("skupina"));
        cisloCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Account, Object>, ObservableValue<Object>>() {
            @Override
            public ObservableValue<Object> call(TableColumn.CellDataFeatures<Account, Object> p) {
                return new SimpleObjectProperty(p.getValue().getNumber());
            }
        });
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        tw.getColumns().addAll(idCol, skupinaCol, cisloCol, nameCol);
        tw.setItems(accounts);
        //   tw.setRowFactory(new ReadersRowFactory());
        //    tw.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return tw;
    }

    public void refresh() {
        try {
            accounts.setAll(FacadeLocator.getInstance().getAllAccounts());
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);
        }
    }

    public List<Account> selected() {
        return tableView.getSelectionModel().getSelectedItems();
    }

}
