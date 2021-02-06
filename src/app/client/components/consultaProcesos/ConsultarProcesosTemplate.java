package app.client.components.consultaProcesos;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ConsultarProcesosTemplate extends JPanel {

    private ConsultarProcesosComponent consultarProcesosComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;
    
    private JPanel pSuperior, pInferior;
    private JButton bVehiculos, bParqueaderos, bContratos;
    private JLabel lTitulo;
    private JScrollPane scrollpane;

    public ConsultarProcesosTemplate(ConsultarProcesosComponent consultarProcesosComponent) {
        this.consultarProcesosComponent = consultarProcesosComponent;
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
        
    public void crearJPanels(){
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
    
    public void crearJButtons(){
        // BOTÓN ENTRADAS Y SALIDAS ------------------------------------------
        bVehiculos = sObjGraficos.construirJButton(
                "Vehiculos", 0, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white, 
                BorderFactory.createMatteBorder(0, 2, 2, 1, Color.BLACK), "C", 
                true
        );
        bVehiculos.addActionListener(consultarProcesosComponent);
        bVehiculos.addMouseListener(consultarProcesosComponent);
        pSuperior.add(bVehiculos);
        
        // BOTÓN PARQUEADEROS ------------------------------------------
        bParqueaderos = sObjGraficos.construirJButton(
                "Parqueaderos", 300, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white,  
                BorderFactory.createMatteBorder(0, 1, 2, 1, Color.BLACK), "C", 
                true
        );
        bParqueaderos.addActionListener(consultarProcesosComponent);
        bParqueaderos.addMouseListener(consultarProcesosComponent);
        pSuperior.add(bParqueaderos);
        
        // BOTÓN CONTRATOS ------------------------------------------
        bContratos = sObjGraficos.construirJButton(
                "Contratos", 600, 0, 300, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white,  
                BorderFactory.createMatteBorder(0, 1, 2, 2, Color.BLACK), "C", 
                true
        );
        bContratos.addActionListener(consultarProcesosComponent);
        bContratos.addMouseListener(consultarProcesosComponent);
        pSuperior.add(bContratos);
    }
    
    public void crearScrollpane(JPanel panel){
        this.scrollpane = sObjGraficos.construirPanelBarra(panel, 0, 0, 900, 480, null, null);
        this.scrollpane.getVerticalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
            7, 10, Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getColorSeleccion())
        );
        this.scrollpane.getHorizontalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
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

    public JButton getbVehiculos() {
        return bVehiculos;
    }

    public JButton getbParqueaderos() {
        return bParqueaderos;
    }

    public JButton getbContratos() {
        return bContratos;
    }
    
    
    
}
