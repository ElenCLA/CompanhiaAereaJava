import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Classe executável principal do sistema (contém o método main).
 * Gere a interação do menu no terminal e as entradas de dados do utilizador.
 */
public class CompanhiaAerea {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Instancia a companhia aérea
        Companhia companhia = new Companhia("Companhia Aerea");

        int opcao;

        // Laço principal de navegação do menu
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarVoo(companhia);
                    break;

                case 2:
                    companhia.listarVoos();
                    break;

                case 3:
                    consultarVoo(companhia);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao inexistente. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close(); // Fecha o leitor de entradas
    }

    /**
     * Exibe o menu principal de opções no consola.
     */
    private static void exibirMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Cadastrar voo");
        System.out.println("2 - Listar voos");
        System.out.println("3 - Consultar um determinado voo");
        System.out.println("0 - Sair");
    }

    /**
     * Lógica para cadastrar um novo voo com validações antecipadas.
     */
    private static void cadastrarVoo(Companhia companhia) {
        System.out.println("\n--- Cadastro de voo ---");

        // 1. Validação Antecipada: Verifica se o vetor da companhia já está cheio
        if (!companhia.temCapacidadeVoos()) {
            System.out.println("Não é possível cadastrar: A companhia já atingiu o limite máximo de 10 voos.");
            return;
        }

        int numero = lerInteiro("Numero do voo: ");

        // 2. Validação Antecipada: Verifica se já existe um voo com este número
        if (companhia.consultarVoo(numero) != null) {
            System.out.println("Não é possível cadastrar: Já existe um voo cadastrado com o número " + numero + ".");
            return;
        }

        System.out.print("Origem: ");
        String origem = scanner.nextLine();

        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Data do voo: ");
        String data = scanner.nextLine();

        // Cria o objeto do voo
        Voo voo = new Voo(numero, origem, destino, data);

        int quantidade = lerInteiro("Quantidade de passageiros: ");

        // Validação da quantidade informada (deve estar entre 0 e 50)
        while (quantidade < 0 || quantidade > 50) {
            System.out.println("A quantidade deve estar entre 0 e 50.");
            quantidade = lerInteiro("Quantidade de passageiros: ");
        }

        // Leitura e associação de cada passageiro ao voo
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nPassageiro " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            // Adiciona o passageiro no vetor interno do voo
            voo.adicionarPassageiro(new Passageiro(nome, cpf));
        }

        // Guarda o voo na companhia aérea
        if (companhia.adicionarVoo(voo)) {
            System.out.println("Voo cadastrado com sucesso.");
        } else {
            System.out.println("Nao foi possivel cadastrar o voo.");
        }
    }

    /**
     * Pede o número do voo e exibe a sua consulta detalhada.
     */
    private static void consultarVoo(Companhia companhia) {
        int numero = lerInteiro("Informe o numero do voo: ");

        Voo voo = companhia.consultarVoo(numero);

        if (voo == null) {
            System.out.println("Voo nao encontrado.");
        } else {
            voo.exibirDados();
        }
    }

    /**
     * Método auxiliar de leitura segura para prevenir exceções na digitação de números inteiros.
     */
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = scanner.nextLine();

                if (entrada == null || entrada.trim().isEmpty()) {
                    System.out.println("Digite um numero valido.");
                    continue;
                }

                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero valido.");
            } catch (NoSuchElementException erro) {
                System.out.println("\nEntrada de dados encerrada. Programa finalizado.");
                System.exit(0);
                return 0;
            }
        }
    }
}