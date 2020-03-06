package mx.edu.ittepic.ladm_u2_practica1_arturolarios

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.AsyncTask
import android.view.View

class Canvas(p : MainActivity) : View(p)
{
    var shape : Shapes ?= null

    var r = 25
    var g = 158
    var b = 218

    var balls : Array<Shapes> = Array(500, {Shapes(this)})

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var p = Paint()

        if(shape == null)
        {
            shape = Shapes(this)
        }

        p?.color= Color.rgb(r, g, b)
        shape?.colorSky(p, canvas!!)

        p?.color = Color.YELLOW
        shape?.drawSun(p, canvas!!)

        // --- GRASS ---
        p.color = Color.rgb(53, 104, 45)
        canvas?.drawRect(0f, height.toFloat(), width.toFloat(), height.toFloat() - (height * 0.25f), p)

        p?.color = Color.WHITE
        shape?.drawCloud(p, canvas!!)

        // --- HOUSE ---
        //----------BASE------------
        p.color = Color.rgb(179, 81, 16)
        canvas?.drawRect(width / 3f, height * 0.85f, width * 0.5f + (width * 0.3f), height * 0.85f - (height * 0.2f), p)
        //---------DOOR---------------------
        p.color = Color.rgb(80, 40, 0)
        canvas?.drawRect(width * 0.5f, height * 0.85f, width * 0.5f + (width * 0.1f), height * 0.85f - (height * 0.1f), p)
        //----------WINDOW----------------
        p.color = Color.WHITE
        canvas?.drawCircle(width / 2.4f, height * 0.75f, width * 0.03f, p)
        //----------CEILING--------------------
        var path = Path()
        p.color = Color.GRAY
        path.moveTo(width / 2.5f + (width * 0.15f), height * 0.55f)
        path.lineTo(width / 2.5f + (width * 0.52f), height * 0.7f)
        path.lineTo(width / 2.5f - (width * 0.17f), height * 0.7f)
        path.close();
        canvas?.drawPath(path, p)

        // --- TREE ---
        p.color = Color.rgb(80, 40, 0)
        canvas?.drawRect(width * 0.1f, height * 0.85f, width * 0.1f + (width * 0.05f), height * 0.95f - (height * 0.2f), p)
        p.color = Color.GREEN
        canvas?.drawCircle(width * 0.12f, height * 0.75f, width * 0.1f, p)
        canvas?.drawCircle(width * 0.12f, height * 0.70f, width * 0.1f, p)

        p.color = Color.WHITE
        (0..499).forEach {
            balls[it].snowBall(p, canvas!!)
        }
    }

    fun clearSky()
    {
        shape!!.clearSky()
        invalidate()
    }

    fun toSnow()
    {
        (0..499).forEach {
            balls[it].toSnow()
        }
        invalidate()
    }
}