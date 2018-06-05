package org.prezydium.streets.ui.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.prezydium.streets.logic.GameRound;

public class WinWindow extends AbstractWindow {

    public WinWindow(GameRound gameRound){
        setBodyText("Gratulacje! to była: " + gameRound.getActualGuessedLetters());
    }
}
