package com.example.samudrasarathi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Ensure the layout file is named correctly

        // Clear shared preferences and cache for debugging or fresh start
        clearAppData();

        // Initialize UI components
        etEmail = findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_login_password);
        btnLogin = findViewById(R.id.btn_login);

        // Set click listener for the login button
        btnLogin.setOnClickListener(v -> handleLogin());
    }

    /**
     * Clears shared preferences and cache data.
     */
    private void clearAppData() {
        getSharedPreferences("AppPrefs", MODE_PRIVATE).edit().clear().apply();
        deleteCache();
    }

    /**
     * Deletes the cache directory.
     */
    private void deleteCache() {
        try {
            if (getCacheDir() != null && getCacheDir().isDirectory()) {
                deleteDir(getCacheDir());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Recursively deletes files and directories.
     *
     * @param dir The directory to delete.
     * @return True if successfully deleted, false otherwise.
     */
    private boolean deleteDir(java.io.File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            if (children != null) {
                for (String child : children) {
                    boolean success = deleteDir(new java.io.File(dir, child));
                    if (!success) {
                        return false;
                    }
                }
            }
        }
        return dir != null && dir.delete();
    }

    /**
     * Handles the login logic when the login button is clicked.
     */
    private void handleLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate input fields
        if (email.isEmpty()) {
            etEmail.setError("Please enter your email");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Please enter your password");
            etPassword.requestFocus();
            return;
        }

        // Perform login action
        performLogin(email, password);
    }

    /**
     * Simulates login validation and navigates to the RegistrationActivity.
     *
     * @param email    User email.
     * @param password User password.
     */
    private void performLogin(String email, String password) {
        // Simulated login logic (replace with real authentication if needed)

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
    }

