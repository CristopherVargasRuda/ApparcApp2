package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Area;
import negocio.models.Espacio;
import util.CaException;
import util.ServiceLocator;

public class EspacioDAO {

    private Espacio espacio;
    private ArrayList<Espacio> espacios;

    public EspacioDAO() {
        espacio = new Espacio();
    }

    public void actualizarEstado() throws CaException {
        String sql = "UPDATE espacio SET i_estado = FALSE where k_idespacio = ?; ";
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1,espacio.getIdEspacio());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se actualizaron los cupos disponibles" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }
    public void registrarEspacio(int codigoParqueadero, int codigoArea) throws CaException{

        String sql = "INSERT INTO espacio(k_idEspacio, i_estado, "
                + "k_codigoParqueadero, k_idArea) VALUES (?, ?, ?, ?)";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, espacio.getIdEspacio());
            prepStmt.setBoolean(2, espacio.isEstado());
            prepStmt.setInt(3, codigoParqueadero);
            prepStmt.setInt(4, codigoArea);
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se puede insertar los datos del  parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarEspacios(int codigoParqueadero, int codigoArea) throws CaException {
        String sql = "SELECT k_idespacio, i_estado FROM area a, parqueadero p, "
                + "espacio c WHERE a.k_codigoparqueadero = p.k_codigoparqueadero "
                + "AND a.k_idarea = c.k_idarea "
                + "AND p.k_codigoparqueadero = ? "
                + "AND c.k_idarea = ?;";

        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, codigoParqueadero);
            prepStmt.setInt(2, codigoArea);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                espacio = new Espacio();
                espacio.setIdEspacio(rs.getInt("k_idespacio"));
                espacio.setEstado(rs.getBoolean("i_estado"));
                espacios.add(espacio);
            }
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No se pudo cargar los datos del espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void cupoLibreContratoDAO(String placa, int codigoParqueadero, boolean cambio) throws CaException {
        String sql = "UPDATE espacio SET i_estado = ? FROM vehiculo ve, parqueadero pa, servicio se, area a, espacio es"
                + " WHERE se.k_idespacio=es.k_idespacio"
                + " AND es.k_idarea=a.k_idarea"
                + " AND se.k_idarea = es.k_idarea"
                + " AND f_salida IS NULL"
                + " AND es.i_estado = false"
                + " AND pa.k_codigoparqueadero = ?"
                + " AND ve.k_placa = ?;";
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setBoolean(1, cambio);
            prepStmt.setInt(2, codigoParqueadero);
            prepStmt.setString(3, placa);
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No se pudo cargar los datos del espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }


    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }

    public void setEspacios(ArrayList<Espacio> espacios) {
        this.espacios = espacios;
    }

}