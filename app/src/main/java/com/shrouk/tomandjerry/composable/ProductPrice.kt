package com.shrouk.tomandjerry.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shrouk.tomandjerry.R
import com.shrouk.tomandjerry.ui.theme.IBMPlexSans
import com.shrouk.tomandjerry.ui.theme.buttonBackground
import com.shrouk.tomandjerry.ui.theme.primaryColor

@Composable
fun ProductPrice(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    productPrice: String,
    productPriceBeforeDiscount: String? = null
) {
    Row(
        modifier = modifier
            .background(color = backgroundColor, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_money_bag),
            tint = primaryColor,
            contentDescription = "money bag"
        )
        if (productPriceBeforeDiscount != null)
            Text(
                text = productPriceBeforeDiscount,
                color = primaryColor,
                fontFamily = IBMPlexSans,
                textDecoration = TextDecoration.LineThrough,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            )

        SpacerFour()
        Text(
            text = productPrice,
            color = primaryColor,
            fontFamily = IBMPlexSans,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
        SpacerFour()

        Text(
            text = stringResource(R.string.cheeses),
            color = primaryColor,
            fontFamily = IBMPlexSans,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        )
    }
}