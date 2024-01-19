package com.meet.bottomnavigationbarjetpackcompose.navigation

/**
 * @author Coding Meet
 * Created 17-01-2024 at 02:20 pm
 */

sealed class Screens(var route: String) {

    object  Home : Screens("home")
    object  Profile : Screens("profile")
    object  Notification : Screens("notification")
    object  Setting : Screens("setting")
}