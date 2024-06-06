package org.example.dao;

import org.apache.log4j.Logger;
import org.example.Exceptions.PacienteNoEncontradoException;
import org.example.model.Domicilio;
import org.example.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger= Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_INSERT="INSERT INTO PACIENTES(NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID) VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("inciando las operaciones de guardado");
        Connection connection= null;
        DomicilioDAOH2 daoAux= new DomicilioDAOH2();
        Domicilio domicilio=  daoAux.guardar(paciente.getDomicilio());
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4, Date.valueOf((paciente.getFechaIngreso())));
        psInsert.setInt(5,domicilio.getId());
        psInsert.execute();
        ResultSet clave= psInsert.getGeneratedKeys();
        while (clave.next()){
            paciente.setId(clave.getInt(1));
        }
        logger.info("paciente guardado");


        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        logger.info("iniciando la operacion de buscado de un paciente con id : "+id);
        Connection connection= null;
        Paciente paciente= null;
        Domicilio domicilio= null;
        try {
            connection = BD.getConnection();
            if (connection == null) {
                logger.error("No se pudo establecer la conexión a la base de datos.");
                return null;
            }
            Statement statement = connection.createStatement();
            PreparedStatement psSElectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSElectOne.setInt(1, id);
            ResultSet rs = psSElectOne.executeQuery();
            DomicilioDAOH2 daoAux = new DomicilioDAOH2();
            while (rs.next()) {
                domicilio = daoAux.buscarPorId(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio);
            }
            if (paciente == null) {
                throw new PacienteNoEncontradoException("No se encontró ningún paciente con el ID: " + id);
            }
        }catch (SQLException e) {
            logger.error("Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();

        }catch (Exception e){
            logger.error("Ha ocurrido un error inesperado" + e.getMessage());
            e.printStackTrace();
        }


        return paciente;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("iniciando las operaciones de busqueda:");
        Connection connection=null;
        List<Paciente> pacientes= new ArrayList<>();
        Paciente paciente= null;
        Domicilio domicilio=null;
        DomicilioDAOH2 daoAux= new DomicilioDAOH2();
        try{
            connection=BD.getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_SELECT_ALL);
            while(rs.next()){
                domicilio= daoAux.buscarPorId(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);
                pacientes.add(paciente);
            }


        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return pacientes;
    }
        /*private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;*/
}
