package com.meet.bottomnavigationbarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meet.bottomnavigationbarjetpackcompose.navigation.BottomNavigationBar
import com.meet.bottomnavigationbarjetpackcompose.navigation.NavigationItem
import com.meet.bottomnavigationbarjetpackcompose.navigation.Screens
import com.meet.bottomnavigationbarjetpackcompose.navigation.SetUpNavGraph
import com.meet.bottomnavigationbarjetpackcompose.ui.theme.BottomNavigationBarJetpackComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBarJetpackComposeTheme {
                val items = listOf(
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
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val topBarTitle =
                    if (currentRoute != null){
                        items[items.indexOfFirst {
                            it.route == currentRoute
                        }].title
                    }else{
                        items[0].title
                    }
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = topBarTitle)
                        })
                    },
                    bottomBar = {
                        BottomNavigationBar(items = items, currentRoute = currentRoute ){currentNavigationItem->
                            navController.navigate(currentNavigationItem.route){
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                                    // Pop up to the start destination, clearing the back stack
                                    popUpTo(startDestinationRoute) {
                                        // Save the state of popped destinations
                                        saveState = true
                                    }
                                }

                                // Configure navigation to avoid multiple instances of the same destination
                                launchSingleTop = true

                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        }
                    }
                ) {innerPadding->
                    SetUpNavGraph(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}
