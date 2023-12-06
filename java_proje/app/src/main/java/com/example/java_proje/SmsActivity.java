package com.example.java_proje;


import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SmsActivity extends AppCompatActivity {

    private Button btnSend;
    private EditText phoneEdit, textEdit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);

        btnSend = findViewById(R.id.btn1);
        phoneEdit = findViewById(R.id.txtTel);
        textEdit = findViewById(R.id.txtmesaj);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });

    }
    private void sendSMS() {
        String phoneNumber = phoneEdit.getText().toString();
        String message = textEdit.getText().toString();

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            // İzin yoksa izin iste
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        } else {
            // İzin varsa SMS gönder
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "Mesaj başarılı bir şekilde gitti", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permission,int[]grantResults){
        super.onRequestPermissionsResult(requestCode,permission,grantResults);
        if(requestCode==1){
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                sendSMS();
            }else{
                Toast.makeText(this,"Reddedildi",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

