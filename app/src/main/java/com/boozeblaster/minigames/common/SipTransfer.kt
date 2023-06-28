package com.boozeblaster.minigames.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.boozeblaster.R
import com.boozeblaster.composables.MyAnimatedVisibility
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleImageButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.widgets.MyMediaPlayer

class SipTransfer : MiniGame() {
    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        MyMediaPlayer.create(context = LocalContext.current, resid = R.raw.ka_ching)

        var buyerDropdownExpanded by remember {
            mutableStateOf(value = false)
        }

        var sellerDropdownExpanded by remember {
            mutableStateOf(value = false)
        }

        var pointsDropdownExpanded by remember {
            mutableStateOf(value = false)
        }

        var sipsDropdownExpanded by remember {
            mutableStateOf(value = false)
        }

        var buyer: Player? by remember {
            mutableStateOf(value = null)
        }

        var seller: Player? by remember {
            mutableStateOf(value = null)
        }

        var pointsToBuy by remember {
            mutableStateOf(value = 0)
        }

        var sipsToOffer by remember {
            mutableStateOf(value = 0)
        }


        //Buyer
        if (!buyerDropdownExpanded && !sellerDropdownExpanded
            && !pointsDropdownExpanded && !sipsDropdownExpanded
        ) {
            SimpleTextDisplay(
                text = "Buyer:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 10)

            SimpleButton(
                onClick = { buyerDropdownExpanded = true },
                text = if (buyer == null) "Pick Buyer" else buyer!!.getName(),
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }

        MyAnimatedVisibility(
            visible = buyerDropdownExpanded,
            animationDuration = AnimationConstants.SIP_TRANSFER_DIALOGS_FADE_IN_OUT.durationMillis
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.sizeIn(maxHeight = 400.dp),
                content = {
                    items(items = Game.getPlayers()) { player ->
                        if (player != seller) {
                            SimpleSpacer(size = 10)

                            SimpleButton(
                                onClick = {
                                    buyer = player
                                    buyerDropdownExpanded = false
                                },
                                text = player.getName(),
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily,
                                buttonType = if (buyer == player)
                                    ButtonType.CORRECT else ButtonType.INCORRECT
                            )

                            SimpleSpacer(size = 10)
                        }
                    }
                })

            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = { buyerDropdownExpanded = false },
                text = "Back",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }

        //Seller
        if (!buyerDropdownExpanded && !sellerDropdownExpanded
            && !pointsDropdownExpanded && !sipsDropdownExpanded
        ) {
            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "Seller:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )

            SimpleSpacer(size = 10)

            SimpleButton(
                onClick = { sellerDropdownExpanded = true },
                text = if (seller == null) "Pick Seller!" else seller!!.getName(),
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }

        MyAnimatedVisibility(
            visible = sellerDropdownExpanded,
            animationDuration = AnimationConstants.SIP_TRANSFER_DIALOGS_FADE_IN_OUT.durationMillis
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.sizeIn(maxHeight = 400.dp),
                content = {
                    items(items = Game.getPlayers()) { player ->
                        if (player != buyer) {
                            SimpleSpacer(size = 10)

                            SimpleButton(
                                onClick = {
                                    seller = player
                                    sellerDropdownExpanded = false
                                },
                                text = player.getName(),
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily,
                                buttonType = if (seller == player)
                                    ButtonType.CORRECT else ButtonType.INCORRECT
                            )

                            SimpleSpacer(size = 10)
                        }
                    }
                })

            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = { sellerDropdownExpanded = false },
                text = "Back",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }

        //Points to buy
        if (!buyerDropdownExpanded && !sellerDropdownExpanded
            && !pointsDropdownExpanded && !sipsDropdownExpanded
        ) {
            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "Points bought:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )

            SimpleSpacer(size = 10)

            SimpleButton(
                onClick = { pointsDropdownExpanded = true },
                text = "$pointsToBuy",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily,
                enabled = seller != null
            )
        }

        MyAnimatedVisibility(
            visible = pointsDropdownExpanded,
            animationDuration = AnimationConstants.SIP_TRANSFER_DIALOGS_FADE_IN_OUT.durationMillis
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.sizeIn(maxHeight = 400.dp),
                content = {
                    items(count = seller!!.getPoints()) { points ->
                        if (points != 0) {
                            SimpleSpacer(size = 10)

                            SimpleButton(
                                onClick = {
                                    pointsToBuy = points
                                    pointsDropdownExpanded = false
                                },
                                text = "$points",
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily,
                                buttonType = if (points == pointsToBuy)
                                    ButtonType.CORRECT else ButtonType.INCORRECT
                            )

                            SimpleSpacer(size = 10)
                        }
                    }
                })

            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = { pointsDropdownExpanded = false },
                text = "Back",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }

