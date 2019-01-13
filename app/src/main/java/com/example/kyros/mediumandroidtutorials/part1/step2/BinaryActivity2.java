package com.example.kyros.mediumandroidtutorials.part1.step2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kyros.mediumandroidtutorials.R;

@SuppressWarnings("Duplicates")
public class BinaryActivity2 extends AppCompatActivity implements View.OnClickListener {
    private BinaryGame2 binaryGame2;
    private TextView inputTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        initializeGame();
        wireWidgets();
    }

    private void initializeGame() {
        binaryGame2 = new BinaryGame2();
        binaryGame2.setGameStateListener(new BinaryGame2.GameStateListener() {
            @Override
            public void onGameEnd(boolean hasWon) {
                if (hasWon) {
                    Toast.makeText(BinaryActivity2.this, "You won!", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onProgressIndexChanged(int progressIndex) {
                inputTextView.setText(binaryGame2.getMessage().substring(0, progressIndex));
            }
        });
    }

    private void wireWidgets() {
        inputTextView = findViewById(R.id.textview_binary_input);
        TextView messageTextView = findViewById(R.id.textview_binary_message);
        messageTextView.setText(binaryGame2.getMessage());
        Button button0 = findViewById(R.id.button_binary_0);
        button0.setOnClickListener(this);
        Button button1 = findViewById(R.id.button_binary_1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //submit the next character the user inputted to the game
        switch (v.getId()) {
            case R.id.button_binary_0:
                binaryGame2.submitChar(BinaryGame2.CHARS.charAt(0));
                break;
            case R.id.button_binary_1:
                binaryGame2.submitChar(BinaryGame2.CHARS.charAt(1));
        }
    }
}
