package org.prezydium.streets.logic;

import com.vaadin.ui.UI;
import org.prezydium.streets.ui.view.LostWindow;

public class LostGame {

    public boolean createInfoWindow(String street) {
        UI.getCurrent().addWindow(new LostWindow(street));
        return true;
    }

}
