package org.prezydium.streets.ui.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import org.prezydium.streets.logic.CountdownEngine;


public class GameClock extends HorizontalLayout {

    private Label clockDescription = new Label("Pozostało Ci : ");
    private volatile Label labelWithTime = new Label("t");
    private Label endOfDescription = new Label("sekund. Powodzenia!");
    private CountdownEngine countdownEngine = new CountdownEngine();

    public GameClock() {
        labelWithTime.setValue(String.valueOf(CountdownEngine.TIME_FOR_GUESSING));
        this.addComponents(clockDescription, labelWithTime, endOfDescription);
        countdown();
    }

    private void countdown() {
        countdownEngine.countdown(labelWithTime);
    }
}
