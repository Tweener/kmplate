package com.tweener.changehere.android._internal.di.module

import android.content.Context
import com.tweener.changehere._internal.di.sharedModule
import com.tweener.changehere.android._internal.di.module.app.appModule
import java.util.Locale
import org.kodein.di.DI
import org.kodein.di.bindSingleton

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
fun rootModule(context: Context) = DI.Module(name = "Application entry point Module") {

    bindSingleton { context }
    bindSingleton { Locale.getDefault() }

    importOnce(appModule)
    importOnce(sharedModule)

}
