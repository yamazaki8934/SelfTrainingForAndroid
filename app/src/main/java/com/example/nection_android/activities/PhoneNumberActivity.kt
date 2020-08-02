package com.example.nection_android.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nection_android.R
import com.example.nection_android.api.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_phone_number.*

class PhoneNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)
        onActivtityCreated(savedInstanceState)
    }

    fun onActivtityCreated(savedInstanceState: Bundle?) {
        phoneNumberNextButton.setOnClickListener { onNextButtonTapped() }
    }

    fun onNextButtonTapped() {
        // ここでHttp通信の動作検証を行う
        ApiClient.postPhoneNumber()
            .phoneAuth(phoneNumber = phoneNumberEditText.text.toString(), countryCode = 81)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              println("aaaa")
            }, {
              println("aaaa")
            })
    }
}