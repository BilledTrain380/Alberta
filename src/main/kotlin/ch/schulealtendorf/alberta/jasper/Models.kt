package ch.schulealtendorf.alberta.jasper

data class EventSheetCompetitor @JvmOverloads constructor(
        val startnumber: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val distance: String? = null
)

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