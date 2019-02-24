package testes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ******************* students' imports here ********************************
 */
import Thairam.PilhaComFilas;
import Thairam.Pilha_IF;
import Thairam.PilhaComArray;

public class TestPilha {

    Pilha_IF pilha = null;
    private int SIZE_PILHA_TEST = 10; //tamanho padrao da pilha para realizar os testes

    @Before
    public void instanciaPilha() { // instancia a pilha
        pilha = new PilhaComFilas(SIZE_PILHA_TEST);
        //pilha = new PilhaComArray(SIZE_PILHA_TEST);
    }

    @Test
    public void testaEstadoInicial() { //testa estado inicial: pilha vazia
        assertTrue(pilha.isEmpty());
        assertFalse(pilha.isFull());
    }

    @Test(expected = Exception.class)
    public void testaUnderFlow() throws Exception { //underflow ao tentar remover da pilha vazia
        pilha.pop();
    }

    @Test(expected = Exception.class)
    public void testaOverFlow() throws Exception { //overflow ao tentar inserir um numero superior de elementos permitidos na pilha
        insereElementosNaPilha(SIZE_PILHA_TEST + 1);
    }

    @Test(expected = Exception.class)
    public void testaTopoPilhaVazia() throws Exception { //exception ao tentar verificar o topo de uma pilha vazia
        pilha.top();
    }

    @Test
    public void testaPilhaCheia() {
        try {
            insereElementosNaPilha(SIZE_PILHA_TEST); // [0,1,2,3,4,5,6,7,8,9] topo = 9
        } catch (Exception e) {
            fail("Não deveria cair aqui: método testaPilhaCheia()");
        }
        assertTrue(pilha.isFull());
        assertFalse(pilha.isEmpty());
    }

    @Test
    public void testaInsercoesRemocoes() throws Exception {
        assertTrue(pilha.isEmpty());
        assertFalse(pilha.isFull());
        insereElementosNaPilha(SIZE_PILHA_TEST); // preenche a pilha [0,1,2,3,4,5,6,7,8,9]
        assertFalse(pilha.isEmpty());
        assertTrue(pilha.isFull());
        removeElementosDaPilha(SIZE_PILHA_TEST); // limpa a pilha []
        assertTrue(pilha.isEmpty());
        assertFalse(pilha.isFull());

    }

    @Test
    public void testaRetornoPop() throws Exception {
        insereElementosNaPilha(SIZE_PILHA_TEST); // [0,1,2,3,4,5,6,7,8,9] preenche a pilha, topo = 9
        assertTrue(pilha.isFull());
        assertEquals(9, pilha.pop());
        assertEquals(8, pilha.pop());
        assertEquals(7, pilha.pop());
        assertEquals(6, pilha.pop());
        assertEquals(5, pilha.pop());
        assertEquals(4, pilha.pop());
        assertEquals(3, pilha.pop());
        assertEquals(2, pilha.pop());
        assertEquals(1, pilha.pop());
        assertEquals(0, pilha.pop());
        assertTrue(pilha.isEmpty());        
    }

    //insere elementos de 0..(qntElementos-1) na pilha
    public void insereElementosNaPilha(int qntElementos) throws Exception {
        for (int i = 0; i < qntElementos; i++) {
            pilha.push(i);
        }
    }

    //remove qntElementos da pilha
    public void removeElementosDaPilha(int qntElementos) throws Exception {
        for (int i = 0; i < qntElementos; i++) {
            pilha.pop();
        }
    }
}
