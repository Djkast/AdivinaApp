package com.example.adivinaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIniciar.setOnClickListener {
            startActivity(Intent(this, PrincipalActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_simple, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var msg: String = ""
        //switch
        when (item.itemId){
            R.id.itmInfo-> {
                startActivity(Intent(this, InfoActivity::class.java))
            }
            R.id.itmSalir-> {
                msg="Adios!!!"
                System.exit(0)
            }
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }
}
