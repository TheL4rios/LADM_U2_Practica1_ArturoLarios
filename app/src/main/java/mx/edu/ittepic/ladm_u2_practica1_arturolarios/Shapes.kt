package mx.edu.ittepic.ladm_u2_practica1_arturolarios

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Shapes(v : View)
{
    var v : View ?= v

    var width = v.width.toFloat()

    var radio = 300f
    var sunX = width
    var cloudX = width * 0.277f//300f
    var cloud2X = width * 0.185f//200f
    var cloud3X = width * 0.37f//400f

    var y : Float = -5000f
    var x : Float = (0..1500).random().toFloat()
    var size : Float = (0..20).random().toFloat()

    var incY = (0..10).random().toFloat()

    fun clearSky()
    {
        if(sunX < width + radio || cloud3X > width * -0.0925f)
        {
            cloudX -= 1f
            cloud2X -= 1f
            cloud3X -= 1f

            sunX += 1f
        }
    }

    fun snowBall(p : Paint, canvas : Canvas)
    {
        canvas.drawCircle(x, y, size, p)
    }

    fun toSnow()
    {
        y += incY
        if(y > 3000)
        {
            y = -30f
            x = (0..1500).random().toFloat()
            size = (0..20).random().toFloat()
            incY = (0..10).random().toFloat()
        }
    }

    fun drawSun(p : Paint, canvas : Canvas)
    {
        // --- SUN ---
        canvas?.drawCircle(sunX, 0f, radio, p!!)
    }

    fun colorSky(p : Paint, canvas : Canvas)
    {
        // --- SKY ---
        canvas?.drawRect(0f,0f,width,v!!.height.toFloat(),p!!)
    }

    fun drawCloud(p : Paint, canvas : Canvas)
    {
        // --- CLOUD ---
        canvas?.drawCircle(cloudX, 400f, 100f, p!!)
        canvas?.drawCircle(cloudX, 600f, 100f, p!!)
        canvas?.drawCircle(cloud3X, 500f, 100f, p!!)
        canvas?.drawCircle(cloud2X, 500f, 100f, p!!)
    }
}