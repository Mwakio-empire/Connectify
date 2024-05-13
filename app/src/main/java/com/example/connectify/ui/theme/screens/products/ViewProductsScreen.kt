package com.example.connectify.ui.theme.screens.products

import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.connectify.data.ProductViewModel
import com.example.connectify.models.Product
import com.example.connectify.navigation.ADD_PRODUCTS_URL
import com.example.connectify.navigation.HOME_URL
import com.example.connectify.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {





        var context = LocalContext.current

        var productRepository = ProductViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Product("","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)

        val mContext = LocalContext.current
        Column(

            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            TopAppBar(title = { Text(text = "" , color = Color.Black, modifier = Modifier.padding(start = 15.dp )) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(HOME_URL) }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "mENU",
                            tint = Color.Black)

                    }

                }

            )



            //end of top app bar
            Text(text = "All Jobs Available",
                fontSize = 35.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        productImage = it.imageUrl
                    )
                }
            }
            FloatingActionButton(onClick = {  navController.navigate(ADD_PRODUCTS_URL) }) {
                IconButton(onClick = { navController.navigate(ADD_PRODUCTS_URL) }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "menu"
                    )
                }
            }
        }
    }
}



@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController,
                productRepository:ProductViewModel, productImage:String) {
    val mContext = LocalContext.current



    Column(modifier = Modifier
        .fillMaxWidth()
        ) {
        Row {
            Card(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
                Row {

                    Image(
                        painter = rememberAsyncImagePainter(productImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(5.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop

                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        modifier = Modifier.padding(start = 13.dp, top = 8.dp),
                        text = name,
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
                        Row {
                            Text(text = "Position Offered :\n",fontWeight = FontWeight.W700)
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                        Text(quantity)
                        Row {
                            Text(text = "Qualifications Required:\n",fontWeight = FontWeight.W700)
                            Spacer(modifier = Modifier.width(10.dp))


                        }



                        Text(price,)
                        Text("Nairobi , Kenya", color = Color.Gray)
                    }

                }


            }
            Spacer(modifier = Modifier.height(20.dp))
        }


        Row {

            Button(onClick = {
                productRepository.deleteProduct(id)
            }) {
                Text(text = "Delete")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(
                    Intent.EXTRA_EMAIL,
                    arrayOf("mikemwazo444gmail.com")
                )
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Application for a job")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                mContext.startActivity(shareIntent)

            }) {
                Text(text = "Email Us")
            }

        }




    }

}


@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){
    WazitoECommerceTheme {
        ViewProductsScreen(navController = rememberNavController())
    }
}