package com.uc.chalk.model

data class MessageGroup (
    val id: Int,
    val messages: String,
    val group_id: String,
    val contact_id: String,
    val user_id: String,
    )

