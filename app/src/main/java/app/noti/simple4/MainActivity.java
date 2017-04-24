package app.noti.simple4;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ggggggg ", "start main activity");



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
