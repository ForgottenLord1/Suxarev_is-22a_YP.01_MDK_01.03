package com.example.shopshoes_suxarev_is_22a.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.shopshoes_suxarev_is_22a.R
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import coil.compose.rememberImagePainter

val images: List<Int> = listOf(
    R.drawable.onboard0,
    R.drawable.onboard1,
    R.drawable.onboard2
)

//Карточки со свайпом Сухарев_ис-22а 16.12.25
@Composable
fun Onboard(modifier: Modifier = Modifier,navController: NavHostController){
    ImageSwiper(imageUrls = images)
    Button(
        onClick = {navController.navigate("registeraccount")},
        modifier = Modifier.fillMaxWidth().offset(y = 760.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.Transparent),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = "Начать"
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSwiper(imageUrls: List<Int>) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    HorizontalPager(
        count = imageUrls.size,
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Image(
            painter = rememberImagePainter(data = imageUrls[page]),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        )
    }
}