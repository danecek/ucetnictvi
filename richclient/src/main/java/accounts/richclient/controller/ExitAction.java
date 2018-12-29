/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient.controller;

import accounts.util.Messages;
import java.util.logging.Logger;
import javafx.application.Platform;

public class ExitAction extends LibAction {

    private static final Logger LOG = Logger.getLogger(ExitAction.class.getName());
    public static final ExitAction instance = new ExitAction();


    private ExitAction() {
        super(Messages.Exit.cm());
    }

    @Override
    public void execute() {
        Platform.exit();
    }

}
