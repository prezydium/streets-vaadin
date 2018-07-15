package org.prezydium.streets.logic;

import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.UIDetachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountdownEngine {

    public static final int TIME_FOR_GUESSING = 60;
    private int remainingTime = TIME_FOR_GUESSING;
    private Thread countdownThread;
    private static final Logger LOG = LoggerFactory.getLogger(CountdownEngine.class);

    public void countdown(Label label) {
        UI ui = UI.getCurrent();
        countdownThread = new Thread(() -> {
            for (int i = TIME_FOR_GUESSING; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LOG.info("Countdown thread stopped by: ".concat(e.getMessage()));
                }
                try{
                    ui.accessSynchronously(() -> {
                        remainingTime--;
                        label.setValue(String.valueOf(remainingTime));
                        if (remainingTime <= 0 && ui.getWindows().isEmpty()) {
                            new LostGame().createInfoWindow((String) ui.getSession().getAttribute("streetToGuess"));
                        }
                    });
                } catch (UIDetachedException e){
                    LOG.warn("UI has been detached");
                }
            }
        });
        countdownThread.start();
    }
}
