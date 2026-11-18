package com.example.lab2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 实验3：ConstraintLayout 实现计算器界面。
 */
public class CalculatorDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle(R.string.task3_title);
    }
}
