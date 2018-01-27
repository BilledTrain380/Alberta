package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplineranking.DisciplineRankingCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineCompetitor
import ch.schulealtendorf.pra.pojo.Result
import org.junit.Assert
import org.junit.Test

class MappingsTest {
    
    @Test
    fun disciplineCompetitorMap() {
        
        val first = Pair(10, Result(10.03))
        val second = Pair(15, Result(10.11))
        val third = Pair(20, Result(11.12))
        val fourth = Pair(25, Result(12.88))
        
        val data: List<DisciplineCompetitor> = getTestData(second, third, fourth, first)
        
        val result = data.map()
        
        val expected: List<DisciplineRankingCompetitor> = getExpectedData(
                Triple(1, first.second, first.first),
                Triple(2, second.second, second.first),
                Triple(3, third.second, third.first),
                Triple(4, fourth.second, fourth.first)
        )
        Assert.assertEquals(expected, result)
    }
    
    @Test
    fun disciplineCompetitorMapWithSameResults() {

        val first = Pair(10, Result(10.03))
        val second = Pair(10, Result(10.03))
        val third = Pair(10, Result(10.03))
        val fourth = Pair(15, Result(12.88))

        val data: List<DisciplineCompetitor> = getTestData(second, third, fourth, first)

        val result = data.map()

        val expected: List<DisciplineRankingCompetitor> = getExpectedData(
                Triple(1, first.second, first.first),
                Triple(1, second.second, second.first),
                Triple(1, third.second, third.first),
                Triple(4, fourth.second, fourth.first)
        )
        Assert.assertEquals(expected, result)
    }
}

fun getTestData(first: Pair<Int, Result>, second: Pair<Int, Result>, third: Pair<Int, Result>, fourth: Pair<Int, Result>): List<DisciplineCompetitor> {
    return listOf(
            DisciplineCompetitor().apply {
                prename = ""
                surname = ""
                clazz = ""
                points = first.first
                result = first.second
            },
            DisciplineCompetitor().apply {
                prename = ""
                surname = ""
                clazz = ""
                points = second.first
                result = second.second
            },
            DisciplineCompetitor().apply {
                prename = ""
                surname = ""
                clazz = ""
                points = third.first
                result = third.second
            },
            DisciplineCompetitor().apply {
                prename = ""
                surname = ""
                clazz = ""
                points = fourth.first
                result = fourth.second
            }
    )
}

fun getExpectedData(first: Triple<Int, Result, Int>, second: Triple<Int, Result, Int>, third: Triple<Int, Result, Int>, fourth: Triple<Int, Result, Int>): List<DisciplineRankingCompetitor> {
    return listOf(
            DisciplineRankingCompetitor(first.first, "", "", "", first.second.toString(), first.third),
            DisciplineRankingCompetitor(second.first, "", "", "", second.second.toString(), second.third),
            DisciplineRankingCompetitor(third.first, "", "", "", third.second.toString(), third.third),
            DisciplineRankingCompetitor(fourth.first, "", "", "", fourth.second.toString(), fourth.third)
    )
}