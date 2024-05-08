import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Modificar {

    static Scanner sc = new Scanner(System.in);

    public static void modificarLibroPorTitulo(Statement statement) {

        try{
            System.out.println("Introduce el titulo del libro");
            String titulo = sc.next();

            System.out.println("Introduce nuevo titulo");
            String titulo2 = sc.next();
            System.out.println("Introduce el precio del libro");
            float precio = sc.nextFloat();

            sc.nextLine();

            statement.executeUpdate("UPDATE libro SET titulo = '" + titulo2 + "', precio = " + precio + " WHERE titulo = '" + titulo + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void modificarAutorPorDni (Statement statement) {
        try{
            System.out.println("Introduce el dni del autor");
            String dni = sc.next();

            System.out.println("Introduce nuevo dni del autor");
            String dni2 = sc.next();
            System.out.println("Introduce el nuevo nombre del autor");
            String nombre = sc.next();
            System.out.println("Introduce la nueva nacionalidad del autor");
            String nacionalidad = sc.next();

            statement.executeUpdate("UPDATE autores SET dni = '" + dni2 + "', nombre = '" + nombre + "', nacionalidad = '"+nacionalidad+"' WHERE dni = '"+ dni+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
