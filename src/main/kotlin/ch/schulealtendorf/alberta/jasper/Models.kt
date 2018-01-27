package ch.schulealtendorf.alberta.jasper

data class Participant(
        val prename: String,
        val surname: String,
        val gender: String,
        val clazz: String,
        val teacher: String
)

data class DisciplineRankingCompetitor(
        val rank: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val result: Double,
        val points: Int
)

data class DisciplineGroupRankingComptitor(
        val rank: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val total: Int,
        val firstResult: Double,
        val firstPoints: Int,
        val secondResult: Double,
        val secondPoints: Int,
        val thirdResult: Double,
        val thirdPoints: Int
)