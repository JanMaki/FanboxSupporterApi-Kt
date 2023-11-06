package net.simpletimer.fanbox_supporter_api.api

import kotlinx.serialization.json.Json
import net.simpletimer.fanbox_supporter_api.data.ResponseBody
import net.simpletimer.fanbox_supporter_api.extensions.addFanboxAPIHeader
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL


open class FanboxAPI {
    companion object {
        //APIのルートURL
        internal const val ROOT_URL = "https://api.fanbox.cc"
    }

    //Jsonの設定
    protected val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    /**
     * FANBOXへGetをする
     *
     * @param T 戻り値に期待する型
     * @param url [URL]
     * @param token Token(セッションのID)
     * @return リクエストの結果を[T]にデコードされたもの
     */
    protected inline fun <reified T> httpGet(url: URL, token: String): T? {
        //リクエストを作成
        val request = Request.Builder()
            .url(url)
            .get()
            .addFanboxAPIHeader(token)
            .build()

        //送信
        val response = OkHttpClient().newCall(request).execute()

        //エラーチェック
        if (!response.isSuccessful) {
            println(response.message)
            return null
        }
        val responseBody = response.body ?: return null

        //デコードして返す
        return json.decodeFromString<ResponseBody<T>>(responseBody.string()).body
    }
}