package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplineranking.DisciplineRankingCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineCompetitor
import ch.schulealtendorf.pra.pojo.Result
import org.junit.Assert
import org.junit.Test

class DisciplineRankingMappingTest {
    
    @Test
    fun disciplineCompetitorMap() {
        
        val first = 25
        val second = 20
        val third = 15
        val fourth = 10
        
        val data: List<DisciplineCompetitor> = getTestData(second, third, fourth, first)
        
        val result = data.map()
        
        val expected: List<DisciplineRankingCompetitor> = getExpectedData(
                Pair(1, first),
                Pair(2, second),
                Pair(3, third),
                Pair(4, fourth)
        )
        Assert.assertEquals(expected, result)
    }
    
    @Test
    fun disciplineCompetitorMapWithSameResults() {

        val first = 10
        val second = 10
        val third = 10
        val fourth = 5

        val data: List<DisciplineCompetitor> = getTestData(second, third, fourth, first)

        val result = data.map()

        val expected: List<DisciplineRankingCompetitor> = getExpectedData(
                Pair(1, first),
                Pair(1, second),
                Pair(1, third),
                Pair(4, fourth)
        )
        Assert.assertEquals(expected, result)
    }

    private fun getTestData(first: Int, second: Int, third: Int, fourth: Int): List<DisciplineCompetitor> {
        return listOf(
                DisciplineCompetitor().apply {
                    prename = ""
                    surname = ""
                    clazz = ""
                    points = first
                    result = Result(0)
                },
                DisciplineCompetitor().apply {
                    prename = ""
                    surname = ""
                    clazz = ""
                    points = second
                    result = Result(0)
                },
                DisciplineCompetitor().apply {
                    prename = ""
                    surname = ""
                    clazz = ""
                    points = third
                    result = Result(0)
                },
                DisciplineCompetitor().apply {
                    prename = ""
                    surname = ""
                    clazz = ""
                    points = fourth
                    result = Result(0)
                }
        )
    }

    private fun getExpectedData(first: Pair<Int, Int>, second: Pair<Int, Int>, third: Pair<Int, Int>, fourth: Pair<Int, Int>): List<DisciplineRankingCompetitor> {
        return listOf(
                DisciplineRankingCompetitor(first.first, "", "", "", "0", first.second),
                DisciplineRankingCompetitor(second.first, "", "", "", "0", second.second),
                DisciplineRankingCompetitor(third.first, "", "", "", "0", third.second),
                DisciplineRankingCompetitor(fourth.first, "", "", "", "0", fourth.second)
        )
    }
}