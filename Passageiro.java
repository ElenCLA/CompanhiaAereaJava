/**
 * Classe responsável por representar a entidade Passageiro no sistema.
 */
public class Passageiro {
    // Atributos privados para garantir o encapsulamento dos dados
    private String nome;
    private String cpf;

    /**
     * Construtor que inicializa um novo passageiro com nome e CPF.
     */
    public Passageiro(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // --- Métodos Getters e Setters (Acesso e Modificação Protegida) ---

    /** Retorna o nome do passageiro */
    public String getNome() {
        return nome;
    }

    /** Define/Altera o nome do passageiro */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Retorna o CPF do passageiro */
    public String getCpf() {
        return cpf;
    }

    /** Define/Altera o CPF do passageiro */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Sobrescrita do método toString para exibição formatada do passageiro.
     * conceito importante da herança e da orientação a objetos
     */
    @Override
    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}