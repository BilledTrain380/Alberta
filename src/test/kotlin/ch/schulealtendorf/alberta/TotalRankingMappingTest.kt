package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.totalranking.TotalRankingCompetitor
import ch.schulealtendorf.pra.pojo.Discipline
import ch.schulealtendorf.pra.pojo.Result
import ch.schulealtendorf.pra.pojo.TotalCompetitor
import org.junit.Assert
import org.junit.Test

class TotalRankingMappingTest {
    
    @Test
    fun totalCompetitorMap() {
        
        val first = Results(100, 150, 120, 110, 130, 180)
        val second = Results(85, 89, 92, 99, 95, 84)
        val third = Results(60, 65, 70, 66, 71, 75)
        val fourth = Results(55, 45, 51, 48, 49, 51)
        
        val totalRanking = listOf(
                createTotalCompetitor(fourth),
                createTotalCompetitor(second),
                createTotalCompetitor(first),
                createTotalCompetitor(third)
        )
        
        
        val result = totalRanking.toTotalRanking()
        
        val expected = getExpected(
                ExpectedCompetitor(1, 690, 100, first),
                ExpectedCompetitor(2, 460, 84, second),
                ExpectedCompetitor(3, 347, 60, third),
                ExpectedCompetitor(4, 254, 45, fourth)
        )
        Assert.assertEquals(expected, result)
    }
    
    @Test
    fun totalCompetiorMapWithSameResults() {

        val first = Results(100, 150, 120, 110, 130, 180)
        val second = Results(100, 150, 120, 110, 130, 180)
        val third = Results(100, 150, 120, 110, 130, 180)
        val fourth = Results(55, 45, 51, 48, 49, 51)

        val totalRanking = listOf(
                createTotalCompetitor(third),
                createTotalCompetitor(second),
                createTotalCompetitor(first),
                createTotalCompetitor(fourth)
        )


        val result = totalRanking.toTotalRanking()

        val expected = getExpected(
                ExpectedCompetitor(1, 690, 100, first),
                ExpectedCompetitor(1, 690, 100, second),
                ExpectedCompetitor(1, 690, 100, third),
                ExpectedCompetitor(4, 254, 45, fourth)
        )
        Assert.assertEquals(expected, result)
    }

    private fun createTotalCompetitor(resuts: Results): TotalCompetitor {
        return TotalCompetitor().apply {
            prename = ""
            surname = ""
            clazz = ""
            ballwurf = Discipline().apply {
                result = Result(0)
                points = resuts.ballwurf
            }
            ballzielWurf = Discipline().apply {
                result = Result(0)
                points = resuts.ballzielwurf
                setDistance("5")
            }
            korbeinwurf = Discipline().apply {
                result = Result(0)
                points = resuts.korbeinwurf
                setDistance("2.5")
            }
            schelllauf = Discipline().apply {
                result = Result(0)
                points = resuts.schnelllauf
            }
            seilspringen = Discipline().apply {
                result = Result(0)
                points = resuts.seilspringen
            }
            weitsprung = Discipline().apply {
                result = Result(0)
                points = resuts.weitsprung
            }
        }
    }

    private fun getExpected(first: ExpectedCompetitor, second: ExpectedCompetitor, third: ExpectedCompetitor, fourth: ExpectedCompetitor): List<TotalRankingCompetitor> {
        return listOf(
                TotalRankingCompetitor(first.rank, "", "", "", first.totalPoints, first.deletedResult, "0", first.results.schnelllauf, "0", first.results.ballwurf, "0", first.results.ballzielwurf, "0", first.results.korbeinwurf, "0", first.results.seilspringen, "0", first.results.weitsprung),
                TotalRankingCompetitor(second.rank, "", "", "", second.totalPoints, second.deletedResult, "0", second.results.schnelllauf, "0", second.results.ballwurf, "0", second.results.ballzielwurf, "0", second.results.korbeinwurf, "0", second.results.seilspringen, "0", second.results.weitsprung),
                TotalRankingCompetitor(third.rank, "", "", "", third.totalPoints, third.deletedResult, "0", third.results.schnelllauf, "0", third.results.ballwurf, "0", third.results.ballzielwurf, "0", third.results.korbeinwurf, "0", third.results.seilspringen, "0", third.results.weitsprung),
                TotalRankingCompetitor(fourth.rank, "", "", "", fourth.totalPoints, fourth.deletedResult, "0", fourth.results.schnelllauf, "0", fourth.results.ballwurf, "0", fourth.results.ballzielwurf, "0", fourth.results.korbeinwurf, "0", fourth.results.seilspringen, "0", fourth.results.weitsprung)
        )
    }

    private data class Results(
            val ballwurf: Int,
            val ballzielwurf: Int,
            val korbeinwurf: Int,
            val schnelllauf: Int,
            val seilspringen: Int,
            val weitsprung: Int
    )

    private data class ExpectedCompetitor(
            val rank: Int,
            val totalPoints: Int,
            val deletedResult: Int,
            val results: Results
    )
}
