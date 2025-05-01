package com.opensource.armmpnews.android.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.opensource.armmpnews.articles.Article
import com.opensource.armmpnews.articles.ArticleViewModel

@Composable
fun ArticleScreen(articleViewModel: ArticleViewModel) {

    val articleState = articleViewModel.articlesState.collectAsState()

    Column {
        AppBar()

        if (articleState.value.loading) {
            Loader()
        }

        if (articleState.value.error != null) {
            ErrorView(articleState.value.error!!)
        }

        if (articleState.value.articles.isNotEmpty()) {
            ArticleListView(articleState.value.articles)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    TopAppBar(title = { Text(text = "Articles")}
    )
}

@Composable
private fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun ErrorView(error: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text (
            text = error,
            color = MaterialTheme.colorScheme.error,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}

@Composable
private fun ArticleListView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles) { article ->
            ArticleItemView(article = article)
        }
    }
}

@Composable
private fun ArticleItemView(article: Article) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = article.title
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = article.desc,
            style = TextStyle(fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = article.date,
            style = TextStyle(fontSize = 12.sp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

