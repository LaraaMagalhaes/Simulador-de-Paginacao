import java.util.LinkedList;
import java.util.HashSet;

public class LRU {
    //Lógica: Remove a página que foi usada menos recentemente.
    public int simular(int[] paginas, int numQuadros) {
        //Utiliza a LinkedList para manter a ordem de uso (o menos recente fica no início, o mais recente no fim) 
        //e o HashSet para checar rapidamente se a página já está na memória.
        int faltasDePagina = 0;
        HashSet<Integer> quadrosSet = new HashSet<>();
        LinkedList<Integer> quadrosLRU = new LinkedList<>();
        for (int paginaAtual : paginas) {
            if (quadrosSet.contains(paginaAtual)) {
                quadrosLRU.remove((Integer) paginaAtual);
                quadrosLRU.addLast(paginaAtual);
            } else {
                faltasDePagina++;
                if (quadrosLRU.size() == numQuadros) {
                    int paginaRemovida = quadrosLRU.removeFirst(); 
                    quadrosSet.remove(paginaRemovida);
                }
                quadrosLRU.addLast(paginaAtual);
                quadrosSet.add(paginaAtual);
            }
        }        
        return faltasDePagina;
    }
}