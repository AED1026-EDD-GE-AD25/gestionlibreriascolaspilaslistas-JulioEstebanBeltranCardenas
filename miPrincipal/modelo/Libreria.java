package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria {
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria() {
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();
    }

    public Libro crearLibro(String titulo, String autor, String isbn) {
        return new Libro(titulo, autor, isbn);
    }

    public void agregarLibro(Libro libro) {
        listaLibros.agregar(libro);
    }

    public ListaDoble<Libro> obtenerLibros() {
        return listaLibros;
    }

    public void mostrarLibros() throws PosicionIlegalException {
        if (listaLibros.esVacia()) {
            System.out.println("No hay libros prestados");
            return;
        }
        listaLibros.mostrar();
    }

    public boolean agregarLibroCola(Libro libro) {
        colaLibros.encolar(libro);
        return true;
    }

    public Libro obtenerLibroCola() {
        return colaLibros.desencolar();
    }

    public void mostrarReservaLibros() {
        colaLibros.mostrar();
    }

    public Pedido crearPedido(Libro libro, Fecha fecha) {
        return new Pedido(libro, fecha);
    }

    public boolean devolverLibro(Libro libro) {
        try {
            int resultado = listaLibros.remover(libro);
            return resultado != -1;
        } catch (PosicionIlegalException e) {
            return false;
        }
    }

    public Libro eliminarUltimoLibro() throws PosicionIlegalException {
    if (listaLibros.esVacia()) {
        return null;
    }
    
    Libro libroEliminado = listaLibros.eliminarUltimo();
    
    if (libroEliminado != null) {
        pilaLibrosEliminados.apilar(libroEliminado);
    }
    
    return libroEliminado;
    }

    public Libro deshacerEliminarLibro() {
        return deshacerEliminacion();
    }

    public Libro deshacerEliminacion() {
        Libro libro = pilaLibrosEliminados.retirar();
        if (libro != null) {
            listaLibros.agregar(libro);
        }
        return libro;
    }

    public Libro obtenerLibroPila() {
        return pilaLibrosEliminados.cima();
    }

    public Libro buscarLibro(String isbn) throws PosicionIlegalException {
        for (int i = 0; i < listaLibros.getTamanio(); i++) {
            Libro libro = listaLibros.getValor(i);
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
}