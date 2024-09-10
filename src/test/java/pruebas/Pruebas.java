package pruebas;

import java.util.List;
import negocio.ClienteDTO;
import negocio.ClientesBO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alex_
 */
public class Pruebas {
    
    private ClientesBO clientesBO;
    
    public Pruebas() {
        clientesBO = ClientesBO.getInstance();
        
    }
    
    /**
     * Test para agregar cliente al sistema.
     */
    @Test
    public void testAgregar() {
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
    
    @Test
    public void testListar() {
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
    
}
