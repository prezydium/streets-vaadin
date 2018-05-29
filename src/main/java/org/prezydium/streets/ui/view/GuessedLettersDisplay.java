package org.prezydium.streets.ui.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class GuessedLettersDisplay extends VerticalLayout {

    private HorizontalLayout horizontalLayout = new HorizontalLayout();

    private String remainingChances = "Pozostało Ci szans: ";
    private Label remainingChancesLabel = new Label();

    private String hitLetters = "Póki co trafiłeś litery: ";
    private String missedLetters = "Tych liter na pewno nie ma: ";

    private Label guessedHitLettersDisplay = new Label(hitLetters);
    private Label guessedMissedLettersDisplay = new Label(missedLetters);

    public GuessedLettersDisplay() {
        remainingChancesLabel.setCaption(remainingChances + 10);
        addComponents(remainingChancesLabel, guessedHitLettersDisplay, guessedMissedLettersDisplay);
    }

    public void actualise(Character charToGuess, Integer chancesLeft, boolean hit) {
        remainingChancesLabel.setCaption(remainingChances + Integer.toString(chancesLeft));
        if (hit) {
            hitLetters = hitLetters + charToGuess;
            guessedHitLettersDisplay.setCaption(hitLetters);
        } else {
            missedLetters = missedLetters + charToGuess;
            guessedMissedLettersDisplay.setCaption(missedLetters);
        }
    }
}
