package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Contrato;
import util.CaException;
import util.ServiceLocator;

public class ContratoDAO {

    private Contrato contrato;
    private ArrayList<Contrato> contratos;

    public ContratoDAO() {
        contrato = new Contrato();
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

}
