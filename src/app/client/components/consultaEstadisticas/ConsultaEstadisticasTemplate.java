package app.client.components.consultaEstadisticas;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import app.services.GraficosAvanzadosService;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ConsultaEstadisticasTemplate extends JPanel {

    private ConsultaEstadisticasComponent consultaEstadisticasComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JPanel pSuperior, pInferior;
    private JButton bEntradasYSalidas, bCantidadServicios, bRecaudo;
    private JLabel lTitulo;
    private JScrollPane scrollpane;

    public ConsultaEstadisticasTemplate(ConsultaEstadisticasComponent consultaEstadisticasComponent) {
        this.consultaEstadisticasComponent = consultaEstadisticasComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJPanels();
        this.crearJButtons();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setSize(900, 530);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJPanels() {
        pSuperior = sObjGraficos.construirJPanel(0, 0, 900, 50,
                sRecursos.getColorAzulOscuro(),
                BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK)
        );
        this.add(pSuperior);

        pInferior = sObjGraficos.construirJPanel(0, 50, 900, 480,
                sRecursos.getColorAzulOscuro(),
                BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK)
        );
        this.add(pInferior);
    }

    public void crearJButtons() {
        // BOTÓN ENTRADAS Y SALIDAS ------------------------------------------
        bEntradasYSalidas = sObjGraficos.construirJButton(
                "Entradas y Salidas", 0, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white,
                BorderFactory.createMatteBorder(0, 2, 2, 1, Color.BLACK), "C",
                true
        );
        bEntradasYSalidas.addActionListener(consultaEstadisticasComponent);
        bEntradasYSalidas.addMouseListener(consultaEstadisticasComponent);
        pSuperior.add(bEntradasYSalidas);

        // BOTÓN CANTIDAD SERVICIOS ---------------------------------------
        bCantidadServicios = sObjGraficos.construirJButton(
                "Cantidad de Servicios", 300, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white,
                BorderFactory.createMatteBorder(0, 1, 2, 1, Color.BLACK), "C",
                true
        );
        bCantidadServicios.addActionListener(consultaEstadisticasComponent);
        bCantidadServicios.addMouseListener(consultaEstadisticasComponent);
        pSuperior.add(bCantidadServicios);

        // BOTÓN RECAUDO ------------------------------------------
        bRecaudo = sObjGraficos.construirJButton(
                "Recaudos", 600, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white,
                BorderFactory.createMatteBorder(0, 1, 2, 2, Color.BLACK), "C",
                true
        );
        bRecaudo.addActionListener(consultaEstadisticasComponent);
        bRecaudo.addMouseListener(consultaEstadisticasComponent);
        pSuperior.add(bRecaudo);
    }

    public void crearScrollpane(JPanel panel) {
        this.scrollpane = sObjGraficos.construirPanelBarra(panel, 0, 0, 898, 480, null, null);
        this.scrollpane.getVerticalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
                7, 10, Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getColorSeleccion())
        );
        this.pInferior.add(scrollpane);
        this.scrollpane.revalidate();
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JPanel getpInferior() {
        return pInferior;
    }

    public JButton getbEntradasYSalidas() {
        return bEntradasYSalidas;
    }

    public JButton getbRecaudo() {
        return bRecaudo;
    }

    public JButton getbCantidadServicios() {
        return bCantidadServicios;
    }

}
