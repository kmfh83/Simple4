package app.noti.simple4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Pop1 extends AppCompatActivity {

    TimePicker timePicker;
    int hour,minuts;
    Button setalarm;
    TextView TextView_Time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop1);

//        Intent service = new Intent(getApplicationContext(),MyIntentService.class);
//        startService(service);

        final Calendar calendar = Calendar.getInstance();
        TextView_Time = (TextView)findViewById(R.id.TextView_Time);

        timePicker = (TimePicker)findViewById(R.id.timePicker);

        setalarm = (Button)findViewById(R.id.setalarm);
        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23 ) {
                    calendar.set(calendar.HOUR_OF_DAY,timePicker.getHour());
                    calendar.set(calendar.MINUTE,timePicker.getMinute());
                    calendar.set(calendar.SECOND,0);
                    hour = timePicker.getHour();
                    minuts = timePicker.getMinute();

                }else {

                    calendar.set(calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                    calendar.set(calendar.MINUTE,timePicker.getCurrentMinute());
                    calendar.set(calendar.SECOND,0);

                    hour= timePicker.getCurrentHour();
                    minuts = timePicker.getCurrentMinute();
                }

                //convert hour and minuts To String

                String hour_string = String.valueOf(hour);
                String mintu_string = String.valueOf(minuts);

                //sharedPrefanses save time from calendar.getTimeInMillis() in azkariTime file

                SharedPreferences sharedPreferences = getSharedPreferences("Azkartime", Context.MODE_PRIVATE);
                SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
                sharedEditor.putLong("morning", calendar.getTimeInMillis());
                sharedEditor.apply();
//
////        seend(getApplicationContext());
                SharedPreferences shared = getSharedPreferences("Azkartime", Context.MODE_PRIVATE);
                Long time_mor = shared.getLong("morning",0);
//
                Log.e("gg time ", String.valueOf(time_mor));
                Intent service = new Intent(getApplicationContext(),MyIntentService.class);
                service.putExtra("morning",time_mor);
                startService(service);
//                AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
//                manager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(getApplicationContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT));




                //convert from 24h to 12h

                if(hour > 12){

                    hour_string = String.valueOf(hour - 12);
                }

                // convert minuts from 10:7 to 10:07

                if (minuts < 10){
                    mintu_string = "0"+ String.valueOf(minuts);
                }

                set_alarm_time("Alarm set On "+hour_string+":"+mintu_string);



            }
        });

        // Pop layout desing (int)(width*.9),(int)(height*.5)
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.90));
    }

    private void set_alarm_time(String x) {
        TextView_Time.setText(x);
    }


}
