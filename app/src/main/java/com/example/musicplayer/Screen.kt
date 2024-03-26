package com.example.musicplayer

import androidx.annotation.DrawableRes

sealed class Screen(
    val title: String,
    val route: String,
    @DrawableRes val icon: Int? = null
) {
    object Home:Screen(title = "Home", route = "home")
    object Account : Screen(title = "Account", route = "account", R.drawable.baseline_account_box_24)
    object Subscription : Screen("Subscription", "subscription", R.drawable.ic_subscribe)
    object AddAccount : Screen("Add Account", "add_account", R.drawable.ic_add_account)
}

val screensInDrawer = listOf(
    Screen.Account,
    Screen.Subscription,
    Screen.AddAccount
)