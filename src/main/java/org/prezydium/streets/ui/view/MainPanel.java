package org.prezydium.streets.ui.view;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MainPanel extends Panel {

    private Label guessedWord = new Label("");
    private VerticalLayout verticalLayout = new VerticalLayout();

    public void setGuessedLetters(String s) {
        this.guessedWord.setValue(s);
    }

    public MainPanel() {
        setCaption("Ukryta ulica:");
        guessedWord.setSizeUndefined();
        verticalLayout.addComponent(guessedWord);
        verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.setSizeUndefined();
        this.setContent(verticalLayout);
    }
}
