package com.example.singletouch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity()   {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Creamos listener sobre texto
        texto.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> Toast.makeText(applicationContext, "ACTION_DOWN", LENGTH_SHORT).show()
                    MotionEvent.ACTION_MOVE-> Toast.makeText(applicationContext, "ACTION_MOVE", LENGTH_SHORT).show()
                    MotionEvent.ACTION_SCROLL -> Toast.makeText(applicationContext, "ACTION_SCROLL", LENGTH_SHORT).show()
                }

                return v?.onTouchEvent(event) ?: true
            }
        })

//Creamos listener sobre button
       button.setOnClickListener(object : View.OnClickListener {
           override fun onClick(v: View) {
               toast("OnClick")
           }
       })



    }


//Creamos listener Touch sobre cualquier objeto

    override fun onTouchEvent( e: MotionEvent): Boolean {

        when (e.action) {
            MotionEvent.ACTION_UP -> {

                toast("OnTouchEvent")
            }
        }
        return true
    }


    fun toast(s:String){
        Toast.makeText(applicationContext, s, LENGTH_SHORT).show()
    }


}
