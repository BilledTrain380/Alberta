package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplineranking.DisciplineRankingCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineCompetitor

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