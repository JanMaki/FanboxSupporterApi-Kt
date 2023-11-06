package net.simpletimer.fanbox_supporter_api.data.relationships

import kotlinx.serialization.Serializable
import net.simpletimer.fanbox_supporter_api.data.User
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import net.simpletimer.fanbox_supporter_api.date.serializer.FanboxDateFullSerializer

@Serializable
data class FanData(
    val status: @Serializable(with = StatusTypeSerializer::class) StatusType,
    val user: User,
    val planId: String? = null,
    val activatedAt: @Serializable(with = FanboxDateFullSerializer::class) FanboxDate,
    val note: String
)