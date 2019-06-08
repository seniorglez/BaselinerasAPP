/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baselinerasapp.Model;

/**
 *
 * @author EdoardoELH
 */
public class Users {
    ///Atributos///
    private String nombre_usuario;
    private String contraseña;
    private String tipo;
    private int referencia;
    ///Constructor///
    public Users(String nombre_usuario, String contraseña, String tipo, int referencia) {
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.referencia = referencia;
    }
    ///Metodos///

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }
    
}
