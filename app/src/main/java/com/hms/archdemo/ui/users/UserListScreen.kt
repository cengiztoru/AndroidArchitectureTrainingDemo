package com.hms.archdemo.ui.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hms.archdemo.ui.users.components.UserListItem

@Composable
fun UserListScreen(
    viewModel: UserViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState

    Column {

        Text(
            "Users",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(start = 16.dp)
        )

        Box(modifier = Modifier.fillMaxSize()) {
            if (uiState.usersItemUiStates.isNotEmpty()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(uiState.usersItemUiStates) { userItemUiState ->
                        UserListItem(userItemUiState = userItemUiState)
                    }
                }
            }

            if (uiState.error.isNotEmpty()) {
                Text(
                    text = uiState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (uiState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp),
                    color = Color.Green
                )
            }
        }

    }


}