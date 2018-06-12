package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplineranking.JasperDisciplineRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineRanking
import ch.schulealtendorf.pra.pojo.Result
import org.junit.Test
import java.time.Year

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class DisciplineRankingTest {

    @Test
    fun disciplineRanking() {
        
        val api = JasperDisciplineRankingAPI()
        
        val data = getTestData()
        
        api.createReport(data).write("discipline-ranking.pdf")
    }
    
    private fun getTestData(): DisciplineRanking {
        
        val competitor1 = DisciplineCompetitor()
        competitor1.surname = "Muster"
        competitor1.prename = "Hans"
        competitor1.clazz = "6a"
        competitor1.result = Result(10)
        competitor1.points = 100

        val competitor2 = DisciplineCompetitor()
        competitor2.surname = "Wirbelwind"
        competitor2.prename = "Willi"
        competitor2.clazz = "6b"
        competitor2.result = Result(12)
        competitor2.points = 86
        
        val ranking = DisciplineRanking()
        ranking.isGender = true
        ranking.discipline = "Ballwurf"
        ranking.competitors = listOf(competitor1, competitor2)
        ranking.year = Year.now().minusYears(12)
        
        return ranking
    }
}