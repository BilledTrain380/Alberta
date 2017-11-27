package ch.schulealtendorf.alberta.jasper

data class EventSheetCompetitor @JvmOverloads constructor(
        val startnumber: Int,
        val prename: String,
        val surname: String,
        val distance: String? = null
)