/**
 * Classe responsável por gerir a frota de voos da companhia aérea.
 */
public class Companhia {
    private String nome;
    // Vetor de objetos para armazenar até 10 voos
    private Voo[] voos;
    // Contador de controlo da quantidade de voos inseridos no vetor
    private int quantidadeVoos;

    /**
     * Construtor da Companhia. Instancia o vetor fixo para 10 voos.
     */
    public Companhia(String nome) {
        this.nome = nome;
        this.voos = new Voo[10]; // Instancia vetor estático de tamanho 10
        this.quantidadeVoos = 0; // Inicializa contador
    }

    // --- Métodos Getters e Setters ---

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeVoos() {
        return quantidadeVoos;
    }

    /**
     * Verifica se a companhia ainda pode receber novos voos (limite de 10).
     */
    public boolean temCapacidadeVoos() {
        return quantidadeVoos < 10;
    }

    /**
     * Adiciona um novo voo ao vetor da companhia após validações.
     */
    public boolean adicionarVoo(Voo voo) {
        // Valida o limite do vetor[cite: 1]
        if (!temCapacidadeVoos()) {
            return false;
        }

        // Valida se já existe um voo com o mesmo número
        if (consultarVoo(voo.getNumero()) != null) {
            return false;
        }

        // Insere o voo no vetor e incrementa o contador
        voos[quantidadeVoos] = voo;
        quantidadeVoos++;
        return true;
    }

    /**
     * Imprime a lista resumida de todos os voos atualmente cadastrados.
     */
    public void listarVoos() {
        System.out.println("Lista de voos da companhia " + nome + ":");

        if (quantidadeVoos == 0) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }

        // Percorre o vetor imprimindo cada voo com quebra de linha
        for (int i = 0; i < quantidadeVoos; i++) {
            System.out.println("\n" + voos[i]);
        }
    }

    /**
     * Realiza uma pesquisa linear no vetor à procura do número do voo.
     */
    public Voo consultarVoo(int numero) {
        for (int i = 0; i < quantidadeVoos; i++) {
            if (voos[i].getNumero() == numero) {
                return voos[i]; // Retorna a referência do objeto encontrado
            }
        }
        return null; // Retorna null caso o voo não seja localizado
    }
}