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

public class LoginActivity extends AppCompatActivity {
    EditText emailInput, passwordInput;
    Button loginBtn;
    TextView toRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginBtn = findViewById(R.id.loginBtn);
        toRegister = findViewById(R.id.toRegister);

        loginBtn.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (UserStorage.checkUser(email, password)) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();

                String name = UserStorage.getNameByEmail(email);

                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Email atau password salah!", Toast.LENGTH_SHORT).show();
            }
        });

        toRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }
}
