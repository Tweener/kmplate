package com.tweener.changehere._internal.di

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

/**
 * @author Vivien Mahe
 * @since 16/02/2024
 */

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = viewModel(qualifier = qualifier, definition = definition)
