/**
 * Classe que representa um voo e gere o seu próprio vetor estático de passageiros.
 */
public class Voo {
    // Atributos privados do voo
    private int numero;
    private String origem;
    private String destino;
    private String data;
    
    // Vetor de objetos para armazenar no máximo 50 passageiros
    private Passageiro[] passageiros;
    // Contador de controlo da quantidade atual de passageiros cadastrados no vetor
    private int quantidadePassageiros;

    /**
     * Construtor do Voo. Inicializa os dados e aloca o vetor com tamanho fixo 50.
     */
    public Voo(int numero, String origem, String destino, String data) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.passageiros = new Passageiro[50]; // Instancia o vetor estático de 50 posições
        this.quantidadePassageiros = 0;        // Inicializa o contador a zero
    }

    // --- Métodos Getters e Setters ---

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    // --- Métodos Auxiliares ---

    /**
     * Verifica se ainda existem assentos disponíveis no vetor do voo.
     */
    public boolean temAssentosLivres() {
        return quantidadePassageiros < 50;
    }

    /**
     * Calcula dinamicamente a quantidade de assentos livres.
     */
    public int getAssentosLivres() {
        return 50 - quantidadePassageiros;
    }

    /**
     * Adiciona um passageiro ao vetor do voo, se houver vaga.
     */
    public boolean adicionarPassageiro(Passageiro passageiro) {
        // Valida se o vetor já atingiu a capacidade máxima de 50 passageiros
        if (!temAssentosLivres()) {
            return false;
        }

        // Armazena o objeto na próxima posição livre e incrementa o contador
        passageiros[quantidadePassageiros] = passageiro;
        quantidadePassageiros++;
        return true;
    }

    /**
     * Imprime todos os dados detalhados do voo, incluindo passageiros e assentos vagos.
     */
    public void exibirDados() {
        System.out.println("\n--- Dados do voo ---");
        System.out.println("Número: " + numero);
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Data: " + data); // Exibe a data do voo

        System.out.println("\nPassageiros:");

        if (quantidadePassageiros == 0) {
            System.out.println("Nenhum passageiro cadastrado.");
        } else {
            // Percorre apenas as posições efetivamente ocupadas do vetor
            for (int i = 0; i < quantidadePassageiros; i++) {
                System.out.println((i + 1) + " - " + passageiros[i]);
            }
        }

        // Exibe a quantidade de lugares vagos[cite: 4]
        System.out.println("\nAssentos livres: " + getAssentosLivres());
    }

    /**
     * Resumo em linha do voo utilizado na listagem geral.
     */
    @Override
    public String toString() {
        return "Voo " + numero
                + " | Origem: " + origem
                + " | Destino: " + destino
                + " | Data: " + data
                + " | Passageiros: " + quantidadePassageiros;
    }
}