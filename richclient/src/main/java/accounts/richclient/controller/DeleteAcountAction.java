/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.richclient.controller;

import accounts.business.FacadeLocator;
import accounts.model.Account;
import accounts.model.AccountId;
import accounts.richclient.MainWindow;
import accounts.util.LibException;
import accounts.util.Messages;
import java.util.List;
import static java.util.stream.Collectors.*;

public class DeleteAcountAction extends LibAction {

    public static final DeleteAcountAction instance = new DeleteAcountAction();

    private DeleteAcountAction() {
        super(Messages.Zrus_ucet.cm());
    }

    @Override
    public void execute() {
        try {
            List<Account> readers = MainWindow.getInstance().selectedReaders();
            List<AccountId> ids = readers.stream().map((r) -> r.getId()).collect(toList());
            FacadeLocator.getInstance().deleteReaders(ids);
        } catch (LibException ex) {
            MainWindow.getInstance().showException(ex);
        }
        MainWindow.getInstance().refresh();

    }

}
