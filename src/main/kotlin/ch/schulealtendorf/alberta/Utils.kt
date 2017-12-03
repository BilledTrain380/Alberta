package ch.schulealtendorf.alberta

/**
 * @author nmaerchy
 * @version 0.0.1
 */

object Utils {
    
    fun gender(value: Boolean) = if (value) "Knaben" else "Mädchen"
    
    fun multipleTrials(value: String): Boolean {
        
        return when(value) {
            "Ballwurf" -> true
            "Seilspringen" -> true
            "Weitsprung" -> true
            else -> false
        }
    }
}