package com.megamind.lemondedansmonphone.ui.screen

import android.widget.ImageButton
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.megamind.lemondedansmonphone.domain.model.Country
import com.megamind.lemondedansmonphone.ui.viewModel.MainViewModel
import com.megamind.lemondedansmonphone.ui.viewModel.UiState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.megamind.lemondedansmonphone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContriesScreen(

    viewModel: MainViewModel = viewModel(),

    ) {


    val countries by viewModel.countries.observeAsState()

    Scaffold(
        topBar = {

        },
        content = {
            Box(


                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                content = {


                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        countries?.let { it1 ->
                            items(it1) { m ->

                                CountryItem(country = m)
                            }
                        }

                    }

                },
                contentAlignment = Alignment.Center
            )
        }
    )
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CountryItem(modifier: Modifier = Modifier, country: Country) {


    var isExpanded by remember { mutableStateOf(false) }
    val animateSize by animateDpAsState(
        targetValue = if (isExpanded) 500.dp else 100.dp,
        label = "",
        animationSpec = tween(durationMillis = 800, easing = LinearEasing)
    )

    Card(
        modifier = modifier
            .padding(4.0.dp)
            .fillMaxWidth()
            .size(animateSize), elevation = CardDefaults.cardElevation(12.dp)
    ) {

        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(12.dp),

            ) {
            GlideImage(
                modifier = modifier.size(100.dp),
                model = country.flags.png,
                contentDescription = ""

            )
            Spacer(modifier = modifier.width(8.dp))
            Column() {
                Text(
                    text = country.translations.fra.official,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = country.continents[0], style = MaterialTheme.typography.bodyMedium)

            }

            IconButton(modifier = modifier, onClick = { isExpanded = !isExpanded }) {

                Icon(
                    imageVector = if (isExpanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                    contentDescription = ""
                )
            }

        }


    }

}


//@Preview
//@Composable
//fun CountryItemPreview(){
//
//    CountryItem(name = "Congo DR", continent ="Afrique" )
//
//
//}