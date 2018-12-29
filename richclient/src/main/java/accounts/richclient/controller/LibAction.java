/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public abstract class LibAction {

    public LibAction(String name) {
        this.name = name;
    }

    String name;

    public abstract void execute();

    public MenuItem createMenuItem() {
        MenuItem mi = new MenuItem(name);
        mi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                execute();
            }
        });
        return mi;
    }

}
