package negocio.models;

import java.util.ArrayList;

public class Parqueadero {

    private ArrayList<Area> areas = new ArrayList<Area>();
    private String nombre, clave, direccion, localidad, factorDemandaZonal,
            tipoSuelo;
    private int cantidadNiveles, cantidadAutomoviles;
    private boolean estado, subterraneo;

    public Parqueadero() {
    }

    public void agregarArea(Area area) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public String getFactorDemandaZonal() {
        return factorDemandaZonal;
    }

    public void setFactorDemandaZonal(String factorDemandaZonal) {
        this.factorDemandaZonal = factorDemandaZonal;
    }

    public int getCantidadNiveles() {
        return cantidadNiveles;
    }

    public void setCantidadNiveles(int cantidadNiveles) {
        this.cantidadNiveles = cantidadNiveles;
    }

    public int getCantidadAutomoviles() {
        return cantidadAutomoviles;
    }

    public void setCantidadAutomoviles(int cantidadAutomoviles) {
        this.cantidadAutomoviles = cantidadAutomoviles;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isSubterraneo() {
        return subterraneo;
    }

    public void setSubterraneo(boolean subterraneo) {
        this.subterraneo = subterraneo;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

}
