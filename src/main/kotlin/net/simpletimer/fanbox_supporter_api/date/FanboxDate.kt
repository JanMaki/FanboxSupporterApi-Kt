package net.simpletimer.fanbox_supporter_api.date

import java.text.SimpleDateFormat
import java.util.*

/**
 * FANBOXで使われている時間
 *
 * @param formatType フォーマットの種類
 * @param dateValue 上記のフォーマットで書かれた値
 */
class FanboxDate(formatType: FormatType, dateValue: String) {
    private val date: Date

    init {
        //フォーマット
        date = formatType.format.parse(dateValue)
    }

    /**
     * 特定のフォーマットに変換
     *
     * @param formatType [FormatType] 返還後のフォーマット
     * @return フォーマットに合わせた文字列
     */
    fun convertTo(formatType: FormatType): String {
        return formatType.format.format(date)
    }

    /**
     * フォーマットの種類
     *
     * @property format [SimpleDateFormat]
     */
    enum class FormatType(val format: SimpleDateFormat) {
        FULL(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSSXXX")),
        DAY(SimpleDateFormat("yyyy-MM-dd")),
        MONTH(SimpleDateFormat("yyyy-MM"))
    }
}