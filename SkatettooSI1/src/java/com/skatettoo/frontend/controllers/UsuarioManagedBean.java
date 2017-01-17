/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.controllers;

import com.plandemjr.frontend.util.Managedbean;
import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author StivenDavid
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable, Managedbean<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuariofc;
    
    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public void registrarUsuario(){
        usuariofc.create(usuario);
    }
    
    public void eliminarUsuario(){
        usuariofc.remove(usuario);
    }
    
    public void modificarUsuario() {
        usuariofc.edit(usuario);
    }
    
    public String actualizarUsuario(Usuario u){
        usuario = u;
        return "";
    }
    
    public List<Usuario> listarUsuario(){
        return usuariofc.findAll();
    }

    @Override
    public Usuario getObject(Integer i) {
        return usuariofc.find(i);
    }
    
}
