package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnApply.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val birthDate = binding.etBirthDate.text.toString()
            val country = binding.etCountry.text.toString()
            Log.d("MainActivity", "$firstName $lastName $birthDate $country")
            Toast.makeText(this, "$firstName $lastName $birthDate $country", Toast.LENGTH_SHORT).show()
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
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MainActivity", "onActivityResult")
        if (resultCode == RESULT_OK && requestCode == 0) {
            val uri = data?.data
            Log.d("MainActivity", "Uri: $uri")
            binding.ivPhoto.setImageURI(uri)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }


}