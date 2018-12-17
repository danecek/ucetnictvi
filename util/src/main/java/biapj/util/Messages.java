/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public enum Messages {
    MyBook,
    MyReader,
    File,
    Add_Reader, Module, Library, Exit, Create_Reader_Dialog;

    private static final ResourceBundle rb = ResourceBundle.getBundle("biapj.util.messages", new Locale("cs"));

    public String createMessage(Object... args) {
        try {
           return MessageFormat.format(rb.getString(this.name()), args);
        } catch (MissingResourceException mre) {
            LOG.warning(mre.toString());
            return name().replace("_", " ");
        }
    }
    private static final Logger LOG = Logger.getLogger(Messages.class.getName());
}
