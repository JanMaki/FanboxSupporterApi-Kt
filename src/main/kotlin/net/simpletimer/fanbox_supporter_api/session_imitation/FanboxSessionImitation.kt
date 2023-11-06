package net.simpletimer.fanbox_supporter_api.session_imitation

import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.simpletimer.fanbox_supporter_api.extensions.addFanboxAPIHeader
import net.simpletimer.fanbox_supporter_api.session_imitation.FanboxSessionImitation.sessionId
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URL

/**
 * Fanboxのセッションを模倣する
 *
 * @property sessionId 使用するSessionのId
 */
object FanboxSessionImitation {
    var sessionId: String = dotenv()["SESSION_ID"]
        private set

    init {
        //非同期にもっていく
        val instance = this
        CoroutineScope(Dispatchers.Default).launch {
            //セッションを定期的につなげる
            while (true) {
                //リクエストを作成
                val request = Request.Builder()
                    .url(URL("https://www.fanbox.cc/"))
                    .get()
                    .addFanboxAPIHeader(instance)
                    .build()

                //送信
                val response = OkHttpClient().newCall(request).execute()

                //エラーチェック
                if (!response.isSuccessful) {
                    println(response.message)
                    continue
                }

                //セッションを更新
                updateSession(response)

                //スレッドを止める
                Thread.sleep(600000)
            }
        }
    }

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