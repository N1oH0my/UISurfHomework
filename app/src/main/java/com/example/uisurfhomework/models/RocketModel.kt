package com.example.uisurfhomework.models

import java.text.SimpleDateFormat
import java.util.Locale

data class RocketModel(
    val img: String,
    val type: String,
    val name: String,
    val launchDate: String,
    val launchSite: String,

    val countDown: String,
    val status: String,

    var isUpcoming: Boolean = false,
    var isLaunch: Boolean = false,
    var isRocket: Boolean = false,
    )
{
    val shortlaunchDate: String
        get() {
            val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.US)
            val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)

            try {
                val date = inputFormat.parse(launchDate)
                return outputFormat.format(date!!)
            } catch (e: Exception) {
                return launchDate
            }

        }
    val shortlaunchSite: String
        get() {
            try {
                return parseString(launchSite)
            }
            catch (e: Exception) {
                return launchSite
            }
        }

    private fun parseString(input: String): String {
        val words = input.split(" ")
        val abbreviation = StringBuilder()


        for (word in words) {

            if (word.isNotEmpty() && word[0].isUpperCase()) {
                abbreviation.append(word[0])
            }
        }

        abbreviation.append(" SLC ")
        words.lastOrNull { it.all { char -> char.isDigit() } }?.let {
            abbreviation.append(it)
        }

        return abbreviation.toString()
    }
}
