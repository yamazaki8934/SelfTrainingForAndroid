package com.example.nection_android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nection_android.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        smsButton.setOnClickListener {onSmsButtonTapped()}
        facebookButton.setOnClickListener { onFacebookButtonTapped() }
    }

    fun onSmsButtonTapped() {
        val intent = Intent(this, PhoneNumberActivity::class.java)
        startActivity(intent)
    }

    fun onFacebookButtonTapped() {

    }
}