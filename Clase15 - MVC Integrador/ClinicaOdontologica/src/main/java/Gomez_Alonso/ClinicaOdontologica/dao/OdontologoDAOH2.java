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
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_ONE = "SELECT * FROM ODONTOLOGOS WHERE ID = ?";
    private static final String SQL_UPDATE="UPDATE ODONTOLOGOS SET NUMERO_MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID=?";
    private static final String SQL_DELETE="DELETE FROM ODONTOLOGOS WHERE ID?";
    private static final String SQL_SELECT_BY_MATRICULA="SELECT * FROM ODONTOLOGOS WHERE NUMERO_MATRICULA=?";

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
            logger.info("Odontólogo guardado con éxito: " + odontologo.toString());
        } catch (Exception e) {
            logger.error("Error al guardar el odontólogo: " + e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        logger.info("Iniciando la operacion de buscado de un odontologo con id : "+id);
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
        logger.info("Iniciando operación de eliminación de paciente con id: " + id);
        Connection connection=null;
        try {
            connection=BD.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            int filasAfectadas = psDelete.executeUpdate();
            if (filasAfectadas == 0){
                logger.error("No se encontró ningún odontólogo con id: " + id);
            }else {
                connection.commit();
                logger.info("Odontólogo con id " + id + " eliminado correctamente.");
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void actualizar(Odontologo odontologo) {
        logger.warn("Iniciando operaciones de actualización de odontólogo con id: " + odontologo.getId());
        Connection connection = null;
        try {
            connection=BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, odontologo.getNumeroMatricula());
            psUpdate.setString(2,odontologo.getNombre());
            psUpdate.setString(3,odontologo.getApellido());
            psUpdate.setInt(4,odontologo.getId());
            psUpdate.execute();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Inicia operación de búsqueda de todos los odontólogos");
        Odontologo odontologo = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Connection connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                odontologo = (new Odontologo(rs.getString(1),rs.getString(2),rs.getString(3)));
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            logger.error("Error al listar los odontólogos: " + e.getMessage());
        }
        return odontologos;
    }

    @Override
    public Odontologo buscarPorString(String string) {
        logger.info("iniciando las operaciones de: ");
        Connection connection = null;
        Odontologo odontologo = null;
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        try{
            connection= BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectM = connection.prepareStatement(SQL_SELECT_BY_MATRICULA);
            psSelectM.setString(1,string);
            ResultSet rs = psSelectM.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4));
            }

        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }
}


