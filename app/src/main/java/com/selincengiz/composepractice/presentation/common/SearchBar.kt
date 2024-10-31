package com.selincengiz.composepractice.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.selincengiz.composepractice.R
import com.selincengiz.composepractice.presentation.Dimens.IconSize
import com.selincengiz.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    readOnly: Boolean,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
) {
    val interactionSource =
        remember {
            MutableInteractionSource()
        }

    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    Box(modifier = modifier) {
        TextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .searchBarBorder(),
            value = text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(IconSize),
                    tint = colorResource(id = R.color.body),
                )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.bodySmall,
                    color =
                        colorResource(
                            id = R.color.placeholder,
                        ),
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors =
                TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(id = R.color.input_background),
                    focusedContainerColor = colorResource(id = R.color.input_background),
                    cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions =
                KeyboardActions(
                    onSearch = {
                        onSearch()
                    },
                ),
            textStyle = MaterialTheme.typography.bodySmall,
            interactionSource = interactionSource,
        )
    }
}

fun Modifier.searchBarBorder(): Modifier =
    composed {
        if (!isSystemInDarkTheme()) {
            border(
                width = 1.dp,
                color = Color.Black,
                shape = MaterialTheme.shapes.medium,
            )
        } else {
            this
        }
    }

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    ComposePracticeTheme {
        SearchBar(text = "", readOnly = false, onValueChange = {}) {
        }
    }
}
