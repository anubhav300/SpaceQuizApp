package com.example.anubhavgupta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btn_start)
        button.setOnClickListener {
            val et_name = findViewById<TextView>(R.id.et_name)
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()

            }
            else{
                val intent = Intent(this,Menu::class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                intent.putExtra(AMQ.USER_NAME,et_name.text.toString())
              intent.putExtra(BHQ.USER_NAME,et_name.text.toString())
              intent.putExtra(CQ.USER_NAME,et_name.text.toString())
                intent.putExtra(EQQ.USER_NAME,et_name.text.toString())

                startActivity(intent)

                finish()
            }
        }



    }
    }
