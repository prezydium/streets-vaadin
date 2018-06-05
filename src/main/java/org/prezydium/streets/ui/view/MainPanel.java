package org.prezydium.streets.ui.view;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MainPanel extends Panel {

    private Label guessedWord = new Label("");
    private VerticalLayout verticalLayout = new VerticalLayout();

    public void setGuessedLetters(String s) {
        s = s.replace("", " ").trim();
        this.guessedWord.setCaption(s);
    }

    public MainPanel() {
        guessedWord.setSizeUndefined();
        verticalLayout.addComponent(guessedWord);
        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.setSizeUndefined();
        this.setContent(verticalLayout);
    }
}
