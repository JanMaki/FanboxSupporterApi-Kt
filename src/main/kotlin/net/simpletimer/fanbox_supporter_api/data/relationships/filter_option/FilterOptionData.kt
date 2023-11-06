package net.simpletimer.fanbox_supporter_api.data.relationships.filter_option

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.data.relationships.StatusType
import net.simpletimer.fanbox_supporter_api.data.relationships.StatusTypeSerializer

/**
 * 支援の種類の一覧
 *
 * @property type 支援の種類 [StatusType]
 * @property planId 支援プランのID(フォロー・すべての場合はnull)
 * @property planTitle 支援プランの名前(フォロー・すべての場合はnull)
 * @property count 人数
 */
@Serializable
data class FilterOptionData(
    val type: @Serializable(with = StatusTypeSerializer::class) StatusType,
    val planId: String? = null,
    val planTitle: String? = null,
    val count: Int,
)