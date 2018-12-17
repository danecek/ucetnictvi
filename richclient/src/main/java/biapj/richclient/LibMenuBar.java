package biapj.richclient;

import javafx.scene.control.MenuBar;

public class LibMenuBar extends MenuBar {

    public LibMenuBar() {
        super(new FileMenu(), new ReaderMenu());
    }

}
