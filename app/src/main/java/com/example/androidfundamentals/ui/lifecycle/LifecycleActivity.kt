package com.example.androidfundamentals.ui.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.R

class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LifecycleFragment.newInstance())
                .commitNow()
        }
    }
}