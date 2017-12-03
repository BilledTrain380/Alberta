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
 * Jasper implementation for event sheet api.
 * 
 * @author nmaerchy
 * @version 1.0.0
 */
class JasperEventSheetAPI: EventSheetAPI {

    private val exportManager = ExportManager()

    /**
     * Creates the report for event sheets.
     * 
     * @param data the event sheet data to use
     * 
     * @return the created report
     */
    override fun createReport(data: EventSheet?): InputStream {
        
        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }
        
        val competitors: List<EventSheetCompetitor> = data.competitors.map { it with data.clazz }
        
        val parameters = hashMapOf<String, Any>(
                "discipline" to data.discipline,
                "gender" to Utils.gender(data.isGender),
                "clazz" to data.clazz,
                "multipleTrials" to Utils.multipleTrials(data.discipline),
                "competitors" to JRBeanCollectionDataSource(competitors))
        
        val report = StreamReport("event-sheet.jasper", parameters)
        return exportManager.export(report)
    }

    /**
     * Creates a {@link EventSheetCompetitor} with the given {@code clazz}.
     * 
     * @param clazz the clazz to use
     * 
     * @return the resulting competitor
     */
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