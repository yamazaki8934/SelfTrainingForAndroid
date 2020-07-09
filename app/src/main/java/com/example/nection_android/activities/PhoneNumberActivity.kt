package com.example.nection_android.activities

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.nection_android.R
import com.example.nection_android.api.ApiClient
import com.example.nection_android.api.ApiConfig
import com.example.nection_android.api.endpoint.PhoneAuthApis
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.content_phone_number.*

class PhoneNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        nextButton.setOnClickListener { onNextButtonTapped() }
    }

    fun onNextButtonTapped() {
        ApiClient.getClient().create(PhoneAuthApis::class.java)
                             .phoneAuth(phoneNumber = inputNumberField.text.toString(), countryCode = 81)
                             .observeOn(AndroidSchedulers.mainThread())
                             .subscribe({
                                 println("aaaa")
                             }, {
                                 println("aaaa")
                             })
    }
}