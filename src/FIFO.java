import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet; 

public class FIFO {
    //Lógica: Remove a página que está na memória há mais tempo.
    public int simular(int[] paginas, int numQuadros) {
        //Utiliza a fila para dizer quem será o primeiro a ser removido e o conjunto hashSet diz se uma página já está na memória
        int faltasDePagina = 0;
        Queue<Integer> quadrosFila = new LinkedList<>();
        HashSet<Integer> quadrosSet = new HashSet<>();
        for (int paginaAtual : paginas) {
            if (!quadrosSet.contains(paginaAtual)) {
                faltasDePagina++;
                if (quadrosFila.size() == numQuadros) {
                    int paginaRemovida = quadrosFila.poll();
                    quadrosSet.remove(paginaRemovida);
                }
                quadrosFila.add(paginaAtual);
                quadrosSet.add(paginaAtual);
                
            } else {
            }
        } 
        return faltasDePagina;
    }
}