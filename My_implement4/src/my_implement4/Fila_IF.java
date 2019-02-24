package my_implement4;

/*
 * Interface para implementação da Fila de Prioridades (classe "MinHeap")
 */
public interface Fila_IF {
	public void enqueue(int element) throws Exception; //não permitir senhas repetidas
	public int dequeue() throws Exception;
	public int head() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
}
