package com.example.movidex.UI.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movidex.R
import com.example.movidex.UI.Fragments.secondFragment

class Main2Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var intent = intent
        var fragment = secondFragment.newInstance(intent.getParcelableExtra("movie"))

        supportFragmentManager.beginTransaction().replace(R.id.fragment_secundario, fragment).commit()
    }
}
