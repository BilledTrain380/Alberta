package ch.schulealtendorf.alberta

import java.io.File
import java.io.InputStream

fun InputStream.write(fileName: String) {
    val file = File("e2e/$fileName")
    file.createNewFile()
    file.writeBytes(this.readBytes())
}