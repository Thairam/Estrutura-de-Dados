package Thairam;

public class PilhaComArray implements Pilha_IF {

    //private int CAPACIDADE;
    private int[] array;
    private int topo = -1;

    public PilhaComArray(int tam) {
        array = new int[tam];
        //this.CAPACIDADE = tam;
    }

    @Override
    public void push(int element) throws Exception {
        if (size() == array.length) {
            throw new StackOverflowException();
        }
        array[++topo] = element;
    }

    @Override
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        int e_Topo = array[topo];
        array[topo] = -1; /////////////
        topo--;
        return e_Topo;
    }

    @Override
    public int top() throws Exception {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return array[topo];
    }

    @Override
    public boolean isEmpty() {
        return (topo == -1);
    }

    @Override
    public boolean isFull() {
        return (size() == array.length);
    }

    public int size() {
        return topo + 1;
    }

    private static class StackOverflowException extends Exception {

        public StackOverflowException() {
            System.out.println("--- PILHA CHEIA ---");
        }
    }

    private static class StackUnderflowException extends Exception {

        public StackUnderflowException() {
            System.out.println("--- PILHA VAZIA ---");
        }
    }

}
