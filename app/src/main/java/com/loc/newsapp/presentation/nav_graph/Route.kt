package com.loc.newsapp.presentation.nav_graph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object AppStartGraph : Route(route = "appStartNavigation")
    object NewsGraph : Route(route = "newsNavigation")
    object BottomNavigationScreen : Route(route = "newsNavigatorScreen")
}
