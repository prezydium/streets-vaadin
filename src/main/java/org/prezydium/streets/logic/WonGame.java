package org.prezydium.streets.logic;

import com.vaadin.ui.UI;
import org.prezydium.streets.ui.view.WinWindow;

public class WonGame {

    public void guessedAll(GameRound gameRound){
        UI.getCurrent().addWindow(new WinWindow(gameRound));
    }

}
