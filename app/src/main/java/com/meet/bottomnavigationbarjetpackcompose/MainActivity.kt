package com.meet.bottomnavigationbarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.meet.bottomnavigationbarjetpackcompose.screens.MainScreen
import com.meet.bottomnavigationbarjetpackcompose.ui.theme.BottomNavigationBarJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBarJetpackComposeTheme {
                MainScreen()
            }
        }
    }
}
