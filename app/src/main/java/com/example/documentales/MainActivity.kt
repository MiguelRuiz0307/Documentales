package com.example.documentales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.documentales.model.Documental
import com.example.documentales.data.DataSource
import com.example.documentales.ui.theme.DocumentalesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DocumentalesTheme {
                Surface {
                    AplicacionDocumentales()
                }
            }
        }
    }
}

@Composable
fun AplicacionDocumentales() {
    ListaDocumentales(
        listaDocumentales = DataSource().loadAffirmations(),
    )
}

@Composable
fun ListaDocumentales(listaDocumentales: List<Documental>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(listaDocumentales.take(10)) { documental ->
            DocumentalesCard(
                documental = documental,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun DocumentalesCard(documental: Documental, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            ImagenDocumental(
                imagenId = documental.imageResourceId,
                descripcion = stringResource(documental.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
            )
            Text(
                text = LocalContext.current.getString(documental.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun ImagenDocumental(imagenId: Int, descripcion: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(imagenId),
        contentDescription = descripcion,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun TarjetaDocumentalPreview() {
    DocumentalesCard(Documental(R.string.documentales1, R.drawable.image1))
}