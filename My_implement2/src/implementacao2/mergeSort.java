package implementacao2;

public class mergeSort {

    final static int margemErro = 5;

    public static void mergeSort(int[] vetor, int left, int high) {
        if (left < high) {
            int meio = (left + high) / 2;
            mergeSort(vetor, left, meio);
            mergeSort(vetor, meio + 1, high);
            merge(vetor, left, meio, high);
        }
    }

    public static void merge(int[] vetor, int left, int meio, int high) {
        int[] aux = new int[vetor.length];
        for (int i = left; i <= high; i++) {
            aux[i] = vetor[i];
        }

        int auxLeft = left;
        int auxRight = meio + 1;
        int atual = left;

        while (auxLeft <= meio && auxRight <= high) {
            if (aux[auxLeft] <= aux[auxRight]) {
                vetor[atual] = aux[auxLeft];
                auxLeft++;

            } else {
                vetor[atual] = aux[auxRight];
                auxRight++;
            }
            atual++;
        }

        int restante = meio - auxLeft;
        for (int i = 0; i <= restante; i++) {
            vetor[atual + i] = aux[auxLeft + i];
        }
    }

    public static long tempomsCrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.crescente(v, tam);

            inicio = System.nanoTime();
            mergeSort(v, 0, v.length - 1);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempomsDecrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.decrescente(v, tam);

            inicio = System.nanoTime();
            mergeSort(v, 0, v.length - 1);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempomsAleatorio(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            if (v.length == 20) {
                v = BrincandoComOrdenacao.vetor1.clone();
            } else {
                v = BrincandoComOrdenacao.vetor2.clone();
            }

            inicio = System.nanoTime();
            mergeSort(v, 0, v.length - 1);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

}
