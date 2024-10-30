package com.yoga.projectpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button buttonh=findViewById(R.id.home11);
        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        checkBox1=findViewById(R.id.checkbox1);
        checkBox2=findViewById(R.id.checkbox2);
        checkBox3=findViewById(R.id.checkbox3);
        checkBox4=findViewById(R.id.checkbox4);
        checkBox5=findViewById(R.id.checkbox5);
        checkBox6=findViewById(R.id.checkbox6);
        checkBox7=findViewById(R.id.checkbox7);
        checkBox8=findViewById(R.id.checkbox8);


    }
//    private boolean areAllCheckBoxesChecked() {
//        for (CheckBox checkBox : checkBox1,checkBox2,checkBox3,) {
//            if (!checkBox.isChecked()) {
//                return false;
//            }
//        }
//        return true;
//    }



    public void Submit(View view) {
        if(checkBox1.isChecked()&&checkBox2.isChecked()&&checkBox3.isChecked()&&checkBox4.isChecked()&&checkBox5.isChecked()&&checkBox6.isChecked()&&checkBox7.isChecked()&&checkBox8.isChecked()){
            yoga();
            Toast.makeText(this, "You are done with today's HealthyHab activities", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, "Please perform all the above  healthy habits to stay safe!!!!!1", Toast.LENGTH_SHORT).show();
    }
    }


    public void home11(View view) {
        startActivity(new Intent(HomeActivity.this,HomeActivity.class));
    }

    public void yoga11(View view) {
        startActivity(new Intent(HomeActivity.this,YogaActivity.class));
    }

    public void profile11(View view) {
        startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
    }

    private void yoga() {

        //horizontali arrange karnyasathi sampala

String title="Yoga";
        String message = " You have completed Todays HealthyHab activities";
        NotificationHelper.createNotification(this, title, message);
    }

}