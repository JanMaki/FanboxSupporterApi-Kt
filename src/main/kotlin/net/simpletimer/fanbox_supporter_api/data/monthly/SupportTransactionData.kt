package net.simpletimer.fanbox_supporter_api.data.monthly

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.data.User
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateFullSerializer
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateMonthSerializer

/**
 * 支援の情報
 *
 * @property id 支援のID
 * @property supporter 対象のユーザー
 * @property paidAmount 支援金額
 * @property paymentMethod 支払い方法
 * @property transactionDatetime 支払いのトランザクションの時間
 * @property targetMonth 対象の月
 */
@Serializable
data class SupportTransactionData(
    val id: String,
    val supporter: User,
    val paidAmount: Int,
    val paymentMethod: String,
    val transactionDatetime: @Serializable(with = FanboxDateFullSerializer::class) FanboxDate,
    val targetMonth: @Serializable(with = FanboxDateMonthSerializer::class) FanboxDate
)