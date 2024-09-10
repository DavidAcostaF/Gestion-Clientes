/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * La clase Cliente representa a un cliente dentro del sistema.
 * Un cliente tiene un identificador único y un nombre.
 * 
 * Se proporcionan métodos para obtener y modificar ambos atributos.
 * 
 * @author af_da
 */
public class Cliente {
    
    /**
     * Identificador único del cliente.
     */
    public String ID;
    
    /**
     * Nombre del cliente.
     */
    public String nombre;

    /**
     * Crea un nuevo cliente con el ID y nombre especificados.
     * 
     * @param ID    El identificador único del cliente.
     * @param nombre El nombre del cliente.
     */
    public Cliente(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    /**
     * Devuelve el identificador único del cliente.
     * 
     * @return El identificador único del cliente.
     */
    public String getID() {
        return ID;
    }

    /**
     * Establece el identificador único del cliente.
     * 
     * @param ID El nuevo identificador único del cliente.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Devuelve el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
