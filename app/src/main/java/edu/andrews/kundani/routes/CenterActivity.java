package edu.andrews.kundani.routes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CenterActivity extends AppCompatActivity {


    public static ArrayList<Information> informationArrayList = new ArrayList<Information>();
    Information someInfo = new Information();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        //get name
        EditText nameHolder = (EditText) findViewById(R.id.centerNameTextView);
        nameHolder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //informationArrayList.add(editable);
                someInfo.setName(editable.toString());
            }
        });

        //get phone number
        EditText phoneNUmberHolder = (EditText) findViewById(R.id.centerNumberTextView);
        phoneNUmberHolder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                someInfo.setPhoneNumber(editable.toString());

            }
        });

        //get address
        EditText locationHolder = (EditText) findViewById(R.id.centerLocation);
        locationHolder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                someInfo.setLocation(editable.toString());

            }
        });

        CheckBox foodCheckbox = (CheckBox) findViewById(R.id.foodNWaterCheckbox);
        CheckBox clothingCheckbox = (CheckBox) findViewById(R.id.clothesCheckbox);
        CheckBox toiletriesCheckbox = (CheckBox) findViewById(R.id.toiletriesCheckbox);
        CheckBox shoesCheckbox = (CheckBox) findViewById(R.id.shoesCheckbox);
        CheckBox blanketCheckbox = (CheckBox) findViewById(R.id.blanketCheckbox);

        //redirect to main activity after center has entered info
        Button submitButton = (Button) findViewById(R.id.comCenSubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(CenterActivity.this, TabActivity.class);
                Toast.makeText(CenterActivity.this, "Thank you!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        informationArrayList.add(someInfo);
    }
}