        //Sips to offer
        if (!buyerDropdownExpanded && !sellerDropdownExpanded
            && !pointsDropdownExpanded && !sipsDropdownExpanded
        ) {
            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "Sips offered:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )

            SimpleSpacer(size = 10)

            SimpleButton(
                onClick = { sipsDropdownExpanded = true },
                text = "$sipsToOffer",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily,
                enabled = buyer != null
            )
        }

        MyAnimatedVisibility(
            visible = sipsDropdownExpanded,
            animationDuration = AnimationConstants.SIP_TRANSFER_DIALOGS_FADE_IN_OUT.durationMillis
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.sizeIn(maxHeight = 400.dp),
                content = {
                    items(count = 31) { sips ->
                        if (sips != 0) {
                            SimpleSpacer(size = 10)

                            SimpleButton(
                                onClick = {
                                    sipsToOffer = sips
                                    sipsDropdownExpanded = false
                                },
                                text = "$sips",
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily,
                                buttonType = if (sips == sipsToOffer)
                                    ButtonType.CORRECT else ButtonType.INCORRECT
                            )

                            SimpleSpacer(size = 10)
                        }
                    }
                })

            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = { sipsDropdownExpanded = false },
                text = "Back",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }


        if (!buyerDropdownExpanded && !sellerDropdownExpanded
            && !pointsDropdownExpanded && !sipsDropdownExpanded
        ) {
            SimpleSpacer(size = 30)

            SimpleImageButton(
                modifier = Modifier.size(width = 150.dp, height = 150.dp),
                onClick = {
                    performTransaction(
                        buyer = buyer!!,
                        seller = seller!!,
                        pointsToBuy = pointsToBuy,
                        sipsToOffer = sipsToOffer
                    )
                    buyer = null
                    seller = null
                    pointsToBuy = 0
                    sipsToOffer = 0
                    MyMediaPlayer.start()
                },
                imageId = R.drawable.handshake,
                enabled = transactionIsLegit(
                    buyer = buyer,
                    seller = seller,
                    pointsToBuy = pointsToBuy
                )
            )

            SimpleSpacer(size = 30)

            SimpleButton(
                onClick = {
                    MyMediaPlayer.stop()
                    callback()
                },
                text = "Continue",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily,
                needsConfirmation = true
            )
        }
    }

    /**
     * @param buyer Buying player
     * @param seller Selling player
     * @param pointsToBuy How many points are to be bought
     * @return True if transaction can be made, false else
     */
    private fun transactionIsLegit(
        buyer: Player?,
        seller: Player?,
        pointsToBuy: Int
    ): Boolean {
        return buyer != null && seller != null
                && buyer != seller && pointsToBuy <= seller.getPoints()
    }

    /**
     * Performs the transaction, adds / subtracts the points and adds the sips to the buyer
     * @param buyer Buying player
     * @param seller Selling player
     * @param pointsToBuy How many points are to be bought
     * @param sipsToOffer How many sips were offered
     */
    private fun performTransaction(
        buyer: Player,
        seller: Player,
        pointsToBuy: Int,
        sipsToOffer: Int
    ) {
        buyer.addPoints(points = pointsToBuy)
        buyer.addSips(sips = sipsToOffer)
        seller.subtractPoints(points = pointsToBuy)
    }
}