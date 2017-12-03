package ch.schulealtendorf.alberta

import ch.schulealtendorf.pra.pojo.Competitor
import ch.schulealtendorf.pra.pojo.EventSheet
import org.junit.Test
import java.io.File

/**
 * @author nmaerchy
 * @version 0.0.1
 */

class APITest {

    @Test
    fun eventSheetApi() {
        
        val api = JasperEventSheetAPI()
        
        val competitor1 = Competitor()
        competitor1.startnumber = 1
        competitor1.prename = "Max"
        competitor1.surname = "Muster"
        competitor1.distance = "60m"

        val competitor2 = Competitor()
        competitor2.startnumber = 2
        competitor2.prename = "Sascha"
        competitor2.surname = "Suster"
        competitor2.distance = "60m"
        
        val data = EventSheet()
        data.discipline = "Schnelllauf"
        data.clazz = "2a"
        data.isGender = true
        data.competitors = listOf(
                competitor1,
                competitor2
        )
        
        val report = api.createReport(data)
        
        val file = File("e2e/event-sheet.pdf")
        file.createNewFile()
        file.writeBytes(report.readBytes())
    }
}