package ch.schulealtendorf.alberta.totalranking

data class TotalRankingCompetitor(
        val rank: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val total: Int,
        val deletedResult: String,
        val schnelllaufResult: String,
        val schnelllaufPoints: Int,
        val ballwurfResult: String,
        val ballwurfPoints: Int,
        val ballzielWurfResult: String,
        val ballzielWurfPoints: Int,
        val korbeinWurfResult: String,
        val korbeinWurfPoints: Int,
        val seilspringenResult: String,
        val seilspringenPoints: Int,
        val weitsprungResult: String,
        val weitsprungPoints: Int
)