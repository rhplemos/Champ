package com.example.baseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.baseproject.viewmodel.MatchesViewModel
import com.example.baseproject.viewmodel.state.MatchesState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(10.dp)) {
                    TopAppBar()
                    FetchData()
                }
            }
        }
    }
}

@Composable
fun FetchData(matchesViewModel: MatchesViewModel = viewModel()){

    Column {
        when(val state = matchesViewModel.matchesState.collectAsState().value) {
            is MatchesState.Empty -> Text(text = "No data avaible")
            is MatchesState.Loading -> Text(text = "Loading...")
            is MatchesState.Success -> Text(text = "Successful!")
            is MatchesState.Error -> Text(text = state.message)


        }
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
        }
        Text(text = "ChampScores", style = MaterialTheme.typography.headlineMedium)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Refresh")
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    MaterialTheme {
        TopAppBar()
    }
}