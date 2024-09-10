package pruebas;

import java.util.List;
import negocio.ClienteDTO;
import negocio.ClientesBO;
import negocio.GenerarReportes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alex_
 */
public class Pruebas {
    
    private ClientesBO clientesBO;
    private GenerarReportes reporte;
    
    public Pruebas() {
        clientesBO = ClientesBO.getInstance();
        reporte = new GenerarReportes();
    }
    
    /**
     * Test para agregar cliente al sistema.
     */
    @Test
    public void testAgregar() {
        System.out.println("Test CP-001: Tests que se encarga de agregar un cliente nuevo correctamente.");
        // Crear cliente de prueba
        ClienteDTO nuevoCliente = new ClienteDTO("CL1", "Juan");

        // Agregar el cliente al sistema
        clientesBO.addCliente(nuevoCliente);

        // Recuperar el cliente agregado
        ClienteDTO clienteRecuperado = clientesBO.encontrarCliente(nuevoCliente);

        // Verificar que el cliente fue agregado correctamente
        assertNotNull(clienteRecuperado);
        assertEquals(nuevoCliente.getID(), clienteRecuperado.getID());
        assertEquals(nuevoCliente.getNombre(), clienteRecuperado.getNombre());
        
        clientesBO.eliminarCliente(nuevoCliente);
    }
    
    /**
     * Test para modificar al cliente en el sistema.
     */
    @Test
    public void testModificar() {
        System.out.println("Test CP-002: Tests que se encarga de modificar un cliente correctamente.");
        // Crear cliente de prueba
        ClienteDTO nuevoCliente = new ClienteDTO("CL1", "Juan");
        ClienteDTO nuevosDatos = new ClienteDTO("CL2", "Pedro");

        // Agregar el cliente al sistema
        clientesBO.addCliente(nuevoCliente);

        // modificar al cliente
        clientesBO.actualizarCliente(nuevoCliente, nuevosDatos);
        
        ClienteDTO clienteRecuperado = clientesBO.encontrarCliente(nuevosDatos);

        // Verificar que el cliente fue agregado correctamente
        assertNotNull(clienteRecuperado);
        assertEquals(nuevosDatos.getID(), clienteRecuperado.getID());
        assertEquals(nuevosDatos.getNombre(), clienteRecuperado.getNombre());
    }

    /**
     * Test para eliminar al cliente en el sistema.
     */
    @Test
    public void testEliminar() {
        System.out.println("Test CP-003: Tests que se encarga de eliminar un cliente correctamente.");

        // Crear cliente de prueba
        ClienteDTO nuevoCliente = new ClienteDTO("CL4", "Luis");

        // Agregar el cliente al sistema
        clientesBO.addCliente(nuevoCliente);
        
        // Eliminar el cliente del sistema
        clientesBO.eliminarCliente(nuevoCliente);

        // Recuperar el cliente agregado
        ClienteDTO clienteRecuperado = clientesBO.encontrarCliente(nuevoCliente);

        // Verificar que el cliente fue agregado correctamente
        assertNull(clienteRecuperado);
        
    }
    
    /**
     * Test para obtener la lista de clientes en el sistema.
     */
    @Test
    public void testListar() {
        System.out.println("Test CP-004: Tests que se encarga de listar los clientes correctamente.");

        // Crear cliente de prueba
        ClienteDTO nuevoCliente = new ClienteDTO("CL8", "Juan");

        // Agregar el cliente al sistema
        clientesBO.addCliente(nuevoCliente);

        // Recuperar lista de clientes
        List<ClienteDTO> clientes = clientesBO.getClientes();

        // Verificar que la lista se recupero
        assertNotNull(clientes);

        // Verificar que la lista no está vacía
        assertFalse(clientes.isEmpty());

    }
    
    /**
     * Test para obtener una lista por filtros en el sistema.
     */
    @Test
    public void testFiltro() {
        System.out.println("Test CP-005: Tests que se encarga de verificar que los filtros funcionan correctamente.");

        // Crear cliente de prueba
        ClienteDTO nuevoCliente = new ClienteDTO("CL9", "Juan");
        ClienteDTO clienteNoExistente = new ClienteDTO("CL10", "Ana");

        // Agregar el cliente al sistema
        clientesBO.addCliente(nuevoCliente);

        // Recuperar lista de clientes con un parametro especifico
        List<ClienteDTO> clientes = clientesBO.encontrarClientes(clienteNoExistente);

        // Verificar que la lista se recupero esta vacia
        assertTrue(clientes.isEmpty());

        // Recuperar clientes existentes
        clientes = clientesBO.encontrarClientes(nuevoCliente);
        
        // Verificar que la lista no está vacía
        assertFalse(clientes.isEmpty());

    }
    
    /**
     * Test para obtener una lista por filtros en el sistema.
     */
    @Test
    public void testReporte() {
        System.out.println("Test CP-006: Tests que se encarga de verificar que se puede generar un reporte correctamente.");

        // Verificar que el reporte se puede crear
        assertTrue(reporte.generarReporte(clientesBO.getClientes()));

    }
    
}
