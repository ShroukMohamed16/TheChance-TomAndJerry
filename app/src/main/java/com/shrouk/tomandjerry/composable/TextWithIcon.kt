package com.shrouk.tomandjerry.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.titleColor

@Composable
fun TextWithIcon(icon:Int,
                 text:String,
                 textColor:Color,
                 textSize:Int,
                 textWeight: FontWeight) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(icon),
            tint = Color.Unspecified,
            contentDescription = "option icon"
        )
        SpacerEight()
        Text(
            text = text,
            fontFamily = IBMPlexSans,
            fontWeight = textWeight,
            fontSize = textSize.sp,
            color = textColor,
            letterSpacing = 0.5.sp
        )

    }
}