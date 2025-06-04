package com.shrouk.tomandjerry.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.composable.ProductPrice
import com.shrouk.tomandjerry.composable.ProfileImage
import com.shrouk.tomandjerry.composable.SpacerFour
import com.shrouk.tomandjerry.composable.ViewAll
import com.shrouk.tomandjerry.models.CardInfo
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.buttonBackground
import com.shrouk.tomandjerry.ui.theme.darkGradiantColor
import com.shrouk.tomandjerry.ui.theme.descriptionColor
import com.shrouk.tomandjerry.ui.theme.lightGradiantColor
import com.shrouk.tomandjerry.ui.theme.primaryColor
import com.shrouk.tomandjerry.ui.theme.screenBackground
import com.shrouk.tomandjerry.ui.theme.titleColor

@Preview(showSystemUi = true, name = "Phone", device = "id:Nexus S")
@Preview(showSystemUi = true, name = "Tablet", device = "spec:width=800dp,height=1280dp")
@Preview(name = "Phone", widthDp = 360, heightDp = 640)
@Composable
fun JerryStoreScreen() {
    val tomProducts = getTomProducts()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = screenBackground)
            .padding(12.dp),
    ) {
        item {
            AppBar(
                "Jerry",
                "Which Tom do you want to buy?",
                R.drawable.jerry_profile_img,
                3
            )
        }
        item {
            Searchbar()
        }
        item {
            Banner()
        }
        item {
            ViewAll(stringResource(R.string.cheap_tom_section))
        }
        item {
            LazyVerticalGrid(
                userScrollEnabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 1000.dp),
                columns = GridCells.Fixed(2)
            ) {
                items(tomProducts.size) {
                    ProductCard(tomProducts[it])

                }
            }
        }
    }

}

@Composable
fun Searchbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Color.White, RoundedCornerShape(8.dp)
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                tint = descriptionColor,
                contentDescription = "search icon"
            )
            SpacerFour()
            Text(
                "Search about tom ...",
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = IBMPlexSans,
                fontWeight = FontWeight.Normal,
                color = descriptionColor
            )

        }
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.CenterVertically)
                .background(primaryColor, RoundedCornerShape(8.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = "filter icon",
                tint = Color.White

            )
        }
    }

}

@Composable
fun AppBar(
    name: String,
    message: String,
    profileImage: Int,
    notificationCount: Int
) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        ProfileImage(
            profileImage,
            size = 48
        )
        Column(modifier = Modifier.padding(start = 4.dp)) {
            Text(
                "Hi, $name \uD83D\uDC4B\uD83C\uDFFB",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold, fontFamily = IBMPlexSans,
                color = titleColor
            )
            Text(
                message,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = IBMPlexSans,
                color = descriptionColor
            )
        }
        Spacer(Modifier.weight(1f))
        Box(modifier = Modifier.padding(top = 5.dp)) {
            Icon(
                painter = painterResource(R.drawable.ic_notification),
                contentDescription = "notification Icon",
                modifier = Modifier
                    .border(1.dp, color = Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
            Badge(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(y = (-5).dp),
                containerColor = primaryColor,
                contentColor = Color.White
            ) {
                Text(notificationCount.toString())
            }
        }
    }

}

@Composable
fun Banner() {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    brush = Brush.linearGradient(
                        listOf(darkGradiantColor, lightGradiantColor)
                    )
                )
                .align(Alignment.BottomStart)
                .padding(start = 8.dp)

        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = "Buy 1 Tom and get 2 for free ",
                    color = Color.White,
                    fontFamily = IBMPlexSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(end = 31.dp, top = 16.dp),
                    text = "Adopt Tom! (Free Fail-Free \n Guarantee)",
                    color = Color.White,
                    fontFamily = IBMPlexSans,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }


        }

        Box(modifier = Modifier
            .fillMaxWidth(0.3f)
            .align(Alignment.BottomEnd)) {

            Box(
                Modifier
                    .height(92.dp)
                    .align(Alignment.BottomEnd)) {
                Image(
                    painter = painterResource(R.drawable.ellipse_two),
                    contentDescription = "",
                    modifier = Modifier
                        .width(115.dp)
                        .height(108.dp)
                        .clipToBounds()
                        .graphicsLayer {
                            translationX = 50f
                        },
                    contentScale = ContentScale.Crop,


                    )
                Image(
                    painter = painterResource(R.drawable.ellipse_two),
                    contentDescription = "",
                    modifier = Modifier
                        .width(115.dp)
                        .height(108.dp)
                        .clipToBounds()
                        .graphicsLayer {
                            translationX = 30f
                        },
                    contentScale = ContentScale.Crop

                )


            }
            Image(
                painter = painterResource(R.drawable.banner_img),
                contentDescription = "product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(115.dp)
                    .height(108.dp)
                    .align(Alignment.BottomEnd)

            )
        }
    }

}

@Composable
fun ProductCard(cardInfo: CardInfo) {
    Box(
        Modifier
            .padding(top = 40.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent)

    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(horizontal = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Spacer(Modifier.height(70.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {


                Text(
                    text = cardInfo.productTitle,
                    modifier = Modifier.fillMaxWidth(),
                    color = titleColor,
                    fontFamily = IBMPlexSans,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = cardInfo.productDescription,
                    modifier = Modifier.fillMaxWidth(),
                    color = descriptionColor,
                    fontFamily = IBMPlexSans,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
                Spacer(Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    ProductPrice(
                        Modifier.weight(1f),
                        backgroundColor = buttonBackground,
                        cardInfo.productPrice,
                        cardInfo.productPriceBeforeDiscount
                    )
                    Spacer(Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_add_to_card),
                        tint = primaryColor,
                        modifier = Modifier
                            .size(32.dp),
                        contentDescription = "add to card"
                    )
                }
            }
        }
        Image(
            painter = painterResource(cardInfo.productImg),
            contentDescription = "product image",
            Modifier
                .size(100.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-30).dp)
        )
    }
}

fun getTomProducts() = listOf(
    CardInfo(
        R.drawable.tom_sport_img,
        "Sport Tom",
        "He runs 1 meter... trips over his boot.",
        "3",
        "5"
    ),
    CardInfo(
        R.drawable.tom_love_img,
        "Tom the lover",
        "He loves one-sidedly... and is beaten by the other side.",
        "5",
    ),
    CardInfo(
        R.drawable.tom_bomb_img,
        "Tom the bomb",
        "He blows himself up before Jerry can catch him.",
        "10",
    ),
    CardInfo(
        R.drawable.tom_spy_img,
        "Spy Tom",
        "Disguises itself as a table.",
        "12",
    ),
    CardInfo(
        R.drawable.tom_frozen_img,
        "Frozen Tom",
        "He was chasing Jerry, he froze after the first look",
        "10",

        ),
    CardInfo(
        R.drawable.tom_sleep_img,
        "Sleeping Tom",
        "He doesn't chase anyone, he just snores in stereo.",
        "10",
    )
)