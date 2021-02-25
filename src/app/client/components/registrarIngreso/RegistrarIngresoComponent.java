package app.client.components.registrarIngreso;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.ParqueaderoLogueadoService;
import negocio.logic.ControlPlaca;
import negocio.logic.ControlRegistrarIngreso;
import negocio.models.*;
import util.CaException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.event.*;

public class RegistrarIngresoComponent implements ActionListener, MouseListener, FocusListener, ItemListener, KeyListener {

    private ParqueaderoLogueadoService parqueaderoLogueadoService;
    private RegistrarIngresoTemplate registrarIngresoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private JTextField textField;
    private JComboBox jComboBox;
    private ControlRegistrarIngreso controlRegistrarIngreso;
    private ControlPlaca controlPlaca;
    private Vehiculo vehiculo;
    private Servicio servicio;
    private Area area;
    private Espacio espacio;
    private boolean bContrato;
    private boolean existencia;
    private int count = 6;
    private String placa = "";
    private String tipoVehiculo = "";
    private String tipoSelected = "Tipo";

    public RegistrarIngresoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        parqueaderoLogueadoService = ParqueaderoLogueadoService.getService();
        registrarIngresoTemplate = new RegistrarIngresoTemplate(this);
        controlRegistrarIngreso = new ControlRegistrarIngreso();
        controlPlaca = new ControlPlaca();
        bContrato = false;
        existencia = false;
        servicio = new Servicio();
        area = new Area();
        espacio = new Espacio();
    }

    public RegistrarIngresoTemplate getRegistrarIngresoTemplate() {
        return registrarIngresoTemplate;
    }

    public boolean verificarExistenciaTipo(String tipo){
        for(Area area : parqueaderoLogueadoService.getParqueadero().getAreas()){
            if(tipo.equals(area.getTipoVehiculo().toLowerCase())){
                return true;
            }
        }
        JOptionPane.showMessageDialog(null,"No hay area para ese tipo de vehiculo");
        return false;
    }

    public void hacerVisible(){
        registrarIngresoTemplate.getlTipo().setVisible(true);
        registrarIngresoTemplate.getCbTipo().setEnabled(true);
        registrarIngresoTemplate.getCbTipo().setVisible(true);
        registrarIngresoTemplate.getlHoraIng().setVisible(true);
        registrarIngresoTemplate.getlHoraIng2().setVisible(true);
        registrarIngresoTemplate.getlFechaIng().setVisible(true);
        registrarIngresoTemplate.getlFechaIng2().setVisible(true);
        registrarIngresoTemplate.getlCupo().setVisible(true);
        registrarIngresoTemplate.gettCupo().setVisible(true);
        registrarIngresoTemplate.getBtnRegistrar().setVisible(true);
        registrarIngresoTemplate.getBtnLimpiar().setVisible(true);
    }

    public void hacerInvisible(){
        registrarIngresoTemplate.getlTipo().setVisible(false);
        registrarIngresoTemplate.getCbTipo().setEnabled(false);
        registrarIngresoTemplate.getCbTipo().setVisible(false);
        registrarIngresoTemplate.getlHoraIng().setVisible(false);
        registrarIngresoTemplate.getlHoraIng2().setVisible(false);
        registrarIngresoTemplate.getlFechaIng().setVisible(false);
        registrarIngresoTemplate.getlFechaIng2().setVisible(false);
        registrarIngresoTemplate.getlCupo().setVisible(false);
        registrarIngresoTemplate.gettCupo().setVisible(false);
        registrarIngresoTemplate.getBtnRegistrar().setVisible(false);
        registrarIngresoTemplate.getBtnLimpiar().setVisible(false);
    }

    public void limpiar(){
        registrarIngresoTemplate.gettPlaca().setText("");
        registrarIngresoTemplate.gettCupo().setText("");
        registrarIngresoTemplate.getCbTipo().setSelectedIndex(0);
    }

    public void habilitar(){
        registrarIngresoTemplate.gettPlaca().setEnabled(true);
        registrarIngresoTemplate.getBtnBuscar().setEnabled(true);
        registrarIngresoTemplate.getCbTipo().setEnabled(true);
    }
    public void validacionExistencia(){
        if(!existencia){
            try {
                controlRegistrarIngreso.registrarVehiculo(servicio.getPlaca(), area.getTipoVehiculo());
                JOptionPane.showMessageDialog(null,"Se ha ingresado el vehiculo con exito.");
            } catch (CaException e) {
                JOptionPane.showMessageDialog(null,"No se han guardado los datos.");
                e.printStackTrace();
            }
        }
    }
    public void validacionContrato(){
        if (bContrato){
            try{
                controlRegistrarIngreso.registrarEspacio(espacio);
                controlRegistrarIngreso.registrarAreas(area);
                controlRegistrarIngreso.registrarServicio(servicio, parqueaderoLogueadoService.getParqueadero());
                JOptionPane.showMessageDialog(null,"Se ha asignado cupo con exito.");
            } catch (CaException e) {
                JOptionPane.showMessageDialog(null,"No se asignó cupo.");
                e.printStackTrace();
            }
        }else{
            if (area.getCantidadCuposDisponibles()>parqueaderoLogueadoService.getParqueadero().getContratos().size()){
                try{
                    controlRegistrarIngreso.registrarEspacio(espacio);
                    controlRegistrarIngreso.registrarAreas(area);
                    controlRegistrarIngreso.registrarServicio(servicio, parqueaderoLogueadoService.getParqueadero());
                    JOptionPane.showMessageDialog(null,"Se ha asignado cupo con exito.");
                } catch (CaException e) {
                    JOptionPane.showMessageDialog(null,"No se asignó cupo.");
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null,"No hay cupos para personas sin contrato");
            }
        }
    }
    public void validacionPlaca(){
        try {
            placa = registrarIngresoTemplate.gettPlaca().getText();
            if (placa.equals("") || placa.equals("Placa del vehículo")){
                JOptionPane.showMessageDialog(null, "Ingrese una placa válida");
            }else{
                hacerVisible();
                if (controlPlaca.verificarContrato(parqueaderoLogueadoService.getParqueadero().getNombre(),placa)){
                    bContrato = true;
                }
                if(controlPlaca.verificarExistencia(placa)){
                    existencia = true;
                    controlPlaca.modificarTipoVehiculo(placa);
                    tipoVehiculo = controlPlaca.getVehiculo().getTipoVehiculo();
                    for( int i=0 ; i<registrarIngresoTemplate.getCbTipo().getItemCount(); i++) {
                        registrarIngresoTemplate.getCbTipo().setSelectedIndex(i);
                        tipoSelected = ((String) registrarIngresoTemplate.getCbTipo().getSelectedItem());
                        if (tipoSelected.equals(tipoVehiculo)) {
                            registrarIngresoTemplate.getCbTipo().setEnabled(false);
                            break;
                        }
                    }
                }else{
                    registrarIngresoTemplate.getCbTipo().setEnabled(true);
                    registrarIngresoTemplate.getCbTipo().setSelectedIndex(0);
                }
                registrarIngresoTemplate.gettPlaca().setEnabled(false);
                registrarIngresoTemplate.getBtnBuscar().setEnabled(false);
            }
        } catch (CaException caException) {
            caException.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Buscar")){
            validacionPlaca();
        }
        if (e.getActionCommand().equals("Registrar")){
            validacionExistencia();
            validacionContrato();


        }
        if (e.getActionCommand().equals("Limpiar")){
            hacerInvisible();
            limpiar();
            habilitar();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(registrarIngresoTemplate.getsRecursos().getBordeSeleccion());
            if (e.getSource() == registrarIngresoTemplate.gettPlaca() && textField.getText().equals("Placa del vehículo")){
                registrarIngresoTemplate.gettPlaca().setText("");
            }
            if (e.getSource() == registrarIngresoTemplate.gettCupo() && textField.getText().equals("Cupo")){
                registrarIngresoTemplate.gettCupo().setText("");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JComboBox){
            jComboBox = ((JComboBox) e.getSource());
            if(e.getStateChange() == ItemEvent.SELECTED){
                String selected = (String) e.getItem();
                if(!selected.equals("Tipo")){
                    if(!verificarExistenciaTipo(selected.toLowerCase())){
                        registrarIngresoTemplate.gettCupo().setText("");
                        registrarIngresoTemplate.getCbTipo().setSelectedIndex(0);
                    }
                }
                for(Area ar: parqueaderoLogueadoService.getParqueadero().getAreas()){
                    if (selected.equals(ar.getTipoVehiculo())){
                        area = ar;
                    }
                }
                if (area!=null){
                    servicio.setCodigoArea(area.getIdArea());
                    for (Espacio espacio : area.getEspacios()){
                        if (espacio.isEstado()){
                            servicio.setCodigoEspacio(espacio.getIdEspacio());
                            registrarIngresoTemplate.gettCupo().setText(String.valueOf(espacio.getIdEspacio()));
                            break;
                        }
                    }
                    try {
                        count = controlRegistrarIngreso.ajustarCount();
                    } catch (CaException caException) {
                        caException.printStackTrace();
                    }
                    espacio.setIdEspacio(servicio.getCodigoEspacio());
                    servicio.setIdServicio(count+1);
                    servicio.setFechaIngreso(registrarIngresoTemplate.getlFechaIng2().getText());
                    servicio.setHoraIngreso(registrarIngresoTemplate.getlHoraIng2().getText());
                    servicio.setPlaca(placa);
                    servicio.setCodigoParqueadero(parqueaderoLogueadoService.getParqueadero().getCodigo());
                }else{
                    registrarIngresoTemplate.gettCupo().setText("");
                }
                registrarIngresoTemplate.gettCupo().setEnabled(false);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(registrarIngresoTemplate.gettPlaca().getText().length()==9){
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        registrarIngresoTemplate.gettPlaca().setText(registrarIngresoTemplate.gettPlaca().getText().toUpperCase());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

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
}