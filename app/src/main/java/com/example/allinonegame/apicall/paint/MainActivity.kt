package com.example.allinonegame.apicall.paint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import com.example.allinonegame.apicall.paint.PaintView.Companion.colorList
import com.example.allinonegame.apicall.paint.PaintView.Companion.currentBrush
import com.example.allinonegame.apicall.paint.PaintView.Companion.pathlist
import com.example.allinonegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }
    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
//        supportActionBar?.hide()

        mainBinding.redBtn.setOnClickListener {
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }
        mainBinding.blueBtn.setOnClickListener {
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }
        mainBinding.blackBtn.setOnClickListener {
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
        }
        mainBinding.eraser.setOnClickListener {
            pathlist.clear()
            colorList.clear()
            path.reset()
        }

    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }
}