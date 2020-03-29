package com.e.myforgroundservice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_service.setOnClickListener(View.OnClickListener {
            val input: String = edit_text.text.toString()

            val serviceIntent = Intent(this, ExampleService::class.java)
            serviceIntent.putExtra("inputExtra", input)

            ContextCompat.startForegroundService(this, serviceIntent)
        })
    }
}
