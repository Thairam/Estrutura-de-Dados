package my_implement4;

/*
 * Interface para implementa��o da classe "BST"
 */
public interface BST_IF {
	public void insert(int element);
	public int search(int element) throws Exception; //lan�ar exce��o caso n�o encontre
	public int remove(int element) throws Exception; //lan�ar exce��o caso o element n�o esteja na BST
	public int[] preOrder();
	public int[] order();
	public int[] postOrder();
	public boolean isComplete();
}
