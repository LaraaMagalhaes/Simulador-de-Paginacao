import java.util.ArrayList;
import java.util.HashMap;

public class Relogio {
    //Lógica: Dá uma "segunda chance" às páginas usadas (bit R=1) e remove a primeira página não usada (bit R=0) que encontrar.
    private class PaginaRelogio {
        int numeroPagina;
        boolean bitR; 
        PaginaRelogio(int numeroPagina) {
            this.numeroPagina = numeroPagina;
            this.bitR = true; 
        }
    }
    public int simular(int[] paginas, int numQuadros) {
        //Utiliza um ArrayList como buffer circular (o "relógio") e um 'ponteiro' para indicar a posição atual. 
        //O HashMap permite checar em O(1) se a página está na memória e acessar seu bit R.
        int faltasDePagina = 0;
        int ponteiro = 0; 
        ArrayList<PaginaRelogio> quadrosCirculares = new ArrayList<>(numQuadros);
        HashMap<Integer, PaginaRelogio> mapaPaginas = new HashMap<>();
        for (int paginaAtual : paginas) {
            if (mapaPaginas.containsKey(paginaAtual)) {
                mapaPaginas.get(paginaAtual).bitR = true;
            
            } else {
                faltasDePagina++;
                if (mapaPaginas.size() < numQuadros) {
                    PaginaRelogio novaPagina = new PaginaRelogio(paginaAtual);
                    quadrosCirculares.add(novaPagina); 
                    mapaPaginas.put(paginaAtual, novaPagina); 
                } else {
                    while (true) {
                        PaginaRelogio paginaAlvo = quadrosCirculares.get(ponteiro);
                        if (paginaAlvo.bitR == true) {
                            paginaAlvo.bitR = false;
                            ponteiro = (ponteiro + 1) % numQuadros; 
                        } else {
                            mapaPaginas.remove(paginaAlvo.numeroPagina);
                            PaginaRelogio novaPagina = new PaginaRelogio(paginaAtual);
                            quadrosCirculares.set(ponteiro, novaPagina);
                            mapaPaginas.put(paginaAtual, novaPagina);
                            ponteiro = (ponteiro + 1) % numQuadros;
                            break; 
                        }
                    } 
                } 
            } 
        } 
        return faltasDePagina;
    }
}