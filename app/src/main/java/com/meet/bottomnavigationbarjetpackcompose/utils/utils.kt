package com.meet.bottomnavigationbarjetpackcompose.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import com.meet.bottomnavigationbarjetpackcompose.navigation.NavigationItem
import com.meet.bottomnavigationbarjetpackcompose.navigation.Screens

val bottomNavigationItemsList = listOf(
    NavigationItem(
        title = "Home",
        route = Screens.Home.route,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
    ),
    NavigationItem(
        title = "Profile",
        route = Screens.Profile.route,
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
    ),
    NavigationItem(
        title = "Notification",
        route = Screens.Notification.route,
        selectedIcon = Icons.Filled.Notifications,
        unSelectedIcon = Icons.Outlined.Notifications,
        badgeCount = 9
    ),
    NavigationItem(
        title = "Setting",
        route = Screens.Setting.route,
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
        hasBadgeDot = true
    ),
)