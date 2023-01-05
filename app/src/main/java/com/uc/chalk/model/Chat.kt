package com.uc.chalk.model

data class Chat (
    val status: Int,
    val message: String,
    val data: List<Data>,
    )