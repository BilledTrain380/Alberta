package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.alberta.jasper.Participant
import ch.schulealtendorf.alberta.jasper.StreamReport
import ch.schulealtendorf.pra.api.ParticipantListAPI
import ch.schulealtendorf.pra.pojo.ParticipantList
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import java.io.InputStream

/**
 * Jasper implementation for participant list.
 * 
 * @author nmaerchy
 * @version 1.0.0
 */
class JasperParticipantListAPI: ParticipantListAPI {

    private val exportManager = ExportManager()

    /**
     * Creates the report for the participant list
     * 
     * @param data the data to use
     * 
     * @return the generated report
     */
    override fun createReport(data: ParticipantList?): InputStream {

        if (data == null) {
            throw IllegalArgumentException("Parameters must not be null: data=null")
        }
        
        val participants: List<Participant> = data.participants.map { 
            Participant(it.prename, it.surname, if (it.isGender) "m" else "w", it.clazz, it.teacher)
        }
        
        val parameters: Map<String, Any> = hashMapOf(
                "sport" to data.sport,
                "participants" to JRBeanCollectionDataSource(participants)
        )
        
        val report = StreamReport("participant-list.jasper", parameters)
        return exportManager.export(report)
    }
}