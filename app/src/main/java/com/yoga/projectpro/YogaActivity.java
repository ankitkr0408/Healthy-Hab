package com.yoga.projectpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class YogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
    }

    public void home22(View view) {
        startActivity(new Intent(YogaActivity.this,HomeActivity.class));
    }

    public void yoga22(View view) {
        startActivity(new Intent(YogaActivity.this,YogaActivity.class));
    }

    public void profile22(View view) {
        startActivity(new Intent(YogaActivity.this,ProfileActivity.class));
    }

    public void yoga_here1(View view) {
        startActivity(new Intent(YogaActivity.this,ChildposeActivity.class));
    }

    public void yoga_here2(View view) {
        startActivity(new Intent(YogaActivity.this,ChildposeActivity.class));
    }
}