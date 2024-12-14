package com.example.samudrasarathi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    private TextView tvRegister, tvLoginLink;
    private EditText etEmail, etPassword, etCPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize UI components
        tvRegister = findViewById(R.id.tv_register_title);
        etEmail = findViewById(R.id.et_register_email);
        etPassword = findViewById(R.id.et_register_password);
        etCPassword = findViewById(R.id.et_register_cpassword);
        btnRegister = findViewById(R.id.btn_register);
        tvLoginLink = findViewById(R.id.tv_login_link); // Add a TextView in XML for "Login Here"

        // Set click listener for the register button
        btnRegister.setOnClickListener(v -> {
            // Get the input values
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etCPassword.getText().toString().trim();

            // Validate inputs
            if (email.isEmpty()) {
                etEmail.setError("Please enter your email");
                return; // Stop further execution
            }

            if (password.isEmpty()) {
                etPassword.setError("Please enter your password");
                return; // Stop further execution
            }

            // Validate password strength
            if (!isValidPassword(password)) {
                etPassword.setError("Password must be at least 6 characters, contain a letter, a number, and a special character");
                return; // Stop further execution
            }

            if (confirmPassword.isEmpty()) {
                etCPassword.setError("Please confirm your password");
                return; // Stop further execution
            }

            if (!password.equals(confirmPassword)) {
                etCPassword.setError("Passwords do not match");
                return; // Stop further execution
            }

            // If validation passes, navigate to LoginActivity
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(RegistrationActivity.this, "Register Successfully Done", Toast.LENGTH_SHORT).show();
        });

        // Set click listener for the login link
        tvLoginLink.setOnClickListener(v -> {
            // Navigate to LoginActivity
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });
    }

    /**
     * Validates the password based on the given conditions.
     * - At least 6 characters long
     * - Contains at least one letter
     * - Contains at least one number
     * - Contains at least one special character
     */
    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{6,}$";
        return password.matches(passwordPattern);
    }
}
