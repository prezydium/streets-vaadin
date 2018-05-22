package org.prezydium.streets.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.prezydium.streets.logic.GameRound;

@SpringView(name = "")
public class GameView extends VerticalLayout implements View {

    private GameRound gameRound;
    private Label header = new Label("Ulice Gdańska");
    private Label chancesLabel = new Label("");
    private MainPanel mainPanel = new MainPanel();
    private TextField textFieldGuess = new TextField("wpisz literę:");
    private Button makeGuessButton = new Button("Zgadnij!", this::clickSubmitButton);
    private Button aboutButton = new Button("Wyjaśnienia", this::clickAboutButton);
    private Label errors = new Label();

    public GameView() {
        gameRound = new GameRound();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        mainPanel.setGuessedLetters(gameRound.getActualGuessedLetters());
        mainPanel.setWidth("50%");
        setSpacing(true);
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.addComponents(header, aboutButton, chancesLabel, mainPanel, textFieldGuess, makeGuessButton, errors);
    }

    private void clickSubmitButton(Button.ClickEvent clickEvent) {
        if (textFieldGuess.getValue() == null || textFieldGuess.getValue().isEmpty()) {
            errors.setValue("Wpisz jakąś literę");
        } else {
            Character charToGuess = textFieldGuess.getValue().charAt(0);
            gameRound.gameTurn(charToGuess);
            mainPanel.setGuessedLetters(gameRound.getActualGuessedLetters());
            chancesLabel.setCaption(Integer.toString(gameRound.getActualChances()));
        }
    }

    private void clickAboutButton(Button.ClickEvent clickEvent){
        UI.getCurrent().addWindow(new AboutWindow());
    }
}
