/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient;

import accounts.richclient.controller.CreateAcountAction;
import accounts.richclient.controller.DeleteAcountAction;
import accounts.util.Messages;
import javafx.scene.control.Menu;

public class UcetMenu extends Menu {

    public UcetMenu() {
        super(Messages.Ucty.cm(), null,
                CreateAcountAction.instance.createMenuItem(),
                DeleteAcountAction.instance.createMenuItem()
        );
    }

}
