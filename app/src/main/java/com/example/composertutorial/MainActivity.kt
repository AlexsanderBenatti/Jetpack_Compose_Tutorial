package com.example.composertutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composertutorial.ui.theme.ComposerTutorialTheme

//Adendo: Algumas linhas eu não comentei porque as funções delas já estão comentadas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //Layout
            ComposerTutorialTheme(darkTheme = true) { //Mudando o tema para modo escuro
                Surface(modifier = Modifier.fillMaxSize()) { //Alterando o layout da mensagem pra maximizar o width e o height
                    MessageCard(Message("Alexsander", "Meu Jetpack Compose funcionou :D")) //Função de texto pré-definido
                    //Autor, Mensagem
                }
            }
        }
    }
}

data class Message(val author: String, val body: String) //Declarando um objeto com as identidades do autor e mensagem

@Composable //Anotação pra tornar uma função composta
fun MessageCard(msg: com.example.composertutorial.Message) { //Função do texto pré-definido
    Row(modifier = Modifier.padding(all = 8.dp)) { //Adicionando padding em volta da mensagem
        Image( //Adicionando a imagem
            painter = painterResource(R.drawable.profile_picture), //Escolhendo qual imagem usar
            contentDescription = "Contact profile picture", //Descrição da imagem
            modifier = Modifier //Modificando a forma da imagem
                .size(40.dp) //Mudando o tamanho
                .clip(CircleShape) //Deixando em formato de círculo
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape) //Adicionando uma borda a imagem
        )

        Spacer(modifier = Modifier.width(8.dp)) //Espaço entre a imagem e coluna
        Column { //Coluna
            Text( //Printando primeiro o autor
                text = msg.author, //Definindo qual vai ser o nome do autor (pegando o msg.author da classe Message)
                color = MaterialTheme.colors.secondary, //Definindo a cor do texto
                style = MaterialTheme.typography.subtitle1 //Definindo o tamanho do texto
            )
            Spacer(modifier = Modifier.height(4.dp)) //Espaço entre os elementos da coluna
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) { //Mudando o layout do texto
                Text( //Printando a mensagem
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview( //Anotação para visualizar uma prévia do projeto no modo claro
    uiMode = Configuration.UI_MODE_NIGHT_NO, //Settando para o modo claro
    showBackground = true, //Usar uma cor de background padrão
    name = "Light Mode" //Nomeando a preview
)
@Preview( //Anotação para visualizar uma prévia do projeto no modo escuro (em relação a função abaixo)
    uiMode = Configuration.UI_MODE_NIGHT_YES, //Settando para o modo escuro
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    ComposerTutorialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(
                msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!") //Testando outra mensagem para o preview
            )
        }
    }

}