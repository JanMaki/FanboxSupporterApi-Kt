package net.simpletimer.fanbox_supporter_api.api.legacy.manage.pledge

import net.simpletimer.fanbox_supporter_api.api.FanboxAPI
import net.simpletimer.fanbox_supporter_api.data.monthly.MonthlyData
import net.simpletimer.fanbox_supporter_api.date.FanboxDate
import java.net.URL

/**
 * 月ごとの支援の詳細を取得する
 */
object Monthly : FanboxAPI() {
    private const val BASE_URL = "$ROOT_URL/legacy/manage/pledge/monthly?"

    /**
     * 月ごとの支援の詳細を取得する
     *
     * @param token 使用するToken
     * @param date 取得する[FanboxDate]
     * @return [MonthlyData]?
     */
    fun getMonthly(token: String, date: FanboxDate): MonthlyData? {
        val url = URL("${BASE_URL}month=${date.convertTo(FanboxDate.FormatType.MONTH)}")
        return httpGet<MonthlyData>(url, token)
    }
}