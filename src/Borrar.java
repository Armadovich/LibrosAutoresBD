import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrar {

    static Scanner sc = new Scanner(System.in);
    public static void borrarLibro(Statement statement){

        try {
            System.out.println("Que titulo tiene el libro quieres borrar?");
            String libroTitulo = sc.next();

            statement.execute("DELETE FROM libro WHERE titulo = '" + libroTitulo + "'");
        } catch (SQLException e) {
            System.out.println("Error al borrar el libro");
        }
    }

    public static void borrarAutor(Statement statement){

        try {
            System.out.println("Que nombre tiene el autor quieres borrar?");
            String autorNombre = sc.next();

            statement.execute("DELETE FROM Autores WHERE nombre = '" + autorNombre + "'");
        } catch (SQLException e) {
            System.out.println("Error al borrar el autor");
        }
    }

}
