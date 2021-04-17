package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // The current word
    private var word = ""

    // The current score
    private var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


    init {
        Log.i("GameViewModel", "GameViewModel created")
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel onClear")
    }

    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
//            gameFinished()
        } else {
            word = wordList.removeAt(0)
        }
    }

    fun getWord(): String {
        return word
    }

    fun getScore(): Int {
        return score
    }
}