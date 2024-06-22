package com.example.deezerclon.android

import android.annotation.SuppressLint
import androidx.compose.material3.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Inicio()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun TopBarWithButtons(
    modifier: Modifier = Modifier,
    leftButtonAction: () -> Unit = {}, // Empty action by default
    rightButtonAction: () -> Unit = {},
    notificationAction: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = "Your Title") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(15, 13, 19, 1)
        ),
        actions = {
            IconButton(onClick = notificationAction) {
                Icon(Icons.Outlined.Notifications, contentDescription = stringResource(id = R.string.left_button))
            }
            IconButton(onClick = rightButtonAction) {
                Icon(Icons.Outlined.AccountCircle, contentDescription = stringResource(id = R.string.right_button))
            }
        },
        modifier = modifier
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Inicio() {
    Scaffold(
        topBar = {
            TopBarWithButtons(
                leftButtonAction = { /* Handle left button click here */ },
                rightButtonAction = { /* Handle right button click here */ },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Apply fixed padding
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Inicio()
    }
}
