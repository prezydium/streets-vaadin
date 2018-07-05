package org.prezydium.streets.logic;

import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class CountdownEngine {

    public static final int TIME_FOR_GUESSING = 60;
    private int remainingTime = TIME_FOR_GUESSING;

    public void countdown(Label label) {
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
                    label.setValue(String.valueOf(remainingTime));
                    if (remainingTime <= 0 && ui.getWindows().isEmpty()) {
                        new LostGame().createInfoWindow((String) ui.getSession().getAttribute("streetToGuess"));
                    }
                });
            }
        });
        thread.start();
    }
}
