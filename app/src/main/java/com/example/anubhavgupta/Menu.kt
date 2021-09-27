package com.example.anubhavgupta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    private var mUserName : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mUserName = intent.getStringExtra(Constants.USER_NAME)



        setContentView(R.layout.activity_menu)

        val gen: Button = findViewById(R.id.gen)
        val apollo: Button = findViewById(R.id.apollo)
        val earth: Button = findViewById(R.id.earth)
        val cs: Button = findViewById(R.id.Constellation)
        val holes: Button = findViewById(R.id.holes)
        gen.setOnClickListener {
            val intent = Intent(this,GS::class.java)
            intent.putExtra(Constants.USER_NAME,mUserName)
            startActivity(intent)
            finish()
        }
        apollo.setOnClickListener {  val intent = Intent(this,AM::class.java)
            startActivity(intent)
            intent.putExtra(AMQ.USER_NAME,mUserName)
            finish() }
        earth.setOnClickListener {  val intent = Intent(this,EQ::class.java)
            intent.putExtra(EQQ.USER_NAME,mUserName)
            startActivity(intent)
            finish() }
        cs.setOnClickListener {  val intent = Intent(this,C::class.java)
            intent.putExtra(CQ.USER_NAME,mUserName)
            startActivity(intent)
            finish() }
        holes.setOnClickListener {  val intent = Intent(this,BH::class.java)
            intent.putExtra(BHQ.USER_NAME,mUserName)
            startActivity(intent)
            finish() }

    }
}