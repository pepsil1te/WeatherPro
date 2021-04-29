package com.demoneater.weatherpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class LaunchActivity : AppCompatActivity() {
        private var progressBar: ProgressBar? = null
        private var i = 0
        private var txtView: TextView? = null
        private val handler = Handler()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_launch)
            progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
                i = progressBar!!.progress
                Thread(Runnable {
                    while (i < 100) {
                        i += 5
                        // Update the progress bar and display the current value
                        handler.post(Runnable {
                            progressBar!!.progress = i
                            txtView!!.text = i.toString() + "/" + progressBar!!.max
                        })
                        try {
                            Thread.sleep(100)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }

                    }
                }).start()
            }
        }


