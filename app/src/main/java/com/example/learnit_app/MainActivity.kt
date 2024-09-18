package com.example.learnit_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit_app.ui.theme.Learnit_appTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Learnit_appTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.background), // Reemplaza con tu recurso de fondo
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop, // Ajusta la imagen al tamaño de la pantalla
            modifier = Modifier.fillMaxSize()
        )

        // Logo y texto centrado
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_learnit), // Logo PNG o JPG
                contentDescription = "Logo Learnit",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bienvenido a Learnit!",
                style = MaterialTheme.typography.titleLarge
            )
        }

        // Botón flotante para el menú
        MenuButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
    }
}

@Composable
fun MenuButton(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        // Botón flotante
        IconButton(onClick = { expanded = true }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Menú")
        }

        // Menú desplegable
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(text = { Text("Ingresar") }, onClick = { /* Acción para Ingresar */ })
            DropdownMenuItem(text = { Text("Registrarse") }, onClick = { /* Acción para Registrarse */ })
            DropdownMenuItem(text = { Text("Cursos") }, onClick = { /* Acción para Cursos */ })
            DropdownMenuItem(text = { Text("Soporte") }, onClick = { /* Acción para Soporte */ })
            DropdownMenuItem(text = { Text("Estudiante") }, onClick = { /* Acción para Estudiante */ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    Learnit_appTheme {
        MainScreen()
    }
}
