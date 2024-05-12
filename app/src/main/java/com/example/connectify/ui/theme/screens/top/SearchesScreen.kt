package com.example.connectify.ui.theme.screens.top

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.connectify.R
import com.example.connectify.navigation.CREATIVE_URL
import com.example.connectify.navigation.ENGINEERING_URL
import com.example.connectify.navigation.FINANCE_URL
import com.example.connectify.navigation.HOME_URL
import com.example.connectify.navigation.RESEARCH_URL
import com.example.connectify.navigation.VIEW_PRODUCTS_URL
import com.example.connectify.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchesScreen(navController: NavHostController) {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.bcg2),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "", color = Color.Black) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(HOME_URL) }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "mENU",
                        tint = Color.Black
                    )

                }

            },
        )

        Spacer(modifier = Modifier.height(12.dp))

        //end of top app bar
        Row {


            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Top Searches",
                fontSize = 40.sp,
                textDecoration = TextDecoration.Underline,


                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column(Modifier.verticalScroll(rememberScrollState())) {


            Row {
                Card {
                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.se2),
                            contentDescription = "image 1",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(5.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop

                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            modifier = Modifier.padding(start = 13.dp, top = 8.dp),
                            text = "Software Engineer",
                            fontSize = 30.sp,


                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black
                        )

                    }
                    Row {


//BUTTON ROW
                        Column(
                            Modifier
                                .padding(6.dp)
                        ) {
                            Text("Details", fontWeight = FontWeight.W700)
                            Text("Location: Kipro Center",)
                            Text("Nairobi , Kenya", color = Color.Gray)
                        }
                        Spacer(
                            modifier = Modifier
                                .width(65.dp)
                                .padding(top = 7.dp)
                        )



                        OutlinedButton(onClick = { navController.navigate(ENGINEERING_URL) }) {
                            Text(text = "View More")
                        }


                    }


                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Card {
                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.mark4),
                            contentDescription = "image 1",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(5.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop

                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            modifier = Modifier.padding(start = 13.dp, top = 8.dp),
                            text = " Research & Marketing",
                            fontSize = 30.sp,


                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black
                        )

                    }
                    Row {


//BUTTON ROW
                        Column(
                            Modifier
                                .padding(6.dp)
                        ) {
                            Text("Details", fontWeight = FontWeight.W700)
                            Text("Location: Kipro Center",)
                            Text("Nairobi , Kenya", color = Color.Gray)
                        }
                        Spacer(
                            modifier = Modifier
                                .width(65.dp)
                                .padding(top = 7.dp)
                        )



                        OutlinedButton(onClick = {
                            navController.navigate(RESEARCH_URL)
                        }) {
                            Text(text = "View More")
                        }


                    }


                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Card {
                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.fan3),
                            contentDescription = "image 1",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(5.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop

                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            modifier = Modifier.padding(start = 13.dp, top = 8.dp),
                            text = "Finance & Business",
                            fontSize = 30.sp,


                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black
                        )

                    }
                    Row {


//BUTTON ROW
                        Column(
                            Modifier
                                .padding(6.dp)
                        ) {
                            Text("Details", fontWeight = FontWeight.W700)
                            Text("Location: Kipro Center",)
                            Text("Nairobi , Kenya", color = Color.Gray)
                        }
                        Spacer(
                            modifier = Modifier
                                .width(65.dp)
                                .padding(top = 7.dp)
                        )



                        OutlinedButton(onClick = {
                            navController.navigate(FINANCE_URL)
                        }) {
                            Text(text = "View More")
                        }


                    }


                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Card {
                    Row {

                        Image(
                            painter = painterResource(id = R.drawable.cre),
                            contentDescription = "image 1",
                            modifier = Modifier
                                .size(70.dp)
                                .padding(5.dp)
                                .clip(shape = CircleShape),
                            contentScale = ContentScale.Crop

                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            modifier = Modifier.padding(start = 13.dp, top = 8.dp),
                            text = "Creative and Media fields",
                            fontSize = 30.sp,


                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black
                        )

                    }
                    Row {


//BUTTON ROW
                        Column(
                            Modifier
                                .padding(6.dp)
                        ) {
                            Text("Details", fontWeight = FontWeight.W700)
                            Text("Location: Kipro Center",)
                            Text("Nairobi , Kenya", color = Color.Gray)
                        }
                        Spacer(
                            modifier = Modifier
                                .width(65.dp)
                                .padding(top = 7.dp)
                        )



                        OutlinedButton(onClick = {
                            navController.navigate(CREATIVE_URL)
                        }) {
                            Text(text = "View more")
                        }


                    }


                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Row {


                Text(
                    modifier = Modifier.padding(start = 0.2.dp),
                    text = "See more jobs available:",
                    fontSize = 30.sp,

                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black,
                    textDecoration = TextDecoration.Underline

                )


                IconButton(
                    onClick = { navController.navigate(VIEW_PRODUCTS_URL) },
                    modifier = Modifier.padding(top = 1.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "settings",
                        tint = Color.Red
                    )

                }
            }

            Row {


                Text(
                    modifier = Modifier.padding(start = 0.2.dp),
                    text = "See more jobs available:",
                    fontSize = 30.sp,

                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    textDecoration = TextDecoration.Underline

                )


                IconButton(
                    onClick = { navController.navigate(VIEW_PRODUCTS_URL) },
                    modifier = Modifier.padding(top = 1.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "settings",
                        tint = Color.Red
                    )

                }
            }

        }


    }
}






@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SearchesScreenPreview(){
    WazitoECommerceTheme {

        SearchesScreen(navController = rememberNavController())
    }
}