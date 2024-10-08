package com.example.supleo_lab_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewMainActivity extends AppCompatActivity {

    TextView title;
    TextView amount;
    TextView category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);

        title = (TextView) findViewById(R.id.title);
        amount = (TextView) findViewById(R.id.amount);
        category = (TextView) findViewById(R.id.category);

        Intent i = getIntent();
        String data_title = i.getStringExtra("title");
        float data_amount = i.getFloatExtra("amount", 0.0f);
        String data_category = i.getStringExtra("category");

        title.setText(data_title);
        amount.setText(String.valueOf(data_amount));
        category.setText(data_category);
    }

}