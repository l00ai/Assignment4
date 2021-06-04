package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            val intent = Intent(this , StreamingActivity::class.java )
            intent.putExtra("video" , 1)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this , StreamingActivity::class.java )
            intent.putExtra("video" , 2)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(this , StreamingActivity::class.java )
            intent.putExtra("video" , 3)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            val intent = Intent(this , StreamingActivity::class.java )
            intent.putExtra("video" , 4)
            startActivity(intent)
        }

    }
}