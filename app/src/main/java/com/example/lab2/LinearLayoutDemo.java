package com.example.lab2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 实验1：LinearLayout 嵌套实现 4×4 文本网格。
 */
public class LinearLayoutDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        setTitle(R.string.task1_title);
    }
}
