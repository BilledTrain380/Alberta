package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.jasper.DisciplineRankingCompetitor
import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.pra.api.DisciplineRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineRanking
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import java.io.InputStream

/**
 * Jasper implementation for discipline ranking.
 * 
 * @author nmaerchy
 * @version 1.0.0
 */
class JasperDisciplineRankingAPI: DisciplineRankingAPI {

    private val exportManager = ExportManager()

    /**
     * Creates the report for the discipline ranking.
     * 
     * @param data the data to use
     * 
     * @return the resulting report
     */
    override fun createReport(data: DisciplineRanking?): InputStream {

        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }

        val competitors: List<DisciplineRankingCompetitor> = data.competitors.map { 
            DisciplineRankingCompetitor(it.rank, it.prename, it.surname, it.clazz, it.result, it.points)
        }
        
        val parameters: Map<String, Any> = hashMapOf(
                "gender" to Utils.gender(data.isGender),
                "year" to data.year,
                "age" to data.age,
                "discipline" to data.discipline,
                "competitors" to JRBeanCollectionDataSource(competitors)
        )

        val report = StreamReport("discipline-ranking.jasper", parameters)
        return exportManager.export(report)
    }
}