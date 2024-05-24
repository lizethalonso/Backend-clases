package Presencial.dao;

import org.apache.log4j.Logger;

import java.lang.ref.PhantomReference;

public class BD {
    private static final Logger logger = Logger.getLogger(BD.class);
    private  static final String SQL_DROP_CREATE="DROP TABLE IF EXIST PACIENTES; CREATE" +
            "PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMRE VARCHAR(1OO) NOT NULL" +
            "APELLIDO VARCHAR (1OO) NOT NULL, CEDULA VARCHAR (100) NOT NULL, FECHA_INGRESO DATE NOT NULL," +
            "DOMICILIO_ID INT NOT NULL)";
    private static final String SQL_DROP_CREATE_DOM="DROP TABLE IF EXIST DOMICILIOS; CREATE" +
                       "DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(1OO) NOT NULL" +
                       "NUMERO INT NOT NULL)";
    private static final String SQL_PRUEBA="INSERT INTO PACIENTES (NOMBRE, APELLIDP, CEDULA, FECHA_INGRESO, DOMICILIO_ID)VALUES ('Liz', 'Alonso', '222', 2024-05-16,1)";
}
