package com.example.mod4chat

import java.time.LocalDateTime

/*data*/ class Message(
    val user: String = "Moi",
    var message: String,
    var date: LocalDateTime = LocalDateTime.now()
)                       //Data
//Constructeur          //equals
//Getter                //toString()
//Setter                //copy
                        //hashcode
