
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insertar {

    static Scanner sc = new Scanner(System.in);

    public static void insertarAutor(Statement statement) {

        String dni, nombre, nacionalidad;

        try {
            System.out.println("Introduce dni");
            dni = sc.next();
            System.out.println("Introduce nombre");
            nombre = sc.next();
            System.out.println("Introduce nacionalidad");
            nacionalidad = sc.next();

            statement.executeUpdate("INSERT INTO autores(dni,nombre,nacionalidad) VALUES ('"+dni+"','"+nombre+"','"+nacionalidad+"')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void insertarLibro(Statement statement) {

        String titulo, precio, autor;

        try {

            System.out.println("Introduce titulo");
            titulo = sc.next();
            System.out.println("Introduce precio");
            precio = sc.next();
            System.out.println("Introduce autor");
            autor = sc.next();

            statement.executeUpdate("INSERT INTO libro(titulo,precio,autor) VALUES ('"+titulo+"','"+precio+"','"+autor+"')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
