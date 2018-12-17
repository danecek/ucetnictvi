/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient.controller;

import biapj.business.FacadeLocator;
import biapj.model.LibReader;
import biapj.model.ReaderId;
import biapj.richclient.MainWindow;
import biapj.util.LibException;
import java.util.List;
import static java.util.stream.Collectors.*;

public class DeleteReadersAction extends LibAction {

    public static final DeleteReadersAction instance = new DeleteReadersAction();

    private DeleteReadersAction() {
        super("Delete Reader");
    }

    @Override
    public void execute() {
        try {
            List<LibReader> readers = MainWindow.getInstance().selectedReaders();
            List<ReaderId> ids = readers.stream().map((r) -> r.getId()).collect(toList());
            FacadeLocator.getInstance().deleteReaders(ids);
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);
        }
        MainWindow.getInstance().refresh();

    }

}
