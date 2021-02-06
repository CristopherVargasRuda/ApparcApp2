package negocio.logic.controlTablas;

import java.util.ArrayList;
import negocio.models.Servicio;

public class ControlTablaEntradasYSalidas {
    
    private String placa, periodo, dia, mes, anio;
    private int cantidadEntradas, cantidadSalidas;
    private ArrayList<Servicio> servicios;

    public ControlTablaEntradasYSalidas() {
        
    }

    public Servicio devolverServicio(int posicion) {
        try {
            return servicios.get(posicion);
        } catch (Exception e) {
            return null;
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
