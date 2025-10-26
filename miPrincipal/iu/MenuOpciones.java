package miPrincipal.iu;
import miPrincipal.servicio.ServicioDatos;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import java.util.Scanner;
import utilerias.Fecha;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import cola.Cola;
import pila.Pila;

public class MenuOpciones{
    static Scanner scanner = new  Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro(){
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();
        
        Libro libro = libreria.crearLibro(titulo, autor, isbn);
        libreria.agregarLibro(libro);
    }
    
    public static void mostrarLibros() throws PosicionIlegalException{
        libreria.mostrarLibros();
    }

    public static void agregarLibroCola(){
        System.out.print("Ingrese el título del libro a reservar: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro a reservar: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro a reservar: ");
        String isbn = scanner.nextLine();
        
        Libro libro = libreria.crearLibro(titulo, autor, isbn);
        libreria.agregarLibroCola(libro);
    }

    public static Libro obtenerLibroCola(){
        return libreria.obtenerLibroCola();
    }

    public static void mostrarReservaLibros(){
        // Este método necesita ser implementado en Libreria
        System.out.println("Funcionalidad en desarrollo...");
    }

    public static void crearPedido(){
        System.out.print("Ingrese el título del libro para el pedido:");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido:");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido:");
        String isbnPedido = scanner.nextLine();
        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido = null;
        if (libroPedido != null){
            pedido = libreria.crearPedido(libroPedido, new Fecha());
            if (pedido != null)
                System.out.println("Pedido creado exitosamente: "+pedido);
            else
                System.out.println("No fue posible crear el pedido");
        }else{
            System.out.println("Error: no fue posible crear el Libro");
        }
    }

    public static void devolverLibro() throws PosicionIlegalException{
        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();
        
        Libro libro = libreria.buscarLibro(isbn);
        if (libro != null) {
            libreria.devolverLibro(libro);
        } else {
            System.out.println("Libro no encontrado en préstamos");
        }
    }

    public static Libro eliminarUltimoLibro() throws PosicionIlegalException{
        return libreria.eliminarUltimoLibro();
    }

    public static void deshacerEliminarLibro(){
        libreria.deshacerEliminacion();
    }
}