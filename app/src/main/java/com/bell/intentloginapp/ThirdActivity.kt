package com.bell.intentloginapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bell.intentloginapp.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private val TAG = "ThirdActivityLifecycle"

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari SecondActivity
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        // Set data ke TextViews
        binding.userThird.text = "Username: $username"
        binding.emailThird.text = "Email: $email"
        binding.phoneThird.text = "Phone: $phone"

        Log.d(TAG, "onCreate: called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: dipanggil")
    }
}
