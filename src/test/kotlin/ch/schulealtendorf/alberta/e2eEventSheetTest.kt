package ch.schulealtendorf.alberta

import ch.schulealtendorf.alberta.eventsheet.JasperEventSheetAPI
import ch.schulealtendorf.pra.pojo.Competitor
import ch.schulealtendorf.pra.pojo.EventSheet
import org.junit.Test
import java.io.File
import java.io.InputStream

/**
 * @author nmaerchy
 * @version 1.0.0
 */
class EventSheetTest {

    @Test
    fun eventSheetApi() {
        
        val api = JasperEventSheetAPI()
        
        val data = eventSheetTestData("Ballzielwurf")
        
        val report = api.createReport(data)
        
        "event-sheet.pdf".create(report)
    }
    
    @Test
    fun eventSheetApiWithDistance() {

        val api = JasperEventSheetAPI()

        val data = eventSheetTestData("Schnelllauf", "60m")

        val report = api.createReport(data)

        "event-sheet-with-distance.pdf".create(report)
    }
    
    @Test
    fun eventSheetApiMultipleTrialsNoDistance() {

        val api = JasperEventSheetAPI()

        val data = eventSheetTestData("Seilspringen")

        val report = api.createReport(data)

        "event-sheet-multiple-trials-no-distance.pdf".create(report)
    }

    @Test
    fun eventSheetApiMultipleTrialsWithDistance() {

        val api = JasperEventSheetAPI()

        val data = eventSheetTestData("Seilspringen", "2.5m")

        val report = api.createReport(data)

        "event-sheet-multiple-trials-with-distance.pdf".create(report)
    }
    
    private fun eventSheetTestData(discipline: String, distance: String? = null): EventSheet {

        val competitor1 = Competitor()
        competitor1.startnumber = 1
        competitor1.prename = "Max"
        competitor1.surname = "Muster"
        if (distance != null) competitor1.setDistance(distance)

        val competitor2 = Competitor()
        competitor2.startnumber = 2
        competitor2.prename = "Sascha"
        competitor2.surname = "Suster"
        if (distance != null) competitor2.setDistance(distance)

        val data = EventSheet()
        data.discipline = discipline
        data.clazz = "2a"
        data.isGender = false
        data.competitors = listOf(
                competitor2,
                competitor1
        )
        
        return data
    }
    
    private fun String.create(stream: InputStream) {
        val file = File("e2e/$this")
        file.createNewFile()
        file.writeBytes(stream.readBytes())
    }
}