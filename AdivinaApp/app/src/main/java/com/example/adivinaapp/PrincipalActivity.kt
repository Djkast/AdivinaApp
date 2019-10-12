package com.example.adivinaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_principal.*
import kotlin.random.Random
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem


class PrincipalActivity : AppCompatActivity() {

    val correctas: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        var ran: Int = Random.nextInt(0, 3)
        var correcto: Int = 0

        class Adivinanzas(val id: Int, val adivinanza: String, val op1: String, val op2: String, val op3: String, val res: String)


            val adivinanzas: Array<Adivinanzas> = arrayOf(
                Adivinanzas(0,"Teclas tengo sin ser piano y mi tamaño es pequeño: conmigo puede mi dueño ahorrar fatiga a su mano.","Piano","Máquina de escribir","Acordeon","Máquina de escribir"),
                Adivinanzas(1,"Mi tía Cuca tiene una mala racha, ¿quién será esta muchacha?","La araña","La abeja","La cucaracha","La cucaracha"),
                Adivinanzas(2,"¿Qué animal tiene las cinco vocales?","El murciélago","El perro","La vaca","El murciélago"),
                Adivinanzas(3,"Canto en la orilla, vivo en el agua, no soy pescado, ni soy cigarra.","La araña","La rana","El grillo","La rana"))

        txvAdivinanza.text = adivinanzas.get(ran).adivinanza.toString()
        btn1.text = adivinanzas.get(ran).op1.toString()
        btn2.text = adivinanzas.get(ran).op2.toString()
        btn3.text = adivinanzas.get(ran).op3.toString()
        val res: String = adivinanzas.get(ran).res.toString()
        val refresh = Intent(this, PrincipalActivity::class.java)

        btn1.setOnClickListener {
            if (res == btn1.text){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                correcto += 1
                finish()
                startActivity(refresh)
            }
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }

        btn2.setOnClickListener {
            if (res == btn2.text){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                correcto += 1
                finish()
                startActivity(refresh)
            }
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }

        btn3.setOnClickListener {
            if (res == btn3.text){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                correcto += 1
                finish()
                startActivity(refresh)
            }
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var msg: String = ""
        //switch
        when (item.itemId){
            R.id.itmRegresarMenu-> {
                finish()
            }
            R.id.itmAciertos-> {
                msg="$correctas adivinanzas correctas"
            }
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }
}
