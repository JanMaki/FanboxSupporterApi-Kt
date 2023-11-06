package net.simpletimer.fanbox_supporter_api.data.relationships

/**
 * 支援の種類の列挙
 *
 * @param apiValue APIでの値
 */
enum class StatusType(val apiValue: String) {
    SUPPORTER("supporter"),
    FOLLOWER("follower"),
    ALL("all"),

    //不明な物があった時に使用
    INVALID("*INVALID");

    companion object {
        /**
         * APIでの値から[StatusType]を取得する
         *
         * @param apiValue APIでの値
         * @return [StatusType]
         */
        internal fun getOptionTypeFromAPIValue(apiValue: String): StatusType {
            return entries.firstOrNull { it.apiValue == apiValue } ?: INVALID
        }
    }
}