package app.client.components.principalParqueadero;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import negocio.models.Area;

public class PrincipalParqueaderoComponent implements ActionListener, MouseListener {

    private PrincipalParqueaderoTemplate principalParqueaderoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    private JButton botonSeleccionado;

    public PrincipalParqueaderoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        principalParqueaderoTemplate = new PrincipalParqueaderoTemplate(this);
        cargarDatos(principalParqueaderoTemplate);
    }

    public PrincipalParqueaderoTemplate getPrincipalParqueaderoTemplate() {
        return principalParqueaderoTemplate;
    }

    public void cargarDatos(PrincipalParqueaderoTemplate principal) {
        String nombreParqueadero = " ";
        String tipoParqueadero = " ";
        String localidad = " ";
        String direccion = " ";
        String tipoSuelo = " ";
        int cantidadNiveles = 0;
        String factorZonal = " ";
        boolean estado = false;

        principal.setTitulo(nombreParqueadero);
        principal.setTipoParqueadero(tipoParqueadero);
        principal.setLocalidad(localidad);
        principal.setDireccion(direccion);
        principal.setTipoSuelo(tipoSuelo);
        principal.setCantidadNiveles(cantidadNiveles);
        principal.setFactorDemandaZonal(factorZonal);
        principal.setEstado(estado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void mostrarRegistrosTabla() {
    }
    public void agregarRegistro(Area area) {        
    }
}