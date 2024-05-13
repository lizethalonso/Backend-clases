package Mesas2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

// Paso 1 Cargar el driver h2 o el que se use
// Paso 2 Obtener conexión a través de un método
// Paso 3 Ejecutar consulta
// Paso 4 Cerrar conexión

public class Figuras {
    public static final Logger logger = LogManager.getLogger("infoLogger");
    public static void main(String[] args) {
        //vamos a preparar el método
        Connection connection = null; //creando el objeto e inicializarlo en null para evitar problemas
        //try catch para arrojar la excepción en caso de falla en conexión
        try {
            connection=getConnection(); //devuelve la conexion
            //Ahora toca insertar las figuras, pero hay que crear la tabla y demás
            //Se necesita un  método de java para llevar y traer cosas y es el sgte
            Statement statement = connection.createStatement(); //nos va a permitir poder comunicarnos con la bdd atraves del objeto statement
            statement.execute("DROP TABLE IF EXISTS FIGURAS; CREATE TABLE FIGURAS " +
                    " (ID INT PRIMARY KEY, FIGURA VARCHAR(20) NOT NULL, COLOR VARCHAR(20) NOT NULL)");
            logger.info("se creo correctamente la tabla en la bdd");
            //AHORA INSERTAMOS
            statement.execute("INSERT INTO FIGURAS VALUES (1,'Circulo','Rojo'),(2,'Cuadrado','Azul'),(3,'Circulo','Blanco'),(4,'Cuadrado','Rosado'),(5,'Cuadrado','Violeta')");
            logger.warn("se insertaron correctamente las figuras");
            //para mostrar necesito guardarlos a los valores en una clase de tipo ResultSet
            ResultSet rs= statement.executeQuery("SELECT * FROM FIGURAS");
            //SIEMPRE EN WHILE
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+" Figura: "+rs.getString(2)+" Color: "+rs.getString(3));
            }
            System.out.println("******************************************************");
            //ahora eliminamos uno
            statement.execute("DELETE FROM FIGURAS WHERE ID=2");
            logger.warn("se elimino el ID 2");
            //MOSTRAR NUEVAMENTE
            ResultSet rs1= statement.executeQuery("SELECT * FROM FIGURAS");
            //SIEMPRE
            while (rs1.next()){
                System.out.println("ID: "+rs1.getInt(1)+" Figura: "+rs1.getString(2)+" Color: "+rs1.getString(3));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                logger.warn("se cerro correctamente la conexion a la bdd");
            }catch (SQLException ex){
                ex.getMessage();
            }
        }
    }

    //Paso 2 - Obtener conexión
    public static Connection getConnection() throws Exception { //se firma el método y se sabe que lanza una excepción si la conexión falla.
        Class.forName("org.h2.Driver"); // Se le dice desde donde se trae el driver
        return DriverManager.getConnection("jdbc:h2:~/C3Figuras","sa","sa"); //ruta y parámetros de la base de datos
        //jdbc es la interfaz
        //h2 cuál es la base de datos - h2
        //~/ donde se ubica la bd - en la raíz
        //jdbc:h2:mem:~/C3Figuras" - si es para probar se puede ubicar esa bd en la ram (mem) y no en la propia bd
    }
}
