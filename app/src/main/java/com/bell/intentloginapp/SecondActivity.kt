package com.bell.intentloginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bell.intentloginapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val TAG = "SecondActivityLifecycle"

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout menggunakan ViewBinding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menerima data dari MainActivity
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val email = intent.getStringExtra(EXTRA_EMAIL)
        val phone = intent.getStringExtra(EXTRA_PHONE)

        // Logika tombol login
        binding.loginButton.setOnClickListener {
            val enteredEmail = binding.emailSecond.editText?.text.toString()
            val enteredPassword = binding.passSecond.editText?.text.toString()

            if (enteredEmail == email && enteredPassword == enteredPassword) {
                // Jika email dan password benar, kirim data ke ThirdActivity
                val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java).apply {
                    putExtra(ThirdActivity.EXTRA_USERNAME, username)
                    putExtra(ThirdActivity.EXTRA_EMAIL, enteredEmail)
                    putExtra(ThirdActivity.EXTRA_PHONE, phone)
                }

                startActivity(intentToThirdActivity)
            } else {
                // Jika email atau password salah
                Log.d(TAG, "Login Gagal: Email atau password salah")
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
