package com.uc.chalk.view

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import com.uc.chalk.helper.Const
import com.uc.chalk.model.User
import com.uc.chalk.view.theme.ui.firaSans
import com.uc.chalk.viewmodel.MainViewModel

@Composable
fun HomeScreen(lifecycleOwner: LifecycleOwner,mainViewModel: MainViewModel) {
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
//            modifier = Modifier.clickable {
//                navController.navigate(route = Screen.Chat.passId(5))
//            }, //kalau mau kirim id ke halaman lain
                    modifier = Modifier.weight(4f),
                    text = "Chalk",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = firaSans,
                    fontWeight = FontWeight.Black,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    textAlign = TextAlign.Start,
                )
                val mContext = LocalContext.current
                IconButton(
                    onClick = {
//                        navController.navigate(route = "chat_screen")
                        val intent = Intent(mContext, NewChat::class.java)
                        //   intent.putExtra("username", response.username)
                        mContext.startActivity(intent)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.AddComment,
                        contentDescription = "Add Chat Icon",
                        modifier = Modifier
                            .graphicsLayer {
                                rotationY = 180f
                            }
                            .weight(1f),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                IconButton(

                    onClick = {
//                        navController.navigate(route = "contact_screen") //harusnya ke add contact
                        val intent = Intent(mContext, NewContact::class.java)
//                        //   intent.putExtra("username", response.username)
                        mContext.startActivity(intent)
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
            mainViewModel.getUser(Const.user_id,Const.token)
//            mainViewModel.token.observe(lifecycleOwner, Observer { response ->

                UserProfile(Const.username) //panggil username dan gambar disini
//            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
//    HomeScreen()
}

@Composable
fun UserProfile(username: String) {
//    lateinit var navController: NavController
    val mContext = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth().clickable {
            val intent = Intent(mContext, ViewProfile::class.java)
            //   intent.putExtra("username", response.username)
            mContext.startActivity(intent)
        },
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            imageVector = Icons.Default.Contacts, //ganti gambar user profile
            contentDescription = "User Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
//                .size(20.dp)
                .clip(CircleShape)
                .weight(1f)
        )
        Text(
            text = username, //panggil username
            modifier = Modifier.padding(16.dp,0.dp).weight(3f),
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp
        )
        val mContext = LocalContext.current
        IconButton(
            onClick = {
                val intent = Intent(mContext, ProfileScreen::class.java)
             //   intent.putExtra("username", response.username)
                mContext.startActivity(intent)
//                navController.navigate("edit_profile")
                      },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Outlined.Edit,
                contentDescription = "Edit Icon")
        }
    }
}