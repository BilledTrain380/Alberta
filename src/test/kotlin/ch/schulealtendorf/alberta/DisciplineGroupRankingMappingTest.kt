package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplinegroupranking.DisciplineGroupRankingCompetitor
import ch.schulealtendorf.pra.pojo.Discipline
import ch.schulealtendorf.pra.pojo.DisciplineGroupCompetitor
import ch.schulealtendorf.pra.pojo.Result
import org.junit.Assert
import org.junit.Test

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class DisciplineGroupRankingMappingTest {
    
    @Test
    fun disciplineGroupCompetitorMap() {
        
        val first = Triple(110, 105, 120)
        val second = Triple(88, 90, 81)
        val third = Triple(41, 58, 48)
        val fourth = Triple(20, 18, 18)
        
        val disciplineGroupRanking = listOf(
                createDisciplineGroupCompetitor(second),
                createDisciplineGroupCompetitor(fourth),
                createDisciplineGroupCompetitor(first),
                createDisciplineGroupCompetitor(third)
        )
        
        
        val result = disciplineGroupRanking.mapToDisciplineGroupRanking()
        
        
        val expected = listOf(
                getExpected(CompetitorData(1, 335, first.first, first.second, first.third)),
                getExpected(CompetitorData(2, 259, second.first, second.second, second.third)),
                getExpected(CompetitorData(3, 147, third.first, third.second, third.third)),
                getExpected(CompetitorData(4, 56, fourth.first, fourth.second, fourth.third))
        )
        Assert.assertEquals(expected, result)
    }
    
    @Test
    fun disciplineGroupCompetitorMapWithSameResults() {

        val first = Triple(110, 105, 120)
        val second = Triple(110, 105, 120)
        val third = Triple(110, 105, 120)
        val fourth = Triple(20, 18, 18)

        val disciplineGroupRanking = listOf(
                createDisciplineGroupCompetitor(fourth),
                createDisciplineGroupCompetitor(second),
                createDisciplineGroupCompetitor(first),
                createDisciplineGroupCompetitor(third)
        )


        val result = disciplineGroupRanking.mapToDisciplineGroupRanking()


        val expected = listOf(
                getExpected(CompetitorData(1, 335, first.first, first.second, first.third)),
                getExpected(CompetitorData(1, 335, second.first, second.second, second.third)),
                getExpected(CompetitorData(1, 335, third.first, third.second, third.third)),
                getExpected(CompetitorData(4, 56, fourth.first, fourth.second, fourth.third))
        )
        Assert.assertEquals(expected, result)
    }
    
    private fun createDisciplineGroupCompetitor(results: Triple<Int, Int, Int>): DisciplineGroupCompetitor {
        return DisciplineGroupCompetitor().apply {
            prename = ""
            surname = ""
            clazz = ""
            schnelllauf = Discipline().apply {
                result = Result(0)
                points = results.second
            }
            weitsprung = Discipline().apply {
                result = Result(0)
                points = results.third
            }
            ballwurf = Discipline().apply {
                result = Result(0)
                points = results.first
            }
        }
    }

    private fun getExpected(data: CompetitorData): DisciplineGroupRankingCompetitor {
        return DisciplineGroupRankingCompetitor(data.rank, "", "", "", data.total, "0", data.schnelllauf, "0", data.weitsprung, "0", data.ballwurf)
    }
    
    private class CompetitorData(
            val rank: Int,
            val total: Int,
            val ballwurf: Int,
            val schnelllauf: Int,
            val weitsprung: Int
    )
}