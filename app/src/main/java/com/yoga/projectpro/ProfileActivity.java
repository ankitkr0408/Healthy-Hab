package com.yoga.projectpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    EditText username3,password3;
    Button update3,delete3,logout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        username3=findViewById(R.id.username3);
        password3=findViewById(R.id.password3);

        update3=findViewById(R.id.update3);
        delete3=findViewById(R.id.delete3);
        logout3=findViewById(R.id.logout3);


        DatabaseHelper dbHelper = new DatabaseHelper(this);
        EditText username3 = findViewById(R.id.username3);
        EditText password3 = findViewById(R.id.password3);

        Button deleteButton = findViewById(R.id.delete3);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username3.getText().toString();
                String password = password3.getText().toString();

                // Check if email and password are not empty
                if (!email.isEmpty() && !password.isEmpty()) {
                    // Call deleteRecord function
                    boolean deleted = dbHelper.deleteRecord(email, password);
                    if (deleted) {
                        Toast.makeText(ProfileActivity.this, "Record deleted successfully", Toast.LENGTH_SHORT).show();

                        // iTHE INTENT PASS KARA KONITARY DIRECT LOGIN MADHYE JANYASATHI
                        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                        startActivity(intent);
                        // You can finish() the activity or do other operations here
                    } else {
                        Toast.makeText(ProfileActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ProfileActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        DatabaseHelper dbhelper = new DatabaseHelper(this);

// check karanyasathi
        Button updatePasswordButton = findViewById(R.id.update_password);
        EditText editTextNewPassword = findViewById(R.id.newpassword3);
        update3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username3.getText().toString().trim();
                String password = password3.getText().toString().trim();

                if (dbhelper.checkUser(email, password)) {
                    editTextNewPassword.setVisibility(View.VISIBLE);
                    updatePasswordButton.setVisibility(View.VISIBLE);


                } else {
                    Toast.makeText(ProfileActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        updatePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = editTextNewPassword.getText().toString().trim();
                String username = username3.getText().toString().trim();

                if (!newPassword.isEmpty() && !username.isEmpty()) {
                    dbHelper.updatePassword(username, newPassword);
                    Toast.makeText(ProfileActivity.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                    editTextNewPassword.setText("");

                    username3.setText("");    //empty karel password and email chi field optional ahe kadhayacha asla tar kadh
                    password3.setText("");


                    editTextNewPassword.setVisibility(View.GONE);
                    updatePasswordButton.setVisibility(View.GONE);
                    // Clear the editText after updating the password

                } else {
                    Toast.makeText(ProfileActivity.this, "Please enter email and new password", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    public void logout(View view) {
        startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
    }

    public void home33(View view) {
        startActivity(new Intent(ProfileActivity.this,HomeActivity.class));
    }

    public void yoga33(View view) {
        startActivity(new Intent(ProfileActivity.this,YogaActivity.class));
    }

    public void profile33(View view) {
        startActivity(new Intent(ProfileActivity.this,ProfileActivity.class));
    }
}