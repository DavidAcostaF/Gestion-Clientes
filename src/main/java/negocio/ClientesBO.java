/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import persistencia.ClienteDAO;

/**
 *
 * @author af_da
 */
public class ClientesBO {

    private static List<Cliente> clientes;
    private static ClientesBO instance;
    private static ClienteDAO clientesDAO;

    private ClientesBO() {
    }

    public static ClientesBO getInstance() {
        if (instance == null) {
            instance = new ClientesBO();
            clientes = new ArrayList<>();
            clientesDAO = ClienteDAO.getInstance();
//            llenarLista();
        }
        return instance;
    }

    public void addCliente(ClienteDTO cliente) {
        this.clientesDAO.addCliente(new Cliente(cliente.getID(),cliente.getNombre()));
    }

    public void llenarLista() {
//        this.addCliente(new Cliente("00222", "David"));
//        this.addCliente(new Cliente("00223", "SI"));
    }

    public List<ClienteDTO> getClientes() {
        List<Cliente> lc = clientesDAO.getClientes();
        List<ClienteDTO> clientes = new ArrayList<>();
        for (Cliente c : lc) {
            clientes.add(new ClienteDTO(c.getID(),c.getNombre()));
        }
        return clientes;
    }

    public ClienteDTO encontrarCliente(ClienteDTO cliente) {
        Cliente c = clientesDAO.encontrarCliente(new Cliente(cliente.getID(), cliente.getNombre()));
        if (c != null) {
            return new ClienteDTO(c.getID(), c.getNombre());
        } else {
            return null;
        }
    }

    public void actualizarCliente(ClienteDTO clienteInfo, ClienteDTO clienteNuevo) {
        Cliente ci = new Cliente(clienteInfo.getID(),clienteInfo.getNombre());
        Cliente cn = new Cliente(clienteNuevo.getID(),clienteNuevo.getNombre());
        clientesDAO.actualizarCliente(ci, cn);
    }

    public void eliminarCliente(ClienteDTO cliente) {
        Cliente c = new Cliente(cliente.getID(),cliente.getNombre());
        clientesDAO.eliminarCliente(c);
    }

    public List<ClienteDTO> encontrarClientes(ClienteDTO cliente) {
        List<Cliente> lc = clientesDAO.encontrarClientes(new Cliente(cliente.getID(),cliente.getNombre()));
        List<ClienteDTO> clientes = new ArrayList<>();
        for (Cliente c : lc) {
            clientes.add(new ClienteDTO(c.getID(),c.getNombre()));
        }
        return clientes;
    }
}
