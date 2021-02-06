package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Area;
import util.CaException;
import util.ServiceLocator;

public class AreaDAO {

    private Area area;
    private ArrayList<Area> areas;

    public AreaDAO() {
        area = new Area();
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

}
