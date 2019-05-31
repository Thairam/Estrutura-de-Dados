package implementacao2;

public class heapSort {
    
    final static int margemErro = 5;
    
    public static void heapSort(int [] vetor){
        buildHeap(vetor);
        
        for(int i = vetor.length - 1; i > 0; i--){
            swap(vetor, 0, i);
        }
    }
    
    public static void buildHeap(int[] vetor){
        
        for(int i = vetor.length / 2; i >= 0; i--){
            heapfy(vetor, i, vetor.length - 1);
        }
    }

    private static void swap(int[] vetor, int i, int j) {
       int aux = vetor[i];
       vetor[i] = j;
       vetor[j] = aux;
    }

    private static void heapfy(int[] vetor, int no, int ultimo) {
        
        int esquerda = 2* no + 1;
        int direita = esquerda + 1;
        int maior = no;
        
        
        if(ultimo >= esquerda){
            if(vetor[esquerda] > vetor[maior]){
                maior = esquerda;
            }
        }
        
        if(ultimo >= direita){
            if(vetor[direita] > vetor[maior]){
                maior = direita;
            }
        }
        
        if(no == maior) return;
        
        swap(vetor, no, maior);
        heapfy(vetor, maior, ultimo);
    }
    
    public static long tempohpCrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.crescente(v, tam);

            inicio = System.nanoTime();
            heapSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }

    public static long tempohpDecrescente(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.decrescente(v, tam);

            inicio = System.nanoTime();
            heapSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    } 
    
    public static long tempohpAleatorio(int v[], int tam) {
        long inicio = 0, fim = 0, total = 0;
        for (int i = 0; i < BrincandoComOrdenacao.teste; i++) {
            BrincandoComOrdenacao.aleatory(v, tam);

            inicio = System.nanoTime();
            heapSort(v);
            fim = System.nanoTime();
            if (i > margemErro) {
                total += (fim - inicio);
            }

            BrincandoComOrdenacao.isSorted(v);
        }
        return (total / BrincandoComOrdenacao.teste);
    }    
}
