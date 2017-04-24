package app.noti.simple4;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

public class Reseverr extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {


            SharedPreferences sharedPreferences = context.getSharedPreferences("Azkartime", Context.MODE_PRIVATE);
            Long timee1 = sharedPreferences.getLong("morning", 0);
            Long timee2 = sharedPreferences.getLong("night", 0);

                if (timee1 != 0) {
                    Log.e("Reseverr now", "mooooor: "+timee1);
                    Intent service = new Intent(context.getApplicationContext(), MyIntentService.class);
                    service.putExtra("morning", timee1);
                    context.startService(service);


                }
                if (timee2 != 0) {
                    Log.e("Reseverr now", "niiiiig: "+timee2);

                    Intent service = new Intent(context.getApplicationContext(), MyIntentService.class);
                    service.putExtra("night", timee2);
                    context.startService(service);

                }


        } else {

            Log.e("Reseverr now", "eeeellllsee");

            if (intent.getType().equals("mor")){

                Log.e("alaaaaaarm","nooo 11111");

                PendingIntent notification = PendingIntent.getActivity(context, 1, new Intent(context, Teee.class), 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                    .setContentTitle("تذكير")
                    .setContentText("قوم بسك نوم أذكار الصباح");

            builder.setContentIntent(notification);
            builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
            builder.setAutoCancel(true);

            NotificationManager mm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mm.cancel(1);
            mm.notify(1, builder.build());

            }

            if (intent.getType().equals("nig")){

                Log.e("alaaaaaarm","nooo 22222");

                PendingIntent notification = PendingIntent.getActivity(context, 2, new Intent(context, Teee.class), 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                    .setContentTitle("تذكير")
                    .setContentText("قوم بسك نوم أذكار المساء");

            builder.setContentIntent(notification);
            builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
            builder.setAutoCancel(true);

            NotificationManager mm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mm.cancel(2);
            mm.notify(2, builder.build());

            }



        }
    }


}
