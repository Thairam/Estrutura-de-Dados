package my_implement4;

class ListaEncadeada {

    private int data = -1;
    private ListaEncadeada Prox;

    public ListaEncadeada() {

    }

    public boolean isEmpty() {
        if (data == -1) {
            return true;
        }
        return false;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return 1 + Prox.size();
    }

    public int search(int element) throws Exception {

        if (isEmpty()) {
            throw new Exception("Elemento não encontrado");
        } else {
            if (data == element) {
                return data;
            } else {
                return Prox.search(element);
            }
        }
    }

    public void insert(int element) {
        if (isEmpty()) {
            this.data = element;
            Prox = new ListaEncadeada();
        } else {
            ListaEncadeada novo = new ListaEncadeada();
            novo.Prox = this.Prox;
            novo.data = this.data;
            this.data = element;
            this.Prox = novo;
        }
    }

    public void remove(int element) {
        if (isEmpty()) {
            return;
        } else {
            if (data == element) {
                data = Prox.data;
                Prox = Prox.Prox;
            } else {
                Prox.remove(element);
            }
        }
    }

    public int[] toArray() {
        int[] result = new int[this.size()];
        toArray(result, 0);
        return result;
    }

    private void toArray(int[] array, int i) {
        if (isEmpty()) {
            return;
        }
        array[i] = this.data;
        Prox.toArray(array, ++i);
    }

}
