package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "{\n [\n  Name : "+person.getName()+"\n  Age : "+person.getAge()+"\n  Email : "+person.getEmail()+"\n  City : "+person.getCity()+"\n ]\n}";
        tvObject.setText(text);

    }
}
