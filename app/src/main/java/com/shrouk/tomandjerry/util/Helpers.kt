package com.shrouk.tomandjerry.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.screens.DetailItem
import com.shrouk.tomandjerry.screens.MostWatchEpisode
import com.shrouk.tomandjerry.screens.MostWatchedCard
import com.shrouk.tomandjerry.screens.PopularCharacter
import com.shrouk.tomandjerry.ui.theme.casheTimeCardColor
import com.shrouk.tomandjerry.ui.theme.heartbrokenCardColor
import com.shrouk.tomandjerry.ui.theme.huntingTimeCardColor
import com.shrouk.tomandjerry.ui.theme.numberOfQuarrelsCardColor

@Composable
fun getMinLines(textList:List<String>,textStyle: TextStyle):Int{
    val textMeasurer = rememberTextMeasurer()
    val maxLines = textList.maxOf { text ->
        textMeasurer.measure(text,textStyle).lineCount
    }
    return maxLines
}

val detailsList = listOf(
    DetailItem(R.drawable.ic_temperature,"1000 V","Temperature"),
    DetailItem(R.drawable.ic_time,"3 sparks","Time"),
    DetailItem(R.drawable.ic_no_of_death,"1M 12K","No. of deaths")
)
val steps = listOf(
    "Put the pasta in a toaster.",
    "Pour battery juice over it.",
    "Wait for the spark to ignite.",
    "Serve with an insulating glove.",

)
val mostWatchEpisodes= listOf(
    MostWatchEpisode(R.drawable.tom_and_jerry_img,"Number 404 - The Cursed Cheese \uD83E\uDDC0"),
    MostWatchEpisode(R.drawable.tom_with_jerry,"Chase on the moon 🌕"),
    MostWatchEpisode(R.drawable.tom_and_jerry_img,"Number 404 - The Cursed Cheese \uD83E\uDDC0"),
    MostWatchEpisode(R.drawable.tom_with_jerry,"Chase on the moon 🌕")
)
val popularCharacters = listOf(
    PopularCharacter(heartbrokenCardColor,R.drawable.tom_head,"Tom","Failed stalker"),
    PopularCharacter(huntingTimeCardColor,R.drawable.jerry,"Jerry","A scammer mouse"),
    PopularCharacter(numberOfQuarrelsCardColor,R.drawable.tom_head,"Tom","Failed stalker"),
    PopularCharacter(casheTimeCardColor,R.drawable.jerry,"Jerry","A scammer mouse"),

)