package org.prezydium.streets.ui.view;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.prezydium.streets.logic.GameRound;

@SpringView(name = GameView.VIEW_NAME)
public class GameView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "game";
    private GameRound gameRound;
    private Label header = new Label("Ulice Gdańska");
    private MainPanel mainPanel = new MainPanel();
    private Label labelForTextField = new Label("Wpisz literę (lub inny symbol) i naciśnij enter:");
    private TextField textFieldGuess = new TextField();
    private Button makeGuessButton = new Button("Zgadnij!", this::clickSubmitButton);
    private HorizontalLayout textWithButton = new HorizontalLayout();
    private GuessedLettersDisplay guessedLettersDisplay = new GuessedLettersDisplay();
    private Label errors = new Label();
    private GameClock gameClock;

    public GameView() {
        gameRound = new GameRound();
        mainPanel.setGuessedLetters(gameRound.getActualGuessedLetters());
        mainPanel.setSizeUndefined();
        mainPanel.setStyleName("street-display");
        textFieldGuess.setMaxLength(1);
        makeGuessButton.addShortcutListener(shortcutListener);
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        textWithButton.addComponents(textFieldGuess, makeGuessButton);
        textWithButton.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        gameClock = new GameClock();
        this.addComponents(header, mainPanel, labelForTextField, textWithButton, gameClock, errors, guessedLettersDisplay);
    }

    private ShortcutListener shortcutListener = new ShortcutListener("Enter", ShortcutAction.KeyCode.ENTER, null) {
        @Override
        public void handleAction(Object o, Object o1) {
            clickSubmitButton(new Button.ClickEvent(makeGuessButton));
        }
    };

    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        if (textFieldGuess.getValue() == null || textFieldGuess.getValue().isEmpty()) {
            errors.setValue("Wpisz jakąś literę");
        } else {
            Character charToGuess = textFieldGuess.getValue().charAt(0);
            gameRound.gameTurn(charToGuess, guessedLettersDisplay);
            mainPanel.setGuessedLetters(gameRound.getActualGuessedLetters());
            textFieldGuess.setValue("");
            textFieldGuess.focus();
        }
    }
}
