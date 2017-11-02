package cl.bienestarpf.controlador;

import cl.bienestarpf.modelo.entidades.CargaEmpleado;
import cl.bienestarpf.controlador.util.JsfUtil;
import cl.bienestarpf.controlador.util.JsfUtil.PersistAction;
import cl.bienestarpf.modelo.sesiones.CargaEmpleadoFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cargaEmpleadoController")
@SessionScoped
public class CargaEmpleadoController implements Serializable {

    @EJB
    private cl.bienestarpf.modelo.sesiones.CargaEmpleadoFacade ejbFacade;
    private List<CargaEmpleado> items = null;
    private List<Object[]> departamentos;
    private CargaEmpleado selected;
    private int totalBonosEscolar;
    private int totalBonosNavidad;

    public CargaEmpleadoController() {
    }

    public CargaEmpleado getSelected() {
        return selected;
    }

    @PostConstruct
    public void init() {
        totalBonosEscolar = 0;
        totalBonosNavidad = 0;
        departamentos = ejbFacade.departamentos();
        for (int i = 0; i < departamentos.size(); i++) {
            totalBonosEscolar = Integer.parseInt(departamentos.get(i)[1].toString()) + totalBonosEscolar;
            totalBonosNavidad = Integer.parseInt(departamentos.get(i)[2].toString()) + totalBonosNavidad;
        }
        System.out.println("ESC "+ totalBonosEscolar);
        System.out.println("Nav "+ totalBonosNavidad);
    }
    
    public int getTotalBonosEscolar(){
        return totalBonosEscolar;
    }
    public int getTotalBonosNavidad(){
        return totalBonosNavidad;
    }
    
    public void setSelected(CargaEmpleado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CargaEmpleadoFacade getFacade() {
        return ejbFacade;
    }

    public CargaEmpleado prepareCreate() {
        selected = new CargaEmpleado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CargaEmpleadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CargaEmpleadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CargaEmpleadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CargaEmpleado> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public List<Object[]> getDepartamentos() {
        return departamentos = ejbFacade.departamentos();
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CargaEmpleado getCargaEmpleado(int id) {
        return getFacade().find(id);
    }

    public List<CargaEmpleado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CargaEmpleado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CargaEmpleado.class)
    public static class CargaEmpleadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CargaEmpleadoController controller = (CargaEmpleadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cargaEmpleadoController");
            return controller.getCargaEmpleado(getKey(value));
        }

        int getKey(String value) {
            int key;
            key = Integer.parseInt(value);
            return key;
        }

        String getStringKey(int value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CargaEmpleado) {
                CargaEmpleado o = (CargaEmpleado) object;
                return getStringKey(o.getIdEmpleado());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CargaEmpleado.class.getName()});
                return null;
            }
        }

    }

}
