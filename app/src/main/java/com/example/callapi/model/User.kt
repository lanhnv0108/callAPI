package com.example.callapi.model

class User(
    val id : Int,
    val name :String,
    val isActive : Boolean,
    val job : Job,
    val favorite: ArrayList<Favorite>
) {
}