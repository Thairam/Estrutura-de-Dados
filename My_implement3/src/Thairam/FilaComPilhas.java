package Thairam;

public class FilaComPilhas implements Fila_IF {

    PilhaComArray p1, p2;

    public FilaComPilhas(int tam) {
        p1 = new PilhaComArray(tam);
        p2 = new PilhaComArray(tam);
    }

    @Override
    public void enqueue(int element) throws Exception {
        if(p1.isFull()){
            throw new FilaOverflowException();
        } else {
            p1.push(element);
        }
    }

    @Override
    public int dequeue() throws Exception {
        int x = 0;
        
        if(p1.isEmpty()){
            throw new FilaUnderflowException();
        } else {
            x = p1.pop();
            
            while(!p1.isEmpty()){
                p2.push(x);
                x = p1.pop();
            }
            
            while(!p2.isEmpty()){
                p1.push(p2.pop());
            }
            return x;
        }
    }

    @Override
    public int head() throws Exception {
        int x = 0;
        
        if(p1.isEmpty()){
            throw new FilaUnderflowException();
        } else {
            do{
                x = p1.pop();
                p2.push(x);
            }while(!p1.isEmpty());
            
            while(!p2.isEmpty()){
                p1.push(p2.pop());
            }
        }
        return x;
    }

    @Override
    public boolean isEmpty() {
        if (p1.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if (p1.isFull()) {
            return true;
        } else {
            return false;
        }
    }

    private static class FilaUnderflowException extends Exception {

        public FilaUnderflowException() {
            System.out.println("--- FILA VAZIA ---");
        }
    }

    private static class FilaOverflowException extends Exception {

        public FilaOverflowException() {
            System.out.println("--- FILA CHEIA ---");
        }
    }

}
