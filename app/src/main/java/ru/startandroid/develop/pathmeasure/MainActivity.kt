package ru.startandroid.develop.pathmeasure

import android.content.Context
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import java.util.Arrays

const val TAG = "myLogs"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(DrawView(this))
    }

    /*internal inner class DrawView(context: Context): View(context) {
        private var paint: Paint = Paint()
        private var paintText: Paint = Paint()
        private var path: Path = Path()
        private var pMeasure: PathMeasure
        private var length: Float

        init {
            paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 3f

            paintText = Paint(Paint.ANTI_ALIAS_FLAG)
            paintText.textSize = 30f

            path.moveTo(100f, 300f)
            path.rLineTo(150f, 100f)
            path.rLineTo(150f, -100f)
            path.rQuadTo(150f, 200f, 300f, 0f)
            path.rLineTo(150f, 100f)
            path.rLineTo(150f, -100f)

            pMeasure = PathMeasure(path, false)
            length = pMeasure.length
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)

            canvas.drawPath(path, paint)
            canvas.drawText(String.format("Length: %s", length), 100f, 100f, paintText)
        }
    } */
    /*internal inner class DrawView(context: Context): View(context) {
        private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var paintText: Paint
        private var path: Path = Path()
        private var pMeasure: PathMeasure
        private var matriX: Matrix = Matrix()
        private var rect: Rect

        private var pos = floatArrayOf()
        private var tan = floatArrayOf()

        private var length: Float
        private var distance: Float

        init {
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 3f

            paintText = Paint(Paint.ANTI_ALIAS_FLAG)
            paintText.textSize = 30f

            path.moveTo(100f, 300f)
            path.rLineTo(150f, 100f)
            path.rLineTo(150f, -100f)
            path.rQuadTo(150f, 200f, 300f, 0f)
            path.rLineTo(150f, 100f)
            path.rLineTo(150f, -100f)

            pMeasure = PathMeasure(path, false)

            length = pMeasure.length
            distance = length / 4

            pMeasure.getMatrix(distance, matriX,
                PathMeasure.POSITION_MATRIX_FLAG
                        + PathMeasure.TANGENT_MATRIX_FLAG)

            pos = FloatArray(2)
            tan = FloatArray(2)
            pMeasure.getPosTan(distance, pos, tan)

            rect = Rect(-20, -10, 20, 10)
        }

        override fun onDraw(canvas: Canvas?) {
            canvas!!.drawARGB(80, 102, 204, 255)

            canvas.drawPath(path, paint)
            canvas.drawText(
                String.format("Distance: %s of %s", distance, length), 100f,
                100f, paintText)
            canvas.drawText(
                String.format("Position: %s. Tangent (cos,sin): %s",
                    pos.contentToString(), tan.contentToString()), 100f, 150f, paintText)

            canvas.setMatrix(matriX)
            canvas.drawRect(rect, paint)
        }
    }*/
    /*internal inner class DrawView(context: Context): View(context) {
        private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var path: Path = Path()
        private var pMeasure: PathMeasure

        init {
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 3f

            path.moveTo(100f, 300f)
            path.rLineTo(150f, 150f)
            path.rLineTo(150f, -100f)

            path.rMoveTo(0f, 0f)
            path.rQuadTo(150f, 200f, 300f, 0f)
            path.close()

            path.rMoveTo(0f, 0f)
            path.rLineTo(150f, 100f)
            path.rLineTo(150f, -150f)
            path.close()

            pMeasure = PathMeasure(path, false)
            do {
                Log.d(TAG, String.format("Length: %s, isClosed: %s",
                pMeasure.length, pMeasure.isClosed))
            } while (pMeasure.nextContour())
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)
            canvas.drawPath(path, paint)
        }
    }*/

    internal inner class DrawView(context: Context): View(context) {
        private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var path: Path = Path()
        private var path1: Path = Path()
        private var pMeasure: PathMeasure

        init {
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 3f

            path.moveTo(100f, 300f)
            path.rLineTo(150f, 150f)
            path.rLineTo(150f, -100f)
            path.rQuadTo(150f, 200f, 300f, 0f)
            path.rLineTo(150f, 100f)
            path.rLineTo(150f, -150f)

            pMeasure = PathMeasure(path, false)

            path1 = Path()
            pMeasure.getSegment(150f, 850f, path1, true)
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)
            canvas.drawPath(path1, paint)
        }
    }
}