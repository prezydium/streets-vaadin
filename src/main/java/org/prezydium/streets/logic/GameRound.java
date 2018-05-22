package org.prezydium.streets.logic;


import org.springframework.stereotype.Component;

@Component
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

    public void gameTurn(Character guessedChar){
        if (actualChances < 0) throw new IllegalStateException("Chances cant be less than 0!") ;
        if (!makeGuess(guessedChar)) actualChances--;
    }

    private boolean makeGuess(Character guessedChar) {
        guessedChar = Character.toUpperCase(guessedChar);
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
