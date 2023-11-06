package net.simpletimer.fanbox_supporter_api.api.relationships

import net.simpletimer.fanbox_supporter_api.api.FanboxAPIRequest
import net.simpletimer.fanbox_supporter_api.data.relationships.filter_option.FilterOptionData
import java.net.URL

/**
 * 支援の種類の一覧を取得する
 */
object ListFilterOptions : FanboxAPIRequest() {
    private val apiUrl = URL("${ROOT_URL}/relationship.listFilterOptions")


    /**
     * 支援の種類の一覧を取得する
     *
     * @return [List]<[FilterOptionData]>
     */
    fun getListFilterOptions(): List<FilterOptionData> {
        return httpGet<List<FilterOptionData>>(apiUrl) ?: emptyList()
    }
}