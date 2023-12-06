package com.example.java_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);


        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ConverterActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RandomActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });

        animateButton(btn1,R.anim.slide_in_down,50);
        animateButton(btn2,R.anim.slide_in_down,150);
        animateButton(btn3,R.anim.slide_in_down,250);
    }

    private void animateButton(final Button button,int animationResource,final int delay){
        final Animation animation=AnimationUtils.loadAnimation(this,animationResource);
        animation.setStartOffset(delay);
        button.post(new Runnable() {
            @Override
            public void run() {
                button.setVisibility(View.VISIBLE);
                button.startAnimation(animation);
            }
        });
    }



}

