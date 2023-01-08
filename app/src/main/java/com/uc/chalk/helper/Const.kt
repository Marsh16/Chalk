package com.uc.chalk.helper

import com.uc.chalk.model.Contact
import com.uc.chalk.model.Chat
import com.uc.chalk.model.Message

object Const {
    const val BASE_URL_LOCALHOST = "http://192.168.43.106:7070"
    var userfail = ""
    //pakai variable untuk simpan , (bisa pakai put extra)
    var user_id = ""
    var username = ""
    var token = ""
    var contacts= ArrayList<Contact>()
    var chats= ArrayList<Chat>()
    var messages= ArrayList<Message>()
    var contactnameselected=""
    var contact_id = ""
}