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
    private JComboBox cbTipo, cbDiaInicio, cbMesInicio, cbAnioInicio, cbHora, cbMinuto, cbAmPm;

    private Timer timer;
    private TimerTask timerTask;
    private int estado;

    public RegistrarIngresoTemplate(RegistrarIngresoComponent registrarIngresoComponent) {

        this.registrarIngresoComponent = registrarIngresoComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        date = new Date();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        hourFormat = new SimpleDateFormat("HH:mm:ss a");
        hourDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
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
                    System.out.println(hourFormat.format(date));
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
                "Placa del vehículo", 390, 240, 350, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tPlaca.setBorder(sRecursos.getBordeNaranja());
        tPlaca.addFocusListener(registrarIngresoComponent);
        this.add(tPlaca);
        // CUPO -------------------------------------------------------------------------------------------------------
        tCupo = sObjGraficos.construirJTextField(
                "Cupo", 520, 530, 100, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tCupo.setBorder(sRecursos.getBordeNaranja());
        tCupo.addFocusListener(registrarIngresoComponent);
        this.add(tCupo);
    }

    public void crearJPasswordFields(){

    }

    public void crearJButtons(){

    }

    public void crearJComboBox() {

        cbTipo = sObjGraficos.construirJComboBox(
                "Tipo_Automóvil_Campero_Camioneta_Vehículo Pesado_Motocicleta_Bicicleta"
                , 390, 320, 350, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbTipo.setFont(sRecursos.getFontText());
        cbTipo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbTipo.addFocusListener(registrarIngresoComponent);
        this.add(cbTipo);

        String texto = "";
        for (int i=0; i<32; i++){
            texto = texto + "_" + i;
        }
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
                "Placa del vehículo:", 170, 250, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lPlaca);

        // Creacion TIPO -----------------------------------------------------------------------------------------------
        lTipo = sObjGraficos.construirJLabel(
                "Tipo de vehiculo:", 170, 320, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lTipo);

        // Creacion FECHA DE INGRESO -----------------------------------------------------------------------------------
        lFechaIng = sObjGraficos.construirJLabel(
                "Fecha de Ingreso:", 170, 390, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lFechaIng);

        // Creacion HORA DE INGRESO ------------------------------------------------------------------------------------
        lHoraIng = sObjGraficos.construirJLabel(
                "Hora de Ingreso:", 170, 460, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lHoraIng);

        // Creacion FECHA DE INGRESO 2 -----------------------------------------------------------------------------------
        lFechaIng2 = sObjGraficos.construirJLabel(
                dateFormat.format(date), 512, 390, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lFechaIng2);

        // Creacion HORA DE INGRESO 2 ------------------------------------------------------------------------------------
        lHoraIng2 = sObjGraficos.construirJLabel(hourFormat.format(date), 510, 460, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lHoraIng2);

        // Creacion CUPO ASIGNADO --------------------------------------------------------------------------------------
        lCupo = sObjGraficos.construirJLabel(
                "Cupo asignado:", 170, 530, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lCupo);
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
}
