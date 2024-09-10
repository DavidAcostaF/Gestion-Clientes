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
 *
 * @author alex_
 */
public class GenerarReportes {

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
