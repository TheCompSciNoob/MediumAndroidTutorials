package com.example.kyros.mediumandroidtutorials.part1.step2;

import java.util.Random;

public class BinaryGame2 {
    public static final String CHARS = "01";
    public static final int MESSAGE_LENGTH = 20;

    private StringBuilder messageBuilder;
    private int progressIndex = 0; //how many characters the player has typed
    private GameStateListener gameStateListener;

    public BinaryGame2() {
        messageBuilder = new StringBuilder();
        Random rnd = new Random();
        while (messageBuilder.length() < MESSAGE_LENGTH) {
            int index = rnd.nextInt(CHARS.length());
            messageBuilder.append(CHARS.charAt(index));
        }
    }

    public void setGameStateListener(GameStateListener gameStateListener) {
        this.gameStateListener = gameStateListener;
    }

    public String getMessage() {
        return messageBuilder.toString();
    }

    public int getProgressIndex() {
        return progressIndex;
    }

    public void submitChar(char nextChar) {
        if (progressIndex < MESSAGE_LENGTH && nextChar == messageBuilder.charAt(progressIndex)) {
            progressIndex++; //increments the progress if character entered is correct
        } else {
            progressIndex = 0; //reset player's progress if character entered is incorrect
        }
        if (gameStateListener != null) { //only gives callbacks if the listener is set
            gameStateListener.onProgressIndexChanged(progressIndex);
            if (hasWon()) {
                gameStateListener.onGameEnd(true);
            }
        }
    }

    public boolean hasWon() {
        return progressIndex >= messageBuilder.length();
    }

    public interface GameStateListener {

        void onGameEnd(boolean hasWon);

        void onProgressIndexChanged(int progressIndex);
    }
}
