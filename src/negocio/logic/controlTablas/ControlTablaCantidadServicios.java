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

public class ControlTablaCantidadServicios {

    private String periodo, dia, mes, anio;
    private int cantidadVehiculos, cantidadServicios;
    private ArrayList<Servicio> servicios;
    private Vehiculo vehiculo;
    private Parqueadero parqueadero;
    private VehiculoDAO vehiculoDAO;
    private ServicioDAO servicioDAO;
    private ParqueaderoDAO parqueaderoDAO;

    public ControlTablaCantidadServicios() {
        vehiculoDAO = new VehiculoDAO();
        servicioDAO = new ServicioDAO();
        parqueaderoDAO = new ParqueaderoDAO();
        servicios = new ArrayList<>();
    }

    public void cargarCantidadServicios() throws CaException, ParseException {
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
        servicioDAO.cargarTodosLosServiciosPorPeriodo(fechaIngreso, fechaSalida);
        servicios = servicioDAO.getServicios();
        cantidadServicios = 0;
        servicioDAO.setCantidadServicios(cantidadServicios);
        servicioDAO.cargarCantidadTotalServicios(fechaIngreso, fechaSalida);
        cantidadServicios = servicioDAO.getCantidadServicios();
        cantidadVehiculos = 0;
        vehiculoDAO.setCantidadVehiculos(cantidadVehiculos);
        vehiculoDAO.cargarCantidadTotalVehiculos();
        cantidadVehiculos = vehiculoDAO.getCantidadVehiculos();
        for (Servicio servicio : servicios) {
            parqueadero = new Parqueadero();
            parqueaderoDAO.setParqueadero(parqueadero);
            parqueaderoDAO.traerParqueaderoPorCodigo(servicio.getCodigoParqueadero());
            parqueaderoDAO.getParqueadero();
            servicio.setParqueadero(parqueadero);
        }
    }

    public Servicio devolverServicio(int posicion) {
        try {
            return servicios.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }
    
    public int devolverCantidadServicios() {
        return servicios.size();
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }

}
