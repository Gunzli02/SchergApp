package com.example.schergapp

import Models.Contact
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schergapp.ui.theme.SchergAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchergAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    //ContactListPreview()
                    ContactList(contact_list)
                }
            }
        }
    }
}

var contact_list: MutableList<Contact> = mutableListOf(
    Contact("Johannes", "will nach Hause", "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg"),
    Contact("Dennis", "will nicht mehr", "https://p6.focus.de/img/fotos/id_219232/traxxx-wassertemperaturen.jpg?im=Resize%3D%28800%2C481%29&impolicy=perceptual&quality=medium&hash=472dabfc72636d656f3015a10ff93b133aa9538f52acda0c81d942c6f5b251a0"),
    Contact("Johannes", "will nach Hause", "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg"),
    Contact("Dennis", "will nicht mehr", "https://p6.focus.de/img/fotos/id_219232/traxxx-wassertemperaturen.jpg?im=Resize%3D%28800%2C481%29&impolicy=perceptual&quality=medium&hash=472dabfc72636d656f3015a10ff93b133aa9538f52acda0c81d942c6f5b251a0"),
    Contact("Johannes", "will nach Hause", "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg"),
    Contact("Dennis", "will nicht mehr", "https://p6.focus.de/img/fotos/id_219232/traxxx-wassertemperaturen.jpg?im=Resize%3D%28800%2C481%29&impolicy=perceptual&quality=medium&hash=472dabfc72636d656f3015a10ff93b133aa9538f52acda0c81d942c6f5b251a0"),
    Contact("Johannes", "will nach Hause", "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg"),
    Contact("Dennis", "will nicht mehr", "https://p6.focus.de/img/fotos/id_219232/traxxx-wassertemperaturen.jpg?im=Resize%3D%28800%2C481%29&impolicy=perceptual&quality=medium&hash=472dabfc72636d656f3015a10ff93b133aa9538f52acda0c81d942c6f5b251a0"),
    Contact("Johannes", "will nach Hause", "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg"),
    Contact("Dennis", "will nicht mehr", "https://p6.focus.de/img/fotos/id_219232/traxxx-wassertemperaturen.jpg?im=Resize%3D%28800%2C481%29&impolicy=perceptual&quality=medium&hash=472dabfc72636d656f3015a10ff93b133aa9538f52acda0c81d942c6f5b251a0"),
    Contact("Johannes", "will nach Hause", "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg"),
    Contact("Dennis", "will nicht mehr", "https://p6.focus.de/img/fotos/id_219232/traxxx-wassertemperaturen.jpg?im=Resize%3D%28800%2C481%29&impolicy=perceptual&quality=medium&hash=472dabfc72636d656f3015a10ff93b133aa9538f52acda0c81d942c6f5b251a0"),

)

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SchergAppTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
            ) {
        Row {
            AsyncImage(
                model = "https://www.shutterstock.com/image-photo/beautiful-sunset-tropical-beach-palm-260nw-1716193708.jpg",
                contentDescription = null,

                modifier = Modifier
                    // Set image size to 40 dp
                    .size(55.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(text = "Johannes", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Will nach Hause", fontStyle = FontStyle.Italic)
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                disabledBackgroundColor = Color.Transparent,
            ),
            elevation = null
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Löschen",

                // on below line we are setting height
                // and width for our image.
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
        }
    }
}

@Composable
fun ContactCard(contact: Contact) {
    Row (
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            AsyncImage(
                model = contact.image,
                contentDescription = null,

                modifier = Modifier
                    // Set image size to 40 dp
                    .size(55.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(text = contact.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = contact.status, fontStyle = FontStyle.Italic)
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                disabledBackgroundColor = Color.Transparent,
            ),
            elevation = null
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Löschen",

                // on below line we are setting height
                // and width for our image.
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun ContactListPreview() {
    LazyColumn ( modifier = Modifier.padding(10.dp)) {
        items(20) {
            ContactCardPreview()
            HorizontalDivider()
        }
        items(1) {
            ContactCardPreview()
        }
    }
}

@Composable
fun ContactList(
    list: MutableList<Contact>
) {
    LazyColumn(modifier = Modifier.padding(5.dp)) {
        items(list){
                contact ->
            ContactCard(contact)
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
fun HorizontalDivider() {
    Spacer(modifier = Modifier.height(7.dp))
    Divider(startIndent = 8.dp, color = Color.Black)
    Spacer(modifier = Modifier.height(7.dp))

}