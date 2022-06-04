package com.mparee.phoneapp
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
/*class MainActivity : Activity() {
    var veditText1: EditText? = null
    var vbutton1: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veditText1 = findViewById<View>(R.id.edphone) as EditText
        vbutton1 = findViewById<View>(R.id.button1) as Button
        vbutton1!!.setOnClickListener {
                // TODO Auto-generated method stub
                var number = veditText1?.text.toString().trim()
                val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number))
                startActivity(callIntent)
            }
        }
    }*/
//With Permission Codes

class MainActivity : Activity() {
    lateinit var veditText1:EditText
    lateinit var vbutton1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veditText1 = findViewById<View>(R.id.edphone) as EditText
        vbutton1 = findViewById<View>(R.id.button1) as Button


        vbutton1.setOnClickListener {
                  if (ActivityCompat.checkSelfPermission(
                            this,
                            android.Manifest.permission.CALL_PHONE,
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE),200 )
            }
                  else {
                startcall()
            }
        }
    }
            private fun startcall() {
            // TODO Auto-generated method stub
            var number = veditText1.text.toString().trim()
            val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number))
            startActivity(callIntent)
        }
         override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
         {
    if (requestCode == 200)
        startcall()
}
}




