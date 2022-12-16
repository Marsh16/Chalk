package com.uc.chalk.model

data class MessageChannel (
    val id: Int,
    val messages: String,
    val channel_id: String,
    val contact_id: String,
    val user_id: String,

)