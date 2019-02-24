package my_implement4;

import java.util.ArrayList;

public class TabelaHash implements TabelaHash_IF {

    ArrayList<ListaEncadeada> tabela = new ArrayList<>();
    ListaEncadeada lista;

    public TabelaHash(int i) {
        for (int j = 0; j < i; j++) {
            lista = new ListaEncadeada();
            tabela.add(lista);

        }
    }
    
    private int hash(int chave){
        return chave % this.tabela.size();
    }

    @Override
    public void insert(int element) {
        lista = this.tabela.get(hash(element));
        try {
            lista.search(element);
        } catch (Exception ex) {
            lista.insert(element);
        }
    }

    @Override
    public void remove(int element) throws Exception {
            lista = this.tabela.get(hash(element));
            lista.remove(element);  
    }

    @Override
    public int search(int element) throws Exception {
            lista = this.tabela.get(hash(element));
            return lista.search(element);
    }

    @Override
    public String print() {

        String table = "";
        for (int i = 0; i < tabela.size(); i++) {

            lista = this.tabela.get(i);

            int[] aux = lista.toArray();
            table += i + ": ";

            for (int j = 0; j < aux.length; j++) {
                table += aux[j];

                if (j < aux.length - 1) {
                    table += ", ";
                }
            }

            if (i < tabela.size() - 1) {
                table += "\n";
            }

        }

        return table;
    }

    /*       0: 24, 16
	 1: 
	 2: 10
	 3: 19, 11, 3
	 4: 12, 4
	 5: 
	 6: 22, 14, 6
	 7: 15
     */
}
