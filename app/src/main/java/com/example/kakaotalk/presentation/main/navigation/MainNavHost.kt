package com.example.kakaotalk.presentation.main.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kakaotalk.presentation.chatlist.ChatList
import com.example.kakaotalk.presentation.chatlist.ChatListRoute
import com.example.kakaotalk.presentation.folder.folderedit.FolderEdit
import com.example.kakaotalk.presentation.folder.folderedit.FolderEditRoute
import com.example.kakaotalk.presentation.folder.folderedit.FolderMore
import com.example.kakaotalk.presentation.folder.folderedit.FolderMoreRoute
import com.example.kakaotalk.presentation.folder.folderhome.FolderHome
import com.example.kakaotalk.presentation.folder.folderhome.FolderHomeRoute

@Composable
fun MainNavHost(
    appState: MainAppState,
    paddingValues: PaddingValues,
){
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = ChatList,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 300)
            )
        },
    ){
        composable<ChatList>{
            ChatListRoute(
                paddingValues = paddingValues,
                NavigateToFolderHome = {navController.navigate(FolderHome)},
            )
        }

        composable<FolderHome>{
            FolderHomeRoute(
                paddingValues = paddingValues,
                navigateUp = { navController.popBackStack() },
                navigateToFolderMore = {navController.navigate(FolderMore)},
                navigateToFolderEdit = {navController.navigate(FolderEdit)}
            )
        }

        composable<FolderMore>{
            FolderMoreRoute(
                paddingValues = paddingValues,
                navigateUp = { navController.popBackStack() },
            )
        }

        composable<FolderEdit>{
            FolderEditRoute(
                paddingValues = paddingValues,
                navigateUp = { navController.popBackStack() },
            )
        }
    }
}