package com.example.testkotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userText.text = "Hello Kotlin!!!"

        testBtn.setOnClickListener {
            var name: String = nameEditText.text.toString()
            if (name.isNotBlank()) {
                toast(name)
            } else {
                toast("please input name")
            }
        }
    }
}
