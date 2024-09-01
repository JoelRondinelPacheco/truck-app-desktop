package org.truckcontrol.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// ui/components/NavigationAside.kt
@Composable
fun NavigationAside(
    onNavigate: (Screen) -> Unit,
    currentScreen: Screen
) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .fillMaxHeight()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        NavigationItem("Inicio", Screen.Home, onNavigate, currentScreen == Screen.Home)
        NavigationItem("Resumen", Screen.Summary, onNavigate, currentScreen == Screen.Summary)
        NavigationItem("Tareas", Screen.Tasks, onNavigate, currentScreen == Screen.Tasks)
    }
}

@Composable
fun NavigationItem(
    text: String,
    screen: Screen,
    onNavigate: (Screen) -> Unit,
    isSelected: Boolean
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        onClick = { onNavigate(screen) },
        colors = if (isSelected) ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        ) else ButtonDefaults.buttonColors()
    ) {
        Text(text)
    }
}

enum class Screen { Home, Summary, Tasks }
