package mx.edu.ittepic.ladm_u2_practica1_arturolarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var canvas : Canvas ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        canvas = Canvas(this)
        setContentView(canvas)

        Thread(this).start()
    }
}
