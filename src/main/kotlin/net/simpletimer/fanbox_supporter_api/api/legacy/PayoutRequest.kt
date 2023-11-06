package net.simpletimer.fanbox_supporter_api.api.legacy

import net.simpletimer.fanbox_supporter_api.api.FanboxAPIRequest
import net.simpletimer.fanbox_supporter_api.data.payout_request.PayoutRequestData
import java.net.URL

/**
 * 支援金の振込情報を取得する
 */
object PayoutRequest : FanboxAPIRequest() {
    private val apiUrl = URL("${ROOT_URL}/legacy/payout_request")

    /**
     * 支援金の振込情報を取得する
     *
     * @return [PayoutRequestData]?
     */
    fun getPayoutRequest(): PayoutRequestData? {
        return httpGet<PayoutRequestData>(apiUrl)
    }
}