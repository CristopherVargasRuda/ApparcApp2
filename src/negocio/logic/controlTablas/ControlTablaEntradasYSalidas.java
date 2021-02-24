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
    
    public void cargarContrato() throws CaException, ParseException {
        servicios.clear();
        servicioDAO.setServicios(servicios);
        servicioDAO.cargarServiciosPorPlaca("AAE231", "2020-01-20", "2023-03-20");
        servicios = servicioDAO.getServicios();
        for (Servicio servicio: servicios){
            System.out.println(servicio.getFechaIngreso());
            System.out.println(servicio.getFechaSalida());
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
