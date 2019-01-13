package com.example.kyros.mediumandroidtutorials.part1.step1;

import java.util.Random;

public class BinaryGame1 {
    public static final String CHARS = "01";
    public static final int MESSAGE_LENGTH = 20;

    private StringBuilder messageBuilder;
    private int progressIndex = 0; //how many characters the player has typed

    public BinaryGame1() {
        messageBuilder = new StringBuilder();
        Random rnd = new Random();
        while (messageBuilder.length() < MESSAGE_LENGTH) {
            int index = rnd.nextInt(CHARS.length());
            messageBuilder.append(CHARS.charAt(index));
        }
    }

    public String getMessage() {
        return messageBuilder.toString();
    }

    public int getProgressIndex() {
        return progressIndex;
    }

    public boolean submitChar(char nextChar) {
        boolean isCorrect = nextChar == messageBuilder.charAt(progressIndex);
        if (isCorrect) {
            progressIndex++; //increments the progress if character entered is correct
        } else {
            progressIndex = 0; //reset player's progress if character entered is incorrect
        }
        return isCorrect;
    }

    public boolean hasWon() {
        return progressIndex >= messageBuilder.length();
    }
}
