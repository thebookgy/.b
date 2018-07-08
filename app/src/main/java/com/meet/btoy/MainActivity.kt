package com.meet.btoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}
