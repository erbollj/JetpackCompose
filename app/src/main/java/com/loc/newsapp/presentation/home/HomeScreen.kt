package com.loc.newsapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.newsapp.R
import com.loc.newsapp.presentation.common.ArticlesList
import com.loc.newsapp.presentation.common.SearchBar
import com.loc.newsapp.presentation.model.Article

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: List<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: () -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.size > 10) {
                articles.joinToString(separator = "\uD83d\uDFE5") { it.name }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        SearchBar(
            modifier = Modifier.padding(horizontal = 16.dp),
            readOnly = true,
            onClick = {
                navigateToSearch()
            },
            onSearch = {}
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )
        Spacer(modifier = Modifier.height(20.dp))
        ArticlesList(
            modifier = Modifier.padding(horizontal = 20.dp),
            articles = articles,
            onClick = {
                navigateToDetails()
            }
        )
    }
}