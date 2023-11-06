package net.simpletimer.fanbox_supporter_api.data.payout_request

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateDaySerializer

/**
 * 月の情報
 *
 * @property maxPayoutRequestAmount 小計
 * @property paymentCharge 手数料
 * @property specialSales
 * @property supportTotal 支援金
 * @property targetMonth 月
 */
@Serializable
data class MonthlyMaxPayoutRequestAmountData(
    val maxPayoutRequestAmount: Int,
    val paymentCharge: Int,
    val specialSales: List<String>,
    val supportTotal: Int,
    val targetMonth: @Serializable(with = FanboxDateDaySerializer::class) FanboxDate
)