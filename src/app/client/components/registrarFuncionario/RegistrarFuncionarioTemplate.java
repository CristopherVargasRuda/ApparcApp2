package app.client.components.registrarFuncionario;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class RegistrarFuncionarioTemplate extends JPanel {

    private RegistrarFuncionarioComponent registrarFuncionarioComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    public RegistrarFuncionarioTemplate(RegistrarFuncionarioComponent registrarFuncionarioComponent) {
        this.registrarFuncionarioComponent = registrarFuncionarioComponent;
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
        this.setPreferredSize(new Dimension(880, 1000));
        this.setLayout(null);
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
