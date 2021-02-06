package app.client.components.registrarParqueadero;

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

public class RegistrarParqueaderoTemplate extends JPanel {

    private RegistrarParqueaderoComponent registrarParqueaderoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JLabel lTitulo, lDatosBasicos, lEstado, lCupostnAutomoviles, lBorde,
            lAutomoviles, lCamperos, lCamionetas, lVehiculosPesados, lDireccion,
            lMotocicletas, lBicicletas, lNombreParqueadero, lClave, lElevacion,
            lLocalidad, lNumeroNiveles, lTipoSuelo, lFactorDemandaZonal, 
            lVMPMAutomoviles, lVMPMCamperos, lVMPMCamionetas, lVMPMBicicletas,
            lVMPMVehiculosPesados, lVMPMMotocicletas;            
    private JTextField tNombreParqueadero, tClaveParqueadero, tDireccion, 
            tnNiveles, tnAutomoviles, tnCamperos, tnCamionetas, 
            tnVehiculosPesados, tnMotocicletas, tnBicicletas, tnVMPMAutomoviles, 
            tnVMPMCamperos, tnVMPMCamionetas, tnVMPMVehiculosPesados, 
            tnVMPMMotocicletas, tnVMPMBicicletas;
    private JComboBox cbTipoSuelo, cbLocalidad, cbFactorDemandaZonal,
            cbTipoParqueadero, cbEstado;
    private JButton bRegistrarParqueadero, bLimpiar;

