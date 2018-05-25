package org.prezydium.streets.logic;

import com.vaadin.ui.UI;
import org.prezydium.streets.ui.view.LostWindow;
import org.springframework.stereotype.Component;

public class LostGame {

    public LostGame(String street){
        UI.getCurrent().addWindow(new LostWindow(street));
        }

}
