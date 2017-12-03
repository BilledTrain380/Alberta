package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.jasper.EventSheetCompetitor
import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.pra.api.EventSheetAPI
import ch.schulealtendorf.pra.pojo.Competitor
import ch.schulealtendorf.pra.pojo.EventSheet
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import java.io.InputStream

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class JasperEventSheetAPI: EventSheetAPI {

    private val exportManager = ExportManager()
    
    override fun createReport(data: EventSheet?): InputStream {
        
        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }
        
        val competitors: List<EventSheetCompetitor> = data.competitors.map { it with data.clazz }
        
        val parameters = hashMapOf<String, Any>(
                "discipline" to data.discipline,
                "gender" to if (data.isGender) "Knaben" else "Mädchen",
                "clazz" to data.clazz,
                "competitors" to JRBeanCollectionDataSource(competitors))
        
        val report = StreamReport("event-sheet.jasper", parameters)
        return exportManager.export(report)
    }
    
    private infix fun Competitor.with(clazz: String): EventSheetCompetitor {
        return EventSheetCompetitor(
                startnumber,
                prename,
                surname,
                clazz,
                distance
        )
    }
}