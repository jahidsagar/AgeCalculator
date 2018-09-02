package com.example.sagar.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    CheckBox Notification , Date_format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Notification = findViewById(R.id.background_notification);
        Date_format = findViewById(R.id.date_format);

        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Notification.isChecked() == true){
                    Toast.makeText(this , "checked",Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });
    }
}
