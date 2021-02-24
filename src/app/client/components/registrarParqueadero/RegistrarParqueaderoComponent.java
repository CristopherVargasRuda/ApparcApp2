package app.client.components.registrarParqueadero;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import negocio.models.Parqueadero;
import negocio.models.Area;
import negocio.models.Espacio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.logic.ControlRegistrarParqueadero;
import negocio.models.Tarifa;
import util.CaException;

public class RegistrarParqueaderoComponent implements ActionListener,
        MouseListener, FocusListener {

    private RegistrarParqueaderoTemplate registrarParqueaderoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ControlRegistrarParqueadero controlRegistrarParqueadero;
    private ArrayList<Area> areas;
    private ArrayList<Espacio> espacios;
    private ArrayList<Tarifa> tarifas;
    private Parqueadero parqueadero;
    private Area area;
    private Espacio espacio;
    private Tarifa tarifa;
    private int cantidad, contadorAreas, contadorPrecios;
    private JTextField textField;
    private JButton boton;
    private JComboBox comboBox;
    private String seleccionComboBox;

    public RegistrarParqueaderoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        areas = new ArrayList<Area>();
        tarifas = new ArrayList<Tarifa>();
        controlRegistrarParqueadero = new ControlRegistrarParqueadero();
        parqueadero = new Parqueadero();
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        registrarParqueaderoTemplate = new RegistrarParqueaderoTemplate(this);
    }

    public RegistrarParqueaderoTemplate getRegistrarParqueaderoTemplate() {
        return registrarParqueaderoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarParqueaderoTemplate.getbRegistrarParqueadero()) {
            if (cargarDatos()) {
               
                
                
                try {

                    
                    
                    
                    controlRegistrarParqueadero.registrarParqueadero(parqueadero);
                    JOptionPane.showMessageDialog(null, "Registro Exitoso", "Advertencia", 1);
                } catch (CaException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Registro Fallido:\n" + ex, "Advertencia", 1);
                }
            }
        }
        if (e.getSource() == registrarParqueaderoTemplate.getbLimpiar()) {
            limpiarDatos();
        }
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
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    registrarParqueaderoTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            if (boton == registrarParqueaderoTemplate.getbRegistrarParqueadero()) {
                boton.setBackground(
                        registrarParqueaderoTemplate.getsRecursos().getColorNaranja()
                );
            } else {
                boton.setBackground(
                        registrarParqueaderoTemplate.getsRecursos().getColorGris()
                );
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeSeleccion()
            );
            if (e.getSource() == registrarParqueaderoTemplate.gettCodigoParqueadero()
                    && textField.getText().equals("Código del parqueadero")) {
                registrarParqueaderoTemplate.gettCodigoParqueadero().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.gettNombreParqueadero()
                    && textField.getText().equals("Nombre del parqueadero")) {
                registrarParqueaderoTemplate.gettNombreParqueadero().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.gettClaveParqueadero()
                    && textField.getText().equals("Contraseña del parqueadero")) {
                registrarParqueaderoTemplate.gettClaveParqueadero().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.gettDireccion()
                    && textField.getText().equals("Dirección")) {
                registrarParqueaderoTemplate.gettDireccion().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnNiveles()
                    && textField.getText().equals("Número de Niveles")) {
                registrarParqueaderoTemplate.getTnNiveles().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnAutomoviles()
                    && textField.getText().equals("Número de cupos de Automóviles")) {
                registrarParqueaderoTemplate.getTnAutomoviles().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnCamperos()
                    && textField.getText().equals("Número de cupos de Camperos")) {
                registrarParqueaderoTemplate.getTnCamperos().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnCamionetas()
                    && textField.getText().equals("Número de cupos de Camionetas")) {
                registrarParqueaderoTemplate.getTnCamionetas().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVehiculosPesados()
                    && textField.getText().equals("Número de cupos de Vehículos Pesados")) {
                registrarParqueaderoTemplate.getTnVehiculosPesados().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnMotocicletas()
                    && textField.getText().equals("Número de cupos de Motocicletas")) {
                registrarParqueaderoTemplate.getTnMotocicletas().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnBicicletas()
                    && textField.getText().equals("Número de cupos de Bicicletas")) {
                registrarParqueaderoTemplate.getTnBicicletas().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMAutomoviles()
                    && textField.getText().equals("Valor Máximo Por Minuto de Automóviles")) {
                registrarParqueaderoTemplate.getTnVMPMAutomoviles().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMCamperos()
                    && textField.getText().equals("Valor Máximo Por Minuto de Camperos")) {
                registrarParqueaderoTemplate.getTnVMPMCamperos().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMCamionetas()
                    && textField.getText().equals("Valor Máximo Por Minuto de Camionetas")) {
                registrarParqueaderoTemplate.getTnVMPMCamionetas().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMVehiculosPesados()
                    && textField.getText().equals("Valor Máximo Por Minuto de Vehículos Pesados")) {
                registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMMotocicletas()
                    && textField.getText().equals("Valor Máximo Por Minuto de Motocicletas")) {
                registrarParqueaderoTemplate.getTnVMPMMotocicletas().setText("");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMBicicletas()
                    && textField.getText().equals("Valor Máximo Por Minuto de Bicicletas")) {
                registrarParqueaderoTemplate.getTnVMPMBicicletas().setText("");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    registrarParqueaderoTemplate.getsRecursos().getColorSeleccion(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeNaranja()
            );
            if (e.getSource() == registrarParqueaderoTemplate.gettCodigoParqueadero()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.gettCodigoParqueadero().setText("Código del parqueadero");
            }
            if (e.getSource() == registrarParqueaderoTemplate.gettNombreParqueadero()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.gettNombreParqueadero().setText("Nombre del parqueadero");
            }
            if (e.getSource() == registrarParqueaderoTemplate.gettClaveParqueadero()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.gettClaveParqueadero().setText("Contraseña del parqueadero");
            }
            if (e.getSource() == registrarParqueaderoTemplate.gettDireccion()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.gettDireccion().setText("Dirección");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnNiveles()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnNiveles().setText("Número de Niveles");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnAutomoviles()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnAutomoviles().setText("Número de cupos de Automóviles");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnCamperos()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnCamperos().setText("Número de cupos de Camperos");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnCamionetas()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnCamionetas().setText("Número de cupos de Camionetas");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVehiculosPesados()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVehiculosPesados().setText("Número de cupos de Vehículos Pesados");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnMotocicletas()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnMotocicletas().setText("Número de cupos de Motocicletas");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnBicicletas()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnBicicletas().setText("Número de cupos de Bicicletas");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMAutomoviles()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVMPMAutomoviles().setText("Valor Máximo Por Minuto de Automóviles");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMCamperos()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVMPMCamperos().setText("Valor Máximo Por Minuto de Camperos");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMCamionetas()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVMPMCamionetas().setText("Valor Máximo Por Minuto de Camionetas");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMVehiculosPesados()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().setText("Valor Máximo Por Minuto de Vehículos Pesados");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMMotocicletas()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVMPMMotocicletas().setText("Valor Máximo Por Minuto de Motocicletas");
            }
            if (e.getSource() == registrarParqueaderoTemplate.getTnVMPMBicicletas()
                    && textField.getText().equals("")) {
                registrarParqueaderoTemplate.getTnVMPMBicicletas().setText("Valor Máximo Por Minuto de Bicicletas");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    registrarParqueaderoTemplate.getsRecursos().getColorNaranja(), 1)
            );
        }
    }

    public boolean cargarDatos() {
        contadorAreas = 0;
        contadorPrecios = 0;
        areas.clear();
        tarifas.clear();

        // CÓDIGO PARQUEADERO -------------------------------------------------        
        if (!registrarParqueaderoTemplate.gettCodigoParqueadero().getText().equals("Código del parqueadero")
                && !registrarParqueaderoTemplate.gettCodigoParqueadero().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.gettCodigoParqueadero().getText().trim(), 15)) {
            parqueadero.setCodigo(Integer.parseInt(registrarParqueaderoTemplate.gettCodigoParqueadero().getText().trim()));
        } else {
            registrarParqueaderoTemplate.gettCodigoParqueadero().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese un código de solo "
                    + "números al parqueadero", "Advertencia", 1);
            return false;
        }

        // NOMBRE PARQUEADERO -------------------------------------------------        
        if (!registrarParqueaderoTemplate.gettNombreParqueadero().getText().equals("Nombre del parqueadero")
                && !registrarParqueaderoTemplate.gettNombreParqueadero().getText().equals("")) {
            parqueadero.setNombre(registrarParqueaderoTemplate.gettNombreParqueadero().getText().trim());
        } else {
            registrarParqueaderoTemplate.gettNombreParqueadero().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del parqueadero", "Advertencia", 1);
            return false;
        }

        // CLAVE PARQUEADERO --------------------------------------------        
        if (!registrarParqueaderoTemplate.gettClaveParqueadero().getText().equals("Contraseña del parqueadero")
                && !registrarParqueaderoTemplate.gettClaveParqueadero().getText().equals("")) {
            parqueadero.setClave(registrarParqueaderoTemplate.gettClaveParqueadero().getText().trim());
        } else {
            registrarParqueaderoTemplate.gettClaveParqueadero().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese una clave de parqueadero", "Advertencia", 1);
            return false;
        }

        // DIRECCIÓN --------------------------------------------   
        if (!registrarParqueaderoTemplate.gettDireccion().getText().equals("Dirección")
                && !registrarParqueaderoTemplate.gettDireccion().getText().equals("")) {
            parqueadero.setDireccion(registrarParqueaderoTemplate.gettDireccion().getText().trim());
        } else {
            registrarParqueaderoTemplate.gettDireccion().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del parqueadero", "Advertencia", 1);
            return false;
        }

        // LOCALIDAD --------------------------------------------   
        seleccionComboBox = (String) registrarParqueaderoTemplate.getCbLocalidad().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            parqueadero.setLocalidad(seleccionComboBox.trim());
        } else {
            registrarParqueaderoTemplate.getCbLocalidad().setBorder(
                    BorderFactory.createLineBorder(
                            registrarParqueaderoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione una Localidad", "Advertencia", 1);
            return false;
        }

        // TIPO PARQUEADERO --------------------------------------------   
        seleccionComboBox = (String) registrarParqueaderoTemplate.getCbTipoParqueadero().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            if (seleccionComboBox.equals("Subterraneo")) {
                parqueadero.setSubterraneo(true);
            } else {
                parqueadero.setSubterraneo(false);
            }
        } else {
            registrarParqueaderoTemplate.getCbTipoParqueadero().setBorder(
                    BorderFactory.createLineBorder(
                            registrarParqueaderoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Parqueadero", "Advertencia", 1);
            return false;
        }

        // CANTIDAD DE NIVELES --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnNiveles().getText().equals("Número de Niveles")
                && !registrarParqueaderoTemplate.getTnNiveles().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnNiveles().getText().trim(), 2)) {
            parqueadero.setCantidadNiveles(Integer.parseInt(
                    registrarParqueaderoTemplate.getTnNiveles().getText().trim()
            )
            );
        } else {
            registrarParqueaderoTemplate.getTnNiveles().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de Nivles\nMínimo 0 máximo 99", "Advertencia", 1);
            return false;
        }

        // TIPO DE SUELO --------------------------------------------   
        seleccionComboBox = (String) registrarParqueaderoTemplate.getCbTipoSuelo().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            parqueadero.setTipoSuelo(seleccionComboBox.trim());
        } else {
            registrarParqueaderoTemplate.getCbTipoSuelo().setBorder(
                    BorderFactory.createLineBorder(
                            registrarParqueaderoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Suelo", "Advertencia", 1);
            return false;
        }

        // FACTOR DEMANDA ZONAL --------------------------------------------   
        seleccionComboBox = (String) registrarParqueaderoTemplate.getCbFactorDemandaZonal().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            parqueadero.setFactorDemandaZonal(Float.parseFloat(
                    seleccionComboBox.trim())
            );
        } else {
            registrarParqueaderoTemplate.getCbFactorDemandaZonal().setBorder(
                    BorderFactory.createLineBorder(
                            registrarParqueaderoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Factor de Demanda Zonal", "Advertencia", 1);
            return false;
        }

        // ESTADO DEL PARQUEADERO --------------------------------------------   
        seleccionComboBox = (String) registrarParqueaderoTemplate.getCbEstado().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            if (seleccionComboBox.equals("Abierto")) {
                parqueadero.setEstado(true);
            } else {
                parqueadero.setEstado(false);
            }
        } else {
            registrarParqueaderoTemplate.getCbEstado().setBorder(
                    BorderFactory.createLineBorder(
                            registrarParqueaderoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Estado", "Advertencia", 1);
            return false;
        }

        // AUTOMOVILES --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnAutomoviles().getText().equals("Número de cupos de Automóviles")
                && !registrarParqueaderoTemplate.getTnAutomoviles().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnAutomoviles().getText().trim(), 3)) {
            cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnAutomoviles().getText());
            if (cantidad > 0) {
                contadorAreas++;
                area = new Area();
                area.setIdArea(contadorAreas);
                area.setCantidadCupos(cantidad);
                area.setCantidadCuposDisponibles(cantidad);
                area.setTipoVehiculo("Automovil");
                espacios = new ArrayList<Espacio>();
                for (int i = 0; i < cantidad; i++) {
                    espacio = new Espacio();
                    espacio.setEstado(true);
                    espacio.setIdEspacio(i + 1);
                    espacios.add(espacio);
                }
                area.setEspacios(espacios);
                areas.add(area);
                if (!registrarParqueaderoTemplate.getTnVMPMAutomoviles().getText().equals("Valor Máximo Por Minuto de Automóviles")
                        && !registrarParqueaderoTemplate.getTnVMPMAutomoviles().getText().equals("")
                        && vistaPrincipalComponent.validarNumeros(
                                registrarParqueaderoTemplate.getTnVMPMAutomoviles().getText().trim(), 3)) {
                    cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVMPMAutomoviles().getText());
                    if (cantidad > 0) {
                        contadorPrecios++;
                        tarifa = new Tarifa();
                        tarifa.setIdTarifa(contadorPrecios);
                        tarifa.setTipoVehiculo("Automovil");
                        tarifa.setPrecioMaximoMinuto(cantidad);
                        tarifas.add(tarifa);
                    } else {
                        registrarParqueaderoTemplate.getTnVMPMAutomoviles().setBorder(
                                registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                        );
                        JOptionPane.showMessageDialog(null, "Valor Máximo por Minuto incorrecto", "Advertencia", 1);
                        return false;
                    }
                } else {
                    registrarParqueaderoTemplate.getTnVMPMAutomoviles().setBorder(
                            registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                    );
                    JOptionPane.showMessageDialog(null, "Introduzca el Valor Máximo Por Minuto de Automóviles", "Advertencia", 1);
                    return false;
                }
            }
        } else {
            registrarParqueaderoTemplate.getTnAutomoviles().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de Automóviles", "Advertencia", 1);
            return false;
        }

        // CAMPEROS --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnCamperos().getText().equals("Número de cupos de Camperos")
                && !registrarParqueaderoTemplate.getTnCamperos().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnCamperos().getText().trim(), 3)) {
            cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnCamperos().getText());
            if (cantidad > 0) {
                contadorAreas++;
                area = new Area();
                area.setIdArea(contadorAreas);
                area.setCantidadCupos(cantidad);
                area.setCantidadCuposDisponibles(cantidad);
                area.setTipoVehiculo("Campero");
                espacios = new ArrayList<Espacio>();
                for (int i = 0; i < cantidad; i++) {
                    espacio = new Espacio();
                    espacio.setEstado(true);
                    espacio.setIdEspacio(i + 1);
                    espacios.add(espacio);
                }
                area.setEspacios(espacios);
                areas.add(area);
                if (!registrarParqueaderoTemplate.getTnVMPMCamperos().getText().equals("Valor Máximo Por Minuto de Camperos")
                        && !registrarParqueaderoTemplate.getTnVMPMCamperos().getText().equals("")
                        && vistaPrincipalComponent.validarNumeros(
                                registrarParqueaderoTemplate.getTnVMPMCamperos().getText().trim(), 3)) {
                    cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVMPMCamperos().getText());
                    if (cantidad > 0) {
                        contadorPrecios++;
                        tarifa = new Tarifa();
                        tarifa.setIdTarifa(contadorPrecios);
                        tarifa.setTipoVehiculo("Campero");
                        tarifa.setPrecioMaximoMinuto(cantidad);
                        tarifas.add(tarifa);
                    } else {
                        registrarParqueaderoTemplate.getTnVMPMCamperos().setBorder(
                                registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                        );
                        JOptionPane.showMessageDialog(null, "Valor Máximo por Minuto incorrecto", "Advertencia", 1);
                        return false;
                    }

                } else {
                    registrarParqueaderoTemplate.getTnVMPMCamperos().setBorder(
                            registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                    );
                    JOptionPane.showMessageDialog(null, "Introduzca el Valor Máximo Por Minuto de Camperos", "Advertencia", 1);
                    return false;
                }
            }
        } else {
            registrarParqueaderoTemplate.getTnCamperos().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de Camperos", "Advertencia", 1);
            return false;
        }

        // CAMIONETAS --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnCamionetas().getText().equals("Número de cupos de Camionetas")
                && !registrarParqueaderoTemplate.getTnCamionetas().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnCamionetas().getText().trim(), 3)) {
            cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnCamionetas().getText());
            if (cantidad > 0) {
                contadorAreas++;
                area = new Area();
                area.setIdArea(contadorAreas);
                area.setCantidadCupos(cantidad);
                area.setCantidadCuposDisponibles(cantidad);
                area.setTipoVehiculo("Camioneta");
                espacios = new ArrayList<Espacio>();
                for (int i = 0; i < cantidad; i++) {
                    espacio = new Espacio();
                    espacio.setEstado(true);
                    espacio.setIdEspacio(i + 1);
                    espacios.add(espacio);
                }
                area.setEspacios(espacios);
                areas.add(area);
                if (!registrarParqueaderoTemplate.getTnVMPMCamionetas().getText().equals("Valor Máximo Por Minuto de Camionetas")
                        && !registrarParqueaderoTemplate.getTnVMPMCamionetas().getText().equals("")
                        && vistaPrincipalComponent.validarNumeros(
                                registrarParqueaderoTemplate.getTnVMPMCamionetas().getText().trim(), 3)) {
                    cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVMPMCamionetas().getText());
                    if (cantidad > 0) {
                        contadorPrecios++;
                        tarifa = new Tarifa();
                        tarifa.setIdTarifa(contadorPrecios);
                        tarifa.setTipoVehiculo("Camioneta");
                        tarifa.setPrecioMaximoMinuto(cantidad);
                        tarifas.add(tarifa);
                    } else {
                        registrarParqueaderoTemplate.getTnVMPMCamionetas().setBorder(
                                registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                        );
                        JOptionPane.showMessageDialog(null, "Valor Máximo por Minuto incorrecto", "Advertencia", 1);
                        return false;
                    }

                } else {
                    registrarParqueaderoTemplate.getTnVMPMCamionetas().setBorder(
                            registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                    );
                    JOptionPane.showMessageDialog(null, "Introduzca el Valor Máximo Por Minuto de Camionetas", "Advertencia", 1);
                    return false;
                }
            }
        } else {
            registrarParqueaderoTemplate.getTnCamionetas().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de Camionetas", "Advertencia", 1);
            return false;
        }

        // VEHÍCULOS PESADOS --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnVehiculosPesados().getText().equals("Número de cupos de Vehículos Pesados")
                && !registrarParqueaderoTemplate.getTnVehiculosPesados().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnVehiculosPesados().getText().trim(), 3)) {
            cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVehiculosPesados().getText());
            if (cantidad > 0) {
                contadorAreas++;
                area = new Area();
                area.setIdArea(contadorAreas);
                area.setCantidadCupos(cantidad);
                area.setCantidadCuposDisponibles(cantidad);
                area.setTipoVehiculo("Vehiculo Pesado");
                espacios = new ArrayList<Espacio>();
                for (int i = 0; i < cantidad; i++) {
                    espacio = new Espacio();
                    espacio.setEstado(true);
                    espacio.setIdEspacio(i + 1);
                    espacios.add(espacio);
                }
                area.setEspacios(espacios);
                areas.add(area);
                if (!registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().getText().equals("Valor Máximo Por Minuto de Vehículos Pesados")
                        && !registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().getText().equals("")
                        && vistaPrincipalComponent.validarNumeros(
                                registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().getText().trim(), 3)) {
                    cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().getText());
                    if (cantidad > 0) {
                        contadorPrecios++;
                        tarifa = new Tarifa();
                        tarifa.setIdTarifa(contadorPrecios);
                        tarifa.setTipoVehiculo("Vehiculo Pesado");
                        tarifa.setPrecioMaximoMinuto(cantidad);
                        tarifas.add(tarifa);
                    } else {
                        registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().setBorder(
                                registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                        );
                        JOptionPane.showMessageDialog(null, "Valor Máximo por Minuto incorrecto", "Advertencia", 1);
                        return false;
                    }

                } else {
                    registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().setBorder(
                            registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                    );
                    JOptionPane.showMessageDialog(null, "Introduzca el Valor Máximo Por Minuto de Vehículos Pesados", "Advertencia", 1);
                    return false;
                }
            }
        } else {
            registrarParqueaderoTemplate.getTnVehiculosPesados().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de ", "Advertencia", 1);
            return false;
        }

        // MOTOCICLETAS --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnMotocicletas().getText().equals("Número de cupos de Motocicletas")
                && !registrarParqueaderoTemplate.getTnMotocicletas().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnMotocicletas().getText().trim(), 3)) {
            cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnMotocicletas().getText());
            if (cantidad > 0) {
                contadorAreas++;
                area = new Area();
                area.setIdArea(contadorAreas);
                area.setCantidadCupos(cantidad);
                area.setCantidadCuposDisponibles(cantidad);
                area.setTipoVehiculo("Motocicleta");
                espacios = new ArrayList<Espacio>();
                for (int i = 0; i < cantidad; i++) {
                    espacio = new Espacio();
                    espacio.setEstado(true);
                    espacio.setIdEspacio(i + 1);
                    espacios.add(espacio);
                }
                area.setEspacios(espacios);
                areas.add(area);
                if (!registrarParqueaderoTemplate.getTnVMPMMotocicletas().getText().equals("Valor Máximo Por Minuto de Motocicletas")
                        && !registrarParqueaderoTemplate.getTnVMPMMotocicletas().equals("")
                        && vistaPrincipalComponent.validarNumeros(
                                registrarParqueaderoTemplate.getTnVMPMMotocicletas().getText().trim(), 3)) {
                    cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVMPMMotocicletas().getText());
                    if (cantidad > 0) {
                        contadorPrecios++;
                        tarifa = new Tarifa();
                        tarifa.setIdTarifa(contadorPrecios);
                        tarifa.setTipoVehiculo("Motocicleta");
                        tarifa.setPrecioMaximoMinuto(cantidad);
                        tarifas.add(tarifa);
                    } else {
                        registrarParqueaderoTemplate.getTnVMPMMotocicletas().setBorder(
                                registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                        );
                        JOptionPane.showMessageDialog(null, "Valor Máximo por Minuto incorrecto", "Advertencia", 1);
                        return false;
                    }

                } else {
                    registrarParqueaderoTemplate.getTnVMPMMotocicletas().setBorder(
                            registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                    );
                    JOptionPane.showMessageDialog(null, "Introduzca el Valor Máximo Por Minuto de Motocicletas", "Advertencia", 1);
                    return false;
                }
            }
        } else {
            registrarParqueaderoTemplate.getTnMotocicletas().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de ", "Advertencia", 1);
            return false;
        }

        // BICICLETAS --------------------------------------------   
        if (!registrarParqueaderoTemplate.getTnBicicletas().getText().equals("Número de cupos de Bicicletas")
                && !registrarParqueaderoTemplate.getTnBicicletas().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarParqueaderoTemplate.getTnBicicletas().getText().trim(), 3)) {
            cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnBicicletas().getText());
            if (cantidad > 0) {
                contadorAreas++;
                area = new Area();
                area.setIdArea(contadorAreas);
                area.setCantidadCupos(cantidad);
                area.setCantidadCuposDisponibles(cantidad);
                area.setTipoVehiculo("Bicicleta");
                espacios = new ArrayList<Espacio>();
                for (int i = 0; i < cantidad; i++) {
                    espacio = new Espacio();
                    espacio.setEstado(true);
                    espacio.setIdEspacio(i + 1);
                    espacios.add(espacio);
                }
                area.setEspacios(espacios);
                areas.add(area);
                if (!registrarParqueaderoTemplate.getTnVMPMBicicletas().getText().equals("Valor Máximo Por Minuto de Bicicletas")
                        && !registrarParqueaderoTemplate.getTnVMPMBicicletas().getText().equals("")
                        && vistaPrincipalComponent.validarNumeros(
                                registrarParqueaderoTemplate.getTnVMPMBicicletas().getText().trim(), 3)) {
                    cantidad = Integer.parseInt(registrarParqueaderoTemplate.getTnVMPMBicicletas().getText());
                    if (cantidad > 0) {
                        contadorPrecios++;
                        tarifa = new Tarifa();
                        tarifa.setIdTarifa(contadorPrecios);
                        tarifa.setTipoVehiculo("Bicicleta");
                        tarifa.setPrecioMaximoMinuto(cantidad);
                        tarifas.add(tarifa);
                    } else {
                        registrarParqueaderoTemplate.getTnVMPMBicicletas().setBorder(
                                registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                        );
                        JOptionPane.showMessageDialog(null, "Valor Máximo por Minuto incorrecto", "Advertencia", 1);
                        return false;
                    }

                } else {
                    registrarParqueaderoTemplate.getTnVMPMBicicletas().setBorder(
                            registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
                    );
                    JOptionPane.showMessageDialog(null, "Introduzca el Valor Máximo Por Minuto de Bicicletas", "Advertencia", 1);
                    return false;
                }
            }
        } else {
            registrarParqueaderoTemplate.getTnBicicletas().setBorder(
                    registrarParqueaderoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad de Bicicletas", "Advertencia", 1);
            return false;
        }
        parqueadero.setAreas(areas);
        parqueadero.setTarifas(tarifas);
        return true;
    }

    public void limpiarDatos() {
        registrarParqueaderoTemplate.gettNombreParqueadero().setText(
                "Nombre del parqueadero"
        );
        registrarParqueaderoTemplate.gettClaveParqueadero().setText(
                "Contraseña del parqueadero");
        registrarParqueaderoTemplate.gettDireccion().setText("Dirección"
        );
        registrarParqueaderoTemplate.getTnNiveles().setText(
                "Número de Niveles"
        );
        registrarParqueaderoTemplate.getTnAutomoviles().setText(
                "Número de cupos de Automóviles"
        );
        registrarParqueaderoTemplate.getTnCamperos().setText(
                "Número de cupos de Camperos"
        );
        registrarParqueaderoTemplate.getTnCamionetas().setText(
                "Número de cupos de Camionetas"
        );
        registrarParqueaderoTemplate.getTnVehiculosPesados().setText(
                "Número de cupos de Vehículos Pesados"
        );
        registrarParqueaderoTemplate.getTnMotocicletas().setText(
                "Número de cupos de Motocicletas"
        );
        registrarParqueaderoTemplate.getTnBicicletas().setText(
                "Número de cupos de Bicicletas"
        );
        registrarParqueaderoTemplate.getTnVMPMAutomoviles().setText(
                "Valor Máximo Por Minuto de Automóviles"
        );
        registrarParqueaderoTemplate.getTnVMPMCamperos().setText(
                "Valor Máximo Por Minuto de Camperos"
        );
        registrarParqueaderoTemplate.getTnVMPMCamionetas().setText(
                "Valor Máximo Por Minuto de Camionetas"
        );
        registrarParqueaderoTemplate.getTnVMPMVehiculosPesados().setText(
                "Valor Máximo Por Minuto de Vehículos Pesados"
        );
        registrarParqueaderoTemplate.getTnVMPMMotocicletas().setText(
                "Valor Máximo Por Minuto de Motocicletas"
        );
        registrarParqueaderoTemplate.getTnVMPMBicicletas().setText(
                "Valor Máximo Por Minuto de Bicicletas"
        );
        registrarParqueaderoTemplate.getCbEstado().setSelectedIndex(0);
        registrarParqueaderoTemplate.getCbFactorDemandaZonal().setSelectedIndex(0);
        registrarParqueaderoTemplate.getCbLocalidad().setSelectedIndex(0);
        registrarParqueaderoTemplate.getCbTipoParqueadero().setSelectedIndex(0);
        registrarParqueaderoTemplate.getCbTipoSuelo().setSelectedIndex(0);
    }

}
