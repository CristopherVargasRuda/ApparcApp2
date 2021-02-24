package app.client.components.principalParqueadero;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.ParqueaderoLogueadoService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import negocio.models.Area;

public class PrincipalParqueaderoComponent implements ActionListener, MouseListener {

    private PrincipalParqueaderoTemplate principalParqueaderoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ParqueaderoLogueadoService parqueaderoService;

    private JButton botonSeleccionado;

    public PrincipalParqueaderoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        parqueaderoService = ParqueaderoLogueadoService.getService();
        principalParqueaderoTemplate = new PrincipalParqueaderoTemplate(this);
        cargarDatos(principalParqueaderoTemplate);
    }

    public PrincipalParqueaderoTemplate getPrincipalParqueaderoTemplate() {
        return principalParqueaderoTemplate;
    }

    public void cargarDatos(PrincipalParqueaderoTemplate principal) {
        String nombreParqueadero = parqueaderoService.getParqueadero().getNombre();
        String tipoParqueadero = " ";
        if(parqueaderoService.getParqueadero().isSubterraneo()){
            tipoParqueadero = "Subterraneo";
        }else{
            tipoParqueadero = "Elevación";
        }
        
        String localidad = parqueaderoService.getParqueadero().getLocalidad();
        String direccion = parqueaderoService.getParqueadero().getDireccion();
        String tipoSuelo = parqueaderoService.getParqueadero().getTipoSuelo();
        int cantidadNiveles = parqueaderoService.getParqueadero().getCantidadNiveles();
        float factorZonal = parqueaderoService.getParqueadero().getFactorDemandaZonal();
        boolean estado = parqueaderoService.getParqueadero().isEstado();

        principal.setTitulo(nombreParqueadero);
        principal.setTipoParqueadero(tipoParqueadero);
        principal.setLocalidad(localidad);
        principal.setDireccion(direccion);
        principal.setTipoSuelo(tipoSuelo);
        principal.setCantidadNiveles(cantidadNiveles);
        principal.setFactorDemandaZonal(factorZonal);
        principal.setEstado(estado);
        
        this.mostrarRegistrosTabla();
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
        for(Area ares : parqueaderoService.getParqueadero().getAreas()){
            this.agregarRegistro(ares);
        }
    }
    public void agregarRegistro(Area area) {       
        principalParqueaderoTemplate.getModelo().addRow(
                new Object[]{area.getIdArea(),area.getTipoVehiculo(),area.getCantidadCupos()}
        );
    }
}