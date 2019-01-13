package com.example.kyros.mediumandroidtutorials.part1.step1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kyros.mediumandroidtutorials.R;

@SuppressWarnings("Duplicates")
public class BinaryActivity1 extends AppCompatActivity implements View.OnClickListener {
    private BinaryGame1 binaryGame1;
    private TextView inputTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        initializeGame();
        wireWidgets();
    }

    private void initializeGame() {
        binaryGame1 = new BinaryGame1();
    }

    private void wireWidgets() {
        inputTextView = findViewById(R.id.textview_binary_input);
        TextView messageTextView = findViewById(R.id.textview_binary_message);
        messageTextView.setText(binaryGame1.getMessage());
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
                binaryGame1.submitChar(BinaryGame1.CHARS.charAt(0));
                break;
            case R.id.button_binary_1:
                binaryGame1.submitChar(BinaryGame1.CHARS.charAt(1));
        }
        inputTextView.setText(binaryGame1.getMessage().substring(0, binaryGame1.getProgressIndex()));
        if (binaryGame1.hasWon()) {
            //send a toast to notify the user and quit the current activity
            Toast.makeText(this, "You won!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
