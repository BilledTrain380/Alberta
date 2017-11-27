package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.jasper.ExportManager
import ch.schulealtendorf.pra.api.EventSheetAPI
import ch.schulealtendorf.pra.pojo.EventSheet
import java.io.InputStream

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class JasperEventSheetAPI: EventSheetAPI {

    private val exportManager = ExportManager()
    
    override fun createReport(data: EventSheet?): InputStream {
        
        
        
        throw UnsupportedOperationException("This method is not implemented yet.") //To change body of created functions use File | Settings | File Templates.
    }
}