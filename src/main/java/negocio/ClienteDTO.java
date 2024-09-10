/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 * La clase ClienteDTO es un objeto de transferencia de datos (DTO) que 
 * representa la información básica de un cliente, incluyendo su ID y nombre.
 * 
 * Esta clase se utiliza para transferir datos entre las diferentes capas de la 
 * aplicación sin exponer la implementación interna del objeto {@code Cliente}.
 * 
 * @author alex_
 */
public class ClienteDTO {
    
    /**
     * El ID del cliente.
     */
    public String ID;
    
    /**
     * El nombre del cliente.
     */
    public String nombre;

    /**
     * Constructor que inicializa el objeto ClienteDTO con un ID y nombre.
     * 
     * @param ID el ID del cliente.
     * @param nombre el nombre del cliente.
     */
    public ClienteDTO(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    /**
     * Devuelve el ID del cliente.
     * 
     * @return el ID del cliente.
     */
    public String getID() {
        return ID;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param ID el nuevo ID del cliente.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Devuelve el nombre del cliente.
     * 
     * @return el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre el nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
