package com.example.sagar.agecalculator;

import android.app.Activity;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class CalanderWork {
    private int Year , Month , Day;
    private static Context context;

    CalanderWork(){
        Calendar calendar = Calendar.getInstance();
        this.Day = calendar.get(Calendar.DAY_OF_MONTH);
        this.Month = calendar.get(Calendar.MONTH);
        this.Year = calendar.get(Calendar.YEAR);
    }

    public String DayofWeek(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Year , Month , Day);
        int d = calendar.get(Calendar.DAY_OF_WEEK);

        String[] Day_name = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        return  Day_name[d-1];
    }

    public String MonthName(){
        String[] months = {
                "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        return months[Month];
    }

    public void SetCalender(int Year , int Month , int Day){
        this.Year = Year;
        this.Month = Month;
        this.Day = Day;

    }

    public long GetInstance(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(getYear() , getMonth() , getDay());

        return calendar.getTimeInMillis();
    }
    public long GetInstance(int Year , int Month , int Day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Year , Month , Day);

        return calendar.getTimeInMillis();
    }

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }
}
