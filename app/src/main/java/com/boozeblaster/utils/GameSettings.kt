package com.boozeblaster.utils

/**
 * Global Settings for the game
 */
object GameSettings {

    private var individualTasks = arrayOf("GuessTheSong", "GuessTheLyrics", "FactOrFiction")
    private var commonTasks = arrayOf("HighestBidder")
    private var versusTasks = arrayOf("RockPaperScissors", "SingASong")

    fun getIndividualTasks(): Array<String> = this.individualTasks
    fun getCommonTasks(): Array<String> = this.commonTasks
    fun getVersusTasks(): Array<String> = this.versusTasks

    fun setIndividualTasks(options: Array<String>) {
        this.individualTasks = options
    }

    fun setCommonTasks(options: Array<String>) {
        this.commonTasks = options
    }

    fun setVersusTasks(options: Array<String>) {
        this.versusTasks = options
    }

    fun playIndividualTasks(): Boolean = !this.individualTasks.isEmpty()
    fun playCommonTasks(): Boolean = !this.commonTasks.isEmpty()
    fun playVersusTasks(): Boolean = !this.versusTasks.isEmpty()

}