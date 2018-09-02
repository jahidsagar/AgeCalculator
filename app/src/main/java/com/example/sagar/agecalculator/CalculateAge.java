package com.example.sagar.agecalculator;

import java.util.Calendar;

public class CalculateAge {

    private int Today_year , Today_month , Today_day ,
            Birth_year , Birth_month , Birth_day ,
            ageYear , ageMonth , ageDay,
            next_Year , Remain_month , Remain_day;
    private  long years , months , days , weeks , hours , minutes , seconds;

    //get today textfield
    public  void SetToday(int Today_year , int Today_month , int Today_day){
        this.Today_day = Today_day;
        this.Today_month = Today_month;
        this.Today_year = Today_year;
    }

    //get birthday textfield
    public  void SetBirth(int Birth_year ,int Birth_month ,int Birth_day){
        this.Birth_day = Birth_day;
        this.Birth_month = Birth_month;
        this.Birth_year = Birth_year;
    }

    //set the value for additional field
    public  void Calculate(){

        Calendar start = Calendar.getInstance();
        start.set(Today_year,Today_month-1,Today_day);

        Calendar end = Calendar.getInstance();
        end.set(Birth_year,Birth_month-1,Birth_day);

        long dif = (start.getTimeInMillis() - end.getTimeInMillis());

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(dif);

        years = (dif/1000)/31536000;
        months = (dif/1000)/2592000;
        weeks = (dif/1000)/604800;
        days = (dif/1000)/86400;
        hours = (dif/1000)/3600;
        minutes = (dif/1000)/60;
        seconds = (dif/1000);

        Different();

    }

    //calculate the total age
    private void Different(){

        int d = Today_day;
        int m = Today_month;
        int y = Today_year;

        if (d < Birth_day){
            d = d + 31;
            m--;
        }
        if (m < Birth_month){
            m = m+12;
            y--;
        }

        ageYear = y - Birth_year;
        ageMonth = m - Birth_month;
        ageDay = d - Birth_day;
    }

    //which year will ur next bday
    private void Next_Birth_Year(){
        if (Birth_month > Today_month){
            next_Year = Today_year;
        }else {
            next_Year = Today_year+1;
        }
    }

    public void Calculate_Next(){
        if (Today_month == Birth_month && Today_day == Birth_day){
            Remain_day = 0;
            Remain_month = 12;
        }else {
            if (Today_year == getBirth_year()){
                int d = Birth_day, m = Birth_month;
                if (d < Today_day){
                    d = d+31;
                    m--;
                }

                Remain_month = m - Today_month;
                Remain_day = d - Today_day;

            }else {
                int d = Birth_day, m = Birth_month;
                if (d < Today_day){
                    d = d+31;
                    m--;
                }
                if (m < Today_month) {
                    m = m+12;
                }

                    Remain_month = m - Today_month;
                    Remain_day = d - Today_day;
                }
            }
    }


    public int getRemain_day() {
        return Remain_day;
    }

    public int getRemain_month() {
        return Remain_month;
    }

    public int getBirth_day() {
        return Birth_day;
    }

    public int getBirth_month() {
        return Birth_month;
    }

    public int getBirth_year() {
        return Birth_year;
    }

    public int getNext_Year() {
        Next_Birth_Year();
        return next_Year;
    }

    public int getAgeYear() {
        return ageYear;
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    public int getAgeDay() {
        return ageDay;
    }

    public long getYears() {
        return years ;
    }

    public long getMonths() {
        return months;
    }

    public long getWeeks() {
        return weeks;
    }

    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }
}
