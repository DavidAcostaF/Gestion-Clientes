/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * La clase GenerarReportes se encarga de generar reportes de clientes
 * utilizando la biblioteca JasperReports.
 * 
 * Esta clase toma una lista de objetos {@code ClienteDTO} y genera un reporte
 * en base a dicha lista, utilizando un archivo de diseño JasperReports (.jrxml)
 * 
 * @author alex_
 */
public class GenerarReportes {

    /**
     * Genera un reporte de clientes basado en una lista de ClienteDTO.
     * 
     * Este método utiliza JasperReports para crear un reporte desde un archivo de
     * diseño (.jrxml), llenar el reporte con los datos de los clientes y mostrarlo
     * en el visor de JasperReports.
     * 
     * @param listaClientes una lista de objetos ClienteDTO que contiene los datos de los clientes a incluir en el reporte.
     * @return true si el reporte se generó correctamente, false si hubo algún error durante el proceso.
     */
    public boolean generarReporte(List<ClienteDTO> listaClientes) {
        // Crear un JRBeanCollectionDataSource con la lista de TramiteReporteDTO
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaClientes);
        // Parámetros para el reporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CollectionBeanParam", itemsJRBean);

        // Cargar el diseño del reporte desde el archivo "reporteClientes.jrxml"
        try (InputStream input = new FileInputStream(new File("reporteClientes.jrxml"))) {
            JasperDesign jasperDesign = JRXmlLoader.load(input);
            // Compilar el reporte
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // Llenar el reporte con los datos y parámetros proporcionados
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Mostrar el reporte en el visor
            JasperViewer.viewReport(jasperPrint, false);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
