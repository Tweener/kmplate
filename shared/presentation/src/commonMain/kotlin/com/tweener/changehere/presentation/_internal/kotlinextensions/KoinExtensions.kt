package com.tweener.changehere.presentation._internal.kotlinextensions

import com.tweener.changehere.presentation._internal.viewmodel.ViewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

/**
 * @author Vivien Mahe
 * @since 01/10/2024
 */

expect inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T>
