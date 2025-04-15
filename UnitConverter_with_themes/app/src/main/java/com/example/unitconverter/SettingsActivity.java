package com.example.unitconverter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RadioGroup themeRadioGroup = findViewById(R.id.themeRadioGroup);
        RadioButton lightTheme = findViewById(R.id.lightTheme);
        RadioButton darkTheme = findViewById(R.id.darkTheme);
        RadioButton systemDefault = findViewById(R.id.systemDefault);

        SharedPreferences sharedPreferences = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        String currentTheme = sharedPreferences.getString("theme_preference", "system");

        switch (currentTheme) {
            case "light":
                lightTheme.setChecked(true);
                break;
            case "dark":
                darkTheme.setChecked(true);
                break;
            default:
                systemDefault.setChecked(true);
        }

        themeRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.lightTheme) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                sharedPreferences.edit().putString("theme_preference", "light").apply();
            } else if (checkedId == R.id.darkTheme) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                sharedPreferences.edit().putString("theme_preference", "dark").apply();
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                sharedPreferences.edit().putString("theme_preference", "system").apply();
            }
            recreate();
        });
    }
}