package com.tweener.changehere.presentation

import kotlin.time.Duration.Companion.milliseconds

/**
 * @author Vivien Mahe
 * @since 04/06/2023
 */
object PresentationConstants {


    /**
     * Delay between two emissions of a flow, to avoid flood.
     */
    val FLOWS_DEBOUNCE_DELAY = 300.milliseconds

}
