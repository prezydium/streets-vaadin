package org.prezydium.streets.logic;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.prezydium.streets.ui.StreetsUI;
import org.prezydium.streets.ui.view.GuessedLettersDisplay;
import org.prezydium.streets.ui.view.LostWindow;

@RunWith(MockitoJUnitRunner.class)
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