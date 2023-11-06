package net.simpletimer.fanbox_supporter_api.data

import kotlinx.serialization.Serializable

/**
 * HTTPのレスポンスボディのデシリアライズに使用する
 *
 */
@Serializable
data class ResponseBody<T>(
    val body: T
)