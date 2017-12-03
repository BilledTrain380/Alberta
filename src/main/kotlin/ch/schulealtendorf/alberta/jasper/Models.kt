package ch.schulealtendorf.alberta.jasper

data class EventSheetCompetitor @JvmOverloads constructor(
        val startnumber: Int,
        val prename: String,
        val surname: String,
        val clazz: String,
        val distance: String? = null
)