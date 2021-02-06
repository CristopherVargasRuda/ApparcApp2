package negocio.logic.controlTablas;

import java.util.ArrayList;
import negocio.models.Servicio;

public class ControlTablaRecaudo {
    
    private ArrayList<String> parqueaderos;
    private ArrayList<String> recaudos;
    private String DiaInicio, MesInicio, AnioInicio, Periodo, totalVehiculos;
    
    public ControlTablaRecaudo() {

    }

    public String devolverParqueadero(int posicion) {
        try {
            return parqueaderos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarParqueadero(String parqueadero) {
        this.parqueaderos.add(parqueadero);
    }

    public int devolverCantidadParqueaderos() {
        return parqueaderos.size();
    }
    
    public String devolverRecaudo(int posicion) {
        try {
            return recaudos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarRecaudo(String recaudo) {
        this.recaudos.add(recaudo);
    }

    public int devolverCantidadRecaudos() {
        return recaudos.size();
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

    public String getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(String totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }
    
    
    
}
