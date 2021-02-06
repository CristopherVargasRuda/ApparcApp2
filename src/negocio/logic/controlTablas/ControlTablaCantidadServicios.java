package negocio.logic.controlTablas;

import java.util.ArrayList;
import negocio.models.Servicio;

public class ControlTablaCantidadServicios {

    private ArrayList<Servicio> servicio;
    private String DiaInicio, MesInicio, AnioInicio, Periodo, totalVehiculos, 
            totalServicios;

    public ControlTablaCantidadServicios() {

    }

    public Servicio devolverServicio(int posicion) {
        try {
            return servicio.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarServicio(Servicio servicio) {
        this.servicio.add(servicio);
    }

    public int devolverCantidadServicios() {
        return servicio.size();
    }

    public String getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(String totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public String getDiaInicio() {
        return DiaInicio;
    }

    public void setDiaInicio(String DiaInicio) {
        this.DiaInicio = DiaInicio;
    }

    public String getMesInicio() {
        return MesInicio;
    }

    public void setMesInicio(String MesInicio) {
        this.MesInicio = MesInicio;
    }

    public String getAnioInicio() {
        return AnioInicio;
    }

    public void setAnioInicio(String AnioInicio) {
        this.AnioInicio = AnioInicio;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getTotalServicios() {
        return totalServicios;
    }

    public void setTotalServicios(String totalServicios) {
        this.totalServicios = totalServicios;
    }

    
}
