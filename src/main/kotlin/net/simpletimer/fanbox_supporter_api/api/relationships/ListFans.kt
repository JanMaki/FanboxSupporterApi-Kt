package net.simpletimer.fanbox_supporter_api.api.relationships

import net.simpletimer.fanbox_supporter_api.api.FanboxAPIRequest
import net.simpletimer.fanbox_supporter_api.data.relationships.FanData
import net.simpletimer.fanbox_supporter_api.data.relationships.StatusType
import java.net.URL

/**
 * 支援者の一覧を取得する
 */
object ListFans : FanboxAPIRequest() {
    //URLのベース
    private const val BASE_URL = "${ROOT_URL}/relationship.listFans?"

    /**
     * 支援者の一覧を取得する
     *
     * @param status 支援の種類 [StatusType]
     * @param planId 支援プランのID(フォロー・すべての場合はnull)
     * @return [List]<[FanData]>
     */
    fun getListFans(status: StatusType, planId: String? = null): List<FanData> {
        //URLを作成
        val url = URL("${BASE_URL}status=${status.apiValue}${if (planId != null) "planId=${planId}" else ""}")
        //取得して返す
        return httpGet<List<FanData>>(url) ?: emptyList()
    }
}