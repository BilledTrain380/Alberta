package ch.schulealtendorf.alberta.jasper

import net.sf.jasperreports.engine.JREmptyDataSource
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperPrint
import java.io.ByteArrayInputStream
import java.io.InputStream

/**
 * @author nmaerchy
 * @version 0.0.1
 */
class ExportManager {
    
    fun export(report: StreamReport): InputStream {
        
        val template = ExportManager::class.java.classLoader.getResourceAsStream(report.source) ?: throw IllegalArgumentException("Source not found on the classpath: source=${report.source}")

        val jasperPrint: JasperPrint = JasperFillManager.fillReport(template, report.parameters, JREmptyDataSource())
        val output = JasperExportManager.exportReportToPdf(jasperPrint)
        
        return ByteArrayInputStream(output)
    }
}