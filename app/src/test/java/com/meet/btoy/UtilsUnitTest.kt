package com.meet.btoy

import android.content.Context
import com.meet.btoy.utils.convertStreamToString
import com.meet.btoy.utils.generateRandomChars
import com.meet.btoy.utils.loadStringFromAsset
import org.json.JSONObject
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.mock
import java.io.FileInputStream


class UtilsUnitTest {


    @Test
    fun get_string_from_assets_getNull() {
        val context: Context = mock(Context::class.java)
        val a = loadStringFromAsset("test.json", context)
        assertNull(a)
    }

    @Test
    fun get_file_input_stream() {
        val path = "../app/src/test/resources/"
        val ips = FileInputStream(path + "test.json")
        val string = convertStreamToString(ips)
        assertNotNull(string)
        assertNotNull(JSONObject(string) )
    }

    @Test
    fun get_random_string(){
        assertNotNull(generateRandomChars(1))
        assertNotNull(generateRandomChars(0))
        assertNotNull(generateRandomChars(-1))
    }
}