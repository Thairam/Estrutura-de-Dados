package Testes;

import my_implement4.TabelaHash;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Hash {
    
    	static TabelaHash t ;
		
	@Before//Instanciando a tabela antes de cada teste
	public void instanciaTabela() throws Exception{
		t = new TabelaHash(19);
	}
	
        //Verifica se os elementos foram inseridos na tabela.
	@Test
	public void testInsert() throws Exception{
		for(int i= 0; i < 20; i++){
			t.insert(i+1);
		}
		assertEquals(10, t.search(10));
	}        
        
        //Procura um elemento em uma tabela vazia
        //Espera uma excecao.
	@Test(expected = Exception.class)
	public void testSearch1() throws Exception{
		t.search(8);
	}
	
        //Procura um elemento na tabela.
	@Test
	public void testSearch2() throws Exception{
		for(int i= 0; i < 20; i++){
			t.insert(i+1);
		}
		assertEquals(8, t.search(8));
	}
	
        //Verifica se o elemento e removido da tabela.
        //Espera uma excecao.
	@Test(expected = Exception.class)
	public void testRemove() throws Exception{
		for(int i= 0; i < 20; i++){
			t.insert(i+1);
		}
		//t.insert(5);//Caso a tabela coloque elementos repetidos
		t.remove(5);
		t.search(5);
	}
	
	
        //Insere um elemento repetido na tabela.
        //Espera uma excecao.
	@Test(expected = Exception.class)
	public void testRepetido() throws Exception{
		for(int i= 0; i < 10; i++){
			t.insert(3);
		}
		t.remove(3);
		t.search(3);
	}
	
        //Testa o método print().
	@Test
	public void testPrint1() throws Exception{
		t = new TabelaHash(8);
		int vet[] = {3,4,6,10,11,12,14,15,16,19,22,24};
		for(int i= 0; i < vet.length; i++){
			t.insert(vet[i]);
		}
		String aux = 
				"0: 24, 16\n"+
				"1: \n"+ 
				"2: 10\n"+
				"3: 19, 11, 3\n"+
				"4: 12, 4\n"+
				"5: \n"+ 
				"6: 22, 14, 6\n"+
				"7: 15";
		System.out.println(" - - - - - - - - - - TestePrint1 - - - - - - - - - -");
		System.out.println("Deveria imprimir:");
		System.out.println(aux);
		System.out.println("O que imprimiu:");
		System.out.println(t.print());
		System.out.println();
		assertTrue(aux.equals(t.print()));
	}
	
        //Testa o método print().
	@Test
	public void testPrint2() throws Exception{
		for(int i= 0; i < 20; i++){
			t.insert(i+1);
		}
		String aux = "0: 19\n"+
					 "1: 20, 1\n"+
				     "2: 2\n"+
					 "3: 3\n"+
				     "4: 4\n"+
					 "5: 5\n"+
				     "6: 6\n"+
					 "7: 7\n"+
				     "8: 8\n"+
					 "9: 9\n"+
				     "10: 10\n"+
					 "11: 11\n"+
				     "12: 12\n"+
					 "13: 13\n"+
				     "14: 14\n"+
					 "15: 15\n"+
				     "16: 16\n"+
					 "17: 17\n"+
				     "18: 18";
		System.out.println(" - - - - - - - - - - TestePrint2 - - - - - - - - - -");
		System.out.println("Deveria imprimir:");
		System.out.println(aux);
		System.out.println("O que imprimiu:");
		System.out.println(t.print());
		System.out.println();
		assertTrue(aux.equals(t.print()));
	}	
}
