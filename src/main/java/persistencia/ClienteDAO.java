/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * La clase ClienteDAO se encarga de manejar las operaciones relacionadas
 * con los objetos de tipo Cliente en una lista interna.
 * 
 * Proporciona métodos para agregar, actualizar, eliminar, buscar y listar clientes.
 * 
 * Implementa el patrón Singleton para asegurar que solo exista una instancia de esta clase.
 * 
 * @author alex_
 */
public class ClienteDAO {
    
    /**
     * Lista estática que almacena los clientes.
     */
    private static List<Cliente> clientes;
    
    /**
     * Instancia única de ClienteDAO (Singleton).
     */
    private static ClienteDAO instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private ClienteDAO() {
    }
    
    /**
     * Devuelve la instancia única de ClienteDAO.
     * Si la instancia aún no ha sido creada, se inicializa junto con la lista de clientes.
     * 
     * @return la instancia única de ClienteDAO.
     */
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
            clientes = new ArrayList<>();
        }
        return instance;
    }
    
    /**
     * Agrega un cliente a la lista.
     * 
     * @param cliente el cliente a agregar.
     */
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    /**
     * Devuelve una lista de todos los clientes.
     * 
     * @return una lista de objetos Cliente.
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Busca un cliente en la lista que coincida con el ID y nombre proporcionados.
     * 
     * @param cliente el cliente con el ID y nombre a buscar.
     * @return el cliente encontrado o null si no se encuentra.
     */
    public Cliente encontrarCliente(Cliente cliente) {
        Optional<Cliente> clienteConsultado = clientes.stream().filter(p -> p.getID().equalsIgnoreCase(cliente.getID())).filter(p -> p.getNombre().equalsIgnoreCase(cliente.getNombre())).findAny();

        if (clienteConsultado.isPresent()) {
            return clienteConsultado.get();

        }
        return null;
    }
    
    /**
     * Busca un cliente en la lista que coincida con el ID proporcionado.
     * 
     * @param id el ID del cliente a buscar.
     * @return el cliente encontrado o null si no se encuentra.
     */
    public Cliente encontrarClienteID(String id){
        
        for (Cliente c : clientes) {
            if (c.getID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        
        return null;
        
    }

    /**
     * Actualiza la información de un cliente existente en la lista.
     * 
     * @param clienteInfo el cliente existente a actualizar.
     * @param clienteNuevo el cliente con la nueva información.
     */
    public void actualizarCliente(Cliente clienteInfo, Cliente clienteNuevo) {
        Optional<Cliente> clienteConsultado = clientes.stream().filter(p -> p.getID().equalsIgnoreCase(clienteInfo.getID())).filter(p -> p.getNombre().equalsIgnoreCase(clienteInfo.getNombre())).findAny();

        if (clienteConsultado.isPresent()) {
            Cliente cliente = clienteConsultado.get();
            cliente.setID(clienteNuevo.getID());
            cliente.setNombre(clienteNuevo.getNombre());
        }
    }

    /**
     * Elimina un cliente de la lista si coincide con el ID y nombre proporcionados.
     * 
     * @param cliente el cliente a eliminar.
     */
    public void eliminarCliente(Cliente cliente) {
        Optional<Cliente> clienteConsultado = clientes.stream().filter(p -> p.getID().equalsIgnoreCase(cliente.getID())).filter(p -> p.getNombre().equalsIgnoreCase(cliente.getNombre())).findFirst();

        if (clienteConsultado.isPresent()) {
            clientes.remove(clienteConsultado.get());
        }
    }

    /**
     * Busca clientes en la lista que contengan parcialmente el ID y nombre proporcionados.
     * 
     * @param cliente el cliente con los atributos a buscar.
     * @return una lista de clientes que coincidan parcialmente con los criterios de búsqueda.
     */
    public List<Cliente> encontrarClientes(Cliente cliente) {
        return clientes.stream().filter(p -> p.getID().contains(cliente.getID())).filter(p -> p.getNombre().contains(cliente.getNombre())).toList();

    }
    
}