    public RegistrarParqueaderoTemplate(RegistrarParqueaderoComponent registrarParqueaderoComponent) {
        this.registrarParqueaderoComponent = registrarParqueaderoComponent;
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
        // NOMBRE PARQUEADERO ----------------------------------------------
        tNombreParqueadero = sObjGraficos.construirJTextField(
                "Nombre del parqueadero", 350, 230, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tNombreParqueadero.setBorder(sRecursos.getBordeNaranja());
        tNombreParqueadero.addFocusListener(registrarParqueaderoComponent);
        this.add(tNombreParqueadero);

        // CONTRASEÑA PARQUEADERO ----------------------------------------------
        tClaveParqueadero = sObjGraficos.construirJTextField(
                "Contraseña del parqueadero", 350, 300, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tClaveParqueadero.setBorder(sRecursos.getBordeNaranja());
        tClaveParqueadero.addFocusListener(registrarParqueaderoComponent);
        this.add(tClaveParqueadero);

        // DIRECCIÓN -------------------------------------------------------
        tDireccion = sObjGraficos.construirJTextField(
                "Dirección", 350, 370, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tDireccion.setBorder(sRecursos.getBordeNaranja());
        tDireccion.addFocusListener(registrarParqueaderoComponent);
        this.add(tDireccion);

        // CANTIDAD DE NIVELES ----------------------------------------------
        tnNiveles = sObjGraficos.construirJTextField(
                "Número de Niveles", 350, 580, 470, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tnNiveles.setBorder(sRecursos.getBordeNaranja());
        tnNiveles.addFocusListener(registrarParqueaderoComponent);
        this.add(tnNiveles);

        // AUTOMÓVILES CUPOS -------------------------------------------------
        tnAutomoviles = sObjGraficos.construirJTextField(
                "Número de cupos de Automóviles", 350, 1030, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnAutomoviles.setBorder(sRecursos.getBordeNaranja());
        tnAutomoviles.addFocusListener(registrarParqueaderoComponent);
        this.add(tnAutomoviles);
        
        // AUTOMÓVILES VALOR MÁXIMO POR MINUTO -------------------------------
        tnVMPMAutomoviles = sObjGraficos.construirJTextField(
                "Valor Máximo Por Minuto de Automóviles", 350, 1100, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVMPMAutomoviles.setBorder(sRecursos.getBordeNaranja());
        tnVMPMAutomoviles.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVMPMAutomoviles);

        // CAMPEROS CUPOS -------------------------------------------------
        tnCamperos = sObjGraficos.construirJTextField(
                "Número de cupos de Camperos", 350, 1170, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnCamperos.setBorder(sRecursos.getBordeNaranja());
        tnCamperos.addFocusListener(registrarParqueaderoComponent);
        this.add(tnCamperos);
        
        // CAMPEROS VALOR MÁXIMO POR MINUTO --------------------------------
        tnVMPMCamperos = sObjGraficos.construirJTextField(
                "Valor Máximo Por Minuto de Camperos", 350, 1240, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVMPMCamperos.setBorder(sRecursos.getBordeNaranja());
        tnVMPMCamperos.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVMPMCamperos);

        // CAMIONETAS CUPOS -------------------------------------------------
        tnCamionetas = sObjGraficos.construirJTextField(
                "Número de cupos de Camionetas", 350, 1310, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnCamionetas.setBorder(sRecursos.getBordeNaranja());
        tnCamionetas.addFocusListener(registrarParqueaderoComponent);
        this.add(tnCamionetas);
        
        // CAMIONETAS VALOR MÁXIMO POR MINUTO -------------------------------
        tnVMPMCamionetas = sObjGraficos.construirJTextField(
                "Valor Máximo Por Minuto de Camionetas", 350, 1380, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVMPMCamionetas.setBorder(sRecursos.getBordeNaranja());
        tnVMPMCamionetas.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVMPMCamionetas);

        // VEHÍCULOS PESADOS CUPOS ----------------------------------------
        tnVehiculosPesados = sObjGraficos.construirJTextField(
                "Número de cupos de Vehículos Pesados", 350, 1450, 470, 40,
                null, Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVehiculosPesados.setBorder(sRecursos.getBordeNaranja());
        tnVehiculosPesados.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVehiculosPesados);
        
        // VEHÍCULOS PESADOS VALOR MÁXIMO POR MINUTO -------------------------
        tnVMPMVehiculosPesados = sObjGraficos.construirJTextField(
                "Valor Máximo Por Minuto de Vehículos Pesados", 350, 1520, 470, 40,
                null, Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVMPMVehiculosPesados.setBorder(sRecursos.getBordeNaranja());
        tnVMPMVehiculosPesados.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVMPMVehiculosPesados);

        // MOTOCICLETAS CUPOS ------------------------------------------------
        tnMotocicletas = sObjGraficos.construirJTextField(
                "Número de cupos de Motocicletas", 350, 1590, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnMotocicletas.setBorder(sRecursos.getBordeNaranja());
        tnMotocicletas.addFocusListener(registrarParqueaderoComponent);
        this.add(tnMotocicletas);
        
        // MOTOCICLETAS VALOR MÁXIMO POR MINUTO -----------------------------
        tnVMPMMotocicletas = sObjGraficos.construirJTextField(
                "Valor Máximo Por Minuto de Motocicletas", 350, 1660, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVMPMMotocicletas.setBorder(sRecursos.getBordeNaranja());
        tnVMPMMotocicletas.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVMPMMotocicletas);

        // BICICLETAS CUPOS -------------------------------------------------
        tnBicicletas = sObjGraficos.construirJTextField(
                "Número de cupos de Bicicletas", 350, 1730, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnBicicletas.setBorder(sRecursos.getBordeNaranja());
        tnBicicletas.addFocusListener(registrarParqueaderoComponent);
        this.add(tnBicicletas);
        
        // BICICLETAS VALOR MÁXIMO POR MINUTO -------------------------------
        tnVMPMBicicletas = sObjGraficos.construirJTextField(
                "Valor Máximo Por Minuto de Bicicletas", 350, 1800, 470, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tnVMPMBicicletas.setBorder(sRecursos.getBordeNaranja());
        tnVMPMBicicletas.addFocusListener(registrarParqueaderoComponent);
        this.add(tnVMPMBicicletas);
    }

    public void crearJButtons() {
        // BOTÓN REGISTRAR PARQUEADERO ---------------------------------------
        bRegistrarParqueadero = sObjGraficos.construirJButton(
                "Registrar Parqueadero", (880 - 300) / 2, 1960, 300, 60,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white, null,
                "C", true
        );
        bRegistrarParqueadero.addMouseListener(registrarParqueaderoComponent);
        bRegistrarParqueadero.addActionListener(registrarParqueaderoComponent);
        this.add(bRegistrarParqueadero);

        // BOTÓN LIMPIAR -----------------------------------------------------
        bLimpiar = sObjGraficos.construirJButton(
                "Limpiar", (880 - 100) / 2, 2075, 100, 30,
                sRecursos.getcMano(), null, sRecursos.getFontText(),
                sRecursos.getColorGris(), Color.WHITE, null,
                "C", true
        );
        bLimpiar.addMouseListener(registrarParqueaderoComponent);
        bLimpiar.addActionListener(registrarParqueaderoComponent);
        this.add(bLimpiar);
    }

    public void crearJComboBox() {
        // LOCALIDAD -------------------------------------------------------
        cbLocalidad = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Usaquen_Chapinero_Santa Fe_San Cristobal"
                + "_Usme_Tunjuelito_Bosa_Kennedy_Fontibon_Engativa_Suba_Barrios"
                + " Unidos_Teusaquillo_Los Martires_Antonio Nariño_Puente "
                + "Aranda_La Candelaria_Rafael Uribe Uribe_Ciudad Bolívar_"
                + "Sumapaz", 350, 440, 470, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbLocalidad.setFont(sRecursos.getFontText());
        cbLocalidad.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbLocalidad.addFocusListener(registrarParqueaderoComponent);
        this.add(cbLocalidad);

        // TIPO DE PARQUEADERO ------------------------------------------------
        cbTipoParqueadero = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Subterraneo_Elevación", 350, 510, 470,
                40, Color.WHITE, Color.BLACK, "c"
        );
        cbTipoParqueadero.setFont(sRecursos.getFontText());
        cbTipoParqueadero.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbTipoParqueadero.addFocusListener(registrarParqueaderoComponent);
        this.add(cbTipoParqueadero);

        // TIPO DE SUELO ----------------------------------------------------
        cbTipoSuelo = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Asfalto_Concreto_Suelo en afirmado_"
                + "Cesped_Gravilla lavada de rio compactada", 350, 650, 470,
                40, Color.WHITE, Color.BLACK, "c"
        );
        cbTipoSuelo.setFont(sRecursos.getFontText());
        cbTipoSuelo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbTipoSuelo.addFocusListener(registrarParqueaderoComponent);
        this.add(cbTipoSuelo);

        // FACTOR DEMANDA ZONAL ----------------------------------------------
        cbFactorDemandaZonal = sObjGraficos.construirJComboBox(
                "Seleccione una opción_0,8_1", 350, 720, 470, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbFactorDemandaZonal.setFont(sRecursos.getFontText());
        cbFactorDemandaZonal.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbFactorDemandaZonal.addFocusListener(registrarParqueaderoComponent);
        this.add(cbFactorDemandaZonal);

        // ESTADO ------------------------------------------------------------
        cbEstado = sObjGraficos.construirJComboBox(
                "Seleccione una opción_Abierto_Cerrado", 350, 790, 470, 40,
                Color.WHITE, Color.BLACK, "c"
        );
        cbEstado.setFont(sRecursos.getFontText());
        cbEstado.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbEstado.addFocusListener(registrarParqueaderoComponent);
        this.add(cbEstado);
    }

    public void crearJLabels() {
        // TITULO -------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Registrar Parqueadero", 0, 20, 880, 80, null,
                sRecursos.getColorNaranja(), null,
                sRecursos.getFontTituloUsuario(), "c"
        );
        this.add(lTitulo);

        // DATOS BÁSICOS ------------------------------------------------------
        lDatosBasicos = sObjGraficos.construirJLabel(
                "Datos Básicos", 0, 150, 880, 40, null, Color.WHITE, null,
                sRecursos.getFontSeccion(), "c"
        );
        this.add(lDatosBasicos);

        // NOMBRE PARQUEADERO -------------------------------------------------
        lNombreParqueadero = sObjGraficos.construirJLabel(
                "Nombre Parqueadero:", 50, 230, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lNombreParqueadero);

        // CONTRASEÑA PARQUEADERO ---------------------------------------------
        lClave = sObjGraficos.construirJLabel(
                "Contraseña Parqueadero:", 50, 300, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lClave);

        // DIRECCIÓN ---------------------------------------------------------
        lDireccion = sObjGraficos.construirJLabel(
                "Dirección:", 50, 370, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lDireccion);

        // LOCALIDAD ---------------------------------------------------------
        lLocalidad = sObjGraficos.construirJLabel(
                "Localidad:", 50, 440, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lLocalidad);

        // ELEVACIÓN ---------------------------------------------------------
        lElevacion = sObjGraficos.construirJLabel(
                "Tipo de Parqueadero:", 50, 510, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lElevacion);

        // CANTIDAD DE NIVELES -----------------------------------------------
        lNumeroNiveles = sObjGraficos.construirJLabel(
                "Cantidad de Niveles:", 50, 580, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lNumeroNiveles);

        // TIPO DE SUELO ----------------------------------------------------
        lTipoSuelo = sObjGraficos.construirJLabel(
                "Tipo de Suelo:", 50, 650, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lTipoSuelo);

        // FACTOR DEMANDA ZONAL ----------------------------------------------
        lFactorDemandaZonal = sObjGraficos.construirJLabel(
                "Factor de Demanda Zonal:", 50, 720, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lFactorDemandaZonal);

        // ESTADO ------------------------------------------------------------
        lEstado = sObjGraficos.construirJLabel(
                "Estado:", 50, 790, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lEstado);

        // BORDE -------------------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 40, 880, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);

        // AREAS Y VALOR MÁXIMO POR MINUTO -----------------------------------
        lCupostnAutomoviles = sObjGraficos.construirJLabel(
                "Áreas Y Valor máximo por minuto", 0, 930, 880, 40, null, 
                Color.WHITE, null, sRecursos.getFontSeccion(), "c"
        );
        this.add(lCupostnAutomoviles);
        
        // AUTOMÓVILES CUPOS ------------------------------------------------
        lAutomoviles = sObjGraficos.construirJLabel(
                "Automóviles:", 50, 1030, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lAutomoviles);
        
        // AUTOMÓVILES VALOR MÁXIMO POR MINUTO ------------------------------
        lVMPMAutomoviles = sObjGraficos.construirJLabel(
                "VMPM -> Automóviles:", 50, 1100, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVMPMAutomoviles);

        // CAMPEROS CUPOS -------------------------------------------------
        lCamperos = sObjGraficos.construirJLabel(
                "Camperos:", 50, 1170, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lCamperos);
        
        // CAMPEROS VALOR MÁXIMO POR MINUTO  -------------------------------
        lVMPMCamperos = sObjGraficos.construirJLabel(
                "VMPM -> Camperos:", 50, 1240, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVMPMCamperos);

        // CAMIONETAS CUPOS -------------------------------------------------
        lCamionetas = sObjGraficos.construirJLabel(
                "Camionetas:", 50, 1310, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lCamionetas);
        
        // CAMIONETAS VALOR MÁXIMO POR MINUTO  ------------------------------
        lVMPMCamionetas = sObjGraficos.construirJLabel(
                "VMPM -> Camionetas:", 50, 1380, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVMPMCamionetas);

        // VEHÍCULOS PESADOS CUPOS -------------------------------------------
        lVehiculosPesados = sObjGraficos.construirJLabel(
                "Vehículos Pesados:", 50, 1450, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVehiculosPesados);
        
        // VEHÍCULOS PESADOS VALOR MÁXIMO POR MINUTO -------------------------
        lVMPMVehiculosPesados = sObjGraficos.construirJLabel(
                "VMPM -> Vehículos Pesados:", 50, 1520, 260, 40, null, 
                Color.WHITE, null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVMPMVehiculosPesados);

        // MOTOCICLETAS CUPOS -------------------------------------------------
        lMotocicletas = sObjGraficos.construirJLabel(
                "Motocicletas:", 50, 1590, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lMotocicletas);

        // MOTOCICLETAS VALOR MÁXIMO POR MINUTO ------------------------------
        lVMPMMotocicletas = sObjGraficos.construirJLabel(
                "VMPM -> Motocicletas:", 50, 1660, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVMPMMotocicletas);
        
        // BICICLETAS CUPOS -------------------------------------------------
        lBicicletas = sObjGraficos.construirJLabel(
                "Bicicletas:", 50, 1730, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lBicicletas);
        
        // BICICLETAS VALOR MÁXIMO POR MINUTO -------------------------------
        lVMPMBicicletas = sObjGraficos.construirJLabel(
                "VMPM -> Bicicletas:", 50, 1800, 260, 40, null, Color.WHITE, 
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lVMPMBicicletas);

        // BORDE -------------------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 40, 1900, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public RegistrarParqueaderoComponent getRegistrarParqueaderoComponent() {
        return registrarParqueaderoComponent;
    }

    public JTextField gettNombreParqueadero() {
        return tNombreParqueadero;
    }

    public JTextField gettDireccion() {
        return tDireccion;
    }

    public JTextField getTnNiveles() {
        return tnNiveles;
    }

    public JTextField getTnAutomoviles() {
        return tnAutomoviles;
    }

    public JTextField getTnCamperos() {
        return tnCamperos;
    }

    public JTextField getTnCamionetas() {
        return tnCamionetas;
    }

    public JTextField getTnVehiculosPesados() {
        return tnVehiculosPesados;
    }

    public JTextField getTnMotocicletas() {
        return tnMotocicletas;
    }

    public JTextField getTnBicicletas() {
        return tnBicicletas;
    }

    public JComboBox getCbTipoSuelo() {
        return cbTipoSuelo;
    }

    public JComboBox getCbLocalidad() {
        return cbLocalidad;
    }

    public JComboBox getCbFactorDemandaZonal() {
        return cbFactorDemandaZonal;
    }

    public JComboBox getCbTipoParqueadero() {
        return cbTipoParqueadero;
    }

    public JTextField gettClaveParqueadero() {
        return tClaveParqueadero;
    }

    public JComboBox getCbEstado() {
        return cbEstado;
    }

    public JButton getbRegistrarParqueadero() {
        return bRegistrarParqueadero;
    }

    public JButton getbLimpiar() {
        return bLimpiar;
    }

    public JTextField getTnVMPMAutomoviles() {
        return tnVMPMAutomoviles;
    }

    public JTextField getTnVMPMCamperos() {
        return tnVMPMCamperos;
    }

    public JTextField getTnVMPMCamionetas() {
        return tnVMPMCamionetas;
    }

    public JTextField getTnVMPMVehiculosPesados() {
        return tnVMPMVehiculosPesados;
    }

    public JTextField getTnVMPMMotocicletas() {
        return tnVMPMMotocicletas;
    }

    public JTextField getTnVMPMBicicletas() {
        return tnVMPMBicicletas;
    }

    
}
