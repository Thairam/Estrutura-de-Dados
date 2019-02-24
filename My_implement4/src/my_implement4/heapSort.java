package my_implement4;

public class heapSort {
    
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
}
