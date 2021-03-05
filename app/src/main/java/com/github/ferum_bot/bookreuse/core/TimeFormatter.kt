package com.github.ferum_bot.bookreuse.core

/**
 * Created by Matvey Popov.
 * Date: 28.02.2021
 * Time: 22:13
 * Project: BookReuse
 */
object TimeFormatter {

    fun formatTime(timeInMillis: Long, textPrefix: String = "", textSuffix: String = "", separator: String = ":"): String {
        val totalNumberOfSeconds = timeInMillis / 1000
        val numberOfSeconds = totalNumberOfSeconds % 60
        val numberOfMinutes = totalNumberOfSeconds / 60
        val numberOfHours = totalNumberOfSeconds / 3600
        return textPrefix + mergeTimeInOneString(numberOfSeconds, numberOfMinutes, numberOfHours, separator) + textSuffix
    }

    private fun mergeTimeInOneString(numberOfSeconds: Long, numberOfMinutes: Long, numberOfHours: Long, separator: String): String {
        val resultString = StringBuilder()
        if (numberOfHours != 0L) {
            resultString.append(numberOfHours)
            resultString.append(separator)
        }
        resultString.append(formatUnitByBasePattern(numberOfMinutes))
        resultString.append(separator)
        resultString.append(formatUnitByBasePattern(numberOfSeconds))
        return resultString.toString()
    }

    /**
     * This function format seconds, minutes or hours.
     * This function just append 0 if length of number
     * is less then two
     */
    private fun formatUnitByBasePattern(unit: Long): String {
        return if (unit > 9) {
            unit.toString()
        }
        else {
            "0$unit"
        }
    }
}