package com.tweener.changehere.presentation._internal.di

import com.tweener.changehere.presentation.mapper.ToastMessageMapper
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val uiMapperModule = module {

    factory { ToastMessageMapper() }

}
