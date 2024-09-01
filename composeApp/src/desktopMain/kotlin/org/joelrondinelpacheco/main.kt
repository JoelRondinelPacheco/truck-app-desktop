package org.joelrondinelpacheco

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.truckcontrol.components.NavigationAside
import org.truckcontrol.components.Screen
import org.truckcontrol.screens.HomeScreen
import org.truckcontrol.screens.SummaryScreen
import org.truckcontrol.screens.TasksScreen
import org.truckcontrol.themes.AppTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TruckControlDesktop",
    ) {
        AppTheme {
            var  currentScreen by remember { mutableStateOf(Screen.Home) }
            Row (
                modifier = Modifier.fillMaxSize()
            ) {
                //NavigationAside(onNavigate = { currentScreen = it },
                NavigationAside(onNavigate = { newScreen -> currentScreen = newScreen },
                    currentScreen = currentScreen
                )
                Box( modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
                ) {
                    when (currentScreen) {
                        Screen.Home -> HomeScreen()
                        Screen.Summary -> SummaryScreen()
                        Screen.Tasks -> TasksScreen()
                    }
                }
            }
        }
        //   App()
    }
}