package com.example.lnoguera.explicitintentdice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnRoll;
    private static final int REQUEST_CODE = 1000;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRoll = (Button) findViewById(R.id.btnRoll);
        result = (TextView) findViewById(R.id.result);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }


    private void rollDice() {
        Intent i = new Intent(this, DiceActivity.class);
        i.putExtra(DiceActivity.KEY_NUM_DICE, 3);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            int total = data.getIntExtra(DiceActivity.KEY_TOTAL, 0);
            result.setText(String.valueOf(total));
            result.setVisibility(View.VISIBLE);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
