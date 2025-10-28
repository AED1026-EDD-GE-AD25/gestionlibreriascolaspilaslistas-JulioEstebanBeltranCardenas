package pila;

public class Pila<T> {
    private Nodo<T> cima;
    private int tamanio;

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public void apilar(T valor) {
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setValor(valor);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamanio++;
    }

    public T retirar() {
        if (esVacia()) {
            return null;
        }
        T valor = cima.getValor();
        cima = cima.getSiguiente();
        tamanio--;
        return valor;
    }

    public T cima() {
        if (esVacia()) {
            return null;
        }
        return cima.getValor();
    }

    public int getTamanio() {
        return tamanio;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Pila vacia");
            return;
        }
        System.out.println("PAL LOBBY MANCO");
        Nodo<T> actual = cima;
        int contador = 1;
        while (actual != null) {
            System.out.println(contador + ". " + actual.getValor());
            actual = actual.getSiguiente();
            contador++;
        }
    }
}