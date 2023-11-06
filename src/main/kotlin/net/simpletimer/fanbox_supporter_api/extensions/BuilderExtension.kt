package net.simpletimer.fanbox_supporter_api.extensions

import okhttp3.Request

/**
 * [Request.Builder]の拡張
 * FanboxのAPI呼び出しに必要なヘッダーを作成
 *
 * @param token [String]
 * @return [Request.Builder]をそのまま返す
 */
fun Request.Builder.addFanboxAPIHeader(token: String): Request.Builder {
    this.addHeader("Origin", "https://simpletimer.fanbox.cc")
    this.addHeader("Cookie", "FANBOXSESSID=$token")

    return this
}