/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient;

import biapj.business.FacadeLocator;
import biapj.model.LibReader;
import biapj.util.LibException;
import java.util.List;
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

public final class ReaderPane extends TitledPane {

    private ObservableList<LibReader> readers = FXCollections.observableArrayList();
    TableView<LibReader> tableView;

    public ReaderPane() {
        super("Readers", null);
        setContent(tableView = createContent());
    }

    class ReadersRowFactory implements Callback<TableView<LibReader>, TableRow<LibReader>> {

        @Override
        public TableRow<LibReader> call(TableView<LibReader> p) {
            TableRow<LibReader> tr = new TableRow<>();
            tr.setOnMouseClicked((MouseEvent t) -> {
                System.out.println(readers.get(tr.getIndex()));

            });
            return tr;
        }

    }

    private TableView<LibReader> createContent() {
        TableView<LibReader> tw = new TableView<>();
        TableColumn<LibReader, Object> idCol = new TableColumn<>("Id");
        TableColumn<LibReader, Object> nameCol = new TableColumn<>("Name");
        TableColumn<LibReader, Object> addressCol = new TableColumn<>("Address");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        tw.getColumns().addAll(idCol, nameCol, addressCol);
        tw.setItems(readers);
        tw.setRowFactory(new ReadersRowFactory());
        tw.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return tw;
    }

    public void refresh() {
        try {
            readers.setAll(FacadeLocator.getInstance().getAllReaders());
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);
        }
    }

    public List<LibReader> selected() {
        return tableView.getSelectionModel().getSelectedItems();
    }

}
