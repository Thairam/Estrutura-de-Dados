package implementacao2;

public class insertionSort {

    final static int margemErro = 5;

    public static void insertionSort(int[] vetor) {
        for (int j = 1; j < vetor.length; j++) {
            int key = vetor[j];
            int i = j - 1;

            while (i > 0 && vetor[i] > key) {
                vetor[i + 1] = vetor[i];
                i = i - 1;
            }
            vetor[i + 1] = key;

        }

    }

    public static long tempoisCrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.crescente(v, tam);

            inicio = System.nanoTime();
            insertionSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempoisDecrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.decrescente(v, tam);

            inicio = System.nanoTime();
            insertionSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempoisAleatorio(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            if (v.length == 20) {
                v = BrincandoComOrdenacao.vetor1.clone();
            } else {
                v = BrincandoComOrdenacao.vetor2.clone();
            }

            inicio = System.nanoTime();
            insertionSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

}
