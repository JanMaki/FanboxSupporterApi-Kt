package net.simpletimer.fanbox_supporter_api.data.monthly

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateMonthSerializer

/**
 * 月のデータ
 *
 * @property supportTransactions 対象のトランザクション
 * @property nextMonth 次の月
 * @property previousMonth 前の月
 */
@Serializable
data class MonthlyData(
    val supportTransactions: List<SupportTransactionData>,
    val nextMonth: @Serializable(with = FanboxDateMonthSerializer::class) FanboxDate? = null,
    val previousMonth: @Serializable(with = FanboxDateMonthSerializer::class) FanboxDate? = null
)