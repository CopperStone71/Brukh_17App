package com.example.a17app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SingInActivity(navController: NavController){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
    ){
        Image(
            painter = painterResource(id = R.drawable.carscreen),
            contentDescription = "carbackground",
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .alpha(0.3f),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .align(Center)
        ){
            TextField(
                value = login,
                onValueChange = {login = it},
                label = { Text("Login")},
                shape = RoundedCornerShape(15.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = "loginIcon")},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    focusedLabelColor = Color.Black
                ),
                modifier = Modifier
                    .padding(14.dp)


            )
            TextField(
                value = password,
                onValueChange = {password = it},
                label = {Text("Password")},
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(15.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "passwordIcon")},
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    focusedLabelColor = Color.Black
                ),
                modifier = Modifier
                    .padding(14.dp)
            )
            Button(
                onClick = {navController.navigate("MapActivity")},
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(14.dp)
            ) {
                Text(
                    text = "Sing In",
                    fontSize = 20.sp
                )
            }
            Text(
                text = "Create a new account",
                color = Color.DarkGray,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 30.dp)
                    .clickable {
                        navController.navigate("SingUpActivity")
                    }
                    .align(CenterHorizontally)
            )
        }
    }


}