package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Red = Color(0xFFC62828)

/** 实验5：Jetpack Compose 实现课程学习任务清单 */
class ComposeTodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme(primary = Red)) {
                TodoScreen()
            }
        }
    }
}

data class Task(val id: Int, val title: String, val done: Boolean = false)

@Composable
fun TodoScreen() {
    val tasks = remember {
        mutableStateListOf(
            Task(1, "学习 Column 和 Row", done = true),
            Task(2, "学习状态管理"),
            Task(3, "完成 Compose 实验")
        )
    }
    var input by remember { mutableStateOf("") }
    var nextId by remember { mutableIntStateOf(4) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "课程学习任务",
            color = Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                singleLine = true,
                placeholder = { Text("请输入学习任务") },
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {
                    if (input.isNotBlank()) {
                        tasks.add(Task(nextId++, input.trim()))
                        input = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Red)
            ) {
                Text("添加")
            }
        }

        Spacer(Modifier.height(10.dp))

        Text(
            text = "已完成：${tasks.count { it.done }} / ${tasks.size}",
            fontSize = 13.sp,
            color = Color(0xFF555555)
        )

        Spacer(Modifier.height(6.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(tasks, key = { it.id }) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = task.done,
                        onCheckedChange = { checked ->
                            val index = tasks.indexOfFirst { it.id == task.id }
                            if (index >= 0) {
                                tasks[index] = task.copy(done = checked)
                            }
                        }
                    )
                    Text(
                        text = task.title,
                        modifier = Modifier.weight(1f),
                        textDecoration = if (task.done) {
                            TextDecoration.LineThrough
                        } else {
                            TextDecoration.None
                        },
                        color = if (task.done) Color(0xFF9E9E9E) else Color(0xFF212121)
                    )
                    TextButton(onClick = { tasks.remove(task) }) {
                        Text("删除", color = Red)
                    }
                }
                HorizontalDivider(color = Color(0xFFE0E0E0))
            }
        }
    }
}
