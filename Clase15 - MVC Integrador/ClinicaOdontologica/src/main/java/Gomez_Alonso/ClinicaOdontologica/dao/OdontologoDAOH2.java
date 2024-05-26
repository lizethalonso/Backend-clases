package Gomez_Alonso.ClinicaOdontologica.dao;

import Gomez_Alonso.ClinicaOdontologica.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?)";
    private static final String SQL_BUSCARTODOS = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_ONE = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try (Connection connection = BD.getConnection();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS)) {
            psInsert.setString(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.executeUpdate();
            ResultSet clave= psInsert.getGeneratedKeys();
            while (clave.next()){
                odontologo.setId(clave.getInt(1));
            }
            logger.info("Odontólogo guardado con éxito: " + odontologo.getApellido());
        } catch (Exception e) {
            logger.error("Error al guardar el odontólogo: " + e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        logger.info("iniciando la operacion de buscado de un odontologo con id : "+id);
        Connection connection= null;
        Odontologo odontologo=null;
        try {
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ONE);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }

        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Connection connection = BD.getConnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_BUSCARTODOS);
            ResultSet rs = psSelectAll.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String numeroMat = rs.getString("NUMERO_MATRICULA");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                odontologos.add(new Odontologo(id, numeroMat, nombre, apellido));
            }

        } catch (Exception e) {
            logger.error("Error al listar los odontólogos: " + e.getMessage());
        }
        return odontologos;
    }

    @Override
    public Odontologo buscarPorString(String string) {
        return null;
    }
}


