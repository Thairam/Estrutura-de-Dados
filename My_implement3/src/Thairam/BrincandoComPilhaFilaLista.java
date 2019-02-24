package Thairam;

public class BrincandoComPilhaFilaLista {

    public static void main(String[] args) throws Exception {

        System.out.println("Brincando com PilhaComArray...");
        Pilha_IF minhaPilha1 = new PilhaComArray(5);
        minhaPilha1.push(100);
        minhaPilha1.push(200);
        System.out.println(minhaPilha1.top() == 200);
        System.out.println(minhaPilha1.pop() == 200);
        System.out.println(minhaPilha1.pop() == 100);
        System.out.println(minhaPilha1.isEmpty());
        System.out.println();
        System.out.println("Brincando com PilhaComFilas...");
        Pilha_IF minhaPilha2 = new PilhaComFilas(2);
        minhaPilha2.push(100);
        minhaPilha2.push(200);
        System.out.println(minhaPilha2.top() == 200);
        System.out.println(minhaPilha2.pop() == 200);
        System.out.println(minhaPilha2.pop() == 100);
        System.out.println(minhaPilha2.isEmpty());
        System.out.println();

        System.out.println("Brincando com FilaComArray...");
        Fila_IF minhaFila1 = new FilaComArray(20);
        minhaFila1.enqueue(100);
        minhaFila1.enqueue(200);
        System.out.println(minhaFila1.head() == 100);
        System.out.println(minhaFila1.dequeue() == 100);
        System.out.println(minhaFila1.dequeue() == 200);
        System.out.println(minhaFila1.isEmpty());
        System.out.println();

        System.out.println("Brincando com FilaComPilhas...");
        Fila_IF minhaFila2 = new FilaComPilhas(2);
        minhaFila2.enqueue(100);
        minhaFila2.enqueue(200);
        System.out.println(minhaFila2.head() == 100);
        System.out.println(minhaFila2.dequeue() == 100);
        System.out.println(minhaFila2.dequeue() == 200);
        System.out.println(minhaFila2.isEmpty());
        System.out.println();
        System.out.println("Brincando com qtdDiamantes...");
        System.out.println(qtdDiamantes("<..><.<..>>") == 3);
        System.out.println(qtdDiamantes("<<<..<......<<<<....>") == 1);
        System.out.println();

        System.out.println("Brincando com ListaEncadeada...");
        ListaEncadeada_IF lista = new ListaEncadeada();
        System.out.println(lista.isEmpty());
        System.out.println(lista.size() == 0);
        lista.insert(100);
        System.out.println(lista.size() == 1);
        System.out.println(lista.toArray()[0] == 100);
        lista.insert(200);
        System.out.println(lista.size() == 2);
        System.out.println(lista.toArray()[0] == 200);
        System.out.println(lista.toArray()[1] == 100);
        lista.insert(300);
        System.out.println(lista.size() == 3);
        System.out.println(lista.toArray()[0] == 300);
        System.out.println(lista.toArray()[1] == 200);
        System.out.println(lista.toArray()[2] == 100);
        lista.remove(100);
        System.out.println(lista.size() == 2);
        System.out.println(lista.toArray()[0] == 300);
        System.out.println(lista.toArray()[1] == 200);
        lista.remove(300);
        System.out.println(lista.size() == 1);
        System.out.println(lista.toArray()[0] == 200);
        System.out.println(lista.search(200) == 200);
        System.out.println();

        //OBS.: Espera-se que nenhum print mostre 'false' na tela! 
    }

    public static int qtdDiamantes(String entrada) throws Exception { //resolver problema 1069 do URI usando PilhaComFilas
        Pilha_IF p = new PilhaComFilas(1002);
        int cont = 0;
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '<') {
                p.push('<');
            } else if (entrada.charAt(i) == '>' && !p.isEmpty()) {
                cont++;
                p.pop();
            }
        }
        return cont;
    }
}
