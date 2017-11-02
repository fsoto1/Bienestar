/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bienestarpf.modelo.sesiones;

import cl.bienestarpf.modelo.entidades.CargaEmpleado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Franco
 */
@Stateless
public class CargaEmpleadoFacade extends AbstractFacade<CargaEmpleado> {

    @PersistenceContext(unitName = "cl_BienestarPF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargaEmpleadoFacade() {
        super(CargaEmpleado.class);
    }

    public List<Object[]> departamentos() {
        try{
            TypedQuery<Object[]> query = em.createNamedQuery("CargaEmpleado.departamentos", Object[].class);
            List<Object[]> departamentos = query.getResultList();
            for (Object[] departamento : departamentos) {
                System.out.println("departamento: " + departamento[0] + ", bonoEscolar: " + departamento[1] + ", bonoNavidad: " + departamento[2]);
            }
            return departamentos;
        } catch (NoResultException e) {
            return null;
        }
    }
}
