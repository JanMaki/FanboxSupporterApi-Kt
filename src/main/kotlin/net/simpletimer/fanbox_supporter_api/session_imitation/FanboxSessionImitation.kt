package net.simpletimer.fanbox_supporter_api.session_imitation

import okhttp3.Response

/**
 * Fanboxのセッションを模倣する
 *
 * @property sessionId 使用するSessionのId
 */
class FanboxSessionImitation(sessionId: String) {
    var sessionId = sessionId
        private set

    fun updateSession(response: Response) {
        response.headers("set-cookie").forEach {
            if (it.contains("FANBOXSESSID")) {
                sessionId = it
            }
        }
    }
}