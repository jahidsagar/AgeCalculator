package com.example.sagar.agecalculator;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //use for set View and clear method
    ValueSet valueSet = new ValueSet(MainActivity.this );
    //use for find month and day of week in month
    CalanderWork calanderWork = new CalanderWork();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set the variable using find view by id
        valueSet.AddReference();

        /*
        * code for logo in action bar
        * */
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.age_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //====================================================== logo in actionbar



        /*
        * this snip of code use for set today date
        * on first time when app is opened.
        * we can replace it valueset class.
        * but now we use it here
        * */
        valueSet.Today_Day.setText(calanderWork.DayofWeek());
        valueSet.Today_DayofMonth.setText(String.valueOf(calanderWork.getDay()));
        valueSet.Today_Month.setText(String.valueOf(calanderWork.getMonth() + 1));
        valueSet.Today_Year.setText(String.valueOf(calanderWork.getYear()));

        /*
        * add listener to the button
        * */
        valueSet.Birth_CalanderButton.setOnClickListener(this);
        valueSet.Today_CalandeButton.setOnClickListener(this);
        valueSet.Clear_Button.setOnClickListener(this);
        valueSet.Calculate_Button.setOnClickListener(this);


        
    }

    /*
    * create options menu
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu , menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.setting_op){
//            Toast.makeText(this,"setting korbi",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this , SettingActivity.class);
            startActivity(intent);
        }else if (item.getItemId() == R.id.share_op){
//            Toast.makeText(this,"share korbi",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"older apps");
            intent.putExtra(Intent.EXTRA_TEXT, "download : "+ getPackageName());
            startActivity(Intent.createChooser(intent , "share with"));
        }

        return super.onOptionsItemSelected(item);
    }

    //================================================== options menu



    /*
    * onclick listener added here
    * */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tdoay_calander_button){
            final DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    valueSet.Clear();
                    calanderWork.SetCalender(year , month , dayOfMonth);

                    valueSet.Today_Day.setText(calanderWork.DayofWeek());
                    valueSet.Today_DayofMonth.setText(String.valueOf(calanderWork.getDay()));
                    valueSet.Today_Month.setText(String.valueOf(calanderWork.getMonth() + 1));
                    valueSet.Today_Year.setText(String.valueOf(calanderWork.getYear()));




                }
            }, calanderWork.getYear(), calanderWork.getMonth(), calanderWork.getDay());
            datePickerDialog.show();
        }
        else if (v.getId() == R.id.birhtday_calander_button) {
            final DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    CalanderWork calanderWork1 = new CalanderWork();
                    calanderWork1.SetCalender(year , month , dayOfMonth);

                    valueSet.Birth_day.setText(calanderWork1.DayofWeek());
                    valueSet.Birth_DayofMonth.setText(String.valueOf(calanderWork1.getDay()));
                    valueSet.Birth_Month.setText(String.valueOf(calanderWork1.getMonth() + 1));
                    valueSet.Birth_Year.setText(String.valueOf(calanderWork1.getYear()));

                    valueSet.check = true;

                }
            }, calanderWork.getYear(), calanderWork.getMonth(), calanderWork.getDay());
            datePickerDialog.getDatePicker().setMaxDate(calanderWork.GetInstance());
            datePickerDialog.show();
        }
        else if (v.getId() == R.id.buttonClear){
            valueSet.Clear();
        }
        else if (v.getId() == R.id.buttonCalculate){
            if (valueSet.check == true){
                CalculateAge calculateAge = new CalculateAge();

                calculateAge.SetToday(
                        Integer.parseInt(valueSet.Today_Year.getText().toString()) ,
                        Integer.parseInt(valueSet.Today_Month.getText().toString()) ,
                        Integer.parseInt(valueSet.Today_DayofMonth.getText().toString())
                );
                calculateAge.SetBirth(
                        Integer.parseInt(valueSet.Birth_Year.getText().toString()) ,
                        Integer.parseInt(valueSet.Birth_Month.getText().toString()) ,
                        Integer.parseInt(valueSet.Birth_DayofMonth.getText().toString())
                );

                calculateAge.Calculate();
                calanderWork.SetCalender(calculateAge.getNext_Year() , calculateAge.getBirth_month()-1 , calculateAge.getBirth_day());
                calculateAge.Calculate_Next();

                valueSet.ValueofText( //this method used for set calculation value
                        String.valueOf(calculateAge.getYears()),
                        String.valueOf(calculateAge.getMonths()),
                        String.valueOf(calculateAge.getWeeks()),
                        String.valueOf(calculateAge.getDays()),
                        String.valueOf(calculateAge.getHours()),
                        String.valueOf(calculateAge.getMinutes()),
                        String.valueOf(calculateAge.getSeconds()),
                        String.valueOf(calculateAge.getAgeDay()),
                        String.valueOf(calculateAge.getAgeMonth()),
                        String.valueOf(calculateAge.getAgeYear()),
                        calanderWork.MonthName()+" "+calculateAge.getBirth_day()+" , "+calculateAge.getNext_Year() ,
                        calanderWork.DayofWeek(),
                        String.valueOf(calculateAge.getRemain_month()),
                        String.valueOf(calculateAge.getRemain_day())
                );

            }else {
                Toast.makeText(MainActivity.this,"please select all field",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
