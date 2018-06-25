package org.prezydium.streets.ui.view;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class GameClock extends VerticalLayout {

    private volatile Label label = new Label("t");
    private volatile Integer remainingTime = 20;

    public GameClock() {
        label.setValue(String.valueOf(remainingTime));
        this.addComponent(label);
        countdown();
    }

    private void countdown() {
        synchronized (new Object()){
            Thread thread = new Thread(() -> {
                for (int i = 20; i > 0; i--) {
                    remainingTime--;
                    label.setValue(String.valueOf(remainingTime));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }


    }

}
