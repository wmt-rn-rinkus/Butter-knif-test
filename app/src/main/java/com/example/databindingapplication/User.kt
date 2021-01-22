package com.example.databindingapplication

import kotlin.properties.Delegates

class User {
    lateinit var name:String
    var age by Delegates.notNull<Int>()
}