package com.example.connectify.ui.theme.screens.immediate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.connectify.R
import com.example.connectify.navigation.SECOND_LANDING_URL
import com.example.connectify.ui.theme.WazitoECommerceTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(navController: NavHostController){

        val mContext = LocalContext.current
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .paint(
                painterResource(id = R.drawable.back7),
                contentScale = ContentScale.FillBounds
            ), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
           ) {


            //centering an image
            //IMAGE


            Image(
                painter = painterResource(id = R.drawable.vec3),
                contentDescription = "footy",
                modifier = Modifier
                    .size(230.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop

            )


            //END OF IMAGE

            Spacer(modifier = Modifier.height(100.dp))


            Row {
                Column {
                    //text
                    Text(
                        modifier = Modifier.padding(start = 20.dp),
                        text = "Find your dream job",
                        fontSize = 40.sp,


                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                }
                Spacer(modifier = Modifier.width(40.dp))

            }

            Row {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    text = "Search millions of jobs and get the inside scoop of companies ",
                    textAlign = TextAlign.Left,
                )

            }
            Spacer(modifier = Modifier.height(70.dp))


            Button(
                onClick = {
                    navController.navigate(SECOND_LANDING_URL)

                },
                shape = RoundedCornerShape(15.dp),
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(start = 30.dp, end = 30.dp)
            ) {
                Text(text = "NEXT")
            }
        }


    }








@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LandingScreenPreview(){
    WazitoECommerceTheme {
        LandingScreen(navController = rememberNavController())
    }
}