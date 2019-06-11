package com.example.movidex

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Main2Activity : AppCompatActivity(), secondFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}
