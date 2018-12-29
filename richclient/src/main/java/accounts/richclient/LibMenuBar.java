package accounts.richclient;

import javafx.scene.control.MenuBar;

public class LibMenuBar extends MenuBar {

    public LibMenuBar() {
        super(new FileMenu(), new UcetMenu());
    }

}
