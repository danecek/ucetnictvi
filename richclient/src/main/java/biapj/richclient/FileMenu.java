/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient;

import biapj.richclient.controller.CreateReaderAction;
import biapj.richclient.controller.ExitAction;
import biapj.util.Messages;
import javafx.scene.control.Menu;

public class FileMenu extends Menu {

    public FileMenu() {
        super(Messages.File.createMessage(), null,
             ExitAction.instance.createMenuItem()
             );
    }

}
