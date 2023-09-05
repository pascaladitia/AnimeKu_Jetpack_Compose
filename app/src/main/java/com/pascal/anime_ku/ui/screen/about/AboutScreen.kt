package com.pascal.anime_ku.ui.screen.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pascal.anime_ku.ui.component.AboutContent

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit)
{
    AboutContent(modifier = modifier, onBackClick = navigateBack)
}