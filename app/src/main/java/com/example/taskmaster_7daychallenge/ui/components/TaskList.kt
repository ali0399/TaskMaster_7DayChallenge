package com.example.taskmaster_7daychallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskListScreen() {
    val tabs = listOf("Todo", "Done")
    var selectedTab by remember { mutableIntStateOf(0) }

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }
        LazyColumn {
            items(3) { task ->
                TaskItem(
                    title = "Title $task",
                    description = "5 Collection",
                    onFavoriteClick = { /* Handle favorite */ },
                    onDeleteClick = { /* Handle delete */ },
                    onMoreOptionsClick = { /* Handle more options */ }
                )
            }
        }
        FloatingActionButton(onClick = { /* Handle add task */ }) {
            Icon(Icons.Default.Add, contentDescription = "Add Task")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(
    title: String,
    description: String,
    onFavoriteClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onMoreOptionsClick: () -> Unit
) {

    val swipeState = rememberSwipeToDismissBoxState(
        initialValue = SwipeToDismissBoxValue.Settled,
        confirmValueChange = { stateValue ->
            when (stateValue) {
                SwipeToDismissBoxValue.Settled -> {
                    false
                }

                SwipeToDismissBoxValue.StartToEnd -> {
                    true
                }

                SwipeToDismissBoxValue.EndToStart -> {
                    true
                }
            }
        },
        positionalThreshold = { totalDistance -> totalDistance * .25f }
    )




    SwipeToDismissBox(state = swipeState, backgroundContent ={

    }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = title, style = MaterialTheme.typography.bodyLarge)
                Text(text = description, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(onClick = onMoreOptionsClick) {
                Icon(Icons.Default.MoreVert, contentDescription = "More Options")
            }
            Row {
                IconButton(onClick = onFavoriteClick) {
                    Icon(Icons.Default.Star, contentDescription = "Favorite")
                }
                IconButton(onClick = onDeleteClick) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeBackgroundView(state: SwipeToDismissBoxState){

}

@Preview
@Composable
private fun TaskListPreview() {
    TaskListScreen()
}
