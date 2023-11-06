package net.simpletimer.fanbox_supporter_api.session_imitation

import io.github.cdimascio.dotenv.dotenv
import okhttp3.Response

/**
 * Fanboxのセッションを模倣する
 *
 * @property sessionId 使用するSessionのId
 */
object FanboxSessionImitation {
    var sessionId: String = dotenv()["SESSION_ID"]
        private set

    /**
     * セッションを更新
     *
     * @param response 問い合わせの情報
     */
    fun updateSession(response: Response) {
        //Cookieを取得
        response.headers("set-cookie").forEach {
            //セッションのIDの値かを確認
            if (it.contains("FANBOXSESSID")) {
                //更新
                sessionId = it
            }
        }
    }
}