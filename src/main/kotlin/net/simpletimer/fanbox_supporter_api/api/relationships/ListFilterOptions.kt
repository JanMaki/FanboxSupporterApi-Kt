package net.simpletimer.fanbox_supporter_api.api.relationships

import net.simpletimer.fanbox_supporter_api.api.FanboxAPI
import net.simpletimer.fanbox_supporter_api.data.relationships.filter_option.FilterOptionData
import java.net.URL

/**
 * 支援の種類の一覧を取得する
 */
object ListFilterOptions : FanboxAPI() {
    private val apiUrl = URL("${ROOT_URL}/relationship.listFilterOptions")


    /**
     * 支援の種類の一覧を取得する
     *
     * @param token 使用するToken
     * @return [List]<[FilterOptionData]>
     */
    fun getListFilterOptions(token: String): List<FilterOptionData> {
        return httpGet<List<FilterOptionData>>(apiUrl, token) ?: emptyList()
    }
}