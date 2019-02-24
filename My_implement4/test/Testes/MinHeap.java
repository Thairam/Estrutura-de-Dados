package Testes;

import my_implement4.Fila_IF;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thairam Michel
 */
public class MinHeap {

    static Fila_IF fila;

    @Before
    public void instanciaMinHeap() {
        fila = new my_implement4.MinHeap(10);
    }

    //Insere o elemento 20 duas vezes.
    //Espera uma excessao.
    @Test(expected = Exception.class)
    public void notPassRepeated() throws Exception {
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }

        fila.enqueue(20);
    }

    //Insere um elemento a mais que a capacidade da fila.
    //Espera uma excecao.
    @Test(expected = Exception.class)
    public void queueFull() throws Exception {
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }

        fila.enqueue(50);
    }

    //Remove de uma fila vazia.
    //Espera uma excecao.
    @Test(expected = Exception.class)
    public void queueEmpty() throws Exception {
        fila.dequeue();
    }

    //Verifica a cabeca de uma fila vazia.
    //Espera uma excecao.
    @Test(expected = Exception.class)
    public void head() throws Exception {
        fila.head();
    }

    @Test
    public void empty() throws Exception {
        assertTrue(fila.isEmpty());
    }

    //Remove a raiz(1).
    @Test
    public void dequeue() throws Exception {
        //1  2  3  4  5   6  7  8  9   10  
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }

        assertEquals(1, fila.dequeue());
    }

    @Test
    public void dequeue2() throws Exception {
        //1  2  3  4  5  7  8  9  10  11  20  
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }

        assertEquals(1, fila.dequeue());
        assertEquals(2, fila.dequeue());
        assertEquals(3, fila.dequeue());
        assertEquals(4, fila.dequeue());
        assertEquals(5, fila.dequeue());
        assertEquals(7, fila.dequeue());
        assertEquals(8, fila.dequeue());
        assertEquals(9, fila.dequeue());
        assertEquals(11, fila.dequeue());
        assertEquals(20, fila.dequeue());
    }

    //Testa o método head().
    @Test
    public void head2() throws Exception {
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }
        assertEquals(1, fila.head());
    }

    @Test
    public void head3() throws Exception {
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }
        fila.dequeue();
        assertEquals(2, fila.head());
    }

    //Testa se a fila ficará vazia.
    @Test
    public void empty2() throws Exception {
        int array[] = {3, 2, 5,};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }
        fila.dequeue();
        fila.dequeue();
        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

    //Testa se a fila ficará cheia.
    @Test
    public void full() throws Exception {
        //1  2  3  4  5   6  7  8  9   10  
        int array[] = {3, 2, 5, 4, 20, 7, 8, 1, 11, 9};
        for (int i = 0; i < array.length; i++) {
            fila.enqueue(array[i]);
        }
        assertTrue(fila.isFull());
    }
}
