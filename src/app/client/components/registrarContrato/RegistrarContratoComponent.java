package app.client.components.registrarContrato;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import negocio.models.Contrato;
import negocio.models.Cliente;
import negocio.models.Vehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarContratoComponent implements ActionListener, 
        MouseListener, FocusListener {
    
    private RegistrarContratoTemplate registrarContratoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private Contrato contrato;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private JTextField textField;
    private JButton boton;
    private JComboBox comboBox;
    private String seleccionComboBox;

    private JButton botonSeleccionado;

    public RegistrarContratoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        contrato = new Contrato();
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        registrarContratoTemplate = new RegistrarContratoTemplate(this);
    }

    public RegistrarContratoTemplate getVistaPrincipalComponent() {
        return registrarContratoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarContratoTemplate.getbRegistrarContrato()) {
            if (cargarDatos()) {
                JOptionPane.showMessageDialog(null, "Registro Exitoso", "Advertencia", 1);
            }
        }
        if (e.getSource() == registrarContratoTemplate.getbLimpiar()) {
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
                    registrarContratoTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            if (boton == registrarContratoTemplate.getbRegistrarContrato()) {
                boton.setBackground(
                        registrarContratoTemplate.getsRecursos().getColorNaranja()
                );
            } else {
                boton.setBackground(
                        registrarContratoTemplate.getsRecursos().getColorGris()
                );
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeSeleccion()
            );
            if (e.getSource() == registrarContratoTemplate.gettPrimerNombre()
                    && textField.getText().equals("Primer nombre")) {
                registrarContratoTemplate.gettPrimerNombre().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettSegundoNombre()
                    && textField.getText().equals("Segundo nombre")) {
                registrarContratoTemplate.gettSegundoNombre().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettPrimerApellido()
                    && textField.getText().equals("Primer apellido")) {
                registrarContratoTemplate.gettPrimerApellido().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettSegundoApellido()
                    && textField.getText().equals("Segundo Apellido")) {
                registrarContratoTemplate.gettSegundoApellido().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettNumeroDocumento()
                    && textField.getText().equals("Número de documento")) {
                registrarContratoTemplate.gettNumeroDocumento().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettDireccionCliente()
                    && textField.getText().equals("Dirección")) {
                registrarContratoTemplate.gettDireccionCliente().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettTelefono()
                    && textField.getText().equals("Telefono")) {
                registrarContratoTemplate.gettTelefono().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.gettTelefonoOpcional()
                    && textField.getText().equals("Telefono (Opcional)")) {
                registrarContratoTemplate.gettTelefonoOpcional().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTPlaca()
                    && textField.getText().equals("Placa/Número de serie")) {
                registrarContratoTemplate.getTPlaca().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTMarca()
                    && textField.getText().equals("Marca")) {
                registrarContratoTemplate.getTMarca().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTColor()
                    && textField.getText().equals("Color")) {
                registrarContratoTemplate.getTColor().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTModelo()
                    && textField.getText().equals("Modelo")) {
                registrarContratoTemplate.getTModelo().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTnFechaInicio()
                    && textField.getText().equals("Fecha de inicio")) {
                registrarContratoTemplate.getTnFechaInicio().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTnFechaFin()
                    && textField.getText().equals("Fecha de caducidad")) {
                registrarContratoTemplate.getTnFechaFin().setText("");
            }
            if (e.getSource() == registrarContratoTemplate.getTnValor()
                    && textField.getText().equals("Valor")) {
                registrarContratoTemplate.getTnValor().setText("");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    registrarContratoTemplate.getsRecursos().getColorSeleccion(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeNaranja()
            );
            if (e.getSource() == registrarContratoTemplate.gettPrimerNombre()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettPrimerNombre().setText("Primer nombre");
            }
            if (e.getSource() == registrarContratoTemplate.gettSegundoNombre()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettSegundoNombre().setText("Segundo nombre");
            }
            if (e.getSource() == registrarContratoTemplate.gettPrimerApellido()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettPrimerApellido().setText("Primer apellido");
            }
            if (e.getSource() == registrarContratoTemplate.gettSegundoApellido()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettSegundoApellido().setText("Segundo apellido");
            }
            if (e.getSource() == registrarContratoTemplate.gettNumeroDocumento()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettNumeroDocumento().setText("Número de documento");
            }
            if (e.getSource() == registrarContratoTemplate.gettDireccionCliente()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettDireccionCliente().setText("Direccion");
            }
            if (e.getSource() == registrarContratoTemplate.gettTelefono()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettTelefono().setText("Telefono");
            }
            if (e.getSource() == registrarContratoTemplate.gettTelefonoOpcional()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.gettTelefonoOpcional().setText("Telefono (Opcional)");
            }
            if (e.getSource() == registrarContratoTemplate.getTPlaca()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTPlaca().setText("Placa/Numero de serie");
            }
            if (e.getSource() == registrarContratoTemplate.getTMarca()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTMarca().setText("Marca");
            }
            if (e.getSource() == registrarContratoTemplate.getTColor()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTColor().setText("Color");
            }
            if (e.getSource() == registrarContratoTemplate.getTModelo()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTModelo().setText("Modelo");
            }
            if (e.getSource() == registrarContratoTemplate.getTnFechaInicio()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTnFechaInicio().setText("Fecha de inicio");
            }
            if (e.getSource() == registrarContratoTemplate.getTnFechaFin()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTnFechaFin().setText("Fecha de caducidad");
            }
            if (e.getSource() == registrarContratoTemplate.getTnValor()
                    && textField.getText().equals("")) {
                registrarContratoTemplate.getTnValor().setText("Valor");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    registrarContratoTemplate.getsRecursos().getColorNaranja(), 1)
            );
        }
    }

    public boolean cargarDatos() {
        // PRIMER NOMBRE DEL CLIENTE -------------------------------------------------        
        if (!registrarContratoTemplate.gettPrimerNombre().getText().equals("Primer nombre")
                && !registrarContratoTemplate.gettPrimerNombre().getText().equals("")) {
            cliente.setPrimerNombre(registrarContratoTemplate.gettPrimerNombre().getText().trim());
        } else {
            registrarContratoTemplate.gettPrimerNombre().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el primer nombre del cliente", "Advertencia", 1);
            return false;
        }

        // SEGUNDO NOMBRE DEL CLIENTE --------------------------------------------        
        if (!registrarContratoTemplate.gettSegundoNombre().getText().equals("Segundo nombre")
                && !registrarContratoTemplate.gettSegundoNombre().getText().equals("")) {
            cliente.setSegundoNombre(registrarContratoTemplate.gettSegundoNombre().getText().trim());
        } else {
            registrarContratoTemplate.gettSegundoNombre().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el segundo nombre del cliente", "Advertencia", 1);
            return false;
        }

        // PRIMER APELLIDO DEL CLIENTE --------------------------------------------   
        if (!registrarContratoTemplate.gettPrimerApellido().getText().equals("Primer apellido")
                && !registrarContratoTemplate.gettPrimerApellido().getText().equals("")) {
            cliente.setPrimerApellido(registrarContratoTemplate.gettPrimerApellido().getText().trim());
        } else {
            registrarContratoTemplate.gettPrimerApellido().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el primer apellido del cliente", "Advertencia", 1);
            return false;
        }
        
        // SEGUNDO APELLIDO DEL CLIENTE --------------------------------------------   
        if (!registrarContratoTemplate.gettSegundoApellido().getText().equals("Segundo apellido")
                && !registrarContratoTemplate.gettSegundoApellido().getText().equals("")) {
            cliente.setSegundoApellido(registrarContratoTemplate.gettSegundoApellido().getText().trim());
        } else {
            registrarContratoTemplate.gettSegundoApellido().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el segundo apellido del cliente", "Advertencia", 1);
            return false;
        }

        // SEXO DEL CLIENTE --------------------------------------------   
        seleccionComboBox = (String) registrarContratoTemplate.getCbSexo().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            cliente.setSexo(seleccionComboBox.trim());
        } else {
            registrarContratoTemplate.getCbSexo().setBorder(
                    BorderFactory.createLineBorder(
                            registrarContratoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione sexo", "Advertencia", 1);
            return false;
        }

        // TIPO DE DOCUMENTO --------------------------------------------   
        seleccionComboBox = (String) registrarContratoTemplate.getCbTipoDocumento().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            cliente.setSexo(seleccionComboBox.trim());
        } else {
            registrarContratoTemplate.getCbTipoDocumento().setBorder(
                    BorderFactory.createLineBorder(
                            registrarContratoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione tipo de documento", "Advertencia", 1);
            return false;
        }

        // NUMERO DE DOCUMENTO --------------------------------------------   
        if (!registrarContratoTemplate.gettNumeroDocumento().getText().equals("Número de Niveles")
                && !registrarContratoTemplate.gettNumeroDocumento().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarContratoTemplate.gettNumeroDocumento().getText().trim(), 2)) {
            cliente.setCedulaCliente(Integer.parseInt(
                    registrarContratoTemplate.gettNumeroDocumento().getText().trim()
            )
            );
        } else {
            registrarContratoTemplate.gettNumeroDocumento().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese numero de documento", "Advertencia", 1);
            return false;
        }

        // DIRECCIÓN CLIENTE--------------------------------------------   
        if (!registrarContratoTemplate.gettDireccionCliente().getText().equals("Dirección")
                && !registrarContratoTemplate.gettDireccionCliente().getText().equals("")) {
            cliente.setDireccion(registrarContratoTemplate.gettDireccionCliente().getText().trim());
        } else {
            registrarContratoTemplate.gettDireccionCliente().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese la dirección del cliente", "Advertencia", 1);
            return false;
        }
        
        // TELEFONO CLIENTE --------------------------------------------   
        if (!registrarContratoTemplate.gettTelefono().getText().equals("Telefono")
                && !registrarContratoTemplate.gettTelefono().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarContratoTemplate.gettTelefono().getText().trim(), 2)) {
            cliente.setTelefono(Integer.parseInt(
                    registrarContratoTemplate.gettTelefono().getText().trim()
            )
            );
        } else {
            registrarContratoTemplate.gettTelefono().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese telefono", "Advertencia", 1);
            return false;
        }
        
        // TELEFONO OPCIONAL CLIENTE --------------------------------------------   
        if (!registrarContratoTemplate.gettTelefonoOpcional().getText().equals("Telefono (Opcional)")
                && !registrarContratoTemplate.gettTelefonoOpcional().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarContratoTemplate.gettTelefonoOpcional().getText().trim(), 2)) {
            cliente.setTelefonoOpcional(Integer.parseInt(
                    registrarContratoTemplate.gettTelefonoOpcional().getText().trim()
            )
            );
        } else {
            registrarContratoTemplate.gettTelefonoOpcional().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese telefono (opcional)", "Advertencia", 1);
            return false;
        }

        // TIPO DE VEHICULO --------------------------------------------   
        seleccionComboBox = (String) registrarContratoTemplate.getCbTipoVehiculo().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            vehiculo.setTipoVehiculo(seleccionComboBox.trim());
        } else {
            registrarContratoTemplate.getCbTipoVehiculo().setBorder(
                    BorderFactory.createLineBorder(
                            registrarContratoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione el Tipo de Vehiculo", "Advertencia", 1);
            return false;
        }
        
        // PLACA / NUMERO DE SERIE  --------------------------------------------        
        if (!registrarContratoTemplate.getTPlaca().getText().equals("Placa/Numero de serie")
                && !registrarContratoTemplate.getTPlaca().getText().equals("")) {
            vehiculo.setPlaca(registrarContratoTemplate.getTPlaca().getText().trim());
        } else {
            registrarContratoTemplate.getTPlaca().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese la placa/numero de serie", "Advertencia", 1);
            return false;
        }
        
        // MARCA DEL VEHICULO -------------------------------------------------        
        if (!registrarContratoTemplate.getTMarca().getText().equals("Marca")
                && !registrarContratoTemplate.getTMarca().getText().equals("")) {
            vehiculo.setMarca(registrarContratoTemplate.getTMarca().getText().trim());
        } else {
            registrarContratoTemplate.getTMarca().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese la marca del vehiculo", "Advertencia", 1);
            return false;
        }
        
        // COLOR DEL VEHICULO -------------------------------------------------        
        if (!registrarContratoTemplate.getTColor().getText().equals("Color")
                && !registrarContratoTemplate.getTColor().getText().equals("")) {
            vehiculo.setColor(registrarContratoTemplate.getTColor().getText().trim());
        } else {
            registrarContratoTemplate.getTColor().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el color del vehiculo", "Advertencia", 1);
            return false;
        }
        
        // MODELO DEL VEHICULO -------------------------------------------------        
        if (!registrarContratoTemplate.getTModelo().getText().equals("Modelo")
                && !registrarContratoTemplate.getTModelo().getText().equals("")) {
            vehiculo.setModelo(registrarContratoTemplate.getTModelo().getText().trim());
        } else {
            registrarContratoTemplate.getTModelo().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el modelo del vehiculo", "Advertencia", 1);
            return false;
        }
        
        // TIPO DE CONTRATO --------------------------------------------   
        seleccionComboBox = (String) registrarContratoTemplate.getCbPeriodo().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            contrato.setPeriodo(seleccionComboBox.trim());
        } else {
            registrarContratoTemplate.getCbPeriodo().setBorder(
                    BorderFactory.createLineBorder(
                            registrarContratoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione el Tipo de Contrato", "Advertencia", 1);
            return false;
        }
        
        // FECHA INICIO CONTRATO -------------------------------------------------        
        if (!registrarContratoTemplate.getTnFechaInicio().getText().equals("Fecha de inicio")
                && !registrarContratoTemplate.getTnFechaInicio().getText().equals("")) {
            contrato.setFechaInicio(registrarContratoTemplate.getTnFechaInicio().getText().trim());
        } else {
            registrarContratoTemplate.getTnFechaInicio().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de inicio del contrato", "Advertencia", 1);
            return false;
        }
        
        // FECHA DE CADUCIDAD CONTRATO -------------------------------------------------        
        if (!registrarContratoTemplate.getTnFechaFin().getText().equals("Fecha de caducidad")
                && !registrarContratoTemplate.getTnFechaFin().getText().equals("")) {
            contrato.setFechaFin(registrarContratoTemplate.getTnFechaFin().getText().trim());
        } else {
            registrarContratoTemplate.getTnFechaFin().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese la fecha de caducidad del contrato", "Advertencia", 1);
            return false;
        }
        
        // VALOR DEL CONTRATO --------------------------------------------   
        if (!registrarContratoTemplate.getTnValor().getText().equals("Valor contrato")
                && !registrarContratoTemplate.getTnValor().getText().equals("")
                && vistaPrincipalComponent.validarNumeros(
                        registrarContratoTemplate.getTnValor().getText().trim(), 2)) {
            contrato.setValorPago(Integer.parseInt(
                    registrarContratoTemplate.getTnValor().getText().trim()
            )
            );
        } else {
            registrarContratoTemplate.getTnValor().setBorder(
                    registrarContratoTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese el valor del contrato", "Advertencia", 1);
            return false;
        }
        
        // ESTADO DEL CONTRATO --------------------------------------------   
        seleccionComboBox = (String) registrarContratoTemplate.getCbEstadoContrato().getSelectedItem();
        if (!seleccionComboBox.equals("Seleccione una opción")
                && !seleccionComboBox.equals("")) {
            if (seleccionComboBox.equals("Vigente")) {
                contrato.setEstadoContrato(true);
            } else {
                contrato.setEstadoContrato(false);
            }
            contrato.setPeriodo(seleccionComboBox.trim());
        } else {
            registrarContratoTemplate.getCbEstadoContrato().setBorder(
                    BorderFactory.createLineBorder(
                            registrarContratoTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un estado", "Advertencia", 1);
            return false;
        }

        return true;
    }

    public void limpiarDatos() {
        registrarContratoTemplate.gettPrimerNombre().setText(
                "Primer nombre"
        );
        registrarContratoTemplate.gettSegundoNombre().setText(
                "Segundo nombre");
        registrarContratoTemplate.gettPrimerApellido().setText("Primer apellido"
        );
        registrarContratoTemplate.gettSegundoApellido().setText(
                "Segundo apellido"
        );
        registrarContratoTemplate.gettNumeroDocumento().setText(
                "Número de documento"
        );
        registrarContratoTemplate.gettDireccionCliente().setText(
                "Direccion"
        );
        registrarContratoTemplate.gettTelefono().setText(
                "Telefono"
        );
        registrarContratoTemplate.gettTelefonoOpcional().setText(
                "Telefono (Opcional)"
        );
        registrarContratoTemplate.getTPlaca().setText(
                "Placa/Numero de serie"
        );
        registrarContratoTemplate.getTMarca().setText(
                "Marca"
        );
        registrarContratoTemplate.getTColor().setText(
                "Color"
        );
        registrarContratoTemplate.getTModelo().setText(
                "Modelo"
        );
        registrarContratoTemplate.getTnFechaInicio().setText(
                "Fecha de inicio"
        );
        registrarContratoTemplate.getTnFechaFin().setText(
                "Fecha de caducidad"
        );
        registrarContratoTemplate.getTnValor().setText(
                "Valor"
        );
        
        registrarContratoTemplate.getCbSexo().setSelectedIndex(0);
        registrarContratoTemplate.getCbTipoDocumento().setSelectedIndex(0);
        registrarContratoTemplate.getCbTipoVehiculo().setSelectedIndex(0);
        registrarContratoTemplate.getCbPeriodo().setSelectedIndex(0);
        registrarContratoTemplate.getCbEstadoContrato().setSelectedIndex(0);
    }
    
}
