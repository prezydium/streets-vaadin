package org.prezydium.streets.logic;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HideWordTest {

    private HideWord hideWord;

    @Before
    public void setUp(){
        hideWord = new HideWord();
    }

    @Test
    public void shouldReturnStringAsXXX() throws Exception {
        //given
        String stringToHide = "testOne";
        String expected = "XXXXXXX";
        //when
        String actual = hideWord.hideWord(stringToHide);
        //then
        Assert.assertEquals(expected , actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shoulThrowExceptionWhenEmptyString() throws Exception {
        //given
        String stringToHide = null;
        //when
        String actual = hideWord.hideWord(stringToHide);
    }


}

/*public class HideWord {

    public static String hideWord(String streetToGuess){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < streetToGuess.length(); i++){
            stringBuilder.append("X");
        }
        return stringBuilder.toString();
    }
}*/