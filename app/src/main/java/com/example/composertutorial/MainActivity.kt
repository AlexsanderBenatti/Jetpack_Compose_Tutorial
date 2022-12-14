package com.example.composertutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //Layout
            MessageCard("Beautiful World") //Função de texto pré-definido
        }
    }
}

@Composable //Anotação pra tornar uma função composta
fun MessageCard(name: String) { //Função do texto pré-definido
    Text(text = "Hello $name!")
}

@Preview //Anotação pra definir uma função para preview (ela não aparece no projeto)
@Composable
fun PreviewMessageCard() {
    MessageCard("Android")
}