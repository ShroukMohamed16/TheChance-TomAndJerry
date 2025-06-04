package com.shrouk.tomandjerry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shrouk.tomandjerry.screens.JerryStoreScreen
import com.shrouk.tomandjerry.screens.TomAccountScreen
import com.shrouk.tomandjerry.screens.TomKitchenScreen
import com.shrouk.tomandjerry.ui.theme.TomAndJerryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TomAndJerryTheme {
                JerryStoreScreen()
                TomAccountScreen()
                TomKitchenScreen()
            }
        }
    }
}

