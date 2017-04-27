package app.noti.simple4;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;


public class MainActivity extends AppCompatActivity {

    TextView tv,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ggggggg ", "start main activity");

        tv= (TextView)findViewById(R.id.timmmm);

        SharedPreferences sharedPreferences = getSharedPreferences("Azkartime", Context.MODE_PRIVATE);
        Long timee1 = sharedPreferences.getLong("morning", 0);

        Time time = new Time(timee1);

        tv.setText(String.valueOf(time));

        tv2= (TextView)findViewById(R.id.timmmm2);

        Long timee2 = sharedPreferences.getLong("night", 0);

        Time time2 = new Time(timee2);

        tv2.setText(String.valueOf(time2));




        findViewById(R.id.morning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent i= new Intent(getApplicationContext(),Pop1.class);
                startActivity(i);

            }
        });

        findViewById(R.id.night).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Pop2.class);
                startActivity(i);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
    }



}
