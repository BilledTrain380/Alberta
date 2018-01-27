package ch.schulealtendorf.alberta.eventsheet

import ch.schulealtendorf.alberta.Utils
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
 * @version 2.0.0
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
        
        val competitors: List<EventSheetCompetitor> = data.competitors.map { it.map(data.clazz) }.sortedBy { it.startnumber }
        
        val parameters: Map<String, Any> = hashMapOf<String, Any>(
                "discipline" to data.discipline,
                "gender" to Utils.gender(data.isGender),
                "clazz" to data.clazz,
                "multipleTrials" to Utils.multipleTrials(data.discipline),
                "withDistance" to competitors.hasDistance(),
                "competitors" to JRBeanCollectionDataSource(competitors))
        
        val report = StreamReport("event-sheet.jasper", parameters)
        return exportManager.export(report)
    }

    private fun List<EventSheetCompetitor>.hasDistance() = this.any { it.distance.isNotEmpty() }
    
    private fun Competitor.map(clazz: String) = EventSheetCompetitor(startnumber, prename, surname, clazz, distance.orElse(""))
}