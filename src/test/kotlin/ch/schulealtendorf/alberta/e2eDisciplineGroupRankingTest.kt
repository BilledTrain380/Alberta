package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.disciplinegroupranking.JasperDisciplineGroupRankingAPI
import ch.schulealtendorf.pra.pojo.Discipline
import ch.schulealtendorf.pra.pojo.DisciplineGroupCompetitor
import ch.schulealtendorf.pra.pojo.DisciplineGroupRanking
import ch.schulealtendorf.pra.pojo.Result
import org.junit.Test
import java.time.Year

class DisciplineGroupRankingTest {
    
    @Test
    fun disciplineGroupRanking() {
        
        val api = JasperDisciplineGroupRankingAPI()
        
        val data = DisciplineGroupRanking().apply { 
            year = Year.now().minusYears(12)
            isGender = true
            competitors = listOf(
                    DisciplineGroupCompetitor().apply { 
                        prename = "Hans"
                        surname = "Muster"
                        clazz = "2a"
                        schnelllauf = Discipline().apply { 
                            result = Result(11.02)
                            points = 80
                            setDistance("60m")
                        }
                        weitsprung = Discipline().apply { 
                            result = Result(1.54)
                            points = 84
                        }
                        ballwurf = Discipline().apply { 
                            result = Result(20)
                            points = 81
                        }
                    },
                    DisciplineGroupCompetitor().apply {
                        prename = "Sascha"
                        surname = "Suster"
                        clazz = "2a"
                        schnelllauf = Discipline().apply {
                            result = Result(10.84)
                            points = 85
                            setDistance("60m")
                        }
                        weitsprung = Discipline().apply {
                            result = Result(1.23)
                            points = 78
                        }
                        ballwurf = Discipline().apply {
                            result = Result(25)
                            points = 89
                        }
                    }
            )
        }
        
        val report = api.createReport(data)
        
        report.write("discipline-group-ranking.pdf")
    }
}