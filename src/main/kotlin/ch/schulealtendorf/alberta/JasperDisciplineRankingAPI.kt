package ch.schulealtendorf.alberta

import ch.schulealtendorf.pra.api.DisciplineRankingAPI
import ch.schulealtendorf.pra.pojo.DisciplineRanking
import java.io.InputStream

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class JasperDisciplineRankingAPI: DisciplineRankingAPI {

    override fun createReport(disciplineRanking: DisciplineRanking?): InputStream {
        throw UnsupportedOperationException("This method is not implemented yet.") //To change body of created functions use File | Settings | File Templates.
    }
}