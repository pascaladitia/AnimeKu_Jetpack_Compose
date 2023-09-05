package com.pascal.anime_ku.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pascal.anime_ku.R
import com.pascal.anime_ku.ui.theme.AnimeKuTheme

@Composable
fun AboutContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Column( modifier = modifier.verticalScroll(rememberScrollState())) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.nav_back),
            modifier = Modifier
                .padding(16.dp)
                .clickable { onBackClick() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp)
                .testTag(stringResource(R.string.about_me)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.about_me),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
            )
            Spacer(modifier = modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = stringResource(R.string.pascal_aditia),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(ShapeDefaults.Medium)
            )
            Spacer(modifier = modifier.padding(5.dp))
            Text(
                text = stringResource(R.string.email),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(R.string.pascal_aditia),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewAbout() {
    AnimeKuTheme {
        AboutContent(onBackClick = {})
    }
}