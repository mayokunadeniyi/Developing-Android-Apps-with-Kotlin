package com.example.android.trackmysleepquality.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepNight

/**
 * Created by Mayokun Adeniyi on 30/11/2019.
 */

@BindingAdapter("setSleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?){
    item?.let {
        text = convertDurationToFormatted(it.startTimeMilli, it.endTimeMilli, context.resources)
    }
}

@BindingAdapter("setSleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight?){
    item?.let {
        text = convertNumericQualityToString(it.sleepQuality, context.resources)
    }
}

@BindingAdapter("setSleepImage")
fun ImageView.setSleepImage(item: SleepNight?){
    item?.let {
        setImageResource(when(it.sleepQuality){
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }
}