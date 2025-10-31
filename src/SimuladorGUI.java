import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SimuladorGUI extends JFrame {
    private final JLabel labelSequencia;
    private final JLabel labelQuadros;
    private final JTextField campoSequencia;
    private final JTextField campoQuadros;
    private final JButton botaoSimular;
    private final JTextArea areaResultados;

    public SimuladorGUI() {

        setTitle("Simulador de Substituição de Páginas");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400);

        labelSequencia = new JLabel("Sequência de Referências (separe por vírgula):");
        campoSequencia = new JTextField("7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1", 40);
        labelQuadros = new JLabel("Nº de Quadros:");
        campoQuadros = new JTextField("3", 5);
        botaoSimular = new JButton("Simular");
        areaResultados = new JTextArea(10, 50);
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));


        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        painelEntrada.add(labelSequencia, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        painelEntrada.add(campoSequencia, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        painelEntrada.add(labelQuadros, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        painelEntrada.add(campoQuadros, gbc);

        JScrollPane painelScrollResultados = new JScrollPane(areaResultados);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza o botão
        painelBotao.add(botaoSimular);

        painelPrincipal.add(painelEntrada, BorderLayout.NORTH);
        painelPrincipal.add(painelScrollResultados, BorderLayout.CENTER);
        painelPrincipal.add(painelBotao, BorderLayout.SOUTH);

        add(painelPrincipal);

        botaoSimular.addActionListener(e -> executarSimulacao());
    }
    private void executarSimulacao() {
        try {
            String textoSequencia = campoSequencia.getText();
            int numQuadros = Integer.parseInt(campoQuadros.getText().trim());

            String[] partes = textoSequencia.split(",");
            int[] sequenciaDeReferencias = new int[partes.length];

            for (int i = 0; i < partes.length; i++) {
                sequenciaDeReferencias[i] = Integer.parseInt(partes[i].trim());
            }

            FIFO algoFIFO = new FIFO();
            LRU algoLRU = new LRU();
            Relogio algoRelogio = new Relogio();
            Otimo algoOtimo = new Otimo();

            int faltasFIFO = algoFIFO.simular(sequenciaDeReferencias, numQuadros);
            int faltasLRU = algoLRU.simular(sequenciaDeReferencias, numQuadros);
            int faltasRelogio = algoRelogio.simular(sequenciaDeReferencias, numQuadros);
            int faltasOtimo = algoOtimo.simular(sequenciaDeReferencias, numQuadros);

            areaResultados.setText("");
            areaResultados.append("Simulação com " + numQuadros + " quadros:\n");
            areaResultados.append("Sequência: " + Arrays.toString(sequenciaDeReferencias) + "\n\n");
            areaResultados.append("Método FIFO - " + faltasFIFO + " faltas de página\n");
            areaResultados.append("Método LRU - " + faltasLRU + " faltas de página\n");
            areaResultados.append("Método Relógio - " + faltasRelogio + " faltas de página\n");
            areaResultados.append("Método Ótimo - " + faltasOtimo + " faltas de página\n");

        } catch (NumberFormatException ex) {
            areaResultados.setText("ERRO: Verifique os dados de entrada.\n");
            areaResultados.append("A sequência deve ser de números separados por vírgula (ex: 7,0,1).\n");
            areaResultados.append("O número de quadros deve ser um único número (ex: 3).");
        } catch (Exception ex) {
            areaResultados.setText("Ocorreu um erro inesperado: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SimuladorGUI gui = new SimuladorGUI();
                gui.setVisible(true);
        });
    }
}
