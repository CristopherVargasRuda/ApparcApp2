package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Parqueadero;
import util.CaException;
import util.ServiceLocator;

public class ParqueaderoDAO {

    private Parqueadero parqueadero;
    private ArrayList<Parqueadero> parqueaderos;

    public ParqueaderoDAO() {
        parqueadero = new Parqueadero();
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

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public ArrayList<Parqueadero> getParqueaderos() {
        return parqueaderos;
    }

}
