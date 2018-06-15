package org.prezydium.streets.logic;


import org.prezydium.streets.ui.StreetsUI;
import org.prezydium.streets.ui.view.GuessedLettersDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class GameRound {

    private String streetToGuess = new RandomStreet().getRandomStreet();

    private String actualGuessedLetters;

    private static final int STARTING_CHANCES = 10;

    private int actualChances;

    public String getActualGuessedLetters() {
        return actualGuessedLetters;
    }

    public int getActualChances() {
        return actualChances;
    }

    public GameRound() {
        actualGuessedLetters = HideWord.hideWord(streetToGuess);
        actualChances = STARTING_CHANCES;
    }

    public GameRound(String streetToGuess, String actualGuessedLetters, int actualChances) {
        this.streetToGuess = streetToGuess;
        this.actualGuessedLetters = actualGuessedLetters;
        this.actualChances = actualChances;
    }

    public void gameTurn(Character guessedChar, GuessedLettersDisplay guessedLettersDisplay) {
        if (actualChances < 0) throw new IllegalStateException("Chances cant be less than 0!");
        boolean hit = false;
        if (!makeGuess(guessedChar)) {
            actualChances--;
        } else {
            hit = true;
        }
        guessedLettersDisplay.actualise(guessedChar, actualChances, hit);
        if (actualChances <= 0) {
            new LostGame().createInfoWindow(streetToGuess);
            StreetsUI.resetGame();
        }
        if (!actualGuessedLetters.contains("X")) {
            new WonGame().guessedAll(this);
            StreetsUI.resetGame();
        }
    }

    private boolean makeGuess(Character guessedChar) {
        guessedChar = Character.toUpperCase(guessedChar);
        streetToGuess = streetToGuess.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder(actualGuessedLetters);
        int x = streetToGuess.indexOf(guessedChar);
        if (x == -1) {
            return false;
        } else {
            while (x > -1) {
                stringBuilder.setCharAt(x, guessedChar);
                x = streetToGuess.indexOf(guessedChar, x + 1);
            }
        }
        actualGuessedLetters = stringBuilder.toString();
        return true;
    }
}
