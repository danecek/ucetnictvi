/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient;

import accounts.model.Account;
import accounts.richclient.controller.ExitAction;
import accounts.util.Messages;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainWindow extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static MainWindow getInstance() {
        return instance;
    }
    
    public LibMenuBar getLibMenuBar() {
        return libMenuBar;
    }
    
    private static MainWindow instance;
    private AccountPane readerPane;
    private LibMenuBar libMenuBar;
    
    public MainWindow() {
        
    }
    
    public void showException(Exception ex) {
        Alert a = new Alert(Alert.AlertType.ERROR, ex.toString());
        a.getDialogPane().setFocusTraversable(true);
        a.setResizable(true);
        a.showAndWait();
    }
    
    public void refresh() {
        readerPane.refresh();
    }
    
    public List<Account> selectedReaders() {
        return readerPane.selected();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(true);
        instance = this;
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                ExitAction.instance.execute();
            }
        });
        primaryStage.setTitle(Messages.Library.cm());
        VBox root = new VBox(libMenuBar = new LibMenuBar(), readerPane = new AccountPane());
        root.setStyle("-fx-font-size:20");
        Scene s = new Scene(root, 800, 600);
        primaryStage.setScene(s);
        primaryStage.show();
    }
    
}
