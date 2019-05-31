package my_implement4;

import static java.lang.Math.ceil;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class BST implements BST_IF {

    private int valor;
    private BST esquerda;
    private BST direita;
    private int cont = 0;
    private int index;

    public BST() {
        this.valor = -1;
    }

    @Override
    public void insert(int element) {
        inserir(this, element);
        this.cont++;
    }

    public void inserir(BST node, int valor) {
        if (node.valor == -1) {
            node.valor = valor;
            node.esquerda = new BST();
            node.direita = new BST();

        } else {
            if (valor < node.valor) {
                inserir(node.esquerda, valor);
            } else {
                inserir(node.direita, valor);
            }
        }
    }
    
    //Retorna o nó sucessor.
    public BST getSucessor(BST node){
        if(node.esquerda.valor != -1){
            return getSucessor(node.esquerda);
        }
        return node;
    }    

    public void remover(int element, BST node){
        if(node.valor == element){
            //Remove nó folha.
            if(node.esquerda.valor == -1 && node.direita.valor == -1){
                node.valor = -1;
            //Remove nó com filho esquerdo.   
            }else if(node.direita.valor == -1){
                BST aux = node.esquerda;
                node.valor = aux.valor;
                node.esquerda = aux.esquerda;
                node.direita = aux.direita;
            //Remove nó com filho direito.
            }else if(node.esquerda.valor == -1){
                BST aux = node.direita;
                node.valor = aux.valor;
                node.direita = aux.direita;
                node.esquerda = aux.esquerda;
                
            //Remove nó com dois filhos.
            } else {
                BST sucessor = getSucessor(node.direita);
                node.valor = sucessor.valor;
                remover(sucessor.valor, node.direita);
            }
            return;
        }
        if(element < node.valor)
            remover(element, node.esquerda);
        else remover(element, node.direita);
    }
    
    @Override
    public int remove(int element) throws Exception {
        search(element);
        remover(element, this);
        this.cont--;
        return element;
    }
    
    @Override
    public int search(int element) throws Exception {
        if (this.valor == -1) {
            throw new Exception("Nâo Encontrado");
        }
        if (this.valor == element) {
            return this.valor;
        }
        if (element < this.valor) {
            return esquerda.search(element);
        }
        return direita.search(element);
    }

    @Override
    public int[] preOrder() {
        int[] result = new int[cont];
        this.index = 0;
        BST node = new BST();
        node.valor = this.valor;
        node.esquerda = this.esquerda;
        node.direita = this.direita;
        pre(node, result);
        return result;
    }

    private void pre(BST node, int[] array) {
        if (node.valor != -1) {
            index(array, node);
            pre(node.esquerda, array);
            pre(node.direita, array);
        }
    }

    private void index(int[] array, BST node) {
        array[index++] = node.valor;
    }

    @Override
    public int[] order() {
        int[] result = new int[cont];
        this.index = 0;
        BST node = new BST();
        node.valor = this.valor;
        node.esquerda = this.esquerda;
        node.direita = this.direita;
        ord(node, result);
        return result;
    }

    private void ord(BST node, int[] array) {
        if (node.valor != -1) {
            ord(node.esquerda, array);
            index(array, node);
            ord(node.direita, array);
        }
    }

    @Override
    public int[] postOrder() {
        int[] result = new int[cont];
        this.index = 0;
        BST node = new BST();
        node.valor = this.valor;
        node.esquerda = this.esquerda;
        node.direita = this.direita;
        pos(node, result);
        return result;
    }

    private void pos(BST node, int[] array) {
        if (node.valor != -1) {
            pos(node.esquerda, array);
            pos(node.direita, array);
            index(array, node);
        }
    }

    private boolean verificaAltura(int altura, int atual) {
        if (atual > altura) {
            return false;
        }

        if (valor == -1) {
            return (altura == atual);
        }

        return esquerda.verificaAltura(altura, atual + 1) && direita.verificaAltura(altura, atual + 1);
    }

    @Override
    public boolean isComplete() {
        int altura = (int) ceil(log(cont + 1) / log(2)) - 1;

        if (pow(2, altura + 1) - 1 != cont) {
            return false;
        }

        return verificaAltura(altura, -1);
    }
}
