package com.example.administrator.eliza

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mcandroid.eliza.Eliza
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userQuestion = findViewById<TextView>(R.id.txtQuestion)
        var answer = findViewById<TextView>(R.id.lblResponse)
        var submit = findViewById<Button>(R.id.btnSubmit)
        var e = Eliza()



        submit.setOnClickListener {
            e.ask(userQuestion.text.toString())
            answer.text = e.generateResponse()
        }

    }
}
