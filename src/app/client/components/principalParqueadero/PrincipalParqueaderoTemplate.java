package app.client.components.principalParqueadero;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PrincipalParqueaderoTemplate extends JPanel {

    private PrincipalParqueaderoComponent principalParqueaderoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JLabel lTitulo, lBorde, lDireccion, lLocalidad, lTipoParqueadero, lNumeroNiveles, lTipoSuelo,
                   lFactorDemandaZonal, lEstado, lAereas;
    private JTextField tTipoParqueadero, tCantidadNiveles, tTipoSuelo, tFactorDemandaZonal, tEstado;

    // Declaración objetos para JTable -----------------------------------------------
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String [] cabecera={"id", "Tipo Vehiculo", "Total Cupos", "Disponibles"};


    public PrincipalParqueaderoTemplate(PrincipalParqueaderoComponent principalParqueaderoComponent) {
        this.principalParqueaderoComponent = principalParqueaderoComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();        

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJButtons();
        this.crearJCheckBoxes();
        this.crearJLabels();
        this.crearJTable();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(880, 1000));
        this.setVisible(true);
    }

    public void crearJTable(){
         this.modelo = new DefaultTableModel();
        this.modelo.setColumnIdentifiers(this.cabecera);
        this.tabla = new JTable();
        this.tabla.setModel(this.modelo);
        this.tabla.addMouseListener(this.principalParqueaderoComponent);
        this.tabla.setRowHeight(40);
        this.tabla.setShowHorizontalLines(false);
        this.tabla.setShowVerticalLines(false);
        this.header = this.tabla.getTableHeader();
        this.header.setPreferredSize(new Dimension(580, 30));
        this.pTabla = this.sObjGraficos.construirPanelBarra(this.tabla, 160, 600, 580, 370, Color.WHITE, (Border)null);
//        this.header.setDefaultRenderer(this.sGraficosAvanzados.devolverTablaPersonalizada(this.sRecursos.getColorAzulOscuro(), (Color)null, (Color)null, Color.WHITE, this.sRecursos.getFontComponente()));
//        this.tabla.setDefaultRenderer(Object.class, this.sGraficosAvanzados.devolverTablaPersonalizada(Color.WHITE, this.sRecursos.getColorGris(), this.sRecursos.getColorAzulOscuro(), this.sRecursos.getColorNaranja(), this.sRecursos.getFontText()));
//        this.pTabla.getVerticalScrollBar().setUI(this.sGraficosAvanzados.devolverScrollPersonalizado(7, 10, Color.WHITE, Color.GRAY, this.sRecursos.getColorRojo()));
        this.pCorner = new JPanel();
        this.pCorner.setBackground(this.sRecursos.getColorNaranja());
        this.pTabla.setCorner("UPPER_RIGHT_CORNER", this.pCorner);
        this.add(this.pTabla);
    }

    public void crearObjetosDecoradores() {
        
    }

    public void crearJPanels() {

    }

    public void crearJTextFields() {
        // TIPO DE PARQUEADERO -------------------------------------------------
        tTipoParqueadero = sObjGraficos.construirJTextField(
                "Tipo Parqueadero", 470, 170, 250, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tTipoParqueadero.setBorder(sRecursos.getBordeNaranja());
        tTipoParqueadero.setEnabled(false);
        tTipoParqueadero.setFocusable(false);
        this.add(tTipoParqueadero);
        
        // CANTIDAD NIVELES ----------------------------------------------------
        tCantidadNiveles = sObjGraficos.construirJTextField(
                "Cantidad niveles", 470, 240, 250, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tCantidadNiveles.setBorder(sRecursos.getBordeNaranja());
        tCantidadNiveles.setEnabled(false);
        tCantidadNiveles.setFocusable(false);
        this.add(tCantidadNiveles);
        
        // TIPO DE SUELO -------------------------------------------------------
        tTipoSuelo = sObjGraficos.construirJTextField(
                "Tipo De Suelo", 470, 310, 250, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tTipoSuelo.setBorder(sRecursos.getBordeNaranja());
        tTipoSuelo.setEnabled(false);
        tTipoSuelo.setFocusable(false);
        this.add(tTipoSuelo);
        
        // FACTOR ZONAL --------------------------------------------------------
        tFactorDemandaZonal = sObjGraficos.construirJTextField(
                "Factor Zonal", 470, 380, 250, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tFactorDemandaZonal.setBorder(sRecursos.getBordeNaranja());
        tFactorDemandaZonal.setEnabled(false);
        tFactorDemandaZonal.setFocusable(false);
        this.add(tFactorDemandaZonal);
        
        // ESTADO --------------------------------------------------------------
        tEstado = sObjGraficos.construirJTextField(
                "Estado", 470, 450, 250, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tEstado.setBorder(sRecursos.getBordeNaranja());
        tEstado.setEnabled(false);
        tEstado.setFocusable(false);
        this.add(tEstado);
    }

    public void crearJPasswordFields() {

    }

    public void crearJButtons() {

    }

    public void crearJCheckBoxes() {

    }

    public void crearJLabels() {
        // NOMBRE PARQUEADERO---------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Nombre Parqueadero", 0, 20, 880, 80, null,
                sRecursos.getColorNaranja(), null,
                sRecursos.getFontTituloUsuario(), "c"
        );
        this.add(lTitulo);
        
        // DIRECCIÓN -----------------------------------------------------------
        lDireccion = sObjGraficos.construirJLabel(
                "Dirección", 470, 100, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lDireccion);
        
        // LOCALIDAD -----------------------------------------------------------
        lLocalidad = sObjGraficos.construirJLabel(
                "Localidad", 170, 100, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lLocalidad);
        
        // DIVISION ------------------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 40, 140, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);
        
        // TIPO PARQUEADERO ----------------------------------------------------
        lTipoParqueadero = sObjGraficos.construirJLabel(
                "Tipo de Parqueadero:", 170, 170, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTipoParqueadero);
        
        // CANTIDAD DE NIVELES -------------------------------------------------
        lNumeroNiveles = sObjGraficos.construirJLabel(
                "Cantidad de Niveles:", 170, 240, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lNumeroNiveles);
        
        // TIPO DE SUELO -------------------------------------------------------
        lTipoSuelo = sObjGraficos.construirJLabel(
                "Tipo de Suelo:", 170, 310, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lTipoSuelo);
        
        // FACTOR DEMANDA ZONAL ----------------------------------------------
        lFactorDemandaZonal = sObjGraficos.construirJLabel(
                "Factor de Demanda Zonal:", 170, 380, 260, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lFactorDemandaZonal);

        // ESTADO ------------------------------------------------------------
        lEstado = sObjGraficos.construirJLabel(
                "Estado:", 170, 450, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lEstado);
        
        // DIVISION ------------------------------------------------------------
        lBorde = sObjGraficos.construirJLabel(
                null, 40, 510, 800, 5, null, null, null, null, "l"
        );
        lBorde.setBorder(sRecursos.getBordeSeccion());
        this.add(lBorde);

        // SUBTITULO -----------------------------------------------------------
        lAereas = sObjGraficos.construirJLabel(
                "Áreas", 0, 550, 880, 40, null, Color.WHITE, null,
                sRecursos.getFontSeccion(), "c"
        );
        this.add(lAereas);
    }

    // SETTERS ------------------------------------------------------------------
    public void setTitulo(String nombreParqueadero) {
        lTitulo.setText(nombreParqueadero);
    }
    public void setLocalidad(String localidad) {
        lLocalidad.setText(localidad);
    }
    public void setDireccion(String direccion) {
        lDireccion.setText(direccion);
    }
    public void setTipoParqueadero(String tipoParqueadero) {
        tTipoParqueadero.setText(tipoParqueadero);
    }
    public void setCantidadNiveles(int cantidadNiveles) {
        tCantidadNiveles.setText(String.valueOf(cantidadNiveles));
    }
    public void setTipoSuelo(String tipoSuelo) {
        tTipoSuelo.setText(tipoSuelo);
    }
    public void setFactorDemandaZonal(String factorDemandaZonal) {
        tFactorDemandaZonal.setText(factorDemandaZonal);
    }
    public void setEstado(boolean estado) {
        String sEstado = "Cerrado";
        if(estado){
            sEstado = "Abierto";
        }
        tEstado.setText(sEstado);
    }
}
