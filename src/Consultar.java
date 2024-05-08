
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultar {
    static Scanner sc = new Scanner(System.in);
    public static void consultarLibroTitulo(Statement statement) {

        try {
            System.out.println("Introduce el titulo");
            String titulo = sc.next();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM libro WHERE titulo = '" + titulo + "'");

            if (resultSet.next()) {
                System.out.println("Titulo: " + resultSet.getString("titulo"));
                System.out.println("\nPrecio: " + resultSet.getFloat("precio"));
                System.out.println("\nAutor: " + resultSet.getString("autor"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    public static void consultarLibrosAutor(Statement statement) {
        try {
            System.out.println("Introduce el nombre del autor");
            String nombreAutor = sc.next();


            ResultSet resultSet = statement.executeQuery("SELECT dni FROM autores WHERE nombre = '" + nombreAutor + "';");

            if (resultSet.next()) {
                String dni = resultSet.getString("dni");

                ResultSet resultSet2 = statement.executeQuery("SELECT * FROM libro WHERE autor = '" + dni + "';");

                if (resultSet2.next()) {
                    System.out.println("Titulo: " + resultSet2.getString("titulo"));
                    System.out.println("\nPrecio: " + resultSet2.getFloat("precio"));
                    System.out.println("\nAutor: " + resultSet2.getString("autor"));
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void consultarTodosLibros(Statement statement) {
        try{

            ResultSet resultSet = statement.executeQuery("SELECT * FROM libro");

            while(resultSet.next()){
                System.out.println("\nTitulo: " + resultSet.getString("titulo"));
                System.out.println("\nPrecio: " + resultSet.getFloat("precio"));
                System.out.println("\nAutor: " + resultSet.getString("autor"));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public static void consultarAutoresConLibros(Statement statement) {

        try{
            ResultSet resultSet = statement.executeQuery("SELECT * FROM autores");

            while(resultSet.next()){
                System.out.println("Autor: " + resultSet.getString("nombre"));
                String dni = resultSet.getString("dni");
                System.out.println("DNI: "+ dni);
                System.out.println("Nacionalidad: " + resultSet.getString("nacionalidad"));

                ResultSet resultSet1 = statement.executeQuery("SELECT * FROM libro WHERE autor = '" + dni + "';");

                if (resultSet1.next()) {
                    System.out.println("Libros del autor:"+ resultSet.getString("nombre"));
                    System.out.println("Titulo: " + resultSet1.getString("titulo"));
                    System.out.println("Precio: " + resultSet1.getFloat("precio"));
                    System.out.println("Autor: " + resultSet1.getString("autor"));
                    System.out.println("\n");
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
