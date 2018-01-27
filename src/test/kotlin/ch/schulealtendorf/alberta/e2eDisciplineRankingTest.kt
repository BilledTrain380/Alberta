package ch.schulealtendorf.alberta

import ch.schulealtendorf.pra.pojo.DisciplineCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineRanking
import org.junit.Test

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
        competitor1.points = 100

        val competitor2 = DisciplineCompetitor()
        competitor2.surname = "Wirbelwind"
        competitor2.prename = "Willi"
        competitor2.clazz = "6b"
        competitor2.points = 86
        
        val ranking = DisciplineRanking()
        ranking.isGender = true
        ranking.discipline = "Ballwurf"
        ranking.competitors = listOf(competitor1, competitor2)
        
        return ranking
    }
}