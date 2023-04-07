package com.buanangelica.registrationform

import java.io.Serializable

data class User( val userName: String,
                 val fullName:String,
                 val email: String,
                 val phoneNumber: String,
                 val gender: String,
                 val password: String) : Serializable
