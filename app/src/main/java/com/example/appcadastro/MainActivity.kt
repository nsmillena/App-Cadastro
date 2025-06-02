package com.example.appcadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcadastro.ui.theme.AppCadastroTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcadastro.ui.theme.Darkblue
import com.example.appcadastro.ui.theme.Lightblue
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCadastroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  appPreview()
                }
            }
        }
    }
}

@Composable
fun ProdutoItem() {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }
    var serie by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Box(
            modifier = Modifier
                .height(180.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Darkblue, Lightblue
                        )
                    )
                )
                .fillMaxWidth()
        )
        {
            Image(
                painter = painterResource(R.drawable.avatr_woman),
                contentDescription = "avatar image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .offset(y = 70.dp)
                    .size(150.dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.Center)

            )

        }
        Spacer(Modifier.height(55.dp))
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                text = "Cadastre-se",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                fontSize = 35.sp,
            )
            Spacer(Modifier.height(25.dp))
            Text(
                text = "Nome: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontSize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Digite seu nome completo") },
                maxLines = 2
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Telefone: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontSize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text("Digite o telefone...") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Curso: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontSize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = curso,
                onValueChange = { curso = it },
                label = { Text("Digite o nome do curso") },
                maxLines = 2
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Série: ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(250),
                fontSize = 25.sp,
            )
            Spacer(Modifier.height(15.dp))
            TextField(
                value = serie,
                onValueChange = { serie = it },
                label = { Text("Digite o nome da sua série") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 2
            )
        }
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Nome: $nome\nTelefone: $telefone\nCurso: $curso\nSérie: $serie",
                    Toast.LENGTH_LONG
                ).show()

                nome = ""
                telefone = ""
                curso = ""
                serie = ""
            }
        ) {
            Text(text = "Cadastrar")
        }

    }
    }



@Preview
@Composable
fun appPreview(){
    AppCadastroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProdutoItem()
        }
    }
}



