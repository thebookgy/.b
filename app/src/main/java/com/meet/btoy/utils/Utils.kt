package com.meet.btoy.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*


fun setLocale(context: Context, languageId: String) {
    val config = context.resources.configuration
    val locale = Locale(languageId)
    Locale.setDefault(locale)

    config.setLocale(locale)
    context.createConfigurationContext(config)
}

fun dpToPx(context: Context, dp: Int): Int {
    val displayMetrics = context.resources.displayMetrics
    return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}

fun pxToDp(context: Context, px: Int): Int {
    val displayMetrics = context.resources.displayMetrics
    return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}


fun hideKeyboard(view: View, context: Context) {
    view.apply {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun checkInternet(context: Context): Boolean {
    val mgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = mgr.activeNetworkInfo
    return netInfo != null
}


fun generateRandomChars(length: Int): String {
    val sb = StringBuilder()
    if (length > 0) {
        val candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqestuvwxyz1234567890"
        val random = Random()
        for (i in 0 until length) {
            sb.append(candidateChars[random.nextInt(candidateChars
                    .length)])
        }
    }
    return sb.toString()
}


fun loadStringFromAsset(name: String, context: Context): String? {
    val string: String?
    try {
        val inputStream = context.assets.open(name)
        string = inputStream?.let {
            convertStreamToString(it)
        }

    } catch (ex: Exception) {
        ex.printStackTrace()
        return null
    }
    return string
}

fun convertStreamToString(inputStream: InputStream): String {
    val reader = BufferedReader(InputStreamReader(inputStream))
    val sb = StringBuilder()
    var line: String?
    line = reader.readLine()
    while (line != null) {
        sb.append(line)
        line = reader.readLine()
    }
    reader.close()
    return sb.toString()
}



