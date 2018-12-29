/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient;

import accounts.richclient.controller.CreateAcountAction;
import accounts.richclient.controller.ExitAction;
import accounts.util.Messages;
import javafx.scene.control.Menu;

public class FileMenu extends Menu {

    public FileMenu() {
        super(Messages.File.cm(), null,
             ExitAction.instance.createMenuItem()
             );
    }

}
