package com.uc.chalk.model

data class User (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone_number: String,
    val dateofbirth: String,
    val password: String
)