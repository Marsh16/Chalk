package com.uc.chalk.view

//import androidx.compose.foundation.layout.RowScopeInstance.weight
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.get
import com.uc.chalk.helper.Const
import com.uc.chalk.model.Contact
import com.uc.chalk.model.ContactList
import com.uc.chalk.retrofit.EndPointApi
import com.uc.chalk.view.theme.ui.ChalkTheme
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@Composable
fun ContactScreen(lifecycleOwner: LifecycleOwner, mainViewModel: MainViewModel) {
   // lateinit var mainViewModel: MainViewModel
    lateinit var navController: NavController

    mainViewModel.getContact(Const.user_id)

//
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState(), true, null, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, bottom = 8.dp)
            ) {
                Text(
                    modifier = Modifier.weight(5f),
                    text = "Contacts",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Black,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    textAlign = TextAlign.Start,
                )
                IconButton(
                    onClick = {
                        navController.navigate(route = "contact_screen") //harusnya ke addContact
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.PersonAdd,
                        contentDescription = "Add Contact Icon",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f)
                    )
                }
            }


            Log.e("masuk", Const.user_id)


        //mainViewModel.contact.observe(lifecycleOwner, Observer { response->
            //menampilkan data di layar
            //ContactList(contactList = response)
                        //ContactList(Const.contacts)
                       // Log.e("contact screen", ContactList(Const.contacts).toString())
            for (i in Const.contacts){
                //Log.e("contact screen", i.toString())
                ContactCard(i)
                Log.e("contact screen", ContactList(Const.contacts).toString())
            }


       // })
        }


    }
}

@Composable
fun ContactList(contactList: ArrayList<Contact>) {
    LazyColumn{
        itemsIndexed(items = contactList){index, item ->
            ContactCard(contact = item)
            Log.e("ok","ok")
            if(  ContactCard(contact = item) != ContactCard(contact = item)){
                Log.e("error","should be "+ ContactCard(contact = item))
                throw AssertionError()
            }else{
                Log.e("ok","ok")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
//    ContactScreen
}

@Composable
fun ContactCard(contact: Contact) {

//    lateinit var navController: NavController
    lateinit var navController: NavController

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        Image(
//            icon_filled = Icons.Default.Chat,
            imageVector = Icons.Default.Contacts, //ganti gambar user profile
            contentDescription = "User Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .weight(1f)
        )
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(3f)
            .padding(16.dp, 0.dp)
        ) {
            Text(
                text = contact.name, //panggil username
                modifier = Modifier
                    .padding(0.dp, bottom = 4.dp)
                    .weight(3f),
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp
            )
            Text(
                text = contact.name,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = contact.phone_number,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        IconButton(
            onClick = { navController.navigate("editprofile_screen") }, //harusnya delete contact
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete Icon")
        }
        IconButton(
            onClick = { navController.navigate("editprofile_screen") },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = "Edit Icon")
        }
    }

}