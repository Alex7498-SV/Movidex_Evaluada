package com.example.movidex

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_principal.*

class MainActivity : AppCompatActivity(), principalFragment.OnFragmentInteractionListener , secondFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(fragment_secundario != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_secundario, secondFragment()).commit()
        }

        btnAceptar.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }

    }
}
