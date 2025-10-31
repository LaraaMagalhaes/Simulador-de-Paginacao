public class App {

    public static void main(String[] args) {
        int[] sequenciaDeReferencias = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        int numeroDeQuadros = 2;

        // Cria um "objeto" para cada lógica de simulação
        FIFO algoFIFO = new FIFO();
        LRU algoLRU = new LRU();
        Relogio algoRelogio = new Relogio();
        Otimo algoOtimo = new Otimo();

        // Cada objeto agora calcula seu próprio resultado
        int faltasFIFO = algoFIFO.simular(sequenciaDeReferencias, numeroDeQuadros);
        int faltasLRU = algoLRU.simular(sequenciaDeReferencias, numeroDeQuadros);
        int faltasRelogio = algoRelogio.simular(sequenciaDeReferencias, numeroDeQuadros);
        int faltasOtimo = algoOtimo.simular(sequenciaDeReferencias, numeroDeQuadros);

        System.out.println("Simulação com " + numeroDeQuadros + " quadros de memória:");
        System.out.println("Método FIFO - " + faltasFIFO + " faltas de página");
        System.out.println("Método LRU - " + faltasLRU + " faltas de página");
        System.out.println("Método Relógio - " + faltasRelogio + " faltas de página");
        System.out.println("Método Ótimo - " + faltasOtimo + " faltas de página");
    }
}
