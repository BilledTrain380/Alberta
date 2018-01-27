package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplineranking.DisciplineRankingCompetitor
import ch.schulealtendorf.alberta.totalranking.TotalRankingCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineCompetitor
import ch.schulealtendorf.pra.pojo.TotalCompetitor

fun List<DisciplineCompetitor>.map(): List<DisciplineRankingCompetitor> {

    var rank = 1
    var previousPoints = -1

    return this.sortedBy { it.points }.reversed().mapIndexed { index, it ->

        if (it.points != previousPoints) {
            rank = index +1
        }
        
        previousPoints = it.points
        
        DisciplineRankingCompetitor(rank, it.prename, it.surname, it.clazz, it.result.toString(), it.points)
    }
}

fun List<TotalCompetitor>.toTotalRanking(): List<TotalRankingCompetitor> {

    var rank = 1
    var previousPoints = -1
    
    return this.map { 
        
        val points = kotlin.collections.listOf(
                it.schelllauf.points, it.weitsprung.points, it.ballwurf.points, it.ballzielWurf.points, it.korbeinwurf.points, it.seilspringen.points
        ).sorted().reversed()
        
        val total = points.dropLast(1).sum()
        val deletedResult = points.last()
        
        MappedTotalCompetitor(total, deletedResult, it)
    }.sortedBy { it.total }.reversed().mapIndexed { index, it ->

        if (it.total != previousPoints) {
            rank = index +1
        }

        previousPoints = it.total
        
        TotalRankingCompetitor(
                rank,
                it.competitor.prename,
                it.competitor.surname,
                it.competitor.clazz,
                it.total,
                it.deletedResult,
                it.competitor.schelllauf.result.toString(),
                it.competitor.schelllauf.points,
                it.competitor.ballwurf.result.toString(),
                it.competitor.ballwurf.points,
                it.competitor.ballzielWurf.result.toString(),
                it.competitor.ballzielWurf.points,
                it.competitor.korbeinwurf.result.toString(),
                it.competitor.korbeinwurf.points,
                it.competitor.seilspringen.result.toString(),
                it.competitor.seilspringen.points,
                it.competitor.weitsprung.result.toString(),
                it.competitor.weitsprung.points
        )
    }
}

data class MappedTotalCompetitor(
        val total: Int,
        val deletedResult: Int,
        val competitor: TotalCompetitor
)