package app.client.components.registrarIngreso;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.ParqueaderoLogueadoService;
import negocio.logic.ControlPlaca;
import negocio.models.Area;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
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
    private ControlPlaca controlPlaca;
    private Area area;

    public RegistrarIngresoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        parqueaderoLogueadoService = ParqueaderoLogueadoService.getService();
        registrarIngresoTemplate = new RegistrarIngresoTemplate(this);
        controlPlaca = new ControlPlaca();
    }

    public RegistrarIngresoTemplate getRegistrarIngresoTemplate() {
        return registrarIngresoTemplate;
    }

    public void verificarExistenciaTipo(String tipo){
        Boolean existe = false;
        for(Area area: parqueaderoLogueadoService.getParqueadero().getAreas()) {
            if(area.equals(tipo)){
                existe = true;
                break;
            }
        }

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

    public void validacionPlaca(){
        String placa = "";
        String tipoVehiculo = "";
        String tipoSelected = "Tipo";
        try {
            placa = registrarIngresoTemplate.gettPlaca().getText();
            if (placa.equals("") || placa.equals("Placa del vehículo")){
                JOptionPane.showMessageDialog(null, "Ingrese una placa válida");
            }else{
                hacerVisible();
                if(controlPlaca.verificarExistencia(placa)){
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
            verificarExistenciaTipo(((String) registrarIngresoTemplate.getCbTipo().getSelectedItem()));
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
                Area area = new Area();
                switch(selected){
                    case "Tipo":
                        area = null;
                        break;
                    case "Automovil":
                        area = parqueaderoLogueadoService.getParqueadero().getAreas().get(0);
                        break;
                    case "Campero":
                        area = parqueaderoLogueadoService.getParqueadero().getAreas().get(2);
                        break;
                    case "Camioneta":
                        area = parqueaderoLogueadoService.getParqueadero().getAreas().get(3);
                        break;
                    case "Vehiculo Pesado":
                        area = parqueaderoLogueadoService.getParqueadero().getAreas().get(1);
                        break;
                    case "Motocicleta":
                        area = parqueaderoLogueadoService.getParqueadero().getAreas().get(4);
                        break;
                    case "Bicicleta":
                        area = parqueaderoLogueadoService.getParqueadero().getAreas().get(5);
                        break;
                    default:
                        break;
                }
                if (area!=null){
                    for (Espacio espacio : area.getEspacios()){
                        if (espacio.isEstado()){
                            System.out.println(espacio.getIdEspacio());
                            System.out.println(espacio.isEstado());
                            registrarIngresoTemplate.gettCupo().setText(String.valueOf(espacio.getIdEspacio()));
                            break;
                        }
                    }
                    System.out.println(area.getTipoVehiculo());
                    System.out.println(area.getCantidadCupos());
                    System.out.println(area.getCantidadCuposDisponibles());
                }
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
