package implementacao2;

import java.util.Random;

public class BrincandoComOrdenacao {
    
    // Variáveis globais constantes
    final static int teste = 1000;

    final static int tam1 = 20;
    final static int tam2 = 2000;

    // vetores globais
    static int v1[] = new int[20];
    static int v2[] = new int[2000];

    static int[] vetor1 = new int[20];
    static int[] vetor2 = new int[2000];

    // Método que recebe um array, e seu tamanho, e ordena de maneira crescente
    public static int[] crescente(int v[], int tam) {
        for (int i = 0; i < tam; i++) {
            v[i] = i + 1;
        }
        return v;
    }

    //// Método que recebe um array, e seu tamanho, e ordena de maneira decrescente
    public static int[] decrescente(int v[], int tam) {
        for (int i = 0; i < tam; i++) {
            v[tam - (i + 1)] = i + 1;
        }
        return v;
    }

    // Método que recebe um array, e seu tamanho, e gera números randômicos nas posições deste array
    public static int[] aleatory(int v[], int tam) {
        Random r = new Random();
        for (int i = 0; i < tam; i++) {
            v[i] = r.nextInt(tam);
        }
        return v;
    }

    // Método que recebe um array e verifica se ele está ordenado
    public static void isSorted(int v[]) {

        if (v[1] > v[2]) {
            System.out.println("Vetor não ordenado\n");
        }
    }
    
    

