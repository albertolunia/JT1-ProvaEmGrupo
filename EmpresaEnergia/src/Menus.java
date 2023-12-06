package EmpresaEnergia.src;

import java.util.Scanner;


public class Menus {

    public static void menuPrincipal() {
        do{
            System.out.println("Menu Principal:\n");
            System.out.println("1. menuClientes()");
            System.out.println("2. menuImoveis()");
            System.out.println("3. menuFaturas()");
            System.out.println("4. menuPagamentos()");
            System.out.println("5. menuFalha()");
            System.out.println("6. Sair");

            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nDigite a opção desejada: ");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        menuClientes();
                        break;
                    case 2:
                        menuImoveis();
                        break;
                    case 3:
                        menuFaturas();
                        break;
                    case 4:
                        menuPagamentos();
                        break;
                    case 5:
                        menuFalha();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Escolha invalida, tente novamente.");
                        menuPrincipal();
                        break;
                }
            }
            catch(Exception e){
                System.out.println("\n-----Erro de digitação-----\n");
            }
        }while(true);
    }

    public static void menuClientes() {
        System.out.println("\nMenu Cliente:\n");
        System.out.println("1. Incluir");
        System.out.println("2. Adicionar imovel");
        System.out.println("3. Consultar");
        System.out.println("4. Listar");
        System.out.println("5. Excluir");
        System.out.println("6. Alterar");
        System.out.println("7. Voltar");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite a opção desejada: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\nDigite o CPF do cliente:");
                String cpf = scanner.next();
                System.out.println("Digite o nome do cliente:");
                String nome = scanner.next();

                Cliente cliente = new Cliente(cpf, nome);

                if(GestaoClientes.addCliente(cliente)) {
                    System.out.println("\nCliente adicionado com sucesso!");
                } else {
                    System.out.println("\nErro ao adicionar cliente!");
                }

                menuClientes();

                break;
            case 2:
                System.out.println("\nDigite o CPF do cliente:");
                String cpfCliente = scanner.next();

                Cliente cliente1 = GestaoClientes.getCliente(cpfCliente);

                if(cliente1 != null) {
                    System.out.println("\nCliente encontrado!");
                    System.out.println(cliente1.toString());

                    System.out.println("\nDigite a matricula do imovel:");
                    String matricula = scanner.next();

                    //Aguardando a logica de imoveis
                    /*Imovel imovel = GestaoImoveis.getIMovel(matricula);
    
                    if(cliente1.addImovel(imovel)) {
                        System.out.println("\nImovel adicionado com sucesso!");
                    } else {
                        System.out.println("\nErro ao adicionar imovel!");
                    }*/
                } else {
                    System.out.println("\nCliente não encontrado!");
                }

                menuClientes();
                break;
            case 3:

                System.out.println("\nDigite o CPF do cliente:");
                String cpfCliente1 = scanner.next();

                Cliente cliente2 = GestaoClientes.getCliente(cpfCliente1);

                if(cliente2 != null) {
                    System.out.println("\nCliente encontrado!");
                    System.out.println(cliente2.toString());
                } else {
                    System.out.println("\nCliente não encontrado!");
                }

                menuClientes();
                break;
            case 4:

                System.out.println("\nLista de clientes: ");
                GestaoClientes.ListarClientes();

                menuClientes();
                break;
            case 5:

                System.out.println("\nDigite o CPF do cliente:");
                String cpfCliente3 = scanner.next();

                Cliente cliente3 = GestaoClientes.getCliente(cpfCliente3);
                if(cliente3 != null) {
                    if(GestaoClientes.removeCliente(cliente3)) {
                        System.out.println("\nCliente removido com sucesso!");
                    } else {
                        System.out.println("\nErro ao remover cliente!");
                    }
                } else {
                    System.out.println("\nCliente não encontrado!");
                }

                menuClientes();
                break;
            case 6:

                System.out.println("\nDigite o CPF do cliente:");
                String cpfCliente4 = scanner.next();

                Cliente cliente4 = GestaoClientes.getCliente(cpfCliente4);

                if(cliente4 != null) {
                    System.out.println("\nCliente encontrado!");
                    System.out.println(cliente4.toString());

                    System.out.println("\nDigite o novo CPF do cliente:");
                    String novoCpf = scanner.next();

                    if(GestaoClientes.getCliente(novoCpf) != null) {
                        System.out.println("\nCPF já cadastrado!");
                        menuClientes();
                        break;
                    } else {
                        cliente4.setCpf(novoCpf);
                    }
                    
                    System.out.println("\nDigite o novo nome do cliente:");
                    String novoNome = scanner.next();
    
                    cliente4.alterarCliente(novoCpf, novoNome);
    
                    System.out.println("\nCliente alterado com sucesso!");
                } else {
                    System.out.println("\nCliente não encontrado!");
                }

                menuClientes();
                break;
            case 7:

                menuPrincipal();
                break;

            default:

                System.out.println("\nEscolha invalida, tente novamente");
                menuClientes();
                break;
        }
    }

    public static void menuImoveis() {
        System.out.println("Menu Imoveis: \n");
        System.out.println("1. Incluir");
        System.out.println("2. Consultar");
        System.out.println("3. Listar");
        System.out.println("4. Excluir");
        System.out.println("5. Alterar");
        System.out.println("6. Voltar");
    }

    public static void menuFaturas() {
        System.out.println("Menu Fatura\n");
        System.out.println("1. Criar");
        System.out.println("2. Listar todas");
        System.out.println("3. Listar em aberto");

    }

    public static void menuPagamentos() {
        System.out.println("Menu Pagamento:\n");
        System.out.println("1. Realizar pagamento");
        System.out.println("2. Listar pagamentos");
        System.out.println("3. Listar pagamentos por fatura");
        System.out.println("4. Listar reembolsos");
        System.out.println("5. Listar reembolsos por fatura");

    }

    public static void menuFalha() {
        System.out.println("Menu Falha:\n");
        System.out.println("1. Incluir Falha");
        System.out.println("2. menuReparos()");

    }

    public static void menuReparos() {
        System.out.println("Menu Reparo:\n");
        System.out.println("1. Listar em aberto");
        System.out.println("2. Encerrar reparo");

    }
}
