package com.example.lnoguera.explicitintentdice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    private Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        TextView tvResult = (TextView) findViewById(R.id.tvResult);

        int result = rollOne();

        String text = String.valueOf(result);
        tvResult.setText(text);

    }

    private int rollOne() {
        return random.nextInt(6) + 1;
    }
}
