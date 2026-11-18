package com.example.lab2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 实验2：TableLayout 实现菜单表格。
 */
public class TableLayoutDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        setTitle(R.string.task2_title);
    }
}
