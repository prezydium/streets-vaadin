package org.prezydium.streets.logic;

public class HideWord {

    public static String hideWord(String streetToGuess){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < streetToGuess.length(); i++){
            stringBuilder.append("X");
        }
        return stringBuilder.toString();
    }
}
