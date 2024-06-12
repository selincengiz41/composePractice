package com.selincengiz.composepractice.presentation.navgraph

sealed class Route(
    val route: String
) {
    data object OnBoardingScreen :Route(route = "onBoardingScreen")
    data object HomeScreen :Route(route = "homeScreen")
    data object SearchScreen :Route(route = "searchScreen")
    data object BookmarkScreen :Route(route = "bookmarkScreen")
    data object DetailScreen :Route(route = "detailScreen")
    data object AppStartNavigation :Route(route = "appStartNavigation")
    data object NewsNavigatorScreen :Route(route = "newsNavigatorScreen")
    data object NewsNavigation :Route(route = "newsNavigation")
}