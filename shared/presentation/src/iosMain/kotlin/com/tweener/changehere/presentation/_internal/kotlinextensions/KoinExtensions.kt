package com.tweener.changehere.presentation._internal.kotlinextensions

import com.tweener.changehere.presentation._internal.viewmodel.ViewModel
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
): KoinDefinition<T> = factory(qualifier = qualifier, definition = definition)
