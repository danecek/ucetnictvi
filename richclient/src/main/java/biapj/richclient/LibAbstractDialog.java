/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.richclient;

import biapj.util.LibException;
import java.util.Optional;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class LibAbstractDialog extends Dialog<ButtonType> implements InvalidationListener {

    Text errortext;

    public LibAbstractDialog(String title) {
        setTitle(title);
        errortext = new Text();
        errortext.setStroke(Color.RED);
        getDialogPane().setContent(new VBox(createContent(), errortext));
        getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        setResizable(true);
        validate();
    }

    protected abstract Node createContent();

    public abstract void ok() throws LibException;

    public void execute() throws LibException {
        Optional<ButtonType> btn = showAndWait();
        if (!btn.isPresent() || btn.get() == ButtonType.CANCEL) {
            return;
        }
        ok();
    }

    public abstract void validate();

    @Override
    public void invalidated(Observable observable) {
        validate();
    }

}
