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

/**
 *
 * @author af_da
 */
public class ClientesBO {

    private static List<Cliente> clientes;
    private static ClientesBO instance;
    
    
    private ClientesBO() {
      }

    public static ClientesBO getInstance(){
         if (instance == null){
            instance = new ClientesBO();
            clientes = new ArrayList<>();
//            llenarLista();
        }
        return instance;
    }
    
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    
    public void llenarLista(){
        this.addCliente(new Cliente("00222","David"));
        this.addCliente(new Cliente("00223","SI"));
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    public Cliente encontrarCliente(Cliente cliente){
    Optional<Cliente> clienteConsultado = clientes.stream().filter(p->p.getID().equalsIgnoreCase(cliente.getID())).filter(p->p.getNombre().equalsIgnoreCase(cliente.getNombre())).findAny();
        
        if (clienteConsultado.isPresent()){
            return clienteConsultado.get();

        }
        return null;
    }
    public void actualizarCliente(Cliente clienteInfo,Cliente clienteNuevo){
        Optional<Cliente> clienteConsultado = clientes.stream().filter(p->p.getID().equalsIgnoreCase(clienteInfo.getID())).filter(p->p.getNombre().equalsIgnoreCase(clienteInfo.getNombre())).findAny();
        
        if (clienteConsultado.isPresent()){
            Cliente cliente = clienteConsultado.get();
            cliente.setID(clienteNuevo.getID());
            cliente.setNombre(clienteNuevo.getNombre());
        }
    }
    public void eliminarCliente(Cliente cliente){
            Optional<Cliente> clienteConsultado = clientes.stream().filter(p->p.getID().equalsIgnoreCase(cliente.getID())).filter(p->p.getNombre().equalsIgnoreCase(cliente.getNombre())).findFirst();
        
        if (clienteConsultado.isPresent()){
            clientes.remove(clienteConsultado.get());
        }
    }
    
    public List<Cliente> encontrarClientes(Cliente cliente){
        return clientes.stream().filter(p->p.getID().contains(cliente.getID())).filter(p->p.getNombre().contains(cliente.getNombre())).toList();

    }
}
