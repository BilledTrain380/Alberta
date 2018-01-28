package ch.schulealtendorf.alberta.disciplinegroupranking

import ch.schulealtendorf.alberta.Utils
import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.alberta.mapToDisciplineGroupRanking
import ch.schulealtendorf.pra.api.DisciplineGroupRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineGroupRanking
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import java.io.InputStream
import java.time.Year

/**
 * Report api for discipline group.
 * 
 * @author nmaerchy
 * @version 1.0.0
 */
class JasperDisciplineGroupRankingAPI: DisciplineGroupRankingAPI {
    
    private val exportManager = ExportManager()
    
    override fun createReport(data: DisciplineGroupRanking?): InputStream {

        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }

        val competitors = data.competitors.mapToDisciplineGroupRanking()

        val parameters: Map<String, Any> = hashMapOf(
                "gender" to Utils.gender(data.isGender),
                "year" to data.year.value,
                "age" to Year.now().value - data.year.value,
                "competitors" to JRBeanCollectionDataSource(competitors)
        )

        val report = StreamReport("discipline-group-ranking.jasper", parameters)
        return exportManager.export(report)
    }
}