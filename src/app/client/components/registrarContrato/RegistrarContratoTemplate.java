package app.client.components.registrarContrato;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrarContratoTemplate extends JPanel {

    private RegistrarContratoComponent registrarContratoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JLabel lTitulo, lDatosCliente, lBorde, lColor, lFechaInicio, lValor, 
            lNumeroDocumento, lPrimerNombre, lSegundoNombre, lPrimerApellido, 
            lSegundoApellido,lSexo, lTipoDocumento,lTelefono, lDireccionCliente, 
            lTelefonoOpcional, lDatosVehiculo, lTipoVehiculo, lPlaca, 
            lMarca,lModelo, lDatosContrato, lPeriodo, lFechaFin,lEstadoContrato;          
    private JTextField tPrimerNombre, tSegundoNombre, tPrimerApellido, 
            tSegundoApellido, tNumeroDocumento, tDireccionCliente,tnNiveles, 
            tnAutomoviles, tTelefono, tTelefonoOpcional, TPlaca, TMarca, TColor, 
            TModelo, tnFechaInicio, tnFechaFin, tnValor;
    private JComboBox cbSexo, cbTipoDocumento, cbTipoVehiculo,
            cbPeriodo, cbEstadoContrato;
    private JButton bRegistrarContrato, bLimpiar;
    
    public RegistrarContratoTemplate(RegistrarContratoComponent registrarContratoComponent) {
        this.registrarContratoComponent = registrarContratoComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJComboBox();
        this.crearJLabels();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(880, 2150));
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJTextFields() {
        
        // PRIMER NOMBRE CLIENTE ----------------------------------------------
        tPrimerNombre = sObjGraficos.construirJTextField(
                "Primer nombre", 350, 230, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tPrimerNombre.setBorder(sRecursos.getBordeNaranja());
        tPrimerNombre.addFocusListener(registrarContratoComponent);
        this.add(tPrimerNombre);

        // SEGUNDO NOMBRE CLIENTE ----------------------------------------------
        tSegundoNombre = sObjGraficos.construirJTextField(
                "Segundo nombre", 350, 300, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tSegundoNombre.setBorder(sRecursos.getBordeNaranja());
        tSegundoNombre.addFocusListener(registrarContratoComponent);
        this.add(tSegundoNombre);

        // PRIMER APELLIDO CLIENTE -------------------------------------------------------
        tPrimerApellido = sObjGraficos.construirJTextField(
                "Primer apellido", 350, 370, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tPrimerApellido.setBorder(sRecursos.getBordeNaranja());
        tPrimerApellido.addFocusListener(registrarContratoComponent);
        this.add(tPrimerApellido);

        // SEGUNDO APELLIDO CLIENTE ----------------------------------------------
        tSegundoApellido = sObjGraficos.construirJTextField(
                "Segundo Apellido", 350, 440, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tSegundoApellido.setBorder(sRecursos.getBordeNaranja());
        tSegundoApellido.addFocusListener(registrarContratoComponent);
        this.add(tSegundoApellido);

        // NUMERO DE DOCUMENTO -------------------------------------------------
        tNumeroDocumento = sObjGraficos.construirJTextField(
                "Número de documento", 350, 650, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tNumeroDocumento.setBorder(sRecursos.getBordeNaranja());
        tNumeroDocumento.addFocusListener(registrarContratoComponent);
        this.add(tNumeroDocumento);
        
        // DIRECCION CLIENTE  -------------------------------
        tDireccionCliente = sObjGraficos.construirJTextField(
                "Dirección", 350, 720, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tDireccionCliente.setBorder(sRecursos.getBordeNaranja());
        tDireccionCliente.addFocusListener(registrarContratoComponent);
        this.add(tDireccionCliente);

        // TELEFONO CLIENTE -------------------------------------------------
        tTelefono = sObjGraficos.construirJTextField(
                "Telefono", 350, 790, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tTelefono.setBorder(sRecursos.getBordeNaranja());
        tTelefono.addFocusListener(registrarContratoComponent);
        this.add(tTelefono);
        
        // TELEFONO OPCIONAL CLIENTE --------------------------------
        tTelefonoOpcional = sObjGraficos.construirJTextField(
                "Telefono (Opcional)", 350, 860, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tTelefonoOpcional.setBorder(sRecursos.getBordeNaranja());
        tTelefonoOpcional.addFocusListener(registrarContratoComponent);
        this.add(tTelefonoOpcional);

        // PLACA/NUMERO DE SERIE -------------------------------------------------
        TPlaca = sObjGraficos.construirJTextField(
                "Placa/Numero de serie", 350, 1170, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        TPlaca.setBorder(sRecursos.getBordeNaranja());
        TPlaca.addFocusListener(registrarContratoComponent);
        this.add(TPlaca);
        
        // MARCA VEHICULO -------------------------------
        TMarca = sObjGraficos.construirJTextField(
                "Marca", 350, 1240, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        TMarca.setBorder(sRecursos.getBordeNaranja());
        TMarca.addFocusListener(registrarContratoComponent);
        this.add(TMarca);

        // COLOR VEHICULO ----------------------------------------
        TColor = sObjGraficos.construirJTextField(
                "Color", 350, 1310, 470, 40,
                null, Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        TColor.setBorder(sRecursos.getBordeNaranja());
        TColor.addFocusListener(registrarContratoComponent);
        this.add(TColor);
        
        // MODELO VEHICULO -----------------------------------------
        TModelo = sObjGraficos.construirJTextField(
                "Modelo", 350, 1380, 470, 40,
                null, Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        TModelo.setBorder(sRecursos.getBordeNaranja());
        TModelo.addFocusListener(registrarContratoComponent);
        this.add(TModelo);

        // FECHA DE INICIO CONTRATO ------------------------------------------------
        tnFechaInicio = sObjGraficos.construirJTextField(
                "Fecha de inicio", 350, 1660, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnFechaInicio.setBorder(sRecursos.getBordeNaranja());
        tnFechaInicio.addFocusListener(registrarContratoComponent);
        this.add(tnFechaInicio);
        
        // FECHA DE CADUCIDAD CONTRATO -----------------------------
        tnFechaFin = sObjGraficos.construirJTextField(
                "Fecha de caducidad", 350, 1730, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnFechaFin.setBorder(sRecursos.getBordeNaranja());
        tnFechaFin.addFocusListener(registrarContratoComponent);
        this.add(tnFechaFin);

        // VALOR CONTRATO -------------------------------------------------
        tnValor = sObjGraficos.construirJTextField(
                "Valor", 350, 1800, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnValor.setBorder(sRecursos.getBordeNaranja());
        tnValor.addFocusListener(registrarContratoComponent);
        this.add(tnValor);
        
    }
    
    public void crearJButtons() {
        // BOTÓN REGISTRAR CONTRATO ---------------------------------------
        bRegistrarContrato = sObjGraficos.construirJButton(
                "Registrar Contrato", (880 - 300) / 2, 1960, 300, 60,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white, null,
                "C", true
        );
        bRegistrarContrato.addMouseListener(registrarContratoComponent);
        bRegistrarContrato.addActionListener(registrarContratoComponent);
        this.add(bRegistrarContrato);

        // BOTÓN LIMPIAR -----------------------------------------------------
        bLimpiar = sObjGraficos.construirJButton(
                "Limpiar", (880 - 100) / 2, 2040, 100, 30,
                sRecursos.getcMano(), null, sRecursos.getFontText(),
                sRecursos.getColorGris(), Color.WHITE, null,
                "C", true
        );
        bLimpiar.addMouseListener(registrarContratoComponent);
        bLimpiar.addActionListener(registrarContratoComponent);
        this.add(bLimpiar);
    }
    
    public void crearJComboBox() {
        // SEXO -------------------------------------------------------
        cbSexo = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Masculino_Femenino_"
                        + "Otro", 350, 510, 470, 40, Color.WHITE, Color.BLACK, 
                        "c"
        );
        cbSexo.setFont(sRecursos.getFontText());
        cbSexo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbSexo.addFocusListener(registrarContratoComponent);
        this.add(cbSexo);

        // TIPO DE DOCUMENTO ------------------------------------------------
        cbTipoDocumento = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Cedula de Ciudadania_Tarjeta de "
                        + "Identidad_Cedula de Extranjeria_NUIP_"
                        + "Pasaporte", 350, 580, 470,
                40, Color.WHITE, Color.BLACK, "c"
        );
        cbTipoDocumento.setFont(sRecursos.getFontText());
        cbTipoDocumento.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbTipoDocumento.addFocusListener(registrarContratoComponent);
        this.add(cbTipoDocumento);

        // TIPO DE VEHICULO ----------------------------------------------------
        cbTipoVehiculo = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Automovil_Campero_Camioneta_"
                + "Pesado_Motocicleta_Bicicleta", 350, 1100, 470,
                40, Color.WHITE, Color.BLACK, "c"
        );
        cbTipoVehiculo.setFont(sRecursos.getFontText());
        cbTipoVehiculo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbTipoVehiculo.addFocusListener(registrarContratoComponent);
        this.add(cbTipoVehiculo);

        // PERIODO ----------------------------------------------
        cbPeriodo = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Dia_Semana_Mes_Año", 350, 1590, 470, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbPeriodo.setFont(sRecursos.getFontText());
        cbPeriodo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbPeriodo.addFocusListener(registrarContratoComponent);
        this.add(cbPeriodo);

        // ESTADO CONTRATO------------------------------------------------------------
        cbEstadoContrato = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Vigente_Caducado", 350, 1870, 470, 40,
                Color.WHITE, Color.BLACK, "c"
        );
        cbEstadoContrato.setFont(sRecursos.getFontText());
        cbEstadoContrato.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbEstadoContrato.addFocusListener(registrarContratoComponent);
        this.add(cbEstadoContrato);
    }

    public void crearJLabels() {
        // TITULO -------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Registrar Contrato", 0, 20, 880, 80, null,
                sRecursos.getColorNaranja(), null,
                sRecursos.getFontTituloUsuario(), "c"
        );
        this.add(lTitulo);

        // DATOS CLIENTE ------------------------------------------------------
        lDatosCliente = sObjGraficos.construirJLabel(
                "Datos Cliente", 0, 150, 880, 40, null, Color.WHITE, null,
                sRecursos.getFontSeccion(), "c"
        );
        this.add(lDatosCliente);

        // PRIMER NOMBRE DEL CLIENTE ------------------------------------------
        lPrimerNombre = sObjGraficos.construirJLabel(
                "Primer nombre:", 50, 230, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lPrimerNombre);

        // SEGUNDO NOMBRE DEL CLIENTE-------------------------------------------
        lSegundoNombre = sObjGraficos.construirJLabel(
                "Segundo nombre:", 50, 300, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lSegundoNombre);
        
        // PRIMER APELLIDO DEL CLIENTE-------------------------------------------
        lPrimerApellido = sObjGraficos.construirJLabel(
                "Primer apellido:", 50, 370, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lPrimerApellido);
        
        // SEGUNDO APELLIDO DEL CLIENTE-------------------------------------------
        lSegundoApellido = sObjGraficos.construirJLabel(
                "Segundo apellido:", 50, 440, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lSegundoApellido);
        
        // SEXO DEL CLIENTE-------------------------------------------
        lSexo = sObjGraficos.construirJLabel(
                "Sexo:", 50, 510, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lSexo);
        
        // TIPO DE DOCUMENTO DEL CLIENTE-------------------------------------------
        lTipoDocumento = sObjGraficos.construirJLabel(
                "Tipo de documento:", 50, 580, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTipoDocumento);

        // NUMERO DE DOCUMENTO CLIENTE -----------------------------------------
        lNumeroDocumento = sObjGraficos.construirJLabel(
                "Numero de documento:", 50, 650, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lNumeroDocumento);

        // DIRECCION DEL CLIENTE------------------------------------------------
        lDireccionCliente = sObjGraficos.construirJLabel(
                "Direccion:", 50, 720, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lDireccionCliente);

        // TELEFONO CLIENTE ----------------------------------------------------
        lTelefono = sObjGraficos.construirJLabel(
                "Telefono:", 50, 790, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTelefono);

        // TELEFONO OPCIONAL CLIENTE-------------------------------------------
        lTelefonoOpcional = sObjGraficos.construirJLabel(
                "Telefono (Opcional):", 50, 860, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTelefonoOpcional);

        // BORDE ----------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 40, 950, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);

        // DATOS VEHICULO ----------------------------------------------
        lDatosVehiculo = sObjGraficos.construirJLabel(
                "Datos Vehiculo", 0, 1000, 880, 40, null, Color.WHITE,
                null, sRecursos.getFontSeccion(), "c"
        );
        this.add(lDatosVehiculo);
        
        // TIPO DE VEHICULO ------------------------------------------------------------
        lTipoVehiculo = sObjGraficos.construirJLabel(
                "Tipo de Vehiculo:", 50, 1100, 880, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lTipoVehiculo);
        
        // PLACA/NUMERO DE SERIE VEHICULO ------------------------------------------------------------
        lPlaca = sObjGraficos.construirJLabel(
                "Placa/Numero de serie:", 50, 1170, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lPlaca);

        // MARCA DEL VEHICULO ------------------------------------------------------------
        lMarca = sObjGraficos.construirJLabel(
                "Marca:", 50, 1240, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lMarca);
        
        // COLOR DEL VEHICULO ------------------------------------------------
        lColor = sObjGraficos.construirJLabel(
                "Color:", 50, 1310, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lColor);
        
        // MODELO DEL VEHICULO ------------------------------
        lModelo = sObjGraficos.construirJLabel(
                "Modelo:", 50, 1380, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lModelo);

        // BORDE -------------------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 40, 1470, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);
        
        // DATOS CONTRATO  -------------------------------
        lDatosContrato = sObjGraficos.construirJLabel(
                "Datos Contrato", 0, 1520, 880, 40, null, Color.WHITE, 
                null, sRecursos.getFontSeccion(), "c"
        );
        this.add(lDatosContrato);
        
        // PERIODO DEL CONTRATO -------------------------------------------------
        lPeriodo = sObjGraficos.construirJLabel(
                "Periodo:", 50, 1590, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lPeriodo);

        // FECHA INICIO DEL CONTRATO -------------------------------------------------
        lFechaInicio = sObjGraficos.construirJLabel(
                "Fecha de inicio:", 50, 1660, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lFechaInicio);
        
        // FECHA FIN DEL CONTRATO  ------------------------------
        lFechaFin = sObjGraficos.construirJLabel(
                "Fecha de caducidad:", 50, 1730, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lFechaFin);

        // VALOR DEL CONTRATO -------------------------------------------
        lValor = sObjGraficos.construirJLabel(
                "Valor:", 50, 1800, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lValor);
        
        // ESTADO DEL CONTRATO ------------------------------------------------------------
        lEstadoContrato = sObjGraficos.construirJLabel(
                "Estado del contrato:", 50, 1870, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lEstadoContrato);

        // BORDE -------------------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 040, 1940, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public RegistrarContratoComponent getRegistrarContratoComponent() {
        return registrarContratoComponent;
    }

    public JTextField gettPrimerNombre() {
        return tPrimerNombre;
    }

    public JTextField gettSegundoNombre() {
        return tSegundoNombre;
    }

    public JTextField gettPrimerApellido() {
        return tPrimerApellido;
    }

    public JTextField gettSegundoApellido() {
        return tSegundoApellido;
    }

    public JTextField gettNumeroDocumento() {
        return tNumeroDocumento;
    }

    public JTextField gettDireccionCliente() {
        return tDireccionCliente;
    }

    public JTextField getTnNiveles() {
        return tnNiveles;
    }

    public JTextField getTnAutomoviles() {
        return tnAutomoviles;
    }

    public JTextField gettTelefono() {
        return tTelefono;
    }

    public JTextField gettTelefonoOpcional() {
        return tTelefonoOpcional;
    }

    public JTextField getTPlaca() {
        return TPlaca;
    }

    public JTextField getTMarca() {
        return TMarca;
    }

    public JTextField getTColor() {
        return TColor;
    }

    public JTextField getTModelo() {
        return TModelo;
    }

    public JTextField getTnFechaInicio() {
        return tnFechaInicio;
    }

    public JTextField getTnFechaFin() {
        return tnFechaFin;
    }

    public JTextField getTnValor() {
        return tnValor;
    }

    
    public JComboBox getCbTipoVehiculo() {
        return cbTipoVehiculo;
    }

    public JComboBox getCbSexo() {
        return cbSexo;
    }

    public JComboBox getCbPeriodo() {
        return cbPeriodo;
    }

    public JComboBox getCbTipoDocumento() {
        return cbTipoDocumento;
    }

    public JComboBox getCbEstadoContrato() {
        return cbEstadoContrato;
    }

    public JButton getbRegistrarContrato() {
        return bRegistrarContrato;
    }

    public JButton getbLimpiar() {
        return bLimpiar;
    }

    

}
