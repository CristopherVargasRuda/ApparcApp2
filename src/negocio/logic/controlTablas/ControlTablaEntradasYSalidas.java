package negocio.logic.controlTablas;

import DAO.ParqueaderoDAO;
import DAO.ServicioDAO;
import DAO.VehiculoDAO;
import java.text.ParseException;
import java.util.ArrayList;
import negocio.models.Parqueadero;
import negocio.models.Servicio;
import negocio.models.Vehiculo;
import util.CaException;

public class ControlTablaEntradasYSalidas {

    private String placa, periodo, dia, mes, anio;
    private int cantidadEntradas, cantidadSalidas;
    private ArrayList<Servicio> servicios;
    private Vehiculo vehiculo;
    private Parqueadero parqueadero;
    private VehiculoDAO vehiculoDAO;
    private ServicioDAO servicioDAO;
    private ParqueaderoDAO parqueaderoDAO;

    public ControlTablaEntradasYSalidas() {
        vehiculoDAO = new VehiculoDAO();
        servicioDAO = new ServicioDAO();
        parqueaderoDAO = new ParqueaderoDAO();
        servicios = new ArrayList<>();
        
    }

    public Servicio devolverServicio(int posicion) {
        try {
            return servicios.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void cargarDatosEntradasYSalidas() throws CaException, ParseException {
        if (Integer.parseInt(dia) > 28 && Integer.parseInt(mes) == 2) {
            dia = "1";
            mes = "3";
        }
        String fechaIngreso = anio + "-" + mes + "-" + dia;
        if (periodo.equals("Día")) {
            dia = (Integer.parseInt(dia) + 1) + "";
        }
        if (periodo.equals("Mes")) {
            mes = (Integer.parseInt(mes) + 1) + "";
        }
        if (periodo.equals("Año")) {
            anio = (Integer.parseInt(anio) + 1) + "";
        }
        if (Integer.parseInt(dia) > 30) {
            dia = "1";
            mes = (Integer.parseInt(mes) + 1) + "";
        }
        if (Integer.parseInt(mes) > 12) {
            mes = "1";
            anio = (Integer.parseInt(anio) + 1) + "";
        }
        String fechaSalida = anio + "-" + mes + "-" + dia;
        servicios.clear();
        servicioDAO.setServicios(servicios);
        servicioDAO.cargarServiciosPorPlaca(placa, fechaIngreso, fechaSalida);
        servicios = servicioDAO.getServicios();
        servicioDAO.setCantidadIngresos(0);
        servicioDAO.setCantidadSalidas(0);
        servicioDAO.cargarCantidadServiciosPorPlaca(placa, fechaIngreso, fechaSalida);
        cantidadEntradas = servicioDAO.getCantidadIngresos();
        cantidadSalidas = servicioDAO.getCantidadSalidas();
        for (Servicio servicio : servicios){
            parqueadero = new Parqueadero();
            parqueaderoDAO.setParqueadero(parqueadero);
            parqueaderoDAO.traerParqueaderoPorCodigo(servicio.getCodigoParqueadero());
            parqueaderoDAO.getParqueadero();
            servicio.setParqueadero(parqueadero);
        }
        
    }

    public void agregarServicio(Servicio servicios) {
        this.servicios.add(servicios);
    }

    public int devolverCantidadServicios() {
        return servicios.size();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public int getCantidadSalidas() {
        return cantidadSalidas;
    }

    public void setCantidadSalidas(int cantidadSalidas) {
        this.cantidadSalidas = cantidadSalidas;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

}
