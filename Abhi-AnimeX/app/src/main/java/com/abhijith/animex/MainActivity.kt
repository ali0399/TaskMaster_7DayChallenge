package com.abhijith.animex

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.abhijith.animex.ui.screens.animedetails.AnimeDetails
import com.abhijith.animex.ui.theme.AnimeXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.WHITE),
            navigationBarStyle = SystemBarStyle.dark(Color.WHITE)
        )
        setContent {
            AnimeXTheme {
                Scaffold() {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .background(color = androidx.compose.ui.graphics.Color.White)
                    ) {
                        AnimeDetails()
                    }
                }
            }
        }
    }
}