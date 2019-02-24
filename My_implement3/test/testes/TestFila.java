package testes;

import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ******************* students' imports here ********************************
 */
import Thairam.FilaComArray;
import Thairam.FilaComPilhas;
import Thairam.Fila_IF;
import static org.junit.Assert.assertFalse;

public class TestFila {

    Fila_IF fila = null;
    private int SIZE_FILA_TEST = 10; //tamanho padrão para os testes

    @Before
    public void instanciaFila() { //instancia a fila
        //fila = new FilaComArray(SIZE_FILA_TEST);
        fila = new FilaComPilhas(SIZE_FILA_TEST);
    }

    @Test
    public void testaEstadoInicial() { //testa estado inicial: fila vazia
        assertTrue(fila.isEmpty());
        assertFalse(fila.isFull());
    }

    @Test(expected = Exception.class)
    public void testaUnderFlow() throws Exception { //underflow quando se tenta remover da fila vazia
        fila.dequeue();
    }

    @Test(expected = Exception.class)
    public void testaOverFlow() throws Exception { //overflow quando se tenta inserir mais do que a capacidade máximada fila
        insereElementosNaFila(SIZE_FILA_TEST + 1);
    }

    @Test(expected = Exception.class)
    public void testaHeadFilaVazia() throws Exception { //lança exception ao tentar ver o head de uma fila vazia
        fila.head();
    }

    @Test
    public void testaFilaCheia() { //preenche a fila e testa os métodos isFull() e isEmpty()
        try {
            insereElementosNaFila(SIZE_FILA_TEST);
        } catch (Exception e) {
            fail("Não deveria cair aqui: método testaFilaCheia()");
        }

        assertTrue(fila.isFull());
        assertFalse(fila.isEmpty());
    }

    @Test
    public void testaHead() throws Exception { //verifica o head da fila
        insereElementosNaFila(8); // [0,1,2,3,4,5,6,7]
        assertEquals(0, fila.head()); //head = 0
        assertEquals(0, fila.dequeue()); // [1,2,3,4,5,6,7]
        assertEquals(1, fila.head()); //head = 1
        assertEquals(1, fila.dequeue()); // [2,3,4,5,6,7] 
        assertEquals(2, fila.head()); //head = 2
    }

    @Test
    public void testaInsercoesRemocoes() throws Exception { //teste geral sobre as insercoes e remocoes da fila
        //lista vazia
        assertTrue(fila.isEmpty());
        assertFalse(fila.isFull());
        insereElementosNaFila(SIZE_FILA_TEST); //preenche a fila
        //lista cheia
        assertFalse(fila.isEmpty());
        assertTrue(fila.isFull());
        removeElementosDaFila(SIZE_FILA_TEST); //remove todos elementos
        //lista vazia
        assertTrue(fila.isEmpty());
        assertFalse(fila.isFull());
    }

    @Test
    public void testaCircularidade() { //testa a circularidade da fila
        try {
            insereElementosNaFila(SIZE_FILA_TEST); // [0,1,2,3,4,5,6,7,8,9] head = 0, tail = 9

            for (int i = 0; i < SIZE_FILA_TEST - 1; i++) {
                fila.dequeue();
            } // [9]

            insereElementosNaFila(SIZE_FILA_TEST - 1); // [0,1,2,3,4,5,6,7,8,9] head = 9, tail = 8
            assertEquals(9, fila.head()); //head = 9
            assertTrue(fila.isFull());
        } catch (Exception e) {
            fail("Não deveria cair aqui: método testaCircularidade()");
        }
    }

    @Test
    public void testaCircularidadePlus() {
        try {
            insereElementosNaFila(SIZE_FILA_TEST); // [0,1,2,3,4,5,6,7,8,9] head = 0, tail = 9
            assertTrue(fila.isFull());
            removeElementosDaFila(5); // [5,6,7,8,9] head = 5, tail = 9
            fila.enqueue(10);
            fila.enqueue(11);
            fila.enqueue(12);
            fila.enqueue(13);
            fila.enqueue(14); // [10,11,12,13,14,5,6,7,8,9] head = 5, tail = 14
            assertTrue(fila.isFull());
            assertEquals(5, fila.head()); // head = 5
            removeElementosDaFila(9); // [14]
            assertEquals(14, fila.head()); //head = 14
            fila.dequeue(); // []
            assertTrue(fila.isEmpty());
        } catch (Exception e) {
            fail("Não deveria cair aqui: método testaCircularidadePlus()");
        }
    }

    //insere elementos de 0..(qntElementos-1) na fila
    public void insereElementosNaFila(int qntElementos) throws Exception {
        for (int i = 0; i < qntElementos; i++) {
            fila.enqueue(i);
        }
    }

    //remove qntElementos da fila
    public void removeElementosDaFila(int qntElementos) throws Exception {
        for (int i = 0; i < qntElementos; i++) {
            fila.dequeue();
        }
    }

}
