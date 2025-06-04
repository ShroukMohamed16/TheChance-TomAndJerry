/*
package com.shrouk.tomandjerry.composable

import androidx.compose.runtime.Composable

@Composable
fun Banner(
    title: String,
    description: String,
    image: Int
) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)

            .background(
                shape = RoundedCornerShape(16.dp),
                brush = Brush.linearGradient(
                    listOf(darkGradiantColor, lightGradiantColor)
                )
            )
    ) {
        Box(){

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f).padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = title,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontFamily = IBMPlexSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                    text = description,
                    color = Color.White,
                    fontFamily = IBMPlexSans,

                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )

            }
            Image(
                painter = painterResource(image),
                contentDescription = "product image",
                contentScale = ContentScale.Crop,
                modifier = Modifier

                    .graphicsLayer {
                        scaleY = 1.15f
                        translationY = -30f
                    }

                    .width(115.dp)

            )
        }
    }
}*/
package com.shrouk.tomandjerry.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.darkGradiantColor
import com.shrouk.tomandjerry.ui.theme.lightGradiantColor
import com.shrouk.tomandjerry.R

@Composable
fun PromoBanner(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomEnd = 16.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(darkGradiantColor, lightGradiantColor),
                        start = Offset.Zero,
                        end = Offset.Infinite
                    )
                )
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                painterResource(R.drawable.ellipse_two),
                "",
                modifier = Modifier
                    .size(width = 170.dp, height = 150.dp)
                    .offset(x = 290.14.dp, y = (-20).dp)
                    .graphicsLayer { rotationZ = 150f }
                    .background(Color.White.copy(alpha = 0.04f), shape = CircleShape)
            )

            Box(
                modifier = Modifier
                    .size(width = 182.dp, height = 160.dp)
                    .offset(x = 298.27.dp, y = (-20).dp)
                    .graphicsLayer { rotationZ = 150f }
                    .background(Color.White.copy(alpha = 0.04f), shape = CircleShape)
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = title,
                        fontFamily = IBMPlexSans,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 2
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = subtitle,
                        fontFamily = IBMPlexSans,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White.copy(alpha = 0.8f),
                        maxLines = 2
                    )
                }
            }
        }

        Image(
            painter = painterResource(R.drawable.banner_img),
            contentDescription = "Promo image",
            contentScale = ContentScale.Crop,
            modifier = imageModifier
                .align(Alignment.TopEnd)
                .offset( y = 0.dp)
                .size(width = 130.dp, height = 110.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TomBannerWithEllipse() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.horizontalGradient(listOf(Color(0xFF0078C4), Color(0xFF005F9E))))
    ) {
        // صورة الـ Ellipse
        Image(
            painter = painterResource(id = R.drawable.ellipse_two), // غيري الاسم حسب الملف عندك
            contentDescription = null,
            modifier = Modifier
                .size(220.dp) // الحجم تقدري تغيريه حسب اللي يظبط معاك
                .align(Alignment.CenterEnd)
                .offset(x = 40.dp)
                .zIndex(0f), // تخليه خلفي
            contentScale = ContentScale.Fit
        )

        // المحتوى الأمامي (النص + توم)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .zIndex(1f), // محتوى أمامي
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Buy 1 Tom and get 2 for free",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Adopt Tom! (Free Fail-Free Guarantee)",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.banner_img), // صورة توم
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}

