package negocio.models;

import java.util.ArrayList;

public class Parqueadero {

    private ArrayList<Area> areas = new ArrayList<Area>();
    private String nombre, clave, direccion, localidad, tipoSuelo;
    private int cantidadNiveles, codigo;
    private boolean estado, subterraneo;
    private float factorDemandaZonal;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
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

    public float getFactorDemandaZonal() {
        return factorDemandaZonal;
    }

    public void setFactorDemandaZonal(float factorDemandaZonal) {
        this.factorDemandaZonal = factorDemandaZonal;
    }
    
    public int getCantidadNiveles() {
        return cantidadNiveles;
    }

    public void setCantidadNiveles(int cantidadNiveles) {
        this.cantidadNiveles = cantidadNiveles;
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

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

}
