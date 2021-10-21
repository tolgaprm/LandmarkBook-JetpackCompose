package com.tolgapirim.lanmarkbook.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tolgapirim.lanmarkbook.R
import com.tolgapirim.lanmarkbook.ui.theme.model.Landmark

@Composable
fun MainScreen(navController: NavController) {


    val landmarkList = ArrayList<Landmark>()

    val pisa = Landmark("Pisa", "Italy", R.drawable.pisa_tower)
    val collesseum = Landmark("Collesseum", "Italy", R.drawable.colesseum)
    val eiffel = Landmark("Eiffel Tower", "France", R.drawable.eyfel_tower)
    val londonBridge = Landmark("London Bridge", "England", R.drawable.london_bridge)

    landmarkList.add(pisa)
    landmarkList.add(collesseum)
    landmarkList.add(eiffel)
    landmarkList.add(londonBridge)


    LazyColumn() {
        items(landmarkList.size) { index ->

            Text(
                text = landmarkList[index].name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("detailScreen/${landmarkList[index].image}/${landmarkList[index].name}/${landmarkList[index].country}")

                    }
                    .padding(16.dp),
                style = MaterialTheme.typography.body1

            )
            Divider()
        }
    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MainScreen(navController = rememberNavController())
}