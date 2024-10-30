package com.yoga.projectpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChildposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childpose);
    }

    public void yog1(View view) {
        startActivity(new Intent(ChildposeActivity.this,YogaActivity.class));
    }
}