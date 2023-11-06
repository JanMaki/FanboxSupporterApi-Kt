import net.simpletimer.fanbox_supporter_api.api.legacy.PayoutRequest
import net.simpletimer.fanbox_supporter_api.api.legacy.manage.pledge.Monthly
import net.simpletimer.fanbox_supporter_api.api.relationships.ListFans
import net.simpletimer.fanbox_supporter_api.data.relationships.StatusType
import net.simpletimer.fanbox_supporter_api.date.FanboxDate

fun main() {
    println("現在支援中のユーザー")
    println(ListFans.getListFans(StatusType.SUPPORTER).joinToString(" ") { it.user.name })

    println("\n過去の情報")
    val payoutRequest = PayoutRequest.getPayoutRequest()
    payoutRequest?.monthlyMaxPayoutRequestAmountHistory?.forEach {
        val month = it.targetMonth.convertTo(FanboxDate.FormatType.MONTH)
        println(month)
        val monthlyData = Monthly.getMonthly(it.targetMonth) ?: return@forEach
        monthlyData.supportTransactions.map { it.supporter.name }.forEach { print("${it} ") }
        println()
    }
}