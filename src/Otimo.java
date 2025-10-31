import java.util.ArrayList;
import java.util.HashSet;

public class Otimo {
    //Lógica: Remove a página que demorará mais tempo para ser usada novamente no futuro (ou que nunca mais será usada).
    public int simular(int[] paginas, int numQuadros) {
        //Utiliza um ArrayList para armazenar os quadros e um HashSet para checagem rápida de presença em O(1). 
        //A lógica principal "olha para o futuro" (o resto do array 'paginas') para decidir quem remover.
        int faltasDePagina = 0;
        ArrayList<Integer> quadros = new ArrayList<>();
        HashSet<Integer> quadrosSet = new HashSet<>();
        for (int i = 0; i < paginas.length; i++) {
            int paginaAtual = paginas[i];
            if (quadrosSet.contains(paginaAtual)) {
                continue; 
            }
            faltasDePagina++;
            if (quadrosSet.size() < numQuadros) {
                quadros.add(paginaAtual);
                quadrosSet.add(paginaAtual);
            } else {
                int paginaParaRemover = -1; 
                int maiorDistancia = -1;    
                for (int paginaNoQuadro : quadros) {  
                    int distanciaFutura = -1;
                    for (int j = i + 1; j < paginas.length; j++) {
                        if (paginas[j] == paginaNoQuadro) {
                            distanciaFutura = j; 
                            break;
                        }
                    }
                    if (distanciaFutura == -1) {
                        paginaParaRemover = paginaNoQuadro;
                        break;                   
                    } else {
                        if (distanciaFutura > maiorDistancia) {
                            maiorDistancia = distanciaFutura;
                            paginaParaRemover = paginaNoQuadro;
                        }
                    }
                }
                quadrosSet.remove(paginaParaRemover);
                quadros.remove(Integer.valueOf(paginaParaRemover)); 
                quadros.add(paginaAtual);
                quadrosSet.add(paginaAtual);
            }
        } 
        return faltasDePagina;
    }
}