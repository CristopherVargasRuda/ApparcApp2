package app.client.vistaPrincipal;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VistaPrincipalTemplate extends JFrame {

    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JPanel pBarraSuperior, pNavegacion, pPrincipal;
    private ImageIcon iDimAux;
    private JLabel lLogo, lTextoLogo;
    private JScrollPane scrollpane;

    private VistaPrincipalComponent vistaPrincipalComponent;

    public VistaPrincipalTemplate(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;

        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJPanels();
        this.crearJLabels();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 650);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void crearJPanels() {
        pBarraSuperior = sObjGraficos.construirJPanel(0, 0, 1200, 120, Color.BLACK, null);
        this.add(pBarraSuperior);

        pNavegacion = sObjGraficos.construirJPanel(0, 120, 300, 530, Color.CYAN, null);
        this.add(pNavegacion);

        pPrincipal = sObjGraficos.construirJPanel(300, 120, 900, 530, 
                sRecursos.getColorAzulOscuro(), sRecursos.getBordeNegro());
        this.add(pPrincipal);
    }

    public JPanel getpBarraSuperior() {
        return pBarraSuperior;
    }

    public JPanel getpNavegacion() {
        return pNavegacion;
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void crearScrollpane(JPanel panel){
        this.scrollpane = sObjGraficos.construirPanelBarra(panel, 0, 0, 898, 530, null, null);
        this.scrollpane.getVerticalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
            7, 10, Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getColorSeleccion())
        );
        this.scrollpane.getHorizontalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(
            7, 10, Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getColorSeleccion())
        );
        this.pPrincipal.add(scrollpane);
        this.scrollpane.revalidate();
    }
    
    public void crearJLabels(){
        // IMAGEN LOGO ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiCarro().getImage().getScaledInstance(
                        400, 400, Image.SCALE_AREA_AVERAGING
                )
        );
        lLogo = sObjGraficos.construirJLabel(
                null, (pPrincipal.getWidth() - 400) / 2, 0, 400, 400,
                iDimAux, null, null, null, "c"
        );
        pPrincipal.add(lLogo);
        
        // TEXTO LOGO ------------------------------------------------
        lTextoLogo = sObjGraficos.construirJLabel(
                "AparcApp", (pPrincipal.getWidth() - 500) / 2, 360, 500, 100,
                null, Color.WHITE, null, sRecursos.getFontLogo(), "c"
        );
        pPrincipal.add(lTextoLogo);
    }
}
