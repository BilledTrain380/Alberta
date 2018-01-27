package ch.schulealtendorf.alberta.disciplineranking

/**
 * @author nmaerchy
 * @version 0.0.1
 */
data class DisciplineRankingCompetitor(
        val rank: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val result: String,
        val points: Int
)
