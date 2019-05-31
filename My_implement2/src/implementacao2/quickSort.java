package implementacao2;

public class quickSort {

    final static int margemErro = 5;

    public static void quickSort(int[] vetor, int esq, int dir) {
        if (esq < dir) {
            int pivot = separar(vetor, esq, dir);
            quickSort(vetor, esq, pivot - 1);
            quickSort(vetor, pivot + 1, dir);
        }
    }

    public static int separar(int[] vetor, int esq, int dir) {
        int p = vetor[esq];
        int i = esq + 1, j = dir;

        while (i <= j) {
            if(vetor[i] <= p) i++;
            else if(vetor[j] > p) j--;
            else trocar(vetor, i, j);
        }
        trocar(vetor, esq, j);
        return j;
    }

    public static void trocar(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    public static long tempoqsCrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.crescente(v, tam);

            inicio = System.nanoTime();
            quickSort(v, 0, v.length - 1);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempoqsDecrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.decrescente(v, tam);

            inicio = System.nanoTime();
            quickSort(v, 0, v.length - 1);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempoqsAleatorio(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            if (v.length == 20) {
                v = BrincandoComOrdenacao.vetor1.clone();
            } else {
                v = BrincandoComOrdenacao.vetor2.clone();
            }

            inicio = System.nanoTime();
            quickSort(v, 0, v.length - 1);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

}
