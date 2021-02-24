package app.client.components.registrarIngreso;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class RegistrarIngresoTemplate extends JPanel {

    private RegistrarIngresoComponent registrarIngresoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    private Date date;
    private DateFormat dateFormat, hourFormat, hourDateFormat;
    private JLabel lTitulo, lDatosVehiculo, lPlaca, lTipo, lContrato, lCupo, lFechaIng, lHoraIng, lFechaIng2, lHoraIng2;
    private JTextField tPlaca, tCupo;
    private JComboBox cbTipo;
    private JButton btnBuscar, btnRegistrar, btnLimpiar;

    private Timer timer;
    private TimerTask timerTask;
    private int estado;

    public RegistrarIngresoTemplate(RegistrarIngresoComponent registrarIngresoComponent) {

        this.registrarIngresoComponent = registrarIngresoComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        date = new Date();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        hourFormat = new SimpleDateFormat("hh:mm:ss a");
        hourDateFormat = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        estado = 1;

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJButtons();
        this.crearJCheckBoxes();
        this.crearJLabels();
        this.crearJComboBox();

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(estado == 1){
                    date = new Date();
                    lHoraIng2.setText(hourFormat.format(date));
                }else{

                }
            }
        };
        timer.schedule(timerTask, 0, 1000);

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(880, 1000));
        this.setLayout(null);
        this.setVisible(true);
    }

    private void crearJCheckBoxes() {
    }

    public void crearObjetosDecoradores(){
    }

    public void crearJPanels(){
    }

    public void crearJTextFields(){

        // PLACA -------------------------------------------------------------------------------------------------------
        tPlaca = sObjGraficos.construirJTextField(
                "Placa del vehículo", 270, 240, 350, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tPlaca.setBorder(sRecursos.getBordeNaranja());
        tPlaca.addFocusListener(registrarIngresoComponent);
        tPlaca.addKeyListener(registrarIngresoComponent);
        this.add(tPlaca);
        // CUPO -------------------------------------------------------------------------------------------------------
        tCupo = sObjGraficos.construirJTextField(
                "Cupo", 520, 550, 100, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tCupo.setBorder(sRecursos.getBordeNaranja());
        tCupo.addFocusListener(registrarIngresoComponent);
        this.add(tCupo);
        tCupo.setVisible(false);
    }

    public void crearJPasswordFields(){

    }

    public void crearJButtons(){

        btnBuscar = sObjGraficos.construirJButton("Buscar", 650, 240, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnBuscar.addActionListener(registrarIngresoComponent);
        btnBuscar.addMouseListener(registrarIngresoComponent);
        this.add(btnBuscar);

        btnRegistrar = sObjGraficos.construirJButton("Registrar", 460, 660, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnRegistrar.addActionListener(registrarIngresoComponent);
        btnRegistrar.addMouseListener(registrarIngresoComponent);
        this.add(btnRegistrar);
        btnRegistrar.setVisible(false);

        btnLimpiar = sObjGraficos.construirJButton("Limpiar", 240, 660, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnLimpiar.addActionListener(registrarIngresoComponent);
        btnLimpiar.addMouseListener(registrarIngresoComponent);
        this.add(btnLimpiar);
        btnLimpiar.setVisible(false);
    }

    public void crearJComboBox() {

        cbTipo = sObjGraficos.construirJComboBox(
                "Tipo_Automovil_Campero_Camioneta_Vehiculo Pesado_Motocicleta_Bicicleta"
                , 390, 340, 350, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbTipo.setFont(sRecursos.getFontText());
        cbTipo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbTipo.addFocusListener(registrarIngresoComponent);
        cbTipo.addItemListener(registrarIngresoComponent);
        this.add(cbTipo);
        cbTipo.setVisible(false);

    }

    public void crearJLabels(){

        // Creacion TITULO ---------------------------------------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Registrar Ingreso", 110, 20, 680, 80, null,
                sRecursos.getColorNaranja(), null,
                sRecursos.getFontTituloUsuario(), "c"
        );
        this.add(lTitulo);

        // DATOS VEHICULO ----------------------------------------------------------------------------------------------
        lDatosVehiculo = sObjGraficos.construirJLabel(
                "Datos del Vehículo", 20, 150, 880, 40, null, Color.WHITE, null,
                sRecursos.getFontSeccion(), "c"
        );
        this.add(lDatosVehiculo);

        // Creacion PLACA ----------------------------------------------------------------------------------------------
        lPlaca = sObjGraficos.construirJLabel(
                "Placa del vehículo:", 70, 250, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lPlaca);

        // Creacion TIPO -----------------------------------------------------------------------------------------------
        lTipo = sObjGraficos.construirJLabel(
                "Tipo de vehiculo:", 170, 340, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lTipo);
        lTipo.setVisible(false);

        // Creacion FECHA DE INGRESO -----------------------------------------------------------------------------------
        lFechaIng = sObjGraficos.construirJLabel(
                "Fecha de Ingreso:", 170, 410, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lFechaIng);
        lFechaIng.setVisible(false);

        // Creacion HORA DE INGRESO ------------------------------------------------------------------------------------
        lHoraIng = sObjGraficos.construirJLabel(
                "Hora de Ingreso:", 170, 480, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lHoraIng);
        lHoraIng.setVisible(false);

        // Creacion FECHA DE INGRESO 2 -----------------------------------------------------------------------------------
        lFechaIng2 = sObjGraficos.construirJLabel(
                dateFormat.format(date), 512, 410, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lFechaIng2);
        lFechaIng2.setVisible(false);

        // Creacion HORA DE INGRESO 2 ------------------------------------------------------------------------------------
        lHoraIng2 = sObjGraficos.construirJLabel(hourFormat.format(date), 510, 480, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lHoraIng2);
        lHoraIng2.setVisible(false);

        // Creacion CUPO ASIGNADO --------------------------------------------------------------------------------------
        lCupo = sObjGraficos.construirJLabel(
                "Cupo asignado:", 170, 550, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "d"
        );
        this.add(lCupo);
        lCupo.setVisible(false);
    }

    public RegistrarIngresoComponent getRegistrarIngresoComponent() {
        return registrarIngresoComponent;
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public JLabel getlTipo() {
        return lTipo;
    }

    public void setlTipo(JLabel lTipo) {
        this.lTipo = lTipo;
    }

    public JLabel getlContrato() {
        return lContrato;
    }

    public void setlContrato(JLabel lContrato) {
        this.lContrato = lContrato;
    }

    public JLabel getlCupo() {
        return lCupo;
    }

    public void setlCupo(JLabel lCupo) {
        this.lCupo = lCupo;
    }

    public JLabel getlFechaIng() {
        return lFechaIng;
    }

    public void setlFechaIng(JLabel lFechaIng) {
        this.lFechaIng = lFechaIng;
    }

    public JLabel getlHoraIng() {
        return lHoraIng;
    }

    public void setlHoraIng(JLabel lHoraIng) {
        this.lHoraIng = lHoraIng;
    }

    public JLabel getlFechaIng2() {
        return lFechaIng2;
    }

    public void setlFechaIng2(JLabel lFechaIng2) {
        this.lFechaIng2 = lFechaIng2;
    }

    public JLabel getlHoraIng2() {
        return lHoraIng2;
    }

    public void setlHoraIng2(JLabel lHoraIng2) {
        this.lHoraIng2 = lHoraIng2;
    }

    public JTextField gettCupo() {
        return tCupo;
    }

    public void settCupo(JTextField tCupo) {
        this.tCupo = tCupo;
    }

    public JComboBox getCbTipo() {
        return cbTipo;
    }

    public void setCbTipo(JComboBox cbTipo) {
        this.cbTipo = cbTipo;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JTextField gettPlaca() {
        return tPlaca;
    }

    public void settPlaca(JTextField tPlaca) {
        this.tPlaca = tPlaca;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }
}
