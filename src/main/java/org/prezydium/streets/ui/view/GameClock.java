package org.prezydium.streets.ui.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;


public class GameClock extends HorizontalLayout {

    private Label clockDescription = new Label("Pozostało Ci : ");
    private volatile Label labelWithTime = new Label("t");
    private Label endOfDescription = new Label("sekund. Powodzenia!");
    private final int TIME_FOR_GUESSING = 60;
    private volatile Integer remainingTime = TIME_FOR_GUESSING;

    public GameClock() {
        labelWithTime.setValue(String.valueOf(remainingTime));
        this.addComponents(clockDescription, labelWithTime, endOfDescription);
        countdown();
    }

    private void countdown() {
        UI ui = UI.getCurrent();
        Thread thread = new Thread(() -> {
            for (int i = TIME_FOR_GUESSING; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ui.accessSynchronously(() -> {
                    remainingTime--;
                    labelWithTime.setValue(String.valueOf(remainingTime));
                });
            }
        });
        thread.start();
   }
}
