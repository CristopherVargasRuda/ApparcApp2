package app.client.components.principalParqueadero;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PrincipalParqueaderoTemplate extends JPanel {

    private PrincipalParqueaderoComponent principalParqueaderoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    

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

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(880, 1000));
        this.setVisible(true);
    }

    

    public void crearObjetosDecoradores() {
        
    }

    public void crearJPanels() {

    }

    public void crearJTextFields() {
        
    }

    public void crearJPasswordFields() {

    }

    public void crearJButtons() {

    }

    public void crearJCheckBoxes() {

    }

    public void crearJLabels() {

    }

}
