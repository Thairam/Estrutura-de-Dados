package Testes;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import my_implement4.BST_IF;

public class BST {

    static BST_IF bst;

    @Before//Instanciando a lista antes de cada teste.
    public void instanciaLista() {
        bst = new my_implement4.BST();
    }

    @Test//Testa se esta inserindo.
    public void insert() throws Exception {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        assertEquals(8, bst.search(8));
    }

    @Test//Prourando elemento na BST.
    public void search1() throws Exception {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        assertEquals(15, bst.search(15));
    }

    //Prourando elemento que nao esta na BST.
    //Espera uma excessao
    @Test(expected = Exception.class)
    public void search2() throws Exception {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        bst.search(16);
    }

    //Remove um elemento que não está na BST.
    //Espera excessao
    @Test(expected = Exception.class)
    public void notRemove() throws Exception {
        int[] array = {15, 23, 6, 7, 4, 5, 71, 50};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        bst.remove(10);
    }

    //Remove um nó folha.
    @Test
    public void removeLeaf() throws Exception {
        int[] array = {15, 23, 6, 7, 4, 5, 71, 50};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] Order = {4, 5, 6, 15, 23, 50, 71};
        assertEquals(7, bst.remove(7));
        System.out.println("Order: " + Arrays.toString(bst.order()));
        assertTrue(Arrays.toString(Order).equals(Arrays.toString(bst.order())));
    }

    //Remove um nó com um filho esquerdo.
    @Test
    public void removeOnLeftChild() throws Exception {
        int[] array = {15, 23, 6, 4, 5, 20, 21};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        //bst.remove(6);
        int[] Order = {4, 5, 15, 20, 21, 23};
        assertEquals(6, bst.remove(6));
        System.out.println("Order: " + Arrays.toString(bst.order()));
        assertTrue(Arrays.toString(Order).equals(Arrays.toString(bst.order())));
    }

    //Remove um nó com um filho direito.
    @Test
    public void removeOnRightChild() throws Exception {
        int[] array = {15, 10, 20, 8, 9, 25, 22, 30};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] Order = {8, 9, 10, 15, 22, 25, 30};
        assertEquals(20, bst.remove(20));
        System.out.println("Order: " + Arrays.toString(bst.order()));
        assertTrue(Arrays.toString(Order).equals(Arrays.toString(bst.order())));
    }

    // Remove um nó com dois filhos.
    @Test
    public void removeWithSucessor() throws Exception {
        int[] array = {15, 23, 6, 7, 4, 5, 71, 50};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] Order = {4, 5, 7, 15, 23, 50, 71};
        assertEquals(6, bst.remove(6));
        System.out.println("PreOrder: " + Arrays.toString(bst.preOrder()));
        assertTrue(Arrays.toString(Order).equals(Arrays.toString(bst.order())));
    }

    //Remove o nó raiz.
    @Test
    public void removeRoot() throws Exception {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] postOrder = {1, 3, 2, 5, 7, 6, 4, 11, 10, 13, 15, 14, 12, 9};
        assertEquals(8, bst.remove(8));
        assertTrue(Arrays.toString(postOrder).equals(Arrays.toString(bst.postOrder())));
    }

    //Remove todos os nós da BST.
    @Test
    public void removeAll() throws Exception {
        int[] array = {15, 23, 6, 7, 4, 5, 71, 50};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] Order = {4, 5, 6, 7, 23, 50, 71};
        assertEquals(15, bst.remove(15));
        assertTrue(Arrays.toString(Order).equals(Arrays.toString(bst.order())));

        int[] Order2 = {4, 5, 6, 7, 50, 71};
        assertEquals(23, bst.remove(23));
        assertTrue(Arrays.toString(Order2).equals(Arrays.toString(bst.order())));

        int[] Order3 = {4, 5, 6, 50, 71};
        assertEquals(7, bst.remove(7));
        assertTrue(Arrays.toString(Order3).equals(Arrays.toString(bst.order())));

        int[] Order4 = {4, 5, 50, 71};
        assertEquals(6, bst.remove(6));
        assertTrue(Arrays.toString(Order4).equals(Arrays.toString(bst.order())));

        int[] Order5 = {5, 50, 71};
        assertEquals(4, bst.remove(4));
        assertTrue(Arrays.toString(Order5).equals(Arrays.toString(bst.order())));

        int[] Order6 = {5, 71};
        assertEquals(50, bst.remove(50));
        assertTrue(Arrays.toString(Order6).equals(Arrays.toString(bst.order())));

        int[] Order7 = {71};
        assertEquals(5, bst.remove(5));
        assertTrue(Arrays.toString(Order7).equals(Arrays.toString(bst.order())));

        assertEquals(71, bst.remove(71));
    }

    @Test
    public void testPreOrder() {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] preOrder = {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        System.out.println("PreOrder: " + Arrays.toString(bst.preOrder()));
        assertTrue(Arrays.toString(preOrder).equals(Arrays.toString(bst.preOrder())));
    }

    @Test
    public void testOrder() {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] Order = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println("Order: " + Arrays.toString(bst.order()));
        System.out.println("PostOrder: " + Arrays.toString(bst.postOrder()));
        assertTrue(Arrays.toString(Order).equals(Arrays.toString(bst.order())));
    }

    @Test
    public void testPostOrder() {
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        int[] postOrder = {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8};
        System.out.println("PostOrder: " + Arrays.toString(bst.postOrder()));
        assertTrue(Arrays.toString(postOrder).equals(Arrays.toString(bst.postOrder())));
    }

    @Test
    public void testIsComplete1() {//Quando a arvore esta cheia
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        assertTrue(bst.isComplete());
    }

    @Test
    public void testIsComplete2() {//Quando a arvore nao esta cheia
        int[] array = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13};
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        assertFalse(bst.isComplete());
    }
}
