package com.meet.btoy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun init() {
        
    }


}
