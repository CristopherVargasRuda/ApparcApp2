package app.client.components.consultaProcesos.contratos;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ConsultaContratosTemplate extends JPanel {

    private ConsultaContratosComponent consultaContratosComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    //Objetos Tabla
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera = {"idContrato", "Valor Pago", "Fecha Inicio", 
        "Fecha Final", "Periodo", "Nombre Cliente", "Identificación", 
        "Placa Vehículo"};

    public ConsultaContratosTemplate(ConsultaContratosComponent consultaContratosComponent) {
        this.consultaContratosComponent = consultaContratosComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTable();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(1500, 460));
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(consultaContratosComponent);
        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(800, 30));

        pTabla = sObjGraficos.construirPanelBarra(tabla, 50, 50, 1400, 380, Color.WHITE, null);

        header.setDefaultRenderer(
                sGraficosAvanzados.devolverTablaPersonalizada(
                        sRecursos.getColorNaranja(), null, null, Color.WHITE,
                        sRecursos.getFontLigera()
                )
        );

        tabla.setDefaultRenderer(
                Object.class,
                sGraficosAvanzados.devolverTablaPersonalizada(
                        Color.WHITE, sRecursos.getColorNavegacionFondo(),
                        sRecursos.getColorNaranja(),
                        Color.BLACK,
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

    public JScrollPane getpTabla() {
        return pTabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

}
