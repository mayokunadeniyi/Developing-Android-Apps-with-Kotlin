package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Mayokun Adeniyi on 2019-11-03.
 */

class ScoreViewModel (score: Int) : ViewModel(){

    //The final score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    //The play again event
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        //Log.i("ScoreViewModel","Final is $score")
        _score.value = score
    }

    fun onPlayAgain(){
        _eventPlayAgain.value = true
    }

    fun onPlayAgainEventComplete(){
        _eventPlayAgain.value = false
    }
}