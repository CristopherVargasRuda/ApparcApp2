package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Servicio;
import util.CaException;
import util.ServiceLocator;

public class ServicioDAO {

    private Servicio servicio;
    private ArrayList<Servicio> servicios;

    public ServicioDAO() {
        servicio = new Servicio();
    }

    public void insertar() throws CaException {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void buscar() throws CaException {

    }

    public void actualizar() throws CaException {

    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

}
