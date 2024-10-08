package com.example.supleo_lab_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner select;
    EditText et1;
    EditText et2;

    Button clear;
    public void Expense(View view) {
        String title = et1.getText().toString();
        String amountStr = et2.getText().toString();
        String category = select.getSelectedItem().toString();

        if (title.trim().isEmpty() || amountStr.trim().isEmpty() || category.trim().isEmpty()) {
            // Inputs are empty, show an error message using a Toast
            Toast.makeText(this, "Provide Complete Details.", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, NewMainActivity.class);

            float amount = Float.parseFloat(amountStr);


            i.putExtra("title", title);
            i.putExtra("amount", amount);
            i.putExtra("category", category);

            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        select = findViewById(R.id.categories);
        Button btn1 = (Button) findViewById(R.id.button);

        et1 = (EditText) findViewById(R.id.title);
        et2 = (EditText) findViewById(R.id.amount);
        clear = (Button) findViewById(R.id.clear);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.itemselect));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select.setAdapter(myadapter);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                et2.setText("");
                select.setSelection(0);
            }
        });
    }
}