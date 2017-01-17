/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.controllers;

import com.plandemjr.frontend.util.Managedbean;
import com.skatettoo.backend.persistence.entities.Disenio;
import com.skatettoo.backend.persistence.facade.DisenioFacadeLocal;
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
@Named(value = "disenioManagedBean")
@SessionScoped
public class DisenioManagedBean implements Serializable, Managedbean <Disenio> {

    private Disenio disenio;
    @EJB
    private DisenioFacadeLocal diseniofc;
    
    public DisenioManagedBean() {
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }
    
    @PostConstruct
    public void init(){
        disenio = new Disenio();
    }
    
    public void registrarDisenio(){
        diseniofc.create(disenio);
    }
    
    public void eliminarDisenio(){
        diseniofc.remove(disenio);
    }
    
    public void editarDisenio(){
        diseniofc.edit(disenio);
    }
    
    public String actualizarDisenio(Disenio d){
        disenio = d;
        return "";
    }
    
    public String verDisenio(Disenio d){
        disenio = d;
        return "";
    }
    
    public List<Disenio> Disenio(){
        return diseniofc.findAll();
    }

    @Override
    public Disenio getObject(Integer i) {
        return diseniofc.find(i);
    }
    
}
