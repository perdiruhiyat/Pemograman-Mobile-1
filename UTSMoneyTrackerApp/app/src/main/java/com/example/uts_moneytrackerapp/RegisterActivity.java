package com.example.uts_moneytrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_moneytrackerapp.model.User;
import com.example.uts_moneytrackerapp.model.UserStorage;

public class RegisterActivity extends AppCompatActivity {
    EditText nameInput, emailInput, passwordInput;
    Button registerBtn;
    TextView toLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerBtn = findViewById(R.id.registerBtn);
        toLogin = findViewById(R.id.toLogin);

        registerBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (UserStorage.isEmailExist(email)) {
                Toast.makeText(this, "Email sudah terdaftar!", Toast.LENGTH_SHORT).show();
            } else {
                UserStorage.addUser(new User(name, email, password));
                Toast.makeText(this, "Register berhasil, silakan login!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        toLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}