package net.simpletimer.fanbox_supporter_api.api

import io.github.cdimascio.dotenv.dotenv
import kotlinx.serialization.json.Json
import net.simpletimer.fanbox_supporter_api.data.ResponseBody
import net.simpletimer.fanbox_supporter_api.extensions.addFanboxAPIHeader
import net.simpletimer.fanbox_supporter_api.session_imitation.FanboxSessionImitation
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL


/**
 * FANBOXのAPIを叩く時の親となるクラス
 *
 */
open class FanboxAPIRequest {
    companion object {
        //APIのルートURL
        internal const val ROOT_URL = "https://api.fanbox.cc"
    }

    //Jsonの設定
    protected val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    //セッション管理
    val session: FanboxSessionImitation = FanboxSessionImitation(dotenv()["SESSION_ID"])

    /**
     * FANBOXへGetをする
     *
     * @param T 戻り値に期待する型
     * @param url [URL]
     * @return リクエストの結果を[T]にデコードされたもの
     */
    protected inline fun <reified T> httpGet(url: URL): T? {
        //リクエストを作成
        val request = Request.Builder()
            .url(url)
            .get()
            .addFanboxAPIHeader(session)
            .build()

        //送信
        val response = OkHttpClient().newCall(request).execute()

        //エラーチェック
        if (!response.isSuccessful) {
            println(response.message)
            return null
        }
        val responseBody = response.body ?: return null

        //セッションを更新
        session.updateSession(response)

        //デコードして返す
        return json.decodeFromString<ResponseBody<T>>(responseBody.string()).body
    }
}