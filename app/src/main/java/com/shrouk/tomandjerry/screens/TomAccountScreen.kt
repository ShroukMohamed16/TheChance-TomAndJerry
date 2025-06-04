package com.shrouk.tomandjerry.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.composable.ProfileImage
import com.shrouk.tomandjerry.composable.SpacerFour
import com.shrouk.tomandjerry.composable.TextWithIcon
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.casheTimeCardColor
import com.shrouk.tomandjerry.ui.theme.descriptionStatColor
import com.shrouk.tomandjerry.ui.theme.dividerColor
import com.shrouk.tomandjerry.ui.theme.heartbrokenCardColor
import com.shrouk.tomandjerry.ui.theme.huntingTimeCardColor
import com.shrouk.tomandjerry.ui.theme.numberOfQuarrelsCardColor
import com.shrouk.tomandjerry.ui.theme.screenBackground
import com.shrouk.tomandjerry.ui.theme.titleColor
import com.shrouk.tomandjerry.ui.theme.titleStatColor
import com.shrouk.tomandjerry.ui.theme.white12
import com.shrouk.tomandjerry.ui.theme.white80

data class SettingItem(
    val icon: Int,
    val title: String
)

data class StatItem(
    val icon: Int,
    val value: String,
    val description: String,
    val backgroundColor: Color,
)


@Preview(name = "Phone", widthDp = 360, heightDp = 640)
@Composable
fun TomAccountScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBackground)
    ) {
        item {
            AccountInfo(
                R.drawable.tom_profile_img,
                "Tom",
                "specializes in failure!"
            )
            Box(
                modifier = Modifier

                    .offset(y = (-30).dp)
                    .background(
                        screenBackground,
                        shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
                    )
                    .padding(vertical = 16.dp)

            ) {
                Column(Modifier.fillMaxHeight()) {

                    StatsGrid(
                        listOf(
                            StatItem(
                                R.drawable.ic_number_of_quarrels,
                                "2M 12K",
                                "No. of quarrels",
                                numberOfQuarrelsCardColor
                            ),
                            StatItem(
                                R.drawable.ic_cashe_time,
                                "+500 h",
                                "Chase time",
                                casheTimeCardColor
                            )
                        )
                    )

                    StatsGrid(
                        listOf(
                            StatItem(
                                R.drawable.ic_hunting_time,
                                "2M 12K",
                                "Hunting times",
                                huntingTimeCardColor
                            ),
                            StatItem(
                                R.drawable.ic_heartbroken,
                                "3M 7K",
                                "Heartbroken",
                                heartbrokenCardColor
                            )
                        )
                    )

                    SettingSection(stringResource(R.string.tom_settings), tomSettingOptions)
                    HorizontalDivider(modifier = Modifier.height(1.dp), color = dividerColor)

                    SettingSection(
                        stringResource(R.string.his_favorite_foods),
                        tomFavoriteFoodOptions
                    )



                    Spacer(Modifier.height(50.dp))

                    Text(
                        text = "v.TomBeta",
                        color = titleStatColor,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = IBMPlexSans,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )


                }
            }
        }
    }

}

@Composable
fun SettingSection(sectionTitle: String, sectionSettings: List<SettingItem>) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = sectionTitle,
            fontFamily = IBMPlexSans,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = titleColor.copy(alpha = .87f)
        )
        sectionSettings.forEach {
            Setting(it)
        }

    }
}

@Composable
fun AccountInfo(
    accountImage: Int,
    name: String,
    message: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(R.drawable.tom_account_background),
            contentDescription = "tom account background"
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileImage(accountImage, 64)
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = IBMPlexSans,
                color = Color.White
            )

            Text(
                text = message,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = IBMPlexSans,
                color = white80
            )


            Text(
                "Edit foolishness",
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = IBMPlexSans,
                color = Color.White,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .background(white12, RoundedCornerShape(32.dp))
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            )


        }
    }

}

@Composable
fun Setting(optionInfo: SettingItem) {
    TextWithIcon(
        optionInfo.icon, optionInfo.title,
        textWeight = FontWeight.Medium,
        textSize = 16,
        textColor = titleColor.copy(alpha = .87f)
    )
}

@Composable
fun StatsGrid(stats: List<StatItem>) {

    Row(
        modifier = Modifier

            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        stats.forEach { card ->
            StatCard(card, Modifier.weight(1f))
        }

    }
}

@Composable
fun StatCard(statItem: StatItem, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(horizontal = 4.dp)

            .background(
                statItem.backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp)
    ) {

        Icon(
            painter = painterResource(statItem.icon),
            tint = Color.Unspecified,
            contentDescription = "info card icon"
        )
        SpacerFour()
        Column {
            Text(
                text = statItem.value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = IBMPlexSans,
                letterSpacing = 0.5.sp,
                color = titleStatColor
            )
            Text(
                text = statItem.description,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = IBMPlexSans,
                letterSpacing = 0.5.sp,
                color = descriptionStatColor
            )
        }
    }
}


val tomSettingOptions = listOf(
    SettingItem(R.drawable.ic_sleeping_place, "Change sleeping place"),
    SettingItem(R.drawable.ic_meow_setting, "Meow settings"),
    SettingItem(R.drawable.ic_fridge_password, "Password to open the fridge")
)

val tomFavoriteFoodOptions = listOf(
    SettingItem(R.drawable.ic_mouses, "Mouses"),
    SettingItem(R.drawable.ic_last_stolen_meal, "Last stolen meal"),
    SettingItem(R.drawable.ic_sleep_mode, "Change sleep mood")
)