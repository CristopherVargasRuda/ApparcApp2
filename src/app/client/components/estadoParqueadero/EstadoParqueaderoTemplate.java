package app.client.components.estadoParqueadero;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import app.services.GraficosAvanzadosService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EstadoParqueaderoTemplate extends JPanel {

    private EstadoParqueaderoComponent estadoParqueaderoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    

    public EstadoParqueaderoTemplate(EstadoParqueaderoComponent estadoParqueaderoComponent) {
        this.estadoParqueaderoComponent = estadoParqueaderoComponent;
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
