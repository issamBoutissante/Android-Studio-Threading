package com.test.threading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView counterText;
    Button startCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterText=findViewById(R.id.counterText);
        startCounter=findViewById(R.id.startCounter);
        startCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread counterTread=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for(int i=0;i<=1000;i++){
                            try {
                                Thread.sleep(1000);
                                final int finalI=i;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        counterText.setText(Integer.toString(finalI));
                                    }
                                });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                counterTread.start();
            }
        });
    }
}