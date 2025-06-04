package com.shrouk.tomandjerry.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.composable.TextWithIcon
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.descriptionStatColor
import com.shrouk.tomandjerry.ui.theme.numberOfQuarrelsCardColor
import com.shrouk.tomandjerry.ui.theme.primaryColor
import com.shrouk.tomandjerry.ui.theme.screenBackground
import com.shrouk.tomandjerry.ui.theme.titleStatColor
import com.shrouk.tomandjerry.util.detailsList
import com.shrouk.tomandjerry.util.getMinLines
import com.shrouk.tomandjerry.util.steps

data class DetailItem(
    val icon: Int,
    val value: String,
    val description: String
)



@Preview(showSystemUi = true, name = "Phone", device = "spec:width=411dp,height=891dp")
@Composable
fun TomKitchenScreen() {


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = primaryColor.copy(alpha = .50f))
    ) {

        item {
            Box(Modifier.wrapContentHeight()) {
                Background()
                Column (modifier = Modifier){
                    MealContainer()
                    Column(
                        Modifier

                            .fillParentMaxSize()

                            .graphicsLayer {
                                translationY = -30f
                            }
                            .background(
                                screenBackground,
                                shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                            )
                            .padding(16.dp),
                    ) {
                        Text(
                            text = "Electric Tom pasta",
                            fontSize = 20.sp,
                            letterSpacing = 0.5.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = IBMPlexSans,
                            color = titleStatColor.copy(alpha = 0.87f),
                            modifier = Modifier
                                .fillMaxWidth(),
                        )
                        Text(
                            text = "Pasta cooked with a charger cable and sprinkled with questionable cheese. Make sure to unplug it before eating (or not, you decide).",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            fontFamily = IBMPlexSans,
                            letterSpacing = 0.5.sp,
                            color = titleStatColor,
                            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                        )

                        DetailsSection(detailsList = detailsList)
                        PreparationMethod(steps)

                    }
                }
            }
        }

    }


    Box(Modifier.fillMaxSize()) {

        AddToCardButton(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .zIndex(1f)
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun Background() {

    Box(
        Modifier
            .fillMaxWidth()
            .zIndex(0f)
    ) {
        Icon(
            painter = painterResource(R.drawable.shape),
            contentDescription = "shape"
        )
    }
}

@Composable
fun MealContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(1f)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter)
        ) {
            TextWithIcon(
                R.drawable.ic_tension,
                "High tension",
                textWeight = FontWeight.Medium,
                textSize = 16,
                textColor = Color.White.copy(alpha = .87f)
            )
            TextWithIcon(
                R.drawable.ic_chef,
                "Shocking foods",
                textWeight = FontWeight.Normal,
                textSize = 16,
                textColor = Color.White.copy(alpha = .87f)
            )


        }
        Icon(
            painter = painterResource(R.drawable.meal),
            contentDescription = "meal image",
            tint = Color.Unspecified,
            modifier = Modifier
                .offset(y = 20.dp)
                .zIndex(1f)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun DetailsSection(detailsList: List<DetailItem>) {
    val values = detailsList.map { it.value }
    val minValueLines = getMinLines(values, TextStyle.Default)
    val descriptions = detailsList.map { it.description }
    val minDescriptionLines = getMinLines(descriptions, TextStyle.Default)
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Details",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = IBMPlexSans,
            letterSpacing = 0.5.sp,
            color = titleStatColor.copy(alpha = 0.87f)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            detailsList.forEach {
                DetailCard(it, minValueLines, minDescriptionLines, Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun DetailCard(
    detailItem: DetailItem,
    minValueLines: Int,
    minDescriptionLines: Int,
    modifier: Modifier = Modifier,
) {

    Log.d("TAG", "DetailCard: $minDescriptionLines $minValueLines")
    Column(
        modifier
            .padding(8.dp)
            .background(numberOfQuarrelsCardColor, RoundedCornerShape(16.dp))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(detailItem.icon),
            tint = Color.Unspecified,
            contentDescription = "Details Icon"
        )
        Text(
            text = detailItem.value,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = IBMPlexSans,
            minLines = minValueLines,
            color = titleStatColor
        )

        Text(
            text = detailItem.description,
            fontSize = 12.sp,
            minLines = minDescriptionLines,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontFamily = IBMPlexSans,
            color = descriptionStatColor
        )


    }
}

@Composable
fun Method(stepNumber: Int, stepDescription: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .background(color = Color.White, RoundedCornerShape(50))
                .border(1.dp, numberOfQuarrelsCardColor, RoundedCornerShape(50))
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .zIndex(1f),
            text = stepNumber.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = IBMPlexSans,
            color = primaryColor,

            )
        Box(modifier = Modifier
            .graphicsLayer {
                translationX = -40f
            }
            .background(Color.White, RoundedCornerShape(12.dp))
            .weight(1f)
            .padding(start = 20.dp)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                    .zIndex(0f),
                text = stepDescription,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = IBMPlexSans,
                letterSpacing = 0.5.sp,
                color = titleStatColor,
            )
        }


    }
}

@Composable
fun PreparationMethod(steps: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Preparation method",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 2.dp),
            fontFamily = IBMPlexSans,
            letterSpacing = 0.5.sp,
            color = titleStatColor.copy(alpha = 0.87f)
        )

        for (i in steps.indices)
            Method(i + 1, steps[i])

    }
}

@Composable
fun AddToCardButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier


    ) {
        Button(
            {}, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Add to cart",
                    modifier = Modifier.padding(end = 8.dp),
                    letterSpacing = 0.5.sp,
                    color = Color.White.copy(alpha = .87f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = IBMPlexSans
                )
                Box(

                    modifier = Modifier
                        .size(5.dp)
                        .background(Color.White.copy(alpha = .38f), CircleShape),
                ) {}
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        "3 cheeses",
                        letterSpacing = 0.5.sp,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = IBMPlexSans
                    )
                    Text(
                        "5 cheeses",
                        letterSpacing = 0.5.sp,
                        color = Color.White.copy(alpha = .80f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        textDecoration = TextDecoration.LineThrough,
                        fontFamily = IBMPlexSans
                    )
                }
            }
        }

    }
}
