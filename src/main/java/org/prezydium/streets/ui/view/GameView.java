package org.prezydium.streets.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.prezydium.streets.logic.GameRound;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = "game")
public class GameView extends VerticalLayout implements View {

    private GameRound gameRound;
    private Label header = new Label("Ulice Gdańska");
    private Label chancesLabel = new Label("");
    private Label guessedWord = new Label(Integer.toString(gameRound.getActualChances()));
    private TextField textFieldGuess = new TextField("wpisz literę:");

    public GameView() {
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
