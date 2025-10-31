# Simulador de Algoritmos de Substituição de Páginas

Este projeto é um simulador desenvolvido em Java para a disciplina de Sistemas Operacionais. O objetivo é avaliar e comparar o desempenho de diferentes algoritmos de substituição de páginas, calculando o número total de *page faults* (faltas de página) para uma dada sequência de referências de memória.

O simulador possui uma interface gráfica (GUI) construída com Java Swing, permitindo ao usuário inserir dados de forma interativa e visualizar os resultados comparativos.

## 📚 Algoritmos Implementados

O simulador implementa 4 dos principais algoritmos de substituição de páginas:

  * **FIFO (First-In, First-Out):** Substitui a página que está na memória há mais tempo.
  * **LRU (Least Recently Used):** Substitui a página que foi usada menos recentemente.
  * **Relógio (Clock / Segunda Chance):** Uma implementação mais eficiente que dá uma "segunda chance" a páginas que foram usadas recentemente (usando um bit de referência R).
  * **Ótimo (Optimal):** O algoritmo ideal (teórico), que substitui a página que demorará mais tempo para ser usada no futuro. Serve como *benchmark* para comparação.

## 🛠️ Tecnologias Utilizadas

  * **Java:** Linguagem principal do projeto.
  * **Java Swing:** Utilizado para a criação da interface gráfica (GUI).

## 🚀 Como Executar o Projeto

### Pré-requisitos

  * Ter o **Java Development Kit (JDK)** versão 8 ou superior instalado e configurado corretamente no seu sistema (com as variáveis de ambiente `JAVA_HOME` e `PATH` definidas).

-----

### Execução (Interface Gráfica - GUI)

**Opção 1: Via Linha de Comando**

1.  Clone ou baixe este repositório para sua máquina.
2.  Abra um terminal (Prompt de Comando, PowerShell, Terminal, etc.).
3.  Navegue até o diretório raiz do projeto (a pasta que contém todos os arquivos `.java`, como `SimuladorGUI.java`, `FIFO.java`, etc.).
4.  Compile todos os arquivos Java com o seguinte comando:
    ```bash
    javac *.java
    ```
5.  Após a compilação (que irá gerar os arquivos `.class`), execute a classe principal da GUI:
    ```bash
    java SimuladorGUI
    ```

-----

### Execução (Versão de Teste - Terminal)

O projeto também inclui uma classe `App.java` que roda a simulação diretamente no terminal com valores fixos (Sem GUI).

1.  Siga os passos 1 a 4 da **Opção 1** para compilar os arquivos (`javac *.java`).
2.  Execute a classe `App`:
    ```bash
    java App
    ```
    Isso irá imprimir os resultados no console com os dados de teste definidos no código.

## 🖥️ Como Usar a Interface

Ao executar o `SimuladorGUI`, a utilização é simples:

1.  **Sequência de Referências:** Insira a cadeia de números (páginas) separada por vírgulas.
      * *Exemplo:* `7,0,1,2,0,3,0,4,2,3,0,3,2`
2.  **Nº de Quadros:** Insira o número total de quadros de memória disponíveis (o tamanho da memória física).
      * *Exemplo:* `3`
3.  **Simular:** Clique no botão "Simular". Os resultados com as faltas de página para cada algoritmo serão exibidos na área de texto abaixo. O programa também trata entradas inválidas (como letras ou campos vazios).

-----

