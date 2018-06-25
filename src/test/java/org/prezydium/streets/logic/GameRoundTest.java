package org.prezydium.streets.logic;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.prezydium.streets.ui.view.GuessedLettersDisplay;

@RunWith(MockitoJUnitRunner.class)
public class GameRoundTest {

    @Test
    public void shouldSuccessfullyHitLetter() {
        String hiddenWord = "XXXXXXXXXX";
        GameRound gameRound = new GameRound("testStreet", hiddenWord, 5);

        gameRound.gameTurn('e', new GuessedLettersDisplay());

        Assertions.assertThat(gameRound.getActualGuessedLetters()).isEqualToIgnoringCase("XeXXXXXeeX");
    }

    @Test
    public void shouldBeCaseInsensitive() {
        String hiddenWord = "XXXXXXXXXX";
        GameRound gameRound = new GameRound("TeStStReEt", hiddenWord, 5);

        gameRound.gameTurn('e', new GuessedLettersDisplay());

        Assertions.assertThat(gameRound.getActualGuessedLetters()).isEqualToIgnoringCase("xexxxxxeex");
    }
}