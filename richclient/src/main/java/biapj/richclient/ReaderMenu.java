/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient;

import biapj.richclient.controller.CreateReaderAction;
import biapj.richclient.controller.DeleteReadersAction;
import javafx.scene.control.Menu;

public class ReaderMenu extends Menu {

    public ReaderMenu() {
        super("Readers", null,
                CreateReaderAction.instance.createMenuItem(),
                DeleteReadersAction.instance.createMenuItem()
        );
    }

}
