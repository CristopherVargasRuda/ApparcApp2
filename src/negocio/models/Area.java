package negocio.models;

import java.util.ArrayList;

public class Area {
    
    private ArrayList<Espacio> espacios = new ArrayList<Espacio>();
    int idArea, cantidadCupos, cantidadCuposDisponibles;
    String tipoVehiculo;
    boolean vigilancia;

    public Area() {
    }
    
    public void agregarEspacio(Espacio espacio){
        this.espacios.add(espacio);
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getCantidadCupos() {
        return cantidadCupos;
    }

    public void setCantidadCupos(int cantidadCupos) {
        this.cantidadCupos = cantidadCupos;
    }

    public int getCantidadCuposDisponibles() {
        return cantidadCuposDisponibles;
    }

    public void setCantidadCuposDisponibles(int cantidadCuposDisponibles) {
        this.cantidadCuposDisponibles = cantidadCuposDisponibles;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public boolean isVigilancia() {
        return vigilancia;
    }

    public void setVigilancia(boolean vigilancia) {
        this.vigilancia = vigilancia;
    }    

    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }    
    
    
    
}
