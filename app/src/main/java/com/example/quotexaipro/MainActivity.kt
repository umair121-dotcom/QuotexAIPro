package com.example.quotexaipro

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var status: TextView
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 32, 28, 32)
            setBackgroundColor(Color.rgb(12, 17, 27))
        }
        fun text(value: String, size: Float, color: Int, bold: Boolean = false) =
            TextView(this).apply {
                text = value
                textSize = size
                setTextColor(color)
                gravity = Gravity.CENTER
                if (bold) setTypeface(null, android.graphics.Typeface.BOLD)
                setPadding(8, 12, 8, 12)
            }

        root.addView(text("QUOTEX AI PRO", 28f, Color.WHITE, true))
        root.addView(text("SCREEN-CAPTURE DEMO", 13f, Color.LTGRAY, true))
        status = text("Status: Demo mode — no live chart connected", 15f, Color.LTGRAY)
        root.addView(status)
        result = text("No signal generated", 24f, Color.WHITE, true)
        root.addView(result)

        val analyze = Button(this).apply {
            text = "RUN DEMO ANALYSIS"
            setOnClickListener {
                result.text = "SCREENSHOT REQUIRED"
                status.text = "Demo only: add chart capture + validated candle recognition first."
            }
        }
        root.addView(analyze, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ))

        root.addView(text(
            "This starter does not read Quotex charts, calculate indicators, or place trades. " +
            "It intentionally does not fabricate BUY/SELL calls. Use a demo account only.",
            13f, Color.LTGRAY
        ))
        setContentView(root)
    }
}
