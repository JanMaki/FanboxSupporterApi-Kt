import net.simpletimer.fanbox_supporter_api.api.legacy.PayoutRequest
import net.simpletimer.fanbox_supporter_api.api.legacy.manage.pledge.Monthly
import net.simpletimer.fanbox_supporter_api.api.relationships.ListFans
import net.simpletimer.fanbox_supporter_api.data.relationships.StatusType
import net.simpletimer.fanbox_supporter_api.date.FanboxDate

fun main(vararg args: String) {
    val token = args[0]

    println("現在支援中のユーザー")
    println(ListFans.getListFans(token, StatusType.SUPPORTER).joinToString(" ") { it.user.name })

    println("\n過去の情報")
    val payoutRequest = PayoutRequest.getPayoutRequest(token)
    payoutRequest?.monthlyMaxPayoutRequestAmountHistory?.forEach {
        val month = it.targetMonth.convertTo(FanboxDate.FormatType.MONTH)
        println(month)
        val monthlyData = Monthly.getMonthly(token, it.targetMonth) ?: return@forEach
        monthlyData.supportTransactions.map { it.supporter.name }.forEach { print("${it} ") }
        println()
    }
}