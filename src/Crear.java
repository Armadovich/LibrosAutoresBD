import java.sql.SQLException;
import java.sql.Statement;

public class Crear {


    public static void crearBD(Statement statement) throws SQLException {

        String bd = "AutoresLibrosBD";

        try {
            statement.execute("CREATE DATABASE IF NOT EXISTS "+bd+";");
            statement.execute("USE "+bd+";");

            statement.execute("CREATE TABLE IF NOT EXISTS Autores"+
                    "(dni varchar(9) Primary Key not null,"
                    +"nombre varchar(30) not null,"
                    +"nacionalidad varchar(30) not null)");

            statement.execute("CREATE  table if not exists Libro"+
                    "(idLibro int(5) primary key auto_increment," +
                    "titulo varchar(30) not null," +
                    "precio float not null," +
                    "autor varchar(9) not null," +
                    "foreign key (autor) references Autores(dni) " +
                    "on delete cascade " +
                    "on update cascade)");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
