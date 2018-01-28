package ch.schulealtendorf.alberta.disciplinegroupranking

/**
 * @author nmaerchy
 * @version 0.0.1
 */
data class DisciplineGroupRankingCompetitor(
        val rank: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val total: Int,
        val schnelllaufResult: String,
        val schnelllaufPoints: Int,
        val weitsprungResult: String,
        val weitsprungPoints: Int,
        val ballwurfResult: String,
        val ballwurfPoints: Int
)