package ch.schulealtendorf.alberta.disciplinegroupranking

import ch.schulealtendorf.alberta.Utils
import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.pra.api.DisciplineGroupRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineGroupRanking
import java.io.InputStream

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class JasperDisciplineGroupRankingAPI: DisciplineGroupRankingAPI {
    
    private val exportManager = ExportManager()
    
    override fun createReport(data: DisciplineGroupRanking?): InputStream {

        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }

//        val competitors: List<DisciplineGroupRankingComptitor> = data.competitors.map {
//            DisciplineGroupRankingComptitor()
//        }

        val parameters: Map<String, Any> = hashMapOf(
                "gender" to Utils.gender(data.isGender),
                "year" to data.year
                //"competitors" to JRBeanCollectionDataSource(competitors)
        )

        val report = StreamReport("discipline-ranking.jasper", parameters)
        return exportManager.export(report)
    }
}