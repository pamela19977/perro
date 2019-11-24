/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamela.bcrril.perro;

import javax.ejb.Stateless;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@Stateless
@Dependent
public class DaoPerro {

   @Inject
  private EntityManager em;
  public List<Perro> consulta() {
    return em.createQuery("SELECT c FROM Perro c ORDER BY c.nombre",
        Perro.class).getResultList();
  }
  public Perro busca(Integer id) {
    return em.find(Perro.class, id);
  }
  public void agrega(Perro modelo) {
    em.persist(modelo); // Agrega el modelo a la base de datos.
  }
  public void modifica(Perro modelo) {
    em.merge(modelo);// Guarda los cambios al modelo.
  }
  public void elimina(Perro modelo) {
    // Busca el modelo en base a su id.
    final Perro anterior = em.find(Perro.class, modelo.getId());
    // Si el resultado es null, el chismoso ya no está registrado.
    if (anterior != null) {
      // Pero si la referencia es diferente de null, hay que eliminar el objeto.
      em.remove(anterior);
    }
  }
}
