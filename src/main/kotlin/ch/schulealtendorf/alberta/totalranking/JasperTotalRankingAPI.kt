package ch.schulealtendorf.alberta.totalranking

import ch.schulealtendorf.alberta.Utils
import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.alberta.toTotalRanking
import ch.schulealtendorf.pra.api.TotalRankingAPI
import ch.schulealtendorf.pra.pojo.TotalCompetitor
import ch.schulealtendorf.pra.pojo.TotalRanking
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import java.io.InputStream
import java.time.Year

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class JasperTotalRankingAPI: TotalRankingAPI {

    private val exportManager = ExportManager()
    
    override fun createReport(data: TotalRanking?): InputStream {

        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }

        val competitors: List<TotalRankingCompetitor> = data.competitors.toTotalRanking()

        val parameters: Map<String, Any> = hashMapOf(
                "age" to Year.now().value - data.year.value,
                "gender" to Utils.gender(data.isGender),
                "year" to data.year.value,
                "ballzielWurfDistance" to data.competitors.ballielwurfDistance(),
                "korbeinwurfDistance" to data.competitors.korbeinwurfDistance(),
                "competitors" to JRBeanCollectionDataSource(competitors))

        val report = StreamReport("total-ranking.jasper", parameters)
        return exportManager.export(report)
    }
    
    private fun List<TotalCompetitor>.ballielwurfDistance() = this.first().ballzielWurf.distance.orElse("")
    
    private fun List<TotalCompetitor>.korbeinwurfDistance() = this.first().korbeinwurf.distance.orElse("")
}