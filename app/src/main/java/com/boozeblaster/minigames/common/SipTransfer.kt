package com.boozeblaster.minigames.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.R
import com.boozeblaster.composables.*
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player

class SipTransfer : MiniGame() {
    /**
     * STUB method - we do not need to display any content here
     */
    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {

        var buyerDropdownExpanded by remember {
            mutableStateOf(value = false)
        }

        var sellerDropdownMenuExpanded by remember {
            mutableStateOf(value = false)
        }

        var pointsDropdownMenuExpanded by remember {
            mutableStateOf(value = false)
        }

        var sipsDropdownMenuExpanded by remember {
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

        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "Buyer:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 10)

            //Buyer
            Box {
                SimpleButton(
                    onClick = { buyerDropdownExpanded = !buyerDropdownExpanded },
                    text = if (buyer == null) "Pick Buyer" else buyer!!.getName(),
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
                DropdownMenu(
                    expanded = buyerDropdownExpanded,
                    onDismissRequest = { buyerDropdownExpanded = false }) {
                    for (player in Game.getPlayers()) {
                        DropdownMenuItem(onClick = {
                            buyer = player
                            buyerDropdownExpanded = false
                        }) {
                            SimpleTextDisplay(
                                text = player.getName(),
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily
                            )
                        }
                    }
                }
            }

            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "Seller:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 10)

            //Seller
            Box {
                SimpleButton(
                    onClick = { sellerDropdownMenuExpanded = !sellerDropdownMenuExpanded },
                    text = if (seller == null) "Pick Seller" else seller!!.getName(),
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
                DropdownMenu(
                    expanded = sellerDropdownMenuExpanded,
                    onDismissRequest = { sellerDropdownMenuExpanded = false }) {
                    for (player in Game.getPlayers()) {
                        DropdownMenuItem(onClick = {
                            seller = player
                            sellerDropdownMenuExpanded = false
                        }) {
                            SimpleTextDisplay(
                                text = player.getName(),
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily
                            )
                        }
                    }
                }
            }

            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "Points bought:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 10)

            //Points to buy
            Box {
                SimpleButton(
                    onClick = { pointsDropdownMenuExpanded = !pointsDropdownMenuExpanded },
                    text = "$pointsToBuy",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
                DropdownMenu(
                    expanded = pointsDropdownMenuExpanded,
                    onDismissRequest = { pointsDropdownMenuExpanded = false }) {
                    if (seller == null) {
                        DropdownMenuItem(onClick = {
                            pointsDropdownMenuExpanded = false
                            sellerDropdownMenuExpanded = true
                        }) {
                            SimpleTextDisplay(
                                text = "Select Seller",
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily
                            )
                        }
                    } else {
                        for (i in 1..seller!!.getPoints()) {
                            DropdownMenuItem(onClick = {
                                pointsToBuy = i
                                pointsDropdownMenuExpanded = false
                            }) {
                                SimpleTextDisplay(
                                    text = "$i",
                                    fontSize = super.fontSize,
                                    fontFamily = super.fontFamily
                                )
                            }
                        }
                    }
                }
            }

            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "Sips offered:",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 10)

            Box {
                SimpleButton(
                    onClick = { sipsDropdownMenuExpanded = !sipsDropdownMenuExpanded },
                    text = "$sipsToOffer",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )

                DropdownMenu(
                    expanded = sipsDropdownMenuExpanded,
                    onDismissRequest = { sipsDropdownMenuExpanded = false }) {
                    for (i in 0..30) {
                        DropdownMenuItem(onClick = {
                            sipsToOffer = i
                            sipsDropdownMenuExpanded = false
                        }) {
                            SimpleTextDisplay(
                                text = "$i",
                                fontSize = super.fontSize,
                                fontFamily = super.fontFamily
                            )
                        }
                    }
                }
            }

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
                onClick = { callback() },
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