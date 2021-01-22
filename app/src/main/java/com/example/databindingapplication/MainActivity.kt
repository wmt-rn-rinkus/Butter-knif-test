package com.example.databindingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        val user = User()
user.name="Rinku"
        user.age=20

        binding.user=user
    }


}