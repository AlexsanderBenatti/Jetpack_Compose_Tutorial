package com.example.composertutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composertutorial.ui.theme.ComposerTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //Layout
            MessageCard(Message("Android", "Jetpack Compose")) //Função de texto pré-definido
            //Autor, Mensagem
        }
    }
}

data class Message(val author: String, val body: String) //Declarando um objeto com as identidades do autor e mensagem

@Composable //Anotação pra tornar uma função composta
fun MessageCard(msg: com.example.composertutorial.Message) { //Função do texto pré-definido
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) { //Adicionando padding em volta da mensagem
        Image(
            painter = painterResource(R.drawable.profile_picture), //Escolhendo qual imagem usar
            contentDescription = "Contact profile picture", //Descrição da imagem
            modifier = Modifier //Modificando a forma da imagem
                .size(40.dp) //Mudando o tamanho
                .clip(CircleShape) //Deixando em formato de círculo
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp)) //Espaço entre a imagem e coluna
        Column { //Coluna
            Text(text = msg.author) //Printando primeiro o autor
            Spacer(modifier = Modifier.height(4.dp)) //Espaço entre os elementos da coluna
            Text(text = msg.body) //Printando a mensagem
        }
    }
}

@Preview //Anotação pra definir uma função para preview (ela não aparece no projeto)
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!") //Usando outro tipo de mensagem para o preview
    )
}