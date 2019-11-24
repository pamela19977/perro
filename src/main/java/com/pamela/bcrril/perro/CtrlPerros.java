/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamela.bcrril.perro;

import com.pamela.web.Mensajes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CtrlPerros {

    @Inject
    private Mensajes mensajes;
    @Inject
    private DaoPerro dao;
    private List<Perro> instancias;

    @PostConstruct
    void init() {
        try {
            instancias = dao.consulta();
        } catch (Exception ex) {
            mensajes.procesa(ex);
        }
    }

    public List<Perro> getInstancias() {
        return instancias;
    }
}
