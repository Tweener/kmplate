package com.tweener.changehere.android.screen._di

import com.tweener.changehere.android.screen.MainViewModel
import com.tweener.changehere.data.repository.PlatformRepositoryImpl
import com.tweener.changehere.domain.Greeting
import org.kodein.di.DI
import org.kodein.di.bindSingleton

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val mainModule = DI.Module(name = "Main screen") {

    bindSingleton { Greeting(platformRepository = PlatformRepositoryImpl()) }
    bindSingleton { MainViewModel() }

}
