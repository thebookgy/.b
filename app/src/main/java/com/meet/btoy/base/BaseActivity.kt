package com.meet.btoy.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import androidx.annotation.NonNull
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment




abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    abstract fun init()

    fun hideKeyboard() {
        val view = this.currentFocus
        view.let {
            val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.let {
                it.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }



    fun onReplaceFragment(@IdRes containerViewId: Int, @NonNull fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(containerViewId, fragment)
                .commit()
    }
}