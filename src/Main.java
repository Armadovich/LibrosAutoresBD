import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        Statement stmt = null;
        Connection con = null;

        try{
            Class.forName("org.mariadb.jdbc.Driver");

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url = "jdbc:mariadb://localhost:3306/?user=root&password";

        try{
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Crear.crearBD(stmt);

        menu(stmt);
    }

    public static void menu(Statement stmt){
        int opcion = 0;

        try {
            while(opcion!=1){
                System.out.println("-------------------MENU-------------------\n");
                System.out.println("Introduce una opcion");
                System.out.println("1. SALIR");
                System.out.println("2. INSERTAR AUTOR");
                System.out.println("3. INSERTAR LIBRO");
                System.out.println("4. ELIMINAR LIBRO");
                System.out.println("5. ELIMINAR AUTOR");
                System.out.println("6. CONSULTAR LIBRO POR TITULO");
                System.out.println("7. CONSULTAR LIBROS POR AUTOR");
                System.out.println("8. CONSULTAR TODOS LOS LIBROS");
                System.out.println("9. CONSULTAR TODOS LOS AUTORES Y SUS LIBROS");
                System.out.println("10. MODIFICAR LIBRO POR TITULO");
                System.out.println("11. MODIFICAR AUTOR POR DNI");

                opcion = sc.nextInt();

                switch (opcion){
                    case 2:
                        Insertar.insertarAutor(stmt);
                        break;
                    case 3:
                        Insertar.insertarLibro(stmt);
                        break;
                    case 4:
                        Borrar.borrarLibro(stmt);
                        break;
                    case 5:
                        Borrar.borrarAutor(stmt);
                        break;
                    case 6:
                        Consultar.consultarLibroTitulo(stmt);
                        break;
                    case 7:
                        Consultar.consultarLibrosAutor(stmt);
                        break;
                    case 8:
                        Consultar.consultarTodosLibros(stmt);
                        break;
                    case 9:
                        Consultar.consultarAutoresConLibros(stmt);
                        break;
                    case 10:
                        Modificar.modificarLibroPorTitulo(stmt);
                        break;
                    case 11:
                        Modificar.modificarAutorPorDni(stmt);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}