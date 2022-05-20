package com.example.midexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var payBtn =  findViewById(R.id.pay_btn) as Button;
        payBtn.setOnClickListener{
            var userName = (findViewById(R.id.user_name) as EditText).text;
            var cardMonth = (findViewById(R.id.card_month) as EditText).text;
            var cardYear = (findViewById(R.id.card_year) as EditText).text;
            var cardCVV = (findViewById(R.id.card_cvv) as EditText).text;

            var cardN1 = (findViewById(R.id.card_1_4) as EditText).text;
            var cardN2 = (findViewById(R.id.card_2_4) as EditText).text;
            var cardN3 = (findViewById(R.id.card_3_4) as EditText).text;
            var cardN4 = (findViewById(R.id.card_4_4) as EditText).text;

            var cardNumber: String = "" + cardN1 + cardN2 + cardN3 + cardN4;

            if(userName.isEmpty()
                || cardNumber.isEmpty()
                || cardMonth.isEmpty()
                || cardYear.isEmpty()
                || cardCVV.isEmpty()
            ){
                Toast.makeText(this, "fill every field!", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }
            if(cardNumber.length < 16){
                Toast.makeText(this, "card number is invalid!", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }
            var month = cardMonth.toString().toInt();
            var year =  cardYear.toString().toInt();
            if ( month< 0
                || month > 12
                || year < 2000
                || Calendar.getInstance().get(Calendar.YEAR) < year) {
                Toast.makeText(this, "card date is invalid!", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }
            if(cardCVV.length<3){
            Toast.makeText(this, "card CVV is invalid!", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }

            Toast.makeText(this, "payment was successful!", Toast.LENGTH_SHORT).show();
        }
    }
}