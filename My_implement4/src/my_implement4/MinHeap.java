package my_implement4;

public class MinHeap implements Fila_IF {

    private int heap[], size = 0;

    public MinHeap() {
        heap = new int[100];
    }

    public MinHeap(int i) {
        heap = new int[i];
    }

    public MinHeap(int v[]) {
        size = v.length;
        heap = new int[100];
        for (int i = 0; i < v.length; i++) {
            heap[i] = v[i];
        }
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    @Override
    public void enqueue(int element) throws Exception {
        for (int i = 0; i < size; i++) {
            if (heap[i] == element) {
                throw new Exception("Elemento ja consta na Heap.");
            }
        }
        int i = size++;
        while ((i + 1) / 2 - 1 >= 0 && element < heap[(i + 1) / 2 - 1]) {
            heap[i] = heap[(i + 1) / 2 - 1];
            i = (i + 1) / 2 - 1;
        }
        heap[i] = element;
    }

    @Override
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Heap Vazia.");
        }
        int min = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return min;
    }

    @Override
    public int head() throws Exception {
        if (isEmpty()) {
            throw new Exception("Heap Vazia.");
        }
        return heap[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == heap.length;
    }

    private void heapify(int i) {
        int left = (i + 1) * 2 - 1, right = (i + 1) * 2, min = i, aux;
        if (left < size && heap[left] < heap[i]) {
            min = left;
        }
        if (right < size && heap[right] < heap[min]) {
            min = right;
        }
        if (min != i) {
            aux = heap[i];
            heap[i] = heap[min];
            heap[min] = aux;
            heapify(min);
        }
    }
}
