package com.edgetechs.lifeactivity

import android.content.Context
import android.content.Context.*
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LOGINK : AppCompatActivity()  {
    private lateinit var etmobno : EditText
lateinit var txtpass : TextView
    private lateinit var btnlogin : Button
   private lateinit var txtforgot : TextView
    private lateinit var txtreg : TextView
    val validmob = "12345"
    val validpass = arrayOf("thanos","tony","steve","bruce")

    lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences= getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(R.layout.activity_new)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedin",false)
        if (isLoggedIn){
            val intent=Intent(this@LOGINK ,MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        etmobno=findViewById(R.id.etmobno)
        txtpass=findViewById(R.id.txtpass)
        btnlogin=findViewById(R.id.btnlogin)
        txtforgot=findViewById(R.id.txtforgot)
        txtreg=findViewById(R.id.txtreg)
        var mobno=etmobno.text.toString()
        var pass =txtpass.text.toString()
        val intent=Intent(this@LOGINK ,MainActivity::class.java)
        var nameavg ="Avengers"
        btnlogin.setOnClickListener{

            val  mobno =etmobno.text.toString()
            val pass =txtpass.text.toString()
            if (mobno==validmob)
            {
                if (pass==validpass[0]){

                        nameavg = "AVENGERS"
                    sharepreferences(nameavg)


                        startActivity(intent)
                    }
                    else if(pass==validpass[1])
                    {
                        nameavg = "IRONMAN"
                        sharepreferences(nameavg)


                        startActivity(intent)
                    }
                    else if(pass==validpass[2] )
                    {
                        nameavg = "CAPTAIN AMERICA"
                        sharepreferences(nameavg)


                        startActivity(intent)
                    }
                    else if(pass==validpass[3] )
                    {
                        nameavg = "HULK"
                        sharepreferences(nameavg)

                        startActivity(intent)
                    }
                    else{ Toast.makeText(this@LOGINK, "invalid id pass", Toast.LENGTH_LONG).show()}



            }
                else{
                    Toast.makeText(this@LOGINK, "invalid id pass", Toast.LENGTH_LONG).show()
                }

    }}

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun sharepreferences(title:String)
    {
        sharedPreferences.edit().putBoolean("isLoggedin",true).apply()
        sharedPreferences.edit().putString("title",title).apply()
    }
}