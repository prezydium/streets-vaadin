package org.prezydium.streets.logic;

public class HideWord {

    public String hideWord(String streetToGuess){
        if (streetToGuess == null) throw new IllegalArgumentException("Street can't be null");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < streetToGuess.length(); i++){
            stringBuilder.append("X");
        }
        return stringBuilder.toString();
    }
}
