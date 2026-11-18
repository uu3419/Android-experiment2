package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 实验2 主页：5 个界面布局实验的入口。
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.lab_title);

        bind(R.id.btn_task1, LinearLayoutDemo.class);
        bind(R.id.btn_task2, TableLayoutDemo.class);
        bind(R.id.btn_task3, CalculatorDemo.class);
        bind(R.id.btn_task4, SpaceDemo.class);
        bind(R.id.btn_task5, ComposeTodoActivity.class);
    }

    private void bind(int buttonId, final Class<?> target) {
        Button b = findViewById(buttonId);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, target));
            }
        });
    }
}
