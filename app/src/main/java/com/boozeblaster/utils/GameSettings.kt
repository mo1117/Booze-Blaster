package com.boozeblaster.utils

/**
 * Global Settings for the game
 */
object GameSettings {

    private var commonTasks = arrayOf(
        "HighestBidder", "SipTransfer", "NeverHaveIEver", "SetRule", "WhoInThisRoom"
    )
    private var versusTasks = arrayOf("RockPaperScissors", "SingASong")
    private var individualTasks =
        arrayOf("GuessTheSong", "GuessTheLyrics", "FactOrFiction")

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

    fun resetIndividualTasks() {
        this.individualTasks = arrayOf("GuessTheSong", "GuessTheLyrics", "FactOrFiction")
    }

    fun resetCommonTasks() {
        this.commonTasks = arrayOf(
            "HighestBidder", "SipTransfer", "NeverHaveIEver", "SetRule", "WhoInThisRoom"
        )
    }

    fun resetVersusTasks() {
        this.versusTasks = arrayOf("RockPaperScissors", "SingASong")
    }

    fun playIndividualTasks(): Boolean = this.individualTasks.isNotEmpty()
    fun playCommonTasks(): Boolean = this.commonTasks.isNotEmpty()
    fun playVersusTasks(): Boolean = this.versusTasks.isNotEmpty()
    fun playSipTransfer(): Boolean = this.commonTasks.contains(element = "SipTransfer")

}