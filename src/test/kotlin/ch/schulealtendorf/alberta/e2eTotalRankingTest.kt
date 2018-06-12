package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.totalranking.JasperTotalRankingAPI
import ch.schulealtendorf.pra.pojo.Discipline
import ch.schulealtendorf.pra.pojo.Result
import ch.schulealtendorf.pra.pojo.TotalCompetitor
import ch.schulealtendorf.pra.pojo.TotalRanking
import org.junit.Test
import java.time.Year

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class TotalRankingTest {
    
    @Test
    fun totalRankingApi() {
        
        val api = JasperTotalRankingAPI()
        
        val data = testData()
        
        val report = api.createReport(data)
        
        report.write("total-ranking.pdf")
    }
    
    private fun testData(): TotalRanking {
        return TotalRanking().apply { 
            year = Year.now().minusYears(12)
            isGender = true
            competitors = listOf(
                    TotalCompetitor().apply {
                        prename = "Hans"
                        surname = "Muster"
                        clazz = "2a"
                        ballwurf = Discipline().apply {
                            result = Result(20)
                            points = 200
                        }
                        ballzielWurf = Discipline().apply {
                            result = Result(13)
                            points = 210
                            setDistance("5m")
                        }
                        korbeinwurf = Discipline().apply {
                            result = Result(18)
                            points = 189
                            setDistance("2.5m")
                        }
                        schelllauf = Discipline().apply {
                            result = Result(11.12)
                            points = 201
                        }
                        seilspringen = Discipline().apply {
                            result = Result(50)
                            points = 198
                        }
                        weitsprung = Discipline().apply {
                            result = Result(1.54)
                            points = 207
                        }
                    },
                    TotalCompetitor().apply {
                        prename = "Sascha"
                        surname = "Suster"
                        clazz = "2a"
                        ballwurf = Discipline().apply {
                            result = Result(25)
                            points = 208
                        }
                        ballzielWurf = Discipline().apply {
                            result = Result(8)
                            points = 180
                            setDistance("5m")
                        }
                        korbeinwurf = Discipline().apply {
                            result = Result(21)
                            points = 198
                            setDistance("2.5m")
                        }
                        schelllauf = Discipline().apply {
                            result = Result(10.08)
                            points = 212
                        }
                        seilspringen = Discipline().apply {
                            result = Result(48)
                            points = 180
                        }
                        weitsprung = Discipline().apply {
                            result = Result(1.2)
                            points = 187
                        }
                    }
            )
        }
    }
}