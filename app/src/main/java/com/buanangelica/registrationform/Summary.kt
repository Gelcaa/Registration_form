package com.buanangelica.registrationform

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_summary.*

class Summary : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var username: String
    private lateinit var fullname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        displaySummary()
        messageButton()
        emailButton()

    }


    private fun displaySummary(){
        user = intent.getSerializableExtra("User") as User
        username= "User: ${user.userName}"
        fullname = "Full name: ${user.fullName}"

        text_view_summary_username.text = username
        text_view_summary_fullname.text = fullname
    }

    private fun messageButton(){
        image_button_message.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${user.phoneNumber}")  // This ensures only SMS apps respond

            }
            startActivity(intent)
        }
    }
    private fun emailButton(){
        image_button_email.setOnClickListener {
            val launchEmailAppIntent = Intent(Intent.ACTION_SENDTO)
            launchEmailAppIntent.data =
                Uri.parse("mailto: ${user.email}") // only email apps should handle this
            startActivity(launchEmailAppIntent)
        }
    }

}

