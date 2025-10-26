package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();

    }

    public void agregarLibro(){
        
           
        
    }

    public void obtenerLibros(){
       

    }

    public void agregarLibroCola(){

        

    }

    public void obtenerLibroCola(){

       
        

    }
    public void obtenerLibroPila(){
        


    }

    public void crearLibro(){
        
    }

    public void crearPedido(){
        

    }

    public void devolverLibro() {
       

    }

    public void eliminarUltimoLibro(){
        

    }

    public void deshacerEliminarLibro(){
        

    }

    public Libro buscarLibro(String isbn) throws PosicionIlegalException {
    for (int i = 0; i < listaLibros.getTamanio(); i++) {
        Libro libro = listaLibros.getValor(i);
        if (libro.getisbn().equals(isbn)) {
            return libro;
        }
    }
    return null;
}


}