package org.prezydium.streets.logic;

import com.vaadin.ui.UI;
import org.prezydium.streets.ui.window.LostWindow;

public class LostGame {

    public void createInfoWindow(String street) {
        UI.getCurrent().addWindow(new LostWindow(street));
    }

}
