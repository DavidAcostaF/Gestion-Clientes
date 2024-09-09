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

/**
 *
 * @author alex_
 */
public class GenerarReportes {
    
    public void generarReporte(List<ClienteDTO> listaClientes) {
        // Crear un JRBeanCollectionDataSource con la lista de TramiteReporteDTO
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listaClientes);
        // Parámetros para el reporte
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CollectionBeanParam", itemsJRBean);

        // Configuración del JFileChooser para seleccionar la ubicación y nombre del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        // Mostrar el diálogo para guardar el archivo
        int userSelection = fileChooser.showSaveDialog(null);

        // Si el usuario selecciona guardar
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Asegurar que la extensión del archivo sea .pdf
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            // Cargar el diseño del reporte desde el archivo "Tramites.jrxml"
            try (InputStream input = new FileInputStream(new File("reporteClientes.jrxml"))) {
                JasperDesign jasperDesign = JRXmlLoader.load(input);
                // Compilar el reporte
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                // Llenar el reporte con los datos y parámetros proporcionados
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                // Exportar el reporte a un archivo PDF
                try (
                        OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                }

            } catch (Exception ex) {
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
        }
    }

}
