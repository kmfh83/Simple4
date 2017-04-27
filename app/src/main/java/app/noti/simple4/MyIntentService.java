package app.noti.simple4;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Calendar;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    public static void startActionFoo(Context context, String param1, String param2) {

    }


    public static void startActionBaz(Context context, String param1, String param2) {

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Long time_mor =intent.getLongExtra("morning",0);
        Long time_nig =intent.getLongExtra("night",0);

        if (time_mor != 0){
            intent = new Intent(getApplicationContext(),Reseverr.class);
            intent.setType("mor");

            AlarmManager manager1 = (AlarmManager)getSystemService(ALARM_SERVICE);

            manager1.setRepeating(AlarmManager.RTC_WAKEUP,time_mor,AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(getApplicationContext(),1,intent,PendingIntent.FLAG_UPDATE_CURRENT));

            Log.e("onHandleIntent ","time_mor now");
            Log.e("onHandleIntent ", String.valueOf(time_mor));

        }

        if (time_nig != 0){

            intent = new Intent(getApplicationContext(),Reseverr.class);
            intent.setType("nig");

            AlarmManager manager2 = (AlarmManager)getSystemService(ALARM_SERVICE);

            manager2.setRepeating(AlarmManager.RTC_WAKEUP,time_nig,AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(getApplicationContext(),2,intent,PendingIntent.FLAG_UPDATE_CURRENT));

            Log.e("onHandleIntent ","time_nig now");
            Log.e("onHandleIntent ", String.valueOf(time_nig));

        }
//        SharedPreferences sharedPreferences = getSharedPreferences("Azkartime", Context.MODE_PRIVATE);
//        Long tiimmee = sharedPreferences.getLong("morning",0);
//        String nig_or_mor = intent.getStringExtra("nig_or_mor");
//        String typee = intent.getType();
////        Log.e("onHandleIntent ", String.valueOf(tiimmee));
//        intent = new Intent(getApplicationContext(),Reseverr.class);
//        intent.putExtra("nig_or_mor","null");
//        intent.setType(typee);
//        AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
//
//        manager.setRepeating(AlarmManager.RTC_WAKEUP,tiimmee,AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT));
//
//        Log.e("onHandleIntent ","ruuuun now");
//        Log.e("onHandleIntent ", String.valueOf(tiimmee));


    }

}
