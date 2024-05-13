package com.example.connectify.ui.theme.screens.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.connectify.R
import com.example.connectify.navigation.ADD_PRODUCTS_URL
import com.example.connectify.navigation.CATEGORIES_URL
import com.example.connectify.navigation.CREATIVE_URL
import com.example.connectify.navigation.ENGINEERING_URL
import com.example.connectify.navigation.FINANCE_URL
import com.example.connectify.navigation.LOGIN_URL
import com.example.connectify.navigation.RESEARCH_URL
import com.example.connectify.navigation.SEARCHES_URL
import com.example.connectify.navigation.VIEW_PRODUCTS_URL
import com.example.connectify.ui.theme.WazitoECommerceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { navController.navigate(ADD_PRODUCTS_URL)}) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
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
                    Column {

                    }




                    //topApp bar
                    TopAppBar(title = { Text(text = "Home" , color = Color.Black, modifier = Modifier.padding(start = 15.dp )) },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
                        actions = {
                            IconButton(onClick = { val shareIntent= Intent(Intent.ACTION_SEND)
                                shareIntent.type="text/plain"
                                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))}) {
                                Icon(imageVector = Icons.Default.Share, contentDescription = "share",
                                    tint = Color.Black)

                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Settings, contentDescription = "settings",
                                    tint = Color.Black)

                            }
                        }
                    )



                    //end of top app bar
                    Spacer(modifier = Modifier.height(10.dp))

                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly)
                    {


                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "Find your dream job",
                            fontSize = 40.sp,


                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black
                        )





                        Spacer(modifier = Modifier.height(10.dp))


                        //searchbar

                        Row {


                            Text(
                                modifier = Modifier.clickable { navController.navigate(
                                    CATEGORIES_URL) },
                                text = "Explore Categories:",
                                fontSize = 30.sp,
                                textAlign = TextAlign.Left,

                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Cursive,
                                color = Color.Black,
                                textDecoration = TextDecoration.Underline
                            )

                            IconButton(
                                onClick = { navController.navigate(CATEGORIES_URL) },
                                modifier = Modifier.padding(top = 1.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "settings",
                                    tint = Color.Red
                                )

                            }

                        }

                        // Row1
                        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                            // row1 part1
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp)
                                        .padding(top = 7.dp)
                                        .size(65.dp)
                                        .clickable { navController.navigate(CATEGORIES_URL) },
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp,
                                        bottomStart = 30.dp,
                                        bottomEnd = 30.dp
                                    )

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Row {


                                            Spacer(modifier = Modifier.height(5.dp))
                                            Image(
                                                painter = painterResource(id = R.drawable.health),
                                                contentDescription = "footy",
                                                modifier = Modifier
                                                    .clip(shape = CircleShape)
                                                    .size(65.dp)
                                                    .padding(top = 6.dp),
                                                contentScale = ContentScale.Crop


                                            )
                                        }

                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row {


                                        Text(
                                            text = "Health",
                                            fontSize = 18.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center
                                        )


                                    }


                                }


                                Spacer(modifier = Modifier.height(5.dp))


                            }
                            Spacer(modifier = Modifier.width(15.dp))


// End of row1 part1

                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp)
                                        .padding(top = 7.dp)
                                        .size(65.dp),
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp,
                                        bottomStart = 30.dp,
                                        bottomEnd = 30.dp
                                    )

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.it),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .size(65.dp)
                                                .padding(top = 6.dp),
                                            contentScale = ContentScale.Crop

                                        )


                                    }
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row {


                                        Text(
                                            text = "Computer",
                                            fontSize = 13.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center
                                        )


                                    }


                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))
//end of column 2


                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp)
                                        .padding(top = 7.dp)
                                        .size(65.dp),
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp,
                                        bottomStart = 30.dp,
                                        bottomEnd = 30.dp
                                    )

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.sscience),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .size(65.dp)
                                                .padding(top = 6.dp),
                                            contentScale = ContentScale.Crop

                                        )


                                    }
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row {


                                        Text(
                                            text = "Science",
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(start = 4.dp)
                                        )


                                    }


                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))
//end of column 3
                            //end of column 2


                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp)
                                        .padding(top = 7.dp)
                                        .size(65.dp),
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp,
                                        bottomStart = 30.dp,
                                        bottomEnd = 30.dp
                                    )

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.education2),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .size(65.dp)
                                                .padding(top = 6.dp),
                                            contentScale = ContentScale.Crop

                                        )


                                    }
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row {


                                        Text(
                                            text = "Law",
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(start = 18.dp)
                                        )


                                    }


                                }


                                Spacer(modifier = Modifier.height(5.dp))


                            }

                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp)
                                        .padding(top = 7.dp)
                                        .size(65.dp),
                                    RoundedCornerShape(
                                        topStart = 30.dp,
                                        topEnd = 30.dp,
                                        bottomStart = 30.dp,
                                        bottomEnd = 30.dp
                                    )

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.culture2),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape)
                                                .size(65.dp)
                                                .padding(top = 6.dp),
                                            contentScale = ContentScale.Crop

                                        )


                                    }
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row {


                                        Text(
                                            text = "Culture",
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(start = 18.dp)
                                        )


                                    }


                                }


                                Spacer(modifier = Modifier.height(5.dp))


                            }
                            Spacer(modifier = Modifier.width(15.dp))


                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        // End of Row1

                        Row {


                            Text(
                                modifier = Modifier
                                    .padding(start = 0.2.dp)
                                    .clickable { navController.navigate(SEARCHES_URL) },
                                text = "Top Searches:",
                                fontSize = 30.sp,

                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Cursive,
                                color = Color.Black,
                                textDecoration = TextDecoration.Underline

                            )


                            IconButton(
                                onClick = { navController.navigate(SEARCHES_URL) },
                                modifier = Modifier.padding(top = 1.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "settings",
                                    tint = Color.Red
                                )

                            }
                        }


                        Spacer(modifier = Modifier.height(10.dp))

                        // Row1
                        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                            // row1 part1
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                        .padding(start = 10.dp)
                                        .clickable { navController.navigate(ENGINEERING_URL) }
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {


                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Software Engineer",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(
                                        text = "5 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))


// End of row1 part1

                            // row1 part2
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                        .clickable { navController.navigate(FINANCE_URL) }
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {


                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Finance and business",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(
                                        text = "3 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))


// End of row1 part2

                            // row1 part3
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                        .clickable { navController.navigate(RESEARCH_URL) }
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {

                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Research and Marketing",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(
                                        text = "09 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(5.dp))
                            }
                            Spacer(modifier = Modifier.width(15.dp))

                            // row1 part3
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                        .clickable { navController.navigate(CREATIVE_URL) }
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {

                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Creative and media fields",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    Text(
                                        text = "1 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(35.dp))
                            }


                        }
                        Row {



                            Button(onClick = {
                                navController.navigate(VIEW_PRODUCTS_URL) }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 30.dp)) {
                                Text(text = "View more jobs available")
                            }



                        }
                    }


// End of row1 part3

                            // End of Row1


                }////



            }

        )

    }
}


val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Login",
        route="login",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = false,
        badges=0
    ),

    BottomNavItem(
        title = "Jobs",
        route="view_products",
        selectedIcon=Icons.Filled.Favorite,
        unselectedIcon=Icons.Outlined.Favorite,
        hasNews = true,
        badges=7
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}