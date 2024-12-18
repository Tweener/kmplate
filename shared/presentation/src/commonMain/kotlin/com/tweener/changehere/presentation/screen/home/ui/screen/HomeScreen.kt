package com.tweener.changehere.presentation.screen.home.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tweener.alarmee.Alarmee
import com.tweener.alarmee.AlarmeeScheduler
import com.tweener.alarmee.AndroidNotificationConfiguration
import com.tweener.alarmee.AndroidNotificationPriority
import com.tweener.alarmee.RepeatInterval
import com.tweener.alarmee.rememberAlarmeeScheduler
import com.tweener.changehere.presentation._internal.kotlinextensions.findRootNavigator
import com.tweener.changehere.presentation.screen.detail.ui.screen.DetailScreen
import com.tweener.changehere.presentation.screen.home.HomeViewModel
import com.tweener.changehere.presentation.screen.home.ui.template.HomeTemplate
import com.tweener.czan._internal.kotlinextensions.subscribe
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinInject()
    val navigator = LocalNavigator.currentOrThrow.findRootNavigator()
    val alarmeeScheduler: AlarmeeScheduler = rememberAlarmeeScheduler(platformConfiguration = koinInject())

    viewModel.openDetailScreen.subscribe { id -> navigator.push(item = DetailScreen(id = id)) }
    viewModel.setOneOffAlarm.subscribe { dateTime ->
        alarmeeScheduler.schedule(
            alarmee = Alarmee(
                uuid = "myOneOffAlarmId",
                notificationTitle = "🎉 Congratulations! You've schedule a one-off Alarmee!",
                notificationBody = "This is the notification that will be displayed at the specified date and time.",
                scheduledDateTime = dateTime,
                androidNotificationConfiguration = AndroidNotificationConfiguration(
                    priority = AndroidNotificationPriority.DEFAULT,
                    channelId = "dailyNewsChannelId",
                ),
            )
        )
    }
    viewModel.setRepeatingAlarm.subscribe { dateTime ->
        alarmeeScheduler.schedule(
            alarmee = Alarmee(
                uuid = "myRepeatingAlarmId",
                notificationTitle = "🔁 Congratulations! You've schedule a repeating Alarmee!",
                notificationBody = "This is the notification that will be displayed every day at 09:36.",
                scheduledDateTime = dateTime,
                repeatInterval = RepeatInterval.Daily,
                androidNotificationConfiguration = AndroidNotificationConfiguration(
                    priority = AndroidNotificationPriority.MAXIMUM,
                    channelId = "breakingNewsChannelId",
                ),
            )
        )
    }

    HomeTemplate(
        onAction = { viewModel.onUiAction(uiAction = it) },
    )
}
