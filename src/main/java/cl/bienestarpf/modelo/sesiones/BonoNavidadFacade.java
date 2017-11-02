/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bienestarpf.modelo.sesiones;

import cl.bienestarpf.modelo.entidades.BonoNavidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Franco
 */
@Stateless
public class BonoNavidadFacade extends AbstractFacade<BonoNavidad> {

    @PersistenceContext(unitName = "cl_BienestarPF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BonoNavidadFacade() {
        super(BonoNavidad.class);
    }
    
}
