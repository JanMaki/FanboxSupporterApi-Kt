package net.simpletimer.fanbox_supporter_api.data.payout_request

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateFullSerializer

/**
 * 支援金の情報
 *
 * @property maxPayoutRequestAmount 現在の振込可能額
 * @property monthlyMaxPayoutRequestAmountHistory 過去の月の支援金
 * @property nextAutoPayoutDatetime 次自動振込される日付
 * @property notice
 */
@Serializable
data class PayoutRequestData(
    val maxPayoutRequestAmount: MaxPayoutRequestAmountData,
    val monthlyMaxPayoutRequestAmountHistory: List<MonthlyMaxPayoutRequestAmountData>,
    val nextAutoPayoutDatetime: @Serializable(with = FanboxDateFullSerializer::class) FanboxDate,
    val notice: String?
)