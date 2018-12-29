/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient.controller;

import accounts.richclient.CreateAcountDialog;
import accounts.richclient.MainWindow;
import accounts.util.LibException;
import accounts.util.Messages;

public class CreateAcountAction extends LibAction {

    public static final CreateAcountAction instance = new CreateAcountAction();

    private CreateAcountAction() {
        super(Messages.Vytvor_ucet.cm());
    }

    @Override
    public void execute() {
        try {
            new CreateAcountDialog().execute();
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);
        }
    }

}
