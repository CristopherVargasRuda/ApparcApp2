package app.client.components.consultaEstadisticas.cantidadServicios;

import app.client.components.consultaEstadisticas.recaudo.EstadisticaRecaudoComponent;
import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class EstadisticaCantidadServiciosTemplate extends JPanel {

    private EstadisticaCantidadServiciosComponent estadisticaCantidadVehiculosComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JTextField tTotalVehiculos, tTotalServicios;
    private JComboBox cbDiaInicio, cbMesInicio, cbAnioInicio, cbPeriodo;
    private JLabel lTotalVehiculos, lTotalServicios;
    private JButton bConfirmar;

    //Objetos Tabla
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera = {"Parqueadero", "Vehiculo", "Fecha de Ingreso",
        "Hora de Ingreso"};

    public EstadisticaCantidadServiciosTemplate(EstadisticaCantidadServiciosComponent estadisticaCantidadVehiculosComponent) {
        this.estadisticaCantidadVehiculosComponent = estadisticaCantidadVehiculosComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJComboBox();
        this.crearJLabels();
        this.crearJTable();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(880, 700));
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJTextFields() {
        // TOTAL VEHICULOS ----------------------------------------------
        tTotalVehiculos = sObjGraficos.construirJTextField(
                "", 430, 180, 200, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tTotalVehiculos.setEnabled(false);
        this.add(tTotalVehiculos);

        // TOTAL SERVICIOS ----------------------------------------------
        tTotalServicios = sObjGraficos.construirJTextField(
                "", 430, 250, 200, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tTotalServicios.setEnabled(false);
        this.add(tTotalServicios);
    }

    public void crearJButtons() {
        // BOTÓN CONFIRMAR ---------------------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "Confirmar", 700, 45, 150, 50, sRecursos.getcMano(), null,
                sRecursos.getFontBoton(), sRecursos.getColorNaranja(),
                Color.white, null, "c", true
        );
        bConfirmar.addMouseListener(estadisticaCantidadVehiculosComponent);
        bConfirmar.addActionListener(estadisticaCantidadVehiculosComponent);
        this.add(bConfirmar);
    }

    public void crearJComboBox() {
        String texto = "";
        for (int i = 0; i < 31; i++) {
            texto = texto + "_" + i;
        }

        // DIA ------------------------------------------------
        cbDiaInicio = sObjGraficos.construirJComboBox(
                "Día" + texto, 50, 50, 100, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbDiaInicio.setFont(sRecursos.getFontText());
        cbDiaInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbDiaInicio.addFocusListener(estadisticaCantidadVehiculosComponent);
        this.add(cbDiaInicio);

        // MES ------------------------------------------------
        cbMesInicio = sObjGraficos.construirJComboBox(
                "Mes_Enero_Febrero_Marzo_Abril_Mayo_Junio_Julio_Agosto_"
                + "Setptiembre_Octubre_Noviembre_Diciembre", 150, 50,
                150, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbMesInicio.setFont(sRecursos.getFontText());
        cbMesInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbMesInicio.addFocusListener(estadisticaCantidadVehiculosComponent);
        this.add(cbMesInicio);

        // AÑO ------------------------------------------------
        cbAnioInicio = sObjGraficos.construirJComboBox(
                "Año_2017_2018_2019_2020_2021", 300, 50, 100, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbAnioInicio.setFont(sRecursos.getFontText());
        cbAnioInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbAnioInicio.addFocusListener(estadisticaCantidadVehiculosComponent);
        this.add(cbAnioInicio);

        // PERIODO ------------------------------------------------
        cbPeriodo = sObjGraficos.construirJComboBox(
                "Periodo_Día_Mes_Año", 480, 50, 150, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbPeriodo.setFont(sRecursos.getFontText());
        cbPeriodo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbPeriodo.addFocusListener(estadisticaCantidadVehiculosComponent);
        this.add(cbPeriodo);
    }

    public void crearJLabels() {
        // VEHICULO ----------------------------------------------------
        lTotalVehiculos = sObjGraficos.construirJLabel(
                "Total Vehículos:", 250, 180, 150, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTotalVehiculos);

        // SERVICIOS ----------------------------------------------------
        lTotalServicios = sObjGraficos.construirJLabel(
                "Total Servicios:", 250, 250, 150, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTotalServicios);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(estadisticaCantidadVehiculosComponent);
        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(800, 30));

        pTabla = sObjGraficos.construirPanelBarra(
                tabla, 50, 350, 780, 300, Color.WHITE, null
        );

        header.setDefaultRenderer(
                sGraficosAvanzados.devolverTablaPersonalizada(
                        sRecursos.getColorNaranja(), null, null, Color.WHITE,
                        sRecursos.getFontLigera()
                )
        );

        tabla.setDefaultRenderer(
                Object.class,
                sGraficosAvanzados.devolverTablaPersonalizada(
                        Color.WHITE, sRecursos.getColorGrisClaro(),
                        sRecursos.getColorNaranja(),
                        sRecursos.getColorGrisOscuro(),
                        sRecursos.getFontLigera()
                )
        );

        pTabla.getVerticalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10, Color.WHITE, sRecursos.getColorNaranja(),
                        sRecursos.getColorSeleccion()
                )
        );

        pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorNaranja());
        pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        this.add(pTabla);
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JTextField gettTotalVehiculos() {
        return tTotalVehiculos;
    }

    public JComboBox getCbDiaInicio() {
        return cbDiaInicio;
    }

    public JComboBox getCbMesInicio() {
        return cbMesInicio;
    }

    public JComboBox getCbAnioInicio() {
        return cbAnioInicio;
    }

    public JComboBox getCbPeriodo() {
        return cbPeriodo;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }

    public JScrollPane getpTabla() {
        return pTabla;
    }

    public JPanel getpCorner() {
        return pCorner;
    }

    public JTable getTabla() {
        return tabla;
    }

    public JTableHeader getHeader() {
        return header;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

}
