/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient.controller;

import biapj.richclient.CreateReaderDialog;
import biapj.richclient.MainWindow;
import biapj.util.LibException;
import biapj.util.Messages;

public class CreateReaderAction extends LibAction {

    public static final CreateReaderAction instance = new CreateReaderAction();

    private CreateReaderAction() {
        super(Messages.Create_Reader_Dialog.createMessage());
    }

    @Override
    public void execute() {
        try {
            new CreateReaderDialog().execute();
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);
        }
    }

}
