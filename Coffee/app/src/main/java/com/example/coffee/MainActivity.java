package com.example.coffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        String inputName = name.getText().toString();
        CheckBox creamCheckbox = (CheckBox) findViewById(R.id.notify_me_checkbox);
        boolean isChecked = creamCheckbox.isChecked();
        String order = "Total " + "$" + (quantity * 5);
        display(quantity);
        displayPrice(order,isChecked,inputName);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    private void displayPrice(String number, boolean isChecked, String inputName) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(inputName + "\n" +number + "\n" + isChecked);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}