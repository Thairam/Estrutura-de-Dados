package implementacao2;

public class countingSort {

    final static int margemErro = 5;

    public static void countingSort(int[] vetor, int maior) {
        int aux[] = new int[maior + 1];

        for (int i : vetor) {
            aux[i]++;
        }
        int temp = 0;

        for (int i = 0; i < aux.length; i++) {
            while (0 < aux[i]) {
                vetor[temp++] = i;
                aux[i]--;
            }
        }
    }

    public static long tempocsCrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.crescente(v, tam);

            inicio = System.nanoTime();
            countingSort(v,tam);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempocsDecrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.decrescente(v, tam);

            inicio = System.nanoTime();
            countingSort(v,tam);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempocsAleatorio(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            if (v.length == 20) {
                v = BrincandoComOrdenacao.vetor1.clone();
            } else {
                v = BrincandoComOrdenacao.vetor2.clone();
            }

            inicio = System.nanoTime();
            countingSort(v,tam);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

}
