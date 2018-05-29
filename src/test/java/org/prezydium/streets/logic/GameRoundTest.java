package org.prezydium.streets.logic;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.prezydium.streets.ui.view.GuessedLettersDisplay;

public class GameRoundTest {

    @Test
    public void shouldSuccessfullyHitLetter() {
        String hiddenWord = "xxxxxxxxxx";
        GameRound gameRound = new GameRound("testStreet", hiddenWord, 5);

        gameRound.gameTurn('e', new GuessedLettersDisplay());

        Assertions.assertThat(gameRound.getActualGuessedLetters()).isEqualToIgnoringCase("xexxxxxeex");
    }

    @Test
    public void shouldBeCaseInsensitive() {
        String hiddenWord = "xxxxxxxxxx";
        GameRound gameRound = new GameRound("TeStStReEt", hiddenWord, 5);

        gameRound.gameTurn('e', new GuessedLettersDisplay());

        Assertions.assertThat(gameRound.getActualGuessedLetters()).isEqualToIgnoringCase("xexxxxxeex");
    }


}