package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtLength;
    private EditText edtWidth;
    private EditText edtHeight;
    private Button btnCalculate;
    private TextView tv_result1;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtLength = findViewById(R.id.edt_length); //mengambil value panjang
        edtWidth = findViewById(R.id.edt_width); //mengambil value lebar
        edtHeight = findViewById(R.id.edt_height); //mengambil value tinggi

        btnCalculate = findViewById(R.id.but_hitung);

        tv_result1 = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);


        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tv_result1.setText(result);
        }
    }


    @Override

    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tv_result1.getText().toString());
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.but_hitung) {

            // save input in variable
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();


            boolean isEmptyFields = false;

            //check nullity value on instance

            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                double Volume = Double.valueOf(inputLength)*Double.valueOf(inputWidth)*Double.valueOf(inputHeight);
                tv_result1.setText(String.valueOf(Volume));
            }




        }

    }
}
