package net.simpletimer.fanbox_supporter_api.api.legacy

import net.simpletimer.fanbox_supporter_api.api.FanboxAPI
import net.simpletimer.fanbox_supporter_api.data.payout_request.PayoutRequestData
import java.net.URL

/**
 * 支援金の振込情報を取得する
 */
object PayoutRequest : FanboxAPI() {
    private val apiUrl = URL("${ROOT_URL}/legacy/payout_request")

    /**
     * 支援金の振込情報を取得する
     *
     * @param token 使用するToken
     * @return [PayoutRequestData]?
     */
    fun getPayoutRequest(token: String): PayoutRequestData? {
        return httpGet<PayoutRequestData>(apiUrl, token)
    }
}