package org.truckcontrol.themes

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

// ui/themes/AppTheme.kt
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}
