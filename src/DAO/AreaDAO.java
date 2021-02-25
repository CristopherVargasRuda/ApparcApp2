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


    public void actualizarCuposDisponibles() throws CaException {
        String sql = "UPDATE area SET q_cuposdisponibles = area.q_cuposdisponibles-1 WHERE k_idarea = ?;";
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1,area.getIdArea());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se actualizaron los cupos disponibles" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    public void registrarArea(int codigoParqueadero) throws CaException {
        String sql = "INSERT INTO area(k_idArea, n_tipoVehiculoArea, q_cupos, "
                + "q_cuposDisponibles, k_codigoParqueadero) VALUES "
                + "(?, ?, ?, ?, ?);";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, area.getIdArea());
            prepStmt.setString(2, area.getTipoVehiculo());
            prepStmt.setInt(3, area.getCantidadCupos());
            prepStmt.setInt(4, area.getCantidadCuposDisponibles());
            prepStmt.setInt(5, codigoParqueadero);
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se puede insertar los datos del  parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarAreas(int codigoParqueadero) throws CaException {
        String sql = "SELECT k_idarea, n_tipovehiculoarea, q_cupos, "
                + "q_cuposdisponibles FROM area a, parqueadero p "
                + "WHERE a.k_codigoparqueadero = p.k_codigoparqueadero "
                + "AND p.k_codigoparqueadero = ?;";

        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, codigoParqueadero);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                area = new Area();
                area.setIdArea(rs.getInt("k_idarea"));
                area.setCantidadCupos(rs.getInt("q_cupos"));
                area.setCantidadCuposDisponibles(rs.getInt("q_cuposdisponibles"));
                area.setTipoVehiculo(rs.getString("n_tipovehiculoarea"));
                areas.add(area);
            }
        } catch (SQLException e) {
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Area" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
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

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

}

