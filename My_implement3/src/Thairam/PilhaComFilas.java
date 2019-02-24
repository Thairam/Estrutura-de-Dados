package Thairam;

public class PilhaComFilas implements Pilha_IF {

    FilaComArray fila, fila2;

    public PilhaComFilas(int tam) {
        fila = new FilaComArray(tam);
        fila2 = new FilaComArray(tam);
    }

    @Override
    public void push(int element) throws Exception {
        if (fila.isFull()) {
            throw new StackOverflowException();
        } else {
            fila.enqueue(element);
        }
    }

    @Override
    public int pop() throws Exception {

        int x = 0;

        if (fila.isEmpty()) {
            throw new StackUnderflowException();
        } else {

            x = fila.dequeue();

            while (!fila.isEmpty()) {
                fila2.enqueue(x);
                x = fila.dequeue();
            }

            while (!fila2.isEmpty()) {
                fila.enqueue(fila2.dequeue());
            }

            return x;
        }
    }

    @Override
    public int top() throws Exception {

        int x = 0;

        if (fila.isEmpty()) {
            throw new StackUnderflowException();

        } else {

            do {
                x = fila.dequeue();
                fila2.enqueue(x);
            } while (!fila.isEmpty());

            while (!fila2.isEmpty()) {
                fila.enqueue(fila2.dequeue());
            }
        }
        return x;
    }

    @Override
    public boolean isEmpty() {
        if (fila.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (fila.isFull()) {
            return true;
        } else {
            return false;
        }
    }

    private static class StackUnderflowException extends Exception {

        public StackUnderflowException() {
            System.out.println("--- PILHA VAZIA ---");
        }
    }

    private static class StackOverflowException extends Exception {

        public StackOverflowException() {
            System.out.println("--- PILHA CHEIA ---");
        }
    }

}
