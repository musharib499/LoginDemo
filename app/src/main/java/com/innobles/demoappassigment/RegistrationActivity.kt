package com.innobles.demoappassigment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.innobles.demoappassigment.ui.main.RegistrationFragment

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegistrationFragment.newInstance())
                .commitNow()
        }
    }
}