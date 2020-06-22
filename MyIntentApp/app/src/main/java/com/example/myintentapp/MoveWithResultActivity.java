package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveWithResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_VALUE = 100;


    private Button btnChoose;
    private RadioGroup rgNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_result);

        btnChoose = findViewById(R.id.btn_choose);
        rgNumber = findViewById(R.id.rg_number);

        btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_choose ) {
            if (rgNumber.getCheckedRadioButtonId() != 0 ) {
                int value = 0;

                switch (rgNumber.getCheckedRadioButtonId()) {

                    case R.id.rb_50:
                        value = 50;
                        break;

                    case R.id.rb_100:
                        value = 100;
                        break;


                    case R.id.rb_150:
                        value = 150;
                        break;

                    case R.id.rb_200:
                        value = 200;
                        break;
                }


                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_VALUE, resultIntent);
                finish();
            }

        }

    }
}
