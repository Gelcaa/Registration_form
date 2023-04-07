package com.buanangelica.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_submit.setOnClickListener {
            onSummaryClicked()
        }

        val spinnerValues : Array<String> = arrayOf("Female", "Male", "Preferred not said")
        val SpinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        spinner_gender.adapter = SpinnerAdapter

    }
    private fun onSummaryClicked(){
        val user = User(
            text_view_username.text.toString(),
            text_view_fullname.text.toString(),
            text_view_email.text.toString(),
            text_view_phone_number.text.toString(),
            spinner_gender.selectedItem.toString(),
            text_view_password.text.toString()

        )

val summaryActivityIntent = Intent(this, Summary::class.java)
        summaryActivityIntent.putExtra("User",user)
        startActivity(summaryActivityIntent)



    }
}




