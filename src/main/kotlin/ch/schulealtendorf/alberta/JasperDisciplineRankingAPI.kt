package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.pra.api.DisciplineRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineRanking
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

        throw UnsupportedOperationException("This method is not implemented yet.")
    }
}