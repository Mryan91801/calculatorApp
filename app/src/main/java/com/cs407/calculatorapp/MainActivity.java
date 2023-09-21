package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view){
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);

        double num1, num2, result = 0;

        try {
            num1 = Double.parseDouble(number1.getText().toString());
            num2 = Double.parseDouble(number2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        if (view.getId() == R.id.addButton) {
            result = num1 + num2;
        } else if (view.getId() == R.id.subtractButton) {
            result = num1 - num2;
        } else if (view.getId() == R.id.multiplyButton) {
            result = num1 * num2;
        } else if (view.getId() == R.id.divideButton) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        goToActivity(String.valueOf(result));
    }

    public void goToActivity(String result) {
        Intent intent = new Intent(this, ResultScreen.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

}