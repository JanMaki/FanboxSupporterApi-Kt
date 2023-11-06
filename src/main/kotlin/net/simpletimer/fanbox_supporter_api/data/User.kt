package net.simpletimer.fanbox_supporter_api.data

import kotlinx.serialization.Serializable

/**
 * ユーザー
 *
 * @property userId ユーザーのID
 * @property name ユーザー名
 * @property iconUrl アイコンのURL
 */
@Serializable
data class User(
    val userId: String,
    val name: String,
    val iconUrl: String?
)