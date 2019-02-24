package Thairam;

/**
 *
 * @author Thairam Michel
 */
public class FilaComArray implements Fila_IF {

    private static int CAPACIDADE;
    int[] elementos;
    int fim = -1;
    int ini = 0;
    int tam = 0;

    public FilaComArray(int tam) {
        elementos = new int[tam];
        this.CAPACIDADE = tam;
    }

    @Override
    public void enqueue(int element) throws Exception {
        if (tam == elementos.length) {
            throw new QueueOverflowException();
        } else {
            if (fim == elementos.length - 1) {
                fim = -1;
            }
            fim++;
            elementos[fim] = element;
            tam++;
        }
    }

    @Override
    public int dequeue() throws Exception {
        if (!isEmpty()) {
            int result = elementos[ini];
            ini = (ini + 1) % CAPACIDADE;
            tam--;
            return result;
        } else {
            throw new QueueUnderflowException();
        }
    }

    @Override
    public int head() throws Exception {
        if (!isEmpty()) {
            return elementos[ini];
        } else {
            throw new QueueUnderflowException();
        }
    }

    @Override
    public boolean isEmpty() {
        if (tam == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (tam == elementos.length) {
            return true;
        } else {
            return false;
        }
    }

    int size() {
        return tam;
    }

    private static class QueueOverflowException extends Exception {

        public QueueOverflowException() {
            System.out.println("--- FILA CHEIA --- ");
        }
    }

    private static class QueueUnderflowException extends Exception {

        public QueueUnderflowException() {
            System.out.println("--- FILA VAZIA ---");
        }
    }

}
