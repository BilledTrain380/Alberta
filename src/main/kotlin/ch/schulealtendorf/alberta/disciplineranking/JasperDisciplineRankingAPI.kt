package ch.schulealtendorf.alberta.disciplineranking

import ch.schulealtendorf.alberta.gender
import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.alberta.map
import ch.schulealtendorf.pra.api.DisciplineRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineRanking
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import java.io.InputStream
import java.time.Year

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

        val competitors: List<DisciplineRankingCompetitor> = data.competitors.map()

        val parameters: Map<String, Any> = hashMapOf<String, Any>(
                "discipline" to data.discipline,
                "gender" to gender(data.isGender),
                "age" to Year.now().value - data.year.value,
                "year" to data.year.value,
                "competitors" to JRBeanCollectionDataSource(competitors))

        val report = StreamReport("discipline-ranking.jasper", parameters)
        return exportManager.export(report)
    }
}