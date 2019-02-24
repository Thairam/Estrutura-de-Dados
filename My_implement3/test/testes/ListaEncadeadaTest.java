package testes;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * ******************* students' imports here ********************************
 */
import Thairam.ListaEncadeada_IF;
import Thairam.ListaEncadeada;

public class ListaEncadeadaTest {

    ListaEncadeada_IF lista = null;

    @Before
    public void instanciaListaEncadeada() { //instancia a lita encadeada
        lista = new ListaEncadeada();
    }

    @Test
    public void testaEstadoInicial() { //testa o estado inicial: vazia, size = 0, []
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
        lista.toArray();
        assertEquals("[]", Arrays.toString(lista.toArray()));
    }

    @Test
    public void testaIsEmpty() throws Exception { //testa método isEmpty()
        assertTrue(lista.isEmpty());
        lista.insert(8);
        assertFalse(lista.isEmpty());
        lista.remove(8);
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testaSize() throws Exception { //testa método size()
        assertEquals(0, lista.size());
        insereElementosNaLista(8); //insere 8 elememtos
        lista.insert(8);
        lista.search(8);
        assertEquals(9, lista.size());
        removeElementosDaLista(5); //remove 5 elementos
        assertEquals(4, lista.size());
        lista.remove(5);
        assertEquals(3, lista.size());
        lista.remove(6);
        lista.remove(7);
        assertEquals(1, lista.size());
        lista.remove(8);
        assertEquals(0, lista.size());
    }

    @Test
    public void testaInsercoesNoInicio() { //testa a ordem de insercao
        lista.insert(1);
        lista.insert(2);
        assertEquals("[2, 1]", Arrays.toString(lista.toArray()));
        lista.insert(3);
        assertEquals("[3, 2, 1]", Arrays.toString(lista.toArray()));
        lista.remove(2);
        lista.insert(5);
        assertEquals("[5, 3, 1]", Arrays.toString(lista.toArray()));
        lista.remove(5);
        lista.remove(1);
        lista.insert(4);
        assertEquals("[4, 3]", Arrays.toString(lista.toArray()));
        lista.remove(3);
        lista.insert(5);
        assertEquals("[5, 4]", Arrays.toString(lista.toArray()));
        lista.insert(0);
        lista.insert(1);
        lista.insert(2);
        assertEquals("[2, 1, 0, 5, 4]", Arrays.toString(lista.toArray()));
    }

    @Test
    public void testaRemocoes() throws Exception {
        insereElementosNaLista(10); //insere 10 elementos
        lista.remove(6); //remove 6
        lista.remove(8); //remove 8
        lista.search(0);
        assertEquals(8, lista.size());
        lista.remove(100); // não remove 100, pois o elemento não existe na lista
        assertEquals(8, lista.size()); // size = 8
        lista.remove(0);
        lista.remove(5);
        lista.remove(4);
        lista.remove(10); // nao remove 10, pois o elemento nao existe na lista.
        assertEquals(5, lista.size());
    }

    @Test
    public void testaSearch() throws Exception {
        insereElementosNaLista(8); //insere [7,6,5,4,3,2,1,0]
        assertEquals(7, lista.search(7));
        assertEquals(2, lista.search(2));
        assertEquals(0, lista.search(0));
        assertEquals(4, lista.search(4));
        assertEquals(6, lista.search(6));
    }

    @Test(expected = Exception.class)
    public void testaSearch2() throws Exception {
        lista.search(0);
        insereElementosNaLista(5); //insere [4,3,2,1,0]
        lista.search(10); //elemento não existente na lista
        lista.search(-1);
        lista.search(5);
    }

    @Test
    public void testaToArray() {
        insereElementosNaLista(5); //insere [4,3,2,1,0]
        assertEquals("[4, 3, 2, 1, 0]", Arrays.toString(lista.toArray()));
        lista.insert(8);
        lista.insert(9); // [9,8,4,3,2,1,0]
        assertEquals("[9, 8, 4, 3, 2, 1, 0]", Arrays.toString(lista.toArray()));
        lista.remove(1);
        lista.remove(8);
        lista.remove(2);
        lista.remove(0);
        assertEquals("[9, 4, 3]", Arrays.toString(lista.toArray()));
        lista.remove(4);
        lista.remove(3);
        lista.remove(9);
        assertEquals("[]", Arrays.toString(lista.toArray()));
        lista.insert(0);
        assertEquals("[0]", Arrays.toString(lista.toArray()));
    }

    //insere qntElementos na lista
    public void insereElementosNaLista(int qntElementos) {
        for (int i = 0; i < qntElementos; i++) {
            lista.insert(i);
        }
    }

    //remove qntElementos da lista
    public void removeElementosDaLista(int qntElementos) {
        for (int i = 0; i < qntElementos; i++) {
            lista.remove(i);
        }
    }
}
