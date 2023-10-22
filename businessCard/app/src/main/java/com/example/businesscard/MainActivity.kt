package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //putText("Android")
                    GreetingImage(message = "Hola", from = "adios")
                }
            }
        }
    }
}

val sombreadoRedondo = Modifier
    .clip(RoundedCornerShape(12.dp))
    .background(Color.Black.copy(alpha = 0.5f))

val verdeClarito = Color(0xFFEBECC2)

val modificador = Modifier
    .clip(RoundedCornerShape(12.dp))
    .background(Color.Black.copy(alpha = 0.5f))
    .padding(8.dp)

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.fondo1)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircularImage() // Alinear al inicio

            Row {
                putText("Jose Manuel", Modifier.padding(8.dp))

            }
            Row{
                putText(text = "Tu sicario de confianza", Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.height(100.dp))
            Column(
                modifier = Modifier
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = modificador,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    CustomImage(drawableId = R.drawable.phone_vector, modifier.size(25.dp))
                    putText(text = "666666666", color = verdeClarito)

                }
                Spacer(modifier = Modifier.height(10.dp))
                Row (
                    modifier = modificador,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    CustomImage(drawableId = R.drawable.lacosa, modifier.size(25.dp))
                    putText(text = "Mejor no lo Pongo", color = verdeClarito)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row (
                    modifier = modificador,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    CustomImage(drawableId = R.drawable.correo_vacio, modifier.size(25.dp))
                    putText(text = "jmksd117@gmail.com", color = verdeClarito)
                }
            }
        }
    }
}

@Composable
fun CustomImage(drawableId: Int, modifier: Modifier = Modifier) {
    val imagePainter = painterResource(id = drawableId)
    Image(painter = imagePainter, contentDescription = null, modifier = modifier)
}


@Composable
fun CircularImage() {
    // Suponiendo que tienes una imagen en res/drawable con el nombre "example_image"
    val imagePainter = painterResource(id = R.drawable.fino_bro)

    Image(
        painter = imagePainter,
        contentDescription = null, // descripción de accesibilidad para la imagen
        modifier = Modifier
            .size(150.dp) // Define el tamaño del círculo
            .clip(CircleShape) // Recorta la imagen en forma de círculo
            .background(Color.Gray), // Fondo en caso de que la imagen no cubra todo el círculo
        contentScale = ContentScale.Crop // Asegura que la imagen se recorte si es más grande que el círculo
    )
}

@Composable
fun putText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black  // Parámetro de color con valor predeterminado
) {
    Text(
        text = text,
        modifier = modifier,
        lineHeight = 50.sp,
        fontWeight = FontWeight.Bold,  // Hace que el texto esté en negrita
        color = color  // Asigna el color
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        GreetingImage(message = "Hola", from = "adios")
    }
}