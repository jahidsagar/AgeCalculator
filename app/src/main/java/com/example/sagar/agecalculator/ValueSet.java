package com.example.sagar.agecalculator;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class ValueSet {
    private Context context;
    boolean check = false;

    //declare all text views here
    TextView
            Today_Day , Today_DayofMonth , Today_Month , Today_Year ,//today text
            Birth_day , Birth_DayofMonth , Birth_Month , Birth_Year,//birthday text
            Text_Year , Text_Month , Text_Days,//calculate text
            Text_Next_Date , Text_Next_Day,//next birthday text
            Reamin_Months , Remain_Days ,//reamins time show using months and days

    //addding additional information here
    Total_Years , Total_Months , Total_Weeks ,Total_Days , Total_Hours , Total_Minutes , Total_Seconds;

    //declare all buttons here
    Button
            Today_CalandeButton,//today datepikerdialog
            Birth_CalanderButton, //birthday datepickerdialog
            Clear_Button, //clear button
            Calculate_Button;//calculate button


    ValueSet(Context context ){
        this.context = context;
    }


    public void AddReference(){


        Today_Day = ((Activity)context).findViewById(R.id.dayoftoday);
        Today_DayofMonth = ((Activity)context).findViewById(R.id.dayofMonth_today);
        Today_Month = ((Activity)context).findViewById(R.id.month_today);
        Today_Year = ((Activity)context).findViewById(R.id.year_today);
        Today_CalandeButton = ((Activity)context).findViewById(R.id.tdoay_calander_button);

        Birth_day = ((Activity)context).findViewById(R.id.dayofBirth);
        Birth_DayofMonth = ((Activity)context).findViewById(R.id.dayofMonth_Birth);
        Birth_Month = ((Activity)context).findViewById(R.id.month_Birth);
        Birth_Year = ((Activity)context).findViewById(R.id.year_Birth);
        Birth_CalanderButton = ((Activity)context).findViewById(R.id.birhtday_calander_button);

        Text_Days = ((Activity)context).findViewById(R.id.text_ageDay);
        Text_Month = ((Activity)context).findViewById(R.id.text_ageMonth);
        Text_Year = ((Activity)context).findViewById(R.id.text_ageYear);

        Text_Next_Date = ((Activity)context).findViewById(R.id.text_nextBirthDay);
        Text_Next_Day= ((Activity)context).findViewById(R.id.text_nextWeekDay);
        Reamin_Months = ((Activity)context).findViewById(R.id.text_Month_Remain);
        Remain_Days = ((Activity)context).findViewById(R.id.text_Day_Remain);

        Total_Years = ((Activity)context).findViewById(R.id.text_totalYear);
        Total_Months = ((Activity)context).findViewById(R.id.text_totalMonth);
        Total_Weeks = ((Activity)context).findViewById(R.id.text_totalWeek);
        Total_Days = ((Activity)context).findViewById(R.id.text_totalDay);
        Total_Hours = ((Activity)context).findViewById(R.id.text_totalHour);
        Total_Minutes = ((Activity)context).findViewById(R.id.text_totalMinute);
        Total_Seconds = ((Activity)context).findViewById(R.id.text_totalSecond);

        Clear_Button = ((Activity)context).findViewById(R.id.buttonClear);
        Calculate_Button = ((Activity)context).findViewById(R.id.buttonCalculate);
    }


    /*
    * we dont use this method from this class.
    * we use it from CalanderWork class
    *
    * */
    @Deprecated
    public String DayofWeek(int year , int month , int dayofMonth){

        Calendar calendar = Calendar.getInstance();
        calendar.set(year , month , dayofMonth);
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

    public  void Clear(){
        CalanderWork calanderWork = new CalanderWork();

        Today_Day.setText(calanderWork.DayofWeek());
        Today_DayofMonth.setText(String.valueOf(calanderWork.getDay()));
        Today_Month.setText(String.valueOf(calanderWork.getMonth() + 1));
        Today_Year.setText(String.valueOf(calanderWork.getYear()));

        Birth_day.setText("Select");
        Birth_DayofMonth.setText("DD");
        Birth_Month.setText("MM");
        Birth_Year.setText("YYYY");

        Text_Days.setText("00");
        Text_Month.setText("00");
        Text_Year.setText("00");

        Text_Next_Date.setText("Mmm Dd , YYYY");
        Text_Next_Day.setText("XXXXX");
        Reamin_Months.setText("00");
        Remain_Days.setText("00");

        Total_Years.setText("000");
        Total_Months.setText("000");
        Total_Weeks.setText("000");
        Total_Hours.setText("000");
        Total_Minutes.setText("000");
        Total_Seconds.setText("000");

        check = false;
    }

    public void ValueofText(//this method used for set calculation value
            String Total_Years ,
            String Total_Months,
            String Total_Weeks ,
            String Total_Days,
            String Total_Hours,
            String Total_Minutes,
            String Total_Seconds,
            String Text_Days,
            String Text_Month,
            String Text_Year,
            String Text_Next_Date ,
            String Text_Next_Day,
            String Reamin_Months,
            String Remain_Days

    ){
        this.Total_Years.setText(Total_Years);
        this.Total_Months.setText(Total_Months);
        this.Total_Weeks.setText(Total_Weeks);
        this.Total_Days.setText(Total_Days);
        this.Total_Hours.setText(Total_Hours);
        this.Total_Minutes.setText(Total_Minutes);
        this.Total_Seconds.setText(Total_Seconds);
        this.Text_Days.setText(Text_Days);
        this.Text_Month.setText(Text_Month);
        this.Text_Year.setText(Text_Year);
        this.Text_Next_Date.setText(Text_Next_Date);
        this.Text_Next_Day.setText(Text_Next_Day);
        this.Reamin_Months.setText(Reamin_Months);
        this.Remain_Days.setText(Remain_Days);
    }
}
