package com.tolgapirim.lanmarkbook.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, image: Int, name: String, country: String) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = image), contentDescription = null,
            modifier = Modifier.fillMaxWidth().clip(MaterialTheme.shapes.medium), contentScale = ContentScale.Crop,

        )

        Text(text = name,modifier = Modifier.padding(top = 40.dp),
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.SemiBold)

        Text(text = country,modifier = Modifier.padding(top = 40.dp),
            style = MaterialTheme.typography.h5,
            fontStyle = FontStyle.Italic)

    }


}