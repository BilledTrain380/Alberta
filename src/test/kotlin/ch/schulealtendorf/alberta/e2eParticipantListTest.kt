package ch.schulealtendorf.alberta

import ch.schulealtendorf.pra.pojo.Participant
import ch.schulealtendorf.pra.pojo.ParticipantList
import org.junit.Test

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class ParticipantListTest {

    @Test
    fun participantList() {
        
        val api = JasperParticipantListAPI()
        
        val data = participantTestData()
        
        api.createReport(data).write("participant-list.pdf")
    }
    
    private fun participantTestData(): ParticipantList {
        
        val participant1 = Participant()
        participant1.surname = "Muster"
        participant1.prename = "Max"
        participant1.isGender = true
        participant1.clazz = "6a"
        participant1.teacher = "Freddy"

        val participant2 = Participant()
        participant2.surname = "Suster"
        participant2.prename = "Susi"
        participant2.isGender = false
        participant2.clazz = "6b"
        participant2.teacher = "Hans"

        val data = ParticipantList()
        data.sport = "Brennball"
        data.participants = listOf(
                participant1,
                participant2
        )
        
        return data
    }
}