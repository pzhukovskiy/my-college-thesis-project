package com.example.project.navigation

sealed class NavigationItem(val route: String) {
    object Homepage : NavigationItem("Homepage")//HomepageScreen
    object DetailNews : NavigationItem("DetailNews")//DetailNewsScreen
    object ListAllNews : NavigationItem("ListAllNews")//ListAllNews
}