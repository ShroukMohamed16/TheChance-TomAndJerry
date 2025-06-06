package com.shrouk.tomandjerry.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.composable.ViewAll
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.Roboto
import com.shrouk.tomandjerry.ui.theme.lightBlue
import com.shrouk.tomandjerry.ui.theme.titleColor
import com.shrouk.tomandjerry.util.getMinLines
import com.shrouk.tomandjerry.util.mostWatchEpisodes
import com.shrouk.tomandjerry.util.popularCharacters

data class MostWatchEpisode(
    val image: Int,
    val text: String

)

data class PopularCharacter(
    val cardColor: Color,
    val image: Int,
    val name: String,
    val description: String
)

@Preview(
    showSystemUi = true,
    device = "id:pixel_4_xl"
)
@Composable
fun SecretEpisodesScreen() {
    val minLinesMostWatchEpisode = getMinLines(mostWatchEpisodes.map { it.text }, TextStyle.Default)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(lightBlue, Color.White)
                )
            )
    ) {
        item {
            Row(Modifier.padding(16.dp)) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(R.drawable.secret_image),
                    contentDescription = ""
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(R.drawable.ic_button),
                    tint = Color.Unspecified,
                    contentDescription = ""
                )

            }
        }
        item {
            MainSection()
        }

        item {
            ViewAll("Most watched", titleColor.copy(alpha = 0.87f), fontFamily = Roboto, horizontalPadding = 16)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                items(mostWatchEpisodes.size) {
                    MostWatchedCard(
                        mostWatchEpisodes[it],
                        minLinesMostWatchEpisode,
                        Modifier.fillParentMaxWidth(0.65f)
                    )
                }
            }
        }
        item {
            Text(
                "Popular character",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Roboto,
                letterSpacing = .25.sp,
                color = titleColor.copy(alpha = 0.87f)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                items(popularCharacters.size) {
                    PopularCharacterCard(
                        popularCharacter = popularCharacters[it],
                        Modifier.fillParentMaxWidth(0.46f)
                    )
                }
            }
        }

    }
}

@Composable
fun MainSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(
                "Deleted episodes of Tom and Jerry!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Roboto,
                letterSpacing = .25.sp,
                color = titleColor.copy(alpha = 0.87f)
            )
            Text(
                "Scenes that were canceled for... mysterious (and sometimes embarrassing) reasons.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Roboto,
                color = titleColor.copy(alpha = 0.60f)
            )
        }
        Image(
            painter = painterResource(R.drawable.tom),
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.Fit,
            contentDescription = "",
        )
    }
}

@Composable
fun MostWatchedCard(
    mostWatchEpisode: MostWatchEpisode,
    minLines: Int,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .padding(start = 16.dp)
            .clip(RoundedCornerShape(20.dp)),
    ) {
        Image(
            painter = painterResource(mostWatchEpisode.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(.7f),
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier
                .matchParentSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color.Black.copy(alpha = 0f), Color.Black.copy(alpha = 0.8f))
                    )
                )
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_cheese),
                contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(48.dp)
                    .padding()
                    .align(Alignment.TopEnd)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = mostWatchEpisode.text,
                    modifier = Modifier.weight(0.7f),
                    letterSpacing = 0.25.sp,
                    fontSize = 14.sp,
                    color = Color.White,
                    minLines = minLines,
                    fontWeight = FontWeight.Bold,
                    fontFamily = IBMPlexSans,
                )
            }

        }

    }
}

@Composable
fun PopularCharacterCard(popularCharacter: PopularCharacter, modifier: Modifier = Modifier) {
    Box(
        modifier
            .width(140.dp)
            .padding(top = 32.dp)
            .padding(start = 16.dp)
            .background(
                color = popularCharacter.cardColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding( 16.dp)



    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .offset(y = (-50).dp)
                .padding(bottom = 16.dp)
                .align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(popularCharacter.image),
                modifier = Modifier
                    .height(64.dp)
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Crop,

                contentDescription = ""
            )
        }

        Column(
            Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(8.dp))

            Text(
                popularCharacter.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = IBMPlexSans,
                letterSpacing = .25.sp,
                maxLines = 1,
                color = titleColor.copy(alpha = 0.87f)
            )
            Text(
                popularCharacter.description,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontFamily = IBMPlexSans,
                maxLines = 1,
                color = titleColor.copy(alpha = 0.60f)
            )
        }

    }
}

