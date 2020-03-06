package mx.edu.ittepic.ladm_u2_practica1_arturolarios

import java.lang.Thread

class Thread(m : MainActivity) : Thread()
{
    var main = m

    override fun run() {
        super.run()

        sleep(5000)
        while(true)
        {
            sleep(10)
            main.runOnUiThread {
                main.canvas!!.clearSky()
                main.canvas!!.toSnow()
            }
        }
    }
}