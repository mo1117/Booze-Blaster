package com.boozeblaster.utils

/**
 * Global Settings for the game
 */
object GameSettings {

    private var commonTasks = arrayOf(
        "HighestBidder", "SipTransfer", "NeverHaveIEver", "SetRule", "WhoInThisRoom"
    )
    private var versusTasks = arrayOf("RockPaperScissors", "SingASong", "MentalArithmetic")
    private var individualTasks =
        arrayOf("GuessTheSong", "GuessTheLyrics", "FactOrFiction", "HigherLower", "GuessTheTheme")

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

    fun reset() {
        resetCommonTasks()
        resetIndividualTasks()
        resetVersusTasks()
    }

    fun resetIndividualTasks() {
        this.individualTasks = arrayOf(
            "GuessTheSong",
            "GuessTheLyrics",
            "FactOrFiction",
            "HigherLower",
            "GuessTheTheme"
        )
    }

    fun resetCommonTasks() {
        this.commonTasks = arrayOf(
            "HighestBidder", "SipTransfer", "NeverHaveIEver", "SetRule", "WhoInThisRoom"
        )
    }

    fun resetVersusTasks() {
        this.versusTasks = arrayOf("RockPaperScissors", "SingASong", "MentalArithmetic")
    }

    fun playIndividualTasks(): Boolean = this.individualTasks.isNotEmpty()
    fun playCommonTasks(): Boolean = this.commonTasks.isNotEmpty()
    fun playVersusTasks(): Boolean = this.versusTasks.isNotEmpty()
    fun playSipTransfer(): Boolean = this.commonTasks.contains(element = "SipTransfer")

}