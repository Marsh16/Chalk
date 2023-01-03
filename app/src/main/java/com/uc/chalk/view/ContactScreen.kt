package com.uc.chalk.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uc.chalk.view.theme.ui.firaSans

@Composable
fun ContactScreen() {
    lateinit var navController: NavController
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState(), true, null, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 16.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, bottom = 8.dp)) {
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
//            ContactCard(profileImage = , username = , phone_number = ) isi variablenya disini, krg lazy column
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    ContactScreen()
}

@Composable
fun ContactCard(profileImage: ImageVector, username: String, phone_number: String) {
    lateinit var navController: NavController
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            imageVector = profileImage, //ganti gambar user profile
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
                text = username, //panggil username
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
                text = phone_number,
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