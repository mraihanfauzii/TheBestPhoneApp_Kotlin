package com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    //Lama waktu splash screen muncul
    private val SPLASH_TIME_OUT:Long = 2000 //2 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
        getSupportActionBar()?.hide();
    }
}