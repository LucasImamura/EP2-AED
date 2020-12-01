import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PilhaCorreta {
    protected int capacity;
    public static final int CAPACITY = 8;
    protected Integer[] pilha;
    protected int size;
	
	public PilhaCorreta(){
        capacity = CAPACITY;
        pilha = new Integer[capacity];
        size = 0;
    }
	
	public void add(int newElement){
		if(size == capacity){
			capacity = capacity*2;
	        Integer[] tmp = new Integer[capacity];
	        for(int j = 0; j < size; j++){
	        	tmp[j] = pilha[j];
	        }
	        pilha = tmp;
		}
	    pilha[size] = newElement;
	    size++;	
	}
	
	public int remove(){
        int tmp = pilha[size-1];
        size--;
        return tmp;
    }

	public static void main(String[] args) throws Exception{
		long inicio = System.currentTimeMillis();
		PilhaCorreta pilha = new PilhaCorreta();
		String caminho = "C:\\Users\\Usuario\\Desktop\\epAed\\tarefas1000.txt"; // inserir aqui o caminho da entrada
		File entrada = new File(caminho);
		Scanner scan = new Scanner(entrada);
		String saida = "";
		while(scan.hasNextLine()) {
			String tarefa = scan.nextLine();
			if(tarefa.equals("")) {
				saida += pilha.remove() + "\n";
			}
			else { 
				int cast = Integer.parseInt(tarefa);
				pilha.add(cast);
			}
		}
		Files.write(Paths.get("C:\\Users\\Usuario\\Desktop\\saida\\tarefas1000.txt"), saida.getBytes()); // inserir aqui o caminho da saída
		scan.close();
		long fim = System.currentTimeMillis();
		System.out.println("Tempo, em milissegundos:" + (fim - inicio));
		
	}

}