package com.example.java_proje;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;


import androidx.appcompat.app.AppCompatActivity;



public class ConverterActivity extends AppCompatActivity {
    private EditText decimalEditText, byteEditText, celciusEditText;
    private Spinner sprTo, sprTo2;
    private RadioButton fahrenheitRadioButton, kelvinRadioButton;
    private Button btnConvert, btnConvert2, btnConvert3;
    private TextView resultText, resultText2, resultText3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        decimalEditText = findViewById(R.id.txtdecimal);
        byteEditText = findViewById(R.id.txtbyte);
        celciusEditText = findViewById(R.id.txtcelcius);

        sprTo = findViewById(R.id.spto);
        sprTo2 = findViewById(R.id.spto2);

        fahrenheitRadioButton = findViewById(R.id.radioButtonFahrenheit);
        kelvinRadioButton = findViewById(R.id.radioButtonKelvin);

        btnConvert = findViewById(R.id.btn1);
        btnConvert2 = findViewById(R.id.btn2);
        btnConvert3 = findViewById(R.id.btn3);

        resultText = findViewById(R.id.resultText);
        resultText2 = findViewById(R.id.resultText2);
        resultText3 = findViewById(R.id.resultText3);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.conversion_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprTo.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.byte_conversion_options,
                android.R.layout.simple_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprTo2.setAdapter(adapter2);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDecimal();
            }
        });
        btnConvert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertByte();
            }
        });
        btnConvert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertDecimal() {
        String input = decimalEditText.getText().toString();
        if (!input.isEmpty()) {
            int decimalValue = Integer.parseInt(input);

            String selectedItem = sprTo.getSelectedItem().toString();
            switch (selectedItem) {
                case "Binary":
                    resultText.setText(Integer.toBinaryString(decimalValue));
                    break;
                case "Octal":
                    resultText.setText(Integer.toOctalString(decimalValue));
                    break;
                case "Hexadecimal":
                    resultText.setText(Integer.toHexString(decimalValue));
                    break;
                default:
                    resultText.setText("Geçersiz işlem");
            }
        }
    }

    private void convertByte(){
        String input=byteEditText.getText().toString();
        if (!input.isEmpty()){
            int byteValue=Integer.parseInt(input);

            String selectedItem=sprTo2.getSelectedItem().toString();
            switch(selectedItem){
                case "Kibibyte":
                    resultText2.setText(String.valueOf(byteValue/1024));
                    break;
                case "Megabyte":
                    resultText2.setText(String.valueOf(byteValue/(1024*1024)));
                    break;
                case "Kilobyte":
                    resultText2.setText(String.valueOf(byteValue/1000));
                    break;
                default:
                    resultText2.setText("Geçersiz işlem");
            }
        }


    }
    private void convertTemperature(){
        String input=celciusEditText.getText().toString();
        if(!input.isEmpty()){
            double celciusValue=Double.parseDouble(input);

            if(fahrenheitRadioButton.isChecked()){
                double fahrenheitValue=(celciusValue*9/5)+32;
                resultText3.setText(String.valueOf(fahrenheitValue));
                fahrenheitRadioButton.setChecked(!fahrenheitRadioButton.isChecked());
            }
            else if(kelvinRadioButton.isChecked()){
                double kelvinValue=celciusValue+273.15;
                resultText3.setText(String.valueOf(kelvinValue));
                kelvinRadioButton.setChecked(!kelvinRadioButton.isChecked());
            }
            else{
                resultText3.setText("farhrenheit veya kelvinden birini seçiniz");
            }
        }

    }
}
