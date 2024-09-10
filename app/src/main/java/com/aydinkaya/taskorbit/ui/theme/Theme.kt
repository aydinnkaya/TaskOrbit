package com.aydinkaya.taskorbit.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TaskOrbitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Dark mode aktif mi?
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFF007AFF),
            secondary = Color(0xFFF50053),
            background = Color.Black, // Arka plan siyah olacak
            surface = Color.DarkGray
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF007AFF),
            secondary = Color(0xFFF50053),
            background = Color.White, // Açık modda beyaz
            surface = Color.LightGray
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography, // Projenizde tanımlı Typography
        content = content
    )
}