    public static void main(String[] args) {
        
       
        // Gera números randômicos nos dois vetores passados, que servirão de base para vetores clones!
        aleatory(vetor1, tam1);
        aleatory(vetor2, tam2);

        long tempos[][] = new long[7][6];
        
        /* Armazeno o tempo de cada algoritmo de ordenaçaõ, e suas variações de tamanho e método, em uma posição específica da matriz.
        Obs: Fazer atribuições a uma matriz, sem laços, como eu fiz, não é a forma mais elegante de pegar esses resultados, porém, dessa maneira,
        juntamente com as operações primeiro em vetores de 2000 posições e depois em vetores de 20 posições, percebi que os tempos das execuções 
        são mais exatas!
        */
        
        // bubbleSort
        tempos[0][3] = bubbleSort.tempobbCrescente(v2, tam2);
        tempos[0][4] = bubbleSort.tempobbAleatorio(v2, tam2);
        tempos[0][5] = bubbleSort.tempobbDecrescente(v2, tam2);

        tempos[0][0] = bubbleSort.tempobbCrescente(v1, tam1);
        tempos[0][1] = bubbleSort.tempobbAleatorio(v1, tam1);
        tempos[0][2] = bubbleSort.tempobbDecrescente(v1, tam1);

        // selectionSort
        tempos[1][3] = selectionSort.tempossCrescente(v2, tam2);
        tempos[1][4] = selectionSort.tempossAleatorio(v2, tam2);
        tempos[1][5] = selectionSort.tempossDecrescente(v2, tam2);

        tempos[1][0] = selectionSort.tempossCrescente(v1, tam1);
        tempos[1][1] = selectionSort.tempossAleatorio(v1, tam1);
        tempos[1][2] = selectionSort.tempossDecrescente(v1, tam1);

        //insertion Sort
        tempos[2][3] = insertionSort.tempoisCrescente(v2, tam2);
        tempos[2][4] = insertionSort.tempoisAleatorio(v2, tam2);
        tempos[2][5] = insertionSort.tempoisDecrescente(v2, tam2);

        tempos[2][0] = insertionSort.tempoisCrescente(v1, tam1);
        tempos[2][1] = insertionSort.tempoisAleatorio(v1, tam1);
        tempos[2][2] = insertionSort.tempoisDecrescente(v1, tam1);
        

        //mergeSort
        tempos[3][3] = mergeSort.tempomsCrescente(v2, tam2);
        tempos[3][4] = mergeSort.tempomsAleatorio(v2, tam2);
        tempos[3][5] = mergeSort.tempomsDecrescente(v2, tam2);
        
        tempos[3][0] = mergeSort.tempomsCrescente(v1, tam1);
        tempos[3][1] = mergeSort.tempomsAleatorio(v1, tam1);
        tempos[3][2] = mergeSort.tempomsDecrescente(v1, tam1);

        //quickSort
        tempos[4][3] = quickSort.tempoqsAleatorio(v2, tam2);
        tempos[4][4] = quickSort.tempoqsAleatorio(v2, tam2);
        tempos[4][5] = quickSort.tempoqsDecrescente(v2, tam2);
        
        tempos[4][0] = quickSort.tempoqsCrescente(v1, tam1);
        tempos[4][1] = quickSort.tempoqsAleatorio(v1, tam1);
        tempos[4][2] = quickSort.tempoqsDecrescente(v1, tam1);

        //coutingSort
        tempos[5][3] = countingSort.tempocsCrescente(v2, tam2);
        tempos[5][4] = countingSort.tempocsAleatorio(v2, tam2);
        tempos[5][5] = countingSort.tempocsDecrescente(v2, tam2);
        
        tempos[5][0] = countingSort.tempocsCrescente(v1, tam1);
        tempos[5][1] = countingSort.tempocsAleatorio(v1, tam1);
        tempos[5][2] = countingSort.tempocsDecrescente(v1, tam1);
        
        //heapSort
        tempos[6][3] = heapSort.tempohpCrescente(v2, tam2);
        tempos[6][4] = heapSort.tempohpAleatorio(v2, tam2);
        tempos[6][5] = heapSort.tempohpDecrescente(v2, tam2);
        
        tempos[6][0] = heapSort.tempohpCrescente(v1, tam1);
        tempos[6][1] = heapSort.tempohpAleatorio(v1, tam1);
        tempos[6][2] = heapSort.tempohpDecrescente(v1, tam1);
        
        
        // Impressão dos resultados com a formatação pedida no exercício
        System.out.println("Algoritmo\tCrescente\tAleatório\tDecrescente");
        System.out.println("\t\tn=20\tn=2000\tn=20\tn=2000\tn=20\tn=2000");
        System.out.println("Bubble Sort\t"+tempos[0][0]+"\t"+tempos[0][3]+"\t"+tempos[0][1]+"\t"+tempos[0][4]+"\t"+tempos[0][2]+"\t"+tempos[0][5]);
        System.out.println("Selection Sort\t"+tempos[1][0]+"\t"+tempos[1][3]+"\t"+tempos[1][1]+"\t"+tempos[1][4]+"\t"+tempos[1][2]+"\t"+tempos[1][5]);
        System.out.println("Insertion Sort\t"+tempos[2][0]+"\t"+tempos[2][3]+"\t"+tempos[2][1]+"\t"+tempos[2][4]+"\t"+tempos[2][2]+"\t"+tempos[2][5]);
        System.out.println("Merge Sort\t"+tempos[3][0]+"\t"+tempos[3][3]+"\t"+tempos[3][1]+"\t"+tempos[3][4]+"\t"+tempos[3][2]+"\t"+tempos[3][5]);
        System.out.println("Quick Sort\t"+tempos[4][0]+"\t"+tempos[4][3]+"\t"+tempos[4][1]+"\t"+tempos[4][4]+"\t"+tempos[4][2]+"\t"+tempos[4][5]);
        System.out.println("Counting Sort\t"+tempos[5][0]+"\t"+tempos[5][3]+"\t"+tempos[5][1]+"\t"+tempos[5][4]+"\t"+tempos[5][2]+"\t"+tempos[5][5]);
        System.out.println("Heap Sort\t"+tempos[6][0]+"\t"+tempos[6][3]+"\t"+tempos[6][1]+"\t"+tempos[6][4]+"\t"+tempos[6][2]+"\t"+tempos[6][5]);

    }

}
