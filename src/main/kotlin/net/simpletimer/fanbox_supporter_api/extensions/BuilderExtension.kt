package net.simpletimer.fanbox_supporter_api.extensions

import net.simpletimer.fanbox_supporter_api.session_imitation.FanboxSessionImitation
import okhttp3.Request

/**
 * [Request.Builder]の拡張
 * FanboxのAPI呼び出しに必要なヘッダーを作成
 *
 * @param token [String]
 * @return [Request.Builder]をそのまま返す
 */
fun Request.Builder.addFanboxAPIHeader(session: FanboxSessionImitation): Request.Builder {
    this.addHeader("Origin", "https://simpletimer.fanbox.cc")
    this.addHeader("Cookie", "FANBOXSESSID=${session.sessionId}")

    return this
}