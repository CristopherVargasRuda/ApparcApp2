package negocio.logic.controlTablas;

import DAO.ContratoDAO;
import DAO.ParqueaderoDAO;
import DAO.ServicioDAO;
import DAO.VehiculoDAO;
import java.text.ParseException;
import java.util.ArrayList;
import negocio.models.Parqueadero;
import negocio.models.Servicio;
import negocio.models.Vehiculo;
import util.CaException;

public class ControlTablaRecaudo {

    private String periodo, dia, mes, anio;
    private ArrayList<Servicio> servicios;
    private ArrayList<Parqueadero> parqueaderos;
    private ArrayList<Integer> recaudos;
    private Vehiculo vehiculo;
    private Parqueadero parqueadero;
    private VehiculoDAO vehiculoDAO;
    private ServicioDAO servicioDAO;
    private ContratoDAO contratoDAO;
    private ParqueaderoDAO parqueaderoDAO;
    private int totalRecaudo;

    public ControlTablaRecaudo() {
        parqueaderoDAO = new ParqueaderoDAO();
        contratoDAO = new ContratoDAO();
        servicioDAO = new ServicioDAO();
        parqueaderos = new ArrayList<>();
        recaudos = new ArrayList<>();
    }

    public String devolverParqueadero(int posicion) {
        try {
            return parqueaderos.get(posicion).getNombre();
        } catch (Exception e) {
            return null;
        }
    }

    public int devolverRecaudo(int posicion) {
        try {
            return recaudos.get(posicion);
        } catch (Exception e) {
            return 0;
        }
    }

    public void cargarCantidadServicios() throws CaException, ParseException {
        int total, totalPorServicios, totalPorContrato;
        totalRecaudo = 0;
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

        parqueaderos.clear();
        parqueaderoDAO.setParqueaderos(parqueaderos);
        parqueaderoDAO.cargarDatosTablaParqueaderos();
        parqueaderos = parqueaderoDAO.getParqueaderos();

        for (Parqueadero parqueadero : parqueaderos) {
            totalPorServicios = 0;
            servicioDAO.setRecaudoParcial(totalPorServicios);
            servicioDAO.calcularTotalParcial(
                    fechaIngreso, fechaSalida, parqueadero.getCodigo()
            );
            totalPorServicios = servicioDAO.getRecaudoParcial();

            totalPorContrato = 0;
            contratoDAO.setRecaudoParcial(totalPorContrato);
            contratoDAO.calcularTotalParcial(
                    fechaIngreso, fechaSalida, parqueadero.getCodigo()
            );
            totalPorContrato = contratoDAO.getRecaudoParcial();

            total = totalPorContrato + totalPorServicios;
            recaudos.add(total);
        }

        totalPorServicios = 0;
        servicioDAO.setRecaudoTotal(totalPorServicios);
        servicioDAO.calcularTotal(fechaIngreso, fechaSalida);
        totalPorServicios = servicioDAO.getRecaudoTotal();

        totalPorContrato = 0;
        contratoDAO.setRecaudoTotal(totalPorContrato);
        contratoDAO.calcularTotal(fechaIngreso, fechaSalida);
        totalPorContrato = contratoDAO.getRecaudoTotal();

        totalRecaudo = totalPorContrato + totalPorServicios;
    }

    public int devolverCantidadParqueaderos() {
        return parqueaderos.size();
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

    public int getTotalRecaudo() {
        return totalRecaudo;
    }

    public void setTotalRecaudo(int totalRecaudo) {
        this.totalRecaudo = totalRecaudo;
    }

}
