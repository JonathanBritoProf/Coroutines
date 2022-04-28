package br.digitalhouse.threadsecoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    var timer1 : Double = 0.00
    var timer2 : Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1 = findViewById<Button>(R.id.timer_1_start_btn)
        var btn2 = findViewById<Button>(R.id.timer_2_start_btn)
        var btnreset = findViewById<Button>(R.id.reset_timer_btn)


        btn1.setOnClickListener {

            lifecycleScope.launch {
                somar1S()
            }
        }
        btn2.setOnClickListener {

        }
        btnreset.setOnClickListener {

        }
        updateTimes()
    }

    private fun updateTimes() {
        var txt1 = findViewById<TextView>(R.id.timer_1_tv)
        var txt2 = findViewById<TextView>(R.id.timer_2_tv)
        txt1.text = timer1.toString()
        txt2.text = timer2.toString()
    }

    private suspend fun somar1S(){
        delay(1000)
        timer1 += 1.0
        updateTimes()
    }


}

