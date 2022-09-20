package com.example.myapplication

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.chrono.ChronoLocalDateTime

var Weath : MutableList<Weather> = mutableListOf()
private lateinit var Date: EditText
private lateinit var  Day_weather: EditText
private lateinit var  Night_weather: EditText
private lateinit var Enrol_button : Button
class MainActivity2 : AppCompatActivity() {
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getWeather()
        Date = findViewById(R.id.date_editText)
        Day_weather = findViewById(R.id.dayweather_editText)
        Night_weather = findViewById(R.id.nightweather_editText)
        Enrol_button = findViewById(R.id.button2)
        Enrol_button.setOnClickListener() {
            addWeather(Date.text.toString(), Day_weather.text.toString(), Night_weather.text.toString())
        }
    }

    private fun getWeather() {
        val preferences = getSharedPreferences("weath", MODE_PRIVATE)
        var json: String = " "
        if (!preferences.contains("json"))
        {
            return
        }
        else{
            json = preferences.getString("json","NOT_JSON").toString()
        }
        val weathList = Gson().fromJson<List<Weather>>(json, object: TypeToken<List<Weather>>(){}.type)
        Weath.addAll(weathList)
    }
    private fun addWeather(date: String, day_weather: String, night_weather: String){
        val Temp = Weather(date, day_weather,night_weather)
        Weath.add(Temp)
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        preferences.edit{
            this.putString("json", Gson().toJson(Weath).toString())
        }
    }

}
