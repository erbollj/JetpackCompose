package com.loc.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.loc.newsapp.presentation.common.ArticlesList
import com.loc.newsapp.presentation.common.SearchBar
import com.loc.newsapp.presentation.model.Article

@Composable
fun SearchScreen(
    navigateToDetails: () -> Unit
) {

    Column(
        modifier = Modifier
            .padding(
                top = 20.dp,
                start = 20.dp,
                end = 20.dp
            )
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        SearchBar(readOnly = false, onSearch = {}, onClick = {})
        Spacer(modifier = Modifier.height(20.dp))
        val list = List(20) { Article() }
        ArticlesList(articles = list, onClick = { navigateToDetails() })
    }

}