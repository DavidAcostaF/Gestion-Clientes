/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;
import persistencia.ClienteDAO;

/**
 * La clase ClientesBO es el objeto de negocio (Business Object) que se 
 * encarga de manejar las operaciones relacionadas con los clientes en el sistema.
 * 
 * Utiliza una instancia de ClienteDAO para interactuar con la capa de 
 * persistencia y realiza las operaciones de alta, baja, consulta y modificación de clientes.
 * 
 * Implementa el patrón Singleton para asegurar que solo exista una instancia de esta clase.
 * 
 * @author af_da
 */
public class ClientesBO {

    /**
     * Instancia única de ClientesBO (Singleton).
     */
    private static ClientesBO instance;
    
    /**
     * Instancia de ClienteDAO utilizada para realizar las operaciones sobre los clientes.
     */
    private static ClienteDAO clientesDAO;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private ClientesBO() {
    }

    /**
     * Devuelve la instancia única de ClientesBO.
     * Si la instancia aún no ha sido creada, se inicializa junto con la instancia de {@code ClienteDAO}.
     * 
     * @return la instancia única de ClientesBO.
     */
    public static ClientesBO getInstance() {
        if (instance == null) {
            instance = new ClientesBO();
            clientesDAO = ClienteDAO.getInstance();
//            llenarLista();
        }
        return instance;
    }

    /**
     * Agrega un nuevo cliente al sistema utilizando un objeto ClienteDTO.
     * 
     * @param cliente el objeto ClienteDTO que representa al cliente a agregar.
     */
    public void addCliente(ClienteDTO cliente) {
        this.clientesDAO.addCliente(new Cliente(cliente.getID(), cliente.getNombre()));
    }

    /**
     * Llena la lista de clientes con valores predefinidos.
     * (Actualmente comentado).
     */
    public void llenarLista() {
//        this.addCliente(new Cliente("00222", "David"));
//        this.addCliente(new Cliente("00223", "SI"));
    }

    /**
     * Obtiene la lista de todos los clientes del sistema.
     * Convierte los objetos Cliente en objetos ClienteDTO para su transferencia.
     * 
     * @return una lista de objetos ClienteDTO.
     */
    public List<ClienteDTO> getClientes() {
        List<Cliente> lc = clientesDAO.getClientes();
        List<ClienteDTO> clientes = new ArrayList<>();
        for (Cliente c : lc) {
            clientes.add(new ClienteDTO(c.getID(), c.getNombre()));
        }
        return clientes;
    }

    /**
     * Encuentra un cliente en el sistema basado en el ID y nombre proporcionados.
     * 
     * @param cliente el objeto ClienteDTO con el ID y nombre a buscar.
     * @return el cliente encontrado como un objeto ClienteDTO, o null si no se encuentra.
     */
    public ClienteDTO encontrarCliente(ClienteDTO cliente) {
        Cliente c = clientesDAO.encontrarCliente(new Cliente(cliente.getID(), cliente.getNombre()));
        if (c != null) {
            return new ClienteDTO(c.getID(), c.getNombre());
        } else {
            return null;
        }
    }

    /**
     * Encuentra un cliente en el sistema basado en su ID.
     * 
     * @param id el ID del cliente a buscar.
     * @return el cliente encontrado como un objeto ClienteDTO, o null si no se encuentra.
     */
    public ClienteDTO encontrarClienteID(String id) {
        Cliente co = clientesDAO.encontrarClienteID(id);

        if (co != null) {
            return new ClienteDTO(co.getID(), co.getNombre());
        }

        return null;

    }

    /**
     * Actualiza la información de un cliente existente en el sistema.
     * 
     * @param clienteInfo el cliente existente que se va a actualizar.
     * @param clienteNuevo el cliente con la nueva información.
     */
    public void actualizarCliente(ClienteDTO clienteInfo, ClienteDTO clienteNuevo) {
        Cliente ci = new Cliente(clienteInfo.getID(), clienteInfo.getNombre());
        Cliente cn = new Cliente(clienteNuevo.getID(), clienteNuevo.getNombre());
        clientesDAO.actualizarCliente(ci, cn);
    }

    /**
     * Elimina un cliente del sistema.
     * 
     * @param cliente el cliente a eliminar, representado por un objeto ClienteDTO.
     */
    public void eliminarCliente(ClienteDTO cliente) {
        Cliente c = new Cliente(cliente.getID(), cliente.getNombre());
        clientesDAO.eliminarCliente(c);
    }

    /**
     * Encuentra una lista de clientes que coincidan con el ID y nombre parcialmente.
     * 
     * @param cliente el cliente con los atributos de búsqueda.
     * @return una lista de clientes que coincidan con los criterios, como objetos ClienteDTO.
     */
    public List<ClienteDTO> encontrarClientes(ClienteDTO cliente) {
        List<Cliente> lc = clientesDAO.encontrarClientes(new Cliente(cliente.getID(), cliente.getNombre()));
        List<ClienteDTO> clientes = new ArrayList<>();
        for (Cliente c : lc) {
            clientes.add(new ClienteDTO(c.getID(), c.getNombre()));
        }
        return clientes;
    }
}
