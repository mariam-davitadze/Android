package com.example.hm5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var runDistance: TextView
    lateinit var swimDistance: TextView
    lateinit var burnCalories: TextView
    lateinit var averageRunDistance: TextView
    lateinit var avarageSwimDistance: TextView
    lateinit var avarageBurnCalories: TextView
    lateinit var sumRunDistance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runDistance = findViewById(R.id.input1)
        swimDistance = findViewById(R.id.input2)
        burnCalories = findViewById(R.id.input3)
        averageRunDistance = findViewById(R.id.textView4)
        avarageSwimDistance = findViewById(R.id.textView5)
        avarageBurnCalories = findViewById(R.id.textView6)
        sumRunDistance = findViewById(R.id.textView7)
        UpdateData()
    }

    fun AddData(view: View) {
        if (TextUtils.isEmpty(runDistance.text)){
            runDistance.setError("error");
            return;
        }
        if (TextUtils.isEmpty(swimDistance.text)){
            swimDistance.setError("error")
            return;
        }
        if (TextUtils.isEmpty(swimDistance.text)){
            swimDistance.setError("error")
            return;
        }
        Controller.instance.db.getWorkoutData().add(Data(0, runDistance.text.toString().toInt(), swimDistance.text.toString().toInt(), burnCalories.text.toString().toInt() ))
        UpdateData()
    }

    fun UpdateData (){
        val sumRun= Controller.instance.db.getWorkoutData().getRunDistanceSum().toString()
        sumRunDistance.text = sumRun
        val averageRun = Controller.instance.db.getWorkoutData().getAverageRunDistance().toString()
        averageRunDistance.text= averageRun
        val averageSwim = Controller.instance.db.getWorkoutData().getAverageSwimDistance().toString()
        avarageSwimDistance.text = averageSwim
        val averageCalories = Controller.instance.db.getWorkoutData().getAverageBurnCalories().toString()
        avarageBurnCalories.text = averageCalories;

    }
}

