package com.tanamo.osm.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.tanamo.osm.R
import com.tanamo.osm.util.Kons.COUNTS
import com.tanamo.osm.util.Kons.FIRSTCHECK
import com.tanamo.osm.util.Kons.PROF
import com.tanamo.osm.util.Kons.TAGG


class Flash : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAGG, "onCreate: ")
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.flash)

        init()

    }

    // Called in the onCreate Function.
    private fun init() {

        if (!PrefM(this@Flash).isFirstTimeLaunch()) {
            val intent = Intent(this, Adder::class.java)
            startActivity(intent)
            this@Flash.finish()
        } else {
            metho()
        }

    }

    // Check First Function.
    private fun metho() {
        PrefM(this@Flash).setFirstTimeLaunch(false)
        Handler().postDelayed({
            this@Flash.finish()
            val mainIntent = Intent(this@Flash, Adder::class.java)
            this@Flash.startActivity(mainIntent)
        }, COUNTS.toLong()) //


    }

    // Using shared preference to check for first time launch.
    inner class PrefM(_context: Context) {

        private val pref: SharedPreferences
        private val editor: SharedPreferences.Editor
        private val mode = 0


        init {
            pref = _context.getSharedPreferences(PROF, mode)
            editor = pref.edit()
        }

        fun setFirstTimeLaunch(isFirstTime: Boolean) {
            editor.putBoolean(FIRSTCHECK, isFirstTime)
            editor.commit()
        }

        fun isFirstTimeLaunch(): Boolean {
            return pref.getBoolean(FIRSTCHECK, true)
        }

    }

}
