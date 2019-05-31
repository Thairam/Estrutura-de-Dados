package implementacao2;

public class selectionSort {

    final static int margemErro = 5;

    public static void selectionSort(int[] vetor) {
        int min, aux;

        for (int i = 0; i < vetor.length - 1; i++) {
            min = i;
            for (int j = (i + 1); j < vetor.length; j++) {
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }
            aux = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = aux;
        }

    }

    public static long tempossCrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.crescente(v, tam);

            inicio = System.nanoTime();
            selectionSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempossDecrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.decrescente(v, tam);

            inicio = System.nanoTime();
            selectionSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempossAleatorio(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            if (v.length == 20) {
                v = BrincandoComOrdenacao.vetor1.clone();
            } else {
                v = BrincandoComOrdenacao.vetor2.clone();
            }

            inicio = System.nanoTime();
            selectionSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

}
