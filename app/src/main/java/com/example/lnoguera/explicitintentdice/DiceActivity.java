package com.example.lnoguera.explicitintentdice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    public static final String KEY_TOTAL = "total";
    private Random random = new Random();
    public static final String KEY_NUM_DICE = "num_dice";
    private int total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        Button btnDone = (Button) findViewById(R.id.btnDone);

        int numDice = getIntent().getIntExtra(KEY_NUM_DICE, 2);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra(KEY_TOTAL, total);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

        rollAll(tvResult, numDice);

    }

    private void rollAll(TextView tv, int numDice){
        StringBuilder builder = new StringBuilder();
        total = 0;
        for(int i = 0; i < numDice; i++){
            int result = rollOne();
            total += result;

            if (i > 0){
                builder.append(" + ");
            }

            builder.append(result);
        }

        if(numDice > 1){
            builder.append(" = ");
            builder.append(total);
        }

        tv.setText(builder.toString());


    }

    private int rollOne() {
        return random.nextInt(6) + 1;
    }
}
