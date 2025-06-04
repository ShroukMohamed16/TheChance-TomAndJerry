package com.shrouk.tomandjerry.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.primaryColor
import com.shrouk.tomandjerry.ui.theme.titleColor

@Composable

fun ViewAll(title:String,

            color: Color = titleColor,
            fontFamily: FontFamily = IBMPlexSans,
            horizontalPadding:Int = 0) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding.dp)
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fontFamily,
            color = color
        )
        Spacer(Modifier.weight(1f))
        Text(
            stringResource(R.string.view_all),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            color = primaryColor
        )
        SpacerFour()
        Icon(
            painter = painterResource(R.drawable.ic_view_all),
            tint = primaryColor,
            contentDescription = "view all"
        )
    }
}