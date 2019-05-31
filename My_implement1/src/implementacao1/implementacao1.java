package implementacao1;

/**
 *
 * @author Thairam Michel Santos Ataide
 */
public class implementacao1 {

    private static long buscaLinear(int n) {
        int vetor[] = new int[n];

        long inicio = 0;
        long termino = 0;
        long total = 0;

        for (int i = 0; i < 1000000; i++) {

            inicio = System.nanoTime();

            for (int j = 0; j < n; j++) {

                if (vetor[j] == -1) {
                    return vetor[j];
                }
            }
            termino = System.nanoTime();

            total += (termino - inicio);
        }

        return (total / 1000000);
    }

    private static long buscaBinaria(int n, int x) {

        int vetor[] = new int[n];
        int inicio = 0, fim = vetor.length - 1;
        long t_inicio = 0, t_fim = 0;
        long total = 0;

        for (int i = 0; i < 1000000; i++) {

            t_inicio = System.nanoTime();
            while (inicio <= fim) {
                int meio = ((inicio + fim) / 2);
                if (vetor[meio] == x) {
                    return meio;
                } else if (vetor[meio] < x) {
                    inicio = meio + 1;
                } else if (vetor[meio] > x) {
                    fim = meio - 1;
                }
            }

            t_fim = System.nanoTime();

            total += t_fim - t_inicio;

        }

        return (total / 1000000);

    }

    private static void cab() {
        System.out.println("Tam\tBusca Linear\tBusca Binária\n");
        System.out.println("100\t" + buscaLinear(100) + "\t\t" + buscaBinaria(100, -2));
        System.out.println("1000\t" + buscaLinear(1000) + "\t\t" + buscaBinaria(1000, -2));
        System.out.println("10000\t" + buscaLinear(10000) + "\t\t" + buscaBinaria(10000, -2));

    }

    public static void main(String[] args) {
        cab();
    }

}
