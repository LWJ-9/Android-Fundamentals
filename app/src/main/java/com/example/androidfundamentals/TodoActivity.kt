package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfundamentals.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var todoList = mutableListOf<Todo>(
            Todo(
                "Learn Kotlin",
                true
            ),
            Todo(
                "Learn Android",
                false
            ),
            Todo(
                "Learn Flutter",
                false
            )
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(
                title,
                false
            )
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}