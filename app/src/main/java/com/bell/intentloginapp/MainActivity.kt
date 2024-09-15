package com.bell.intentloginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bell.intentloginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRegisterButton.setOnClickListener {
                // Intent untuk berpindah ke SecondActivity (layout login)
                val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)

                // Mengambil input dari TextInputLayout
                val username = username.editText?.text.toString()
                val email = email.editText?.text.toString()
                val phone = phone.editText?.text.toString()

                // Mengirim data ke SecondActivity
                intentToSecondActivity.putExtra(EXTRA_USERNAME, username)
                intentToSecondActivity.putExtra(EXTRA_EMAIL, email)
                intentToSecondActivity.putExtra(EXTRA_PHONE, phone)

                // Memulai SecondActivity
                startActivity(intentToSecondActivity)
            }
        }

        Log.d(TAG, "onCreate: dipanggil")
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
