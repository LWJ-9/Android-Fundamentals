package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivityMainBinding
import com.example.androidfundamentals.ui.form.FormActivity
import com.example.androidfundamentals.ui.lifecycle.LifecycleActivity
import com.example.androidfundamentals.ui.todo.TodoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("MainActivity", "onCreate")
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnApply.setOnClickListener {
            Log.d("MainActivity", "Go to Form button clicked")
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
        binding.btnTakePhoto.setOnClickListener {
            Log.d("MainActivity", "Take photo button clicked")
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }

        binding.btnGoTodo.setOnClickListener {
            Log.d("MainActivity", "Go to Todo button clicked")
            val intent = Intent(this, TodoActivity::class.java)
            startActivity(intent)
        }

        binding.btnGoLifeCycle.setOnClickListener {
            Log.d("MainActivity", "Go to Lifecycle button clicked")
            val intent = Intent(this, LifecycleActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v("MainActivity", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.v("MainActivity", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.v("MainActivity", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.v("MainActivity", "onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.v("MainActivity", "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.v("MainActivity", "onDestroy")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.v("MainActivity", "onSaveInstanceState")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.v("MainActivity", "onActivityResult")
        if (resultCode == RESULT_OK && requestCode == 0) {
            val uri = data?.data
            Log.v("MainActivity", "Uri: $uri")
            binding.ivPhoto.setImageURI(uri)
        }
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }


}