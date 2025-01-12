package com.amicus.dz23_tipcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckDescription checkDescription = new CheckDescription();
    CheckCalculator tipCalculator = new CheckCalculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText eTextCheck = findViewById(R.id.editTextCheck);
        EditText eTextNumGuests = findViewById(R.id.editTextNumGuests);
        SeekBar sBarTip = findViewById(R.id.sBarTip);
        TextView tViewTip = findViewById(R.id.tViewTip);
        TextView tViewTipAmount = findViewById(R.id.tViewTipAmount);
        TextView tViewPaymentCheck = findViewById(R.id.tViewPaymentCheck);
        TextView tViewSplitCheck = findViewById(R.id.tViewSplitCheck);
        Button btnPayment = findViewById(R.id.btnPyament);
        Button btnReset = findViewById(R.id.btnReset);
        Button btnExit = findViewById(R.id.btnExit);
        eTextCheck.addTextChangedListener(new TextWatcher() {   // при вводе-изменении  чека
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {// метод обрабатывающий изменение в EditText
               float check=0;
                try{check=Float.parseFloat(eTextCheck.getText().toString().trim());}catch (NumberFormatException e){}
                checkDescription.setCheck(check);
                tipCalculator.calculate(checkDescription);
                tViewTipAmount.setText(String.valueOf(checkDescription.getTipAmount())+" руб.");
                tViewPaymentCheck.setText(String.valueOf(checkDescription.getPaymentCheck())+" руб.");
                tViewSplitCheck.setText(String.valueOf(checkDescription.getSplitCheck())+" руб.");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        eTextNumGuests.addTextChangedListener(new TextWatcher() {// при вводе-изменении  числа гостей
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int num=1;
                try
                {
                    num=Integer.parseInt(eTextNumGuests.getText().toString().trim());

                }catch (NumberFormatException e){e.getMessage();}
                if(num<1){ eTextNumGuests.setText(null);}
                else {
                    checkDescription.setNumGuests(num);
                    tipCalculator.calculate(checkDescription);
                    tViewTipAmount.setText(String.valueOf(checkDescription.getTipAmount())+" руб.");
                    tViewPaymentCheck.setText(String.valueOf(checkDescription.getPaymentCheck())+" руб.");
                    tViewSplitCheck.setText(String.valueOf(checkDescription.getSplitCheck())+" руб.");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {// при изменении положения ползунка слайдера
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // обрабатываем изменение

                checkDescription.setTipPercent(sBarTip.getProgress());
                tViewTip.setText(checkDescription.getTipPercent()+" %");
                tipCalculator.calculate(checkDescription);
                tViewTipAmount.setText(String.valueOf(checkDescription.getTipAmount())+" руб.");
                tViewPaymentCheck.setText(String.valueOf(checkDescription.getPaymentCheck())+" руб.");
                tViewSplitCheck.setText(String.valueOf(checkDescription.getSplitCheck())+" руб.");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnReset.setOnClickListener(b->{
            tipCalculator.reset(checkDescription);
            sBarTip.setProgress(checkDescription.getTipPercent());
            eTextCheck.setText(null);
            eTextNumGuests.setText(null);
        });
        btnExit.setOnClickListener(b->{finish();});
    }
}