package org.geeksforgeeks.toastdisplaylength

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val mToastDuration = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.text_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        val mToast = Toast.makeText(applicationContext, "Sample Toast", Toast.LENGTH_LONG)

        mButton.setOnClickListener {
            mDisplayTimer(mTextView)
            mDisplayToast(mToast)
        }
    }

    private fun mDisplayTimer(view: TextView){
        Thread {
            val mToastDurationSecs = mToastDuration/1000
            for (i in 1..mToastDurationSecs) {
                runOnUiThread {
                    view.text = i.toString()
                }
                Thread.sleep(1000)
            }
        }.start()
    }

    private fun mDisplayToast(toast: Toast){
        Thread{
            for(i in 1..mToastDuration/2000){
                toast.show()
                Thread.sleep(2000)
                toast.cancel()
            }
        }.start()

    }
}