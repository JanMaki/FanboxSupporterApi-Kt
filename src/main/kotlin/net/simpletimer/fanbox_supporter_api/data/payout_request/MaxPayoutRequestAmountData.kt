package net.simpletimer.fanbox_supporter_api.data.payout_request

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateFullSerializer

/**
 * 振込可能額
 *
 * @property amount 額
 * @property calculatedDatetime いつ計算されたか
 */
@Serializable
data class MaxPayoutRequestAmountData(
    val amount: Int,
    val calculatedDatetime: @Serializable(with = FanboxDateFullSerializer::class) FanboxDate
)