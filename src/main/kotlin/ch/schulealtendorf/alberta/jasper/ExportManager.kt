package ch.schulealtendorf.alberta.jasper

import net.sf.jasperreports.engine.JREmptyDataSource
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperPrint
import java.io.ByteArrayInputStream
import java.io.InputStream

/**
 * Abstracts the jasper report api.
 * 
 * @author nmaerchy
 * @version 1.0.0
 */
class ExportManager {

    /**
     * Exports the given {@code report} with jasper reports.
     * 
     * @param report data to use in the report
     * 
     * @return the generated report
     * @throws IllegalArgumentException if the source of the report is not found
     */
    fun export(report: StreamReport): InputStream {
        
        val template = ExportManager::class.java.classLoader.getResourceAsStream(report.source) ?: throw IllegalArgumentException("Source not found on the classpath: source=${report.source}")

        val jasperPrint: JasperPrint = JasperFillManager.fillReport(template, report.parameters, JREmptyDataSource())
        val output = JasperExportManager.exportReportToPdf(jasperPrint)
        
        return ByteArrayInputStream(output)
    }
}