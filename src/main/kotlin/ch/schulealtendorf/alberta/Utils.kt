package ch.schulealtendorf.alberta

/**
 * Utils class to convert specific data.
 * 
 * @author nmaerchy
 * @version 1.0.0
 */
object Utils {

    /**
     * @return "Knaben" if the value is true, otherwise "Mädchen"
     */
    fun gender(value: Boolean) = if (value) "Knaben" else "Mädchen"

    /**
     * @return "m" if the value is true, otherwise "w"
     */
    fun genderShort(value: Boolean) = if (value) "m" else "w"

    /**
     * Checks if the given {@code value} is a discipline with multiple trials.
     * 
     * @param value the discipline to check
     * 
     * @return true if the discipline has multiple trials
     */
    fun multipleTrials(value: String): Boolean {
        
        return when(value) {
            "Ballwurf" -> true
            "Seilspringen" -> true
            "Weitsprung" -> true
            else -> false
        }
    }
}