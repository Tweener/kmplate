package com.tweener.changehere.domain._internal

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * @author Vivien Mahe
 * @since 05/10/2023
 */

fun LocalDateTime.Companion.now(timeZone: TimeZone = TimeZone.currentSystemDefault()) = Clock.System.now().toLocalDateTime(timeZone)

fun LocalDate.Companion.now(timeZone: TimeZone = TimeZone.currentSystemDefault()) = LocalDateTime.now(timeZone).date

fun LocalDate.isAfter(other: LocalDate) = this > other
fun LocalDate.isBefore(other: LocalDate) = this < other
fun LocalDate.isSameDate(other: LocalDate) = this == other
