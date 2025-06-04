package com.shrouk.tomandjerry.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfileImage(
    profileImage:Int,
    size:Int
) {
    Image(
        painter = painterResource(profileImage),
        modifier = Modifier.size(size.dp),
        contentDescription = "profile Image"
    )
}