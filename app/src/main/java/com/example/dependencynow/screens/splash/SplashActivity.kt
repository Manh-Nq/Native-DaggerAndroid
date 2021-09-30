package com.example.dependencynow.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencynow.MyApp
import com.example.dependencynow.databinding.ActivitySplashBinding
import com.example.dependencynow.screens.main.MainActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewmodel: SplashViewModel

    lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val component = (application as MyApp).component.getSplashComponent().create()
        component.inject(this)
        viewmodel._loadData.observe(this) {
            if (!it) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

}