package com.example.java_proje;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class RandomActivity extends AppCompatActivity{

    private EditText txtEditAdet,txtEditMin,txtEditMax;
    private Button btnCreate;
    private ScrollView scrollview;
    private LinearLayout llcontainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);

        txtEditAdet=findViewById(R.id.txtadet);
        txtEditMax=findViewById(R.id.txtmax);
        txtEditMin=findViewById(R.id.txtmin);

        btnCreate=findViewById(R.id.btn1);

        scrollview=findViewById(R.id.scroll);

        llcontainer=findViewById(R.id.container);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProgressBar();
            }
        });
    }
    private void createProgressBar(){
        llcontainer.removeAllViews();
        int adet=Integer.parseInt(txtEditAdet.getText().toString());
        int min=Integer.parseInt(txtEditMin.getText().toString());
        int max=Integer.parseInt(txtEditMax.getText().toString());

        Random random=new Random();
        for(int i=0;i<adet;i++){
            int minimum=random.nextInt((max-min)+1)+min;
            int maksimum=random.nextInt((max-minimum)+1)+minimum;

            int progress=random.nextInt((maksimum-minimum)+1)+minimum;
            int yuzde=(progress-minimum)*100/(maksimum-minimum);

            ProgressBar progressBar=new ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal);
            progressBar.setProgress(yuzde);

            TextView textView=new TextView(this);
            textView.setText("Min: "+minimum+"Max: "+maksimum+"Deger: "+progress+"Yüzdelik: "+yuzde+" %");

            LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            llcontainer.addView(progressBar,layoutParams);
            llcontainer.addView(textView,layoutParams);
        }

        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}