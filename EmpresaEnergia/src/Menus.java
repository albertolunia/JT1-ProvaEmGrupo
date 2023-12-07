package EmpresaEnergia.src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Menus {

    public static void menuPrincipal() {
        int opcao;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu Principal:\n");
            System.out.println("1. Menu Clientes");
            System.out.println("2. Menu Imoveis");
            System.out.println("3. Menu Faturas");
            System.out.println("4. Menu Pagamentos");
            System.out.println("5. Menu Falha");
            System.out.println("6. Sair");

            System.out.print("\nDigite a opção desejada: ");
            try{
                opcao = scanner.nextInt();
                scanner.nextLine();
            }
            catch(Exception e){
                System.out.println("\n-----Erro de digitação-----\n");
                continue;
            }
            switch (opcao) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuImoveis(scanner);
                    break;
                case 3:
                    menuFaturas(scanner);
                    break;
                case 4:
                    menuPagamentos();
                    break;
                case 5:
                    menuFalha(scanner);
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha invalida, tente novamente.");
                    menuPrincipal();
                    break;
            }
        }while(true);
    }

    public static void menuClientes(Scanner scanner){
        do{
            System.out.println("\nMenu Cliente:\n");
            System.out.println("1. Incluir");
            System.out.println("2. Adicionar imovel");
            System.out.println("3. Consultar");
            System.out.println("4. Listar");
            System.out.println("5. Excluir");
            System.out.println("6. Alterar");
            System.out.println("7. Voltar");

            System.out.print("\nDigite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();

                    Cliente cliente = new Cliente(cpf, nome);

                    if(GestaoClientes.addCliente(cliente)) {
                        System.out.println("\nCliente adicionado com sucesso!");
                    } else {
                        System.out.println("\nErro ao adicionar cliente!");
                    }


                    break;
                case 2:
                    System.out.println("\nDigite o CPF do cliente:");
                    String cpfCliente = scanner.nextLine();

                    Cliente cliente1 = GestaoClientes.getCliente(cpfCliente);

                    if(cliente1 != null) {

                        System.out.println("\nDigite a matricula do imovel:");
                        String matricula = scanner.nextLine();

                        
                        Imovel imovel = GestaoImoveis.getImovel(matricula);
        
                        if (imovel == null) {
                            System.out.println("\nImovel não encontrado!");
                            break;
                        }

                        if(cliente1.addImovel(imovel)) {
                            System.out.println("\nImovel adicionado com sucesso!");
                        } else {
                            System.out.println("\nErro ao adicionar imovel!");
                        }
                    } else {
                        System.out.println("\nCliente não encontrado!");
                    }

                    break;
                case 3:

                    System.out.println("\nDigite o CPF do cliente:");
                    String cpfCliente1 = scanner.nextLine();

                    Cliente cliente2 = GestaoClientes.getCliente(cpfCliente1);

                    if(cliente2 != null) {
                        System.out.println("\nCliente encontrado!");
                        System.out.println(cliente2.toString());
                    } else {
                        System.out.println("\nCliente não encontrado!");
                    }

                    break;
                case 4:

                    System.out.println("\nLista de clientes: ");
                    GestaoClientes.ListarClientes();

                    break;
                case 5:

                    System.out.println("\nDigite o CPF do cliente:");
                    String cpfCliente3 = scanner.nextLine();

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
                    break;
                case 6:

                    System.out.println("\nDigite o CPF do cliente:");
                    String cpfCliente4 = scanner.nextLine();

                    Cliente cliente4 = GestaoClientes.getCliente(cpfCliente4);

                    if(cliente4 != null) {
                        System.out.println("\nCliente encontrado!");
                        System.out.println(cliente4.toString());

                        System.out.println("\nDigite o novo CPF do cliente:");
                        String novoCpf = scanner.nextLine();
                        System.out.println("\nDigite o novo nome do cliente:");
                        String novoNome = scanner.nextLine();
        
                        cliente4.alterarCliente(novoCpf, novoNome);
        
                        System.out.println("\nCliente alterado com sucesso!");
                    } else {
                        System.out.println("\nCliente não encontrado!");
                    }
                    break;
                case 7:
                    return;

                default:
                    System.out.println("\nEscolha invalida, tente novamente");
                    break;
            }
        }while(true);
    }

    public static void menuImoveis(Scanner scanner) {
        int opc;
        
        do{
            System.out.println("Menu Imoveis: \n");
            System.out.println("1. Incluir");
            System.out.println("2. Consultar");
            System.out.println("3. Listar");
            System.out.println("4. Excluir");
            System.out.println("5. Alterar");
            System.out.println("6. Voltar");

            System.out.print("\nDigite a opção desejada: ");
            try{
                opc = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                System.out.println("\n-----Erro de digitação-----\n");
                break;
            }

            switch (opc) {
                case 1:
                    System.out.println("\nDigite a matricula do imovel:");
                    String matricula = scanner.nextLine();

                    System.out.println("Digite o endereco do imovel:");
                    String endereco = scanner.nextLine();

                    Imovel imovel = new Imovel(matricula, endereco);

                    if(GestaoImoveis.addImovel(imovel)) {
                        System.out.println("\nImovel adicionado com sucesso!");
                    } else {
                        System.out.println("\nImovel já cadastrado!");
                    }
                    break;
                case 2:
                    System.out.println("\nDigite a matricula do imovel:");
                    String matricula1 = scanner.nextLine();

                    Imovel imovel1 = GestaoImoveis.getImovel(matricula1);

                    if(imovel1 != null) {
                        System.out.println(imovel1.toString());
                    } else {
                        System.out.println("\nImovel não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("\nLista de imoveis: ");
                    GestaoImoveis.ListarImoveis();
                    break;
                case 4:
                    System.out.println("\nDigite a matricula do imovel:");
                    String matricula2 = scanner.nextLine();

                    Imovel imovel2 = GestaoImoveis.getImovel(matricula2);

                    if(GestaoImoveis.removeImovel(imovel2)) {
                        System.out.println("\nImovel removido com sucesso!");
                    } else {
                        System.out.println("\nImovel nao encontrado!");
                    }
                    break;
                case 5:
                    System.out.println("\nDigite a matricula do imovel:");
                    String matricula3 = scanner.nextLine();

                    Imovel imovel3 = GestaoImoveis.getImovel(matricula3);

                    if(imovel3 != null) {
                        System.out.println(imovel3.toString());

                        System.out.println("\nDigite o novo endereco do imovel:");
                        String novoEndereco = scanner.nextLine();
        
                        imovel3.setEndereco(novoEndereco);
        
                        System.out.println("\nImovel alterado com sucesso!");
                    } else {
                        System.out.println("\nImovel não encontrado!");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("\nEscolha invalida, tente novamente");
                    break;
            }
        }while(true);
    }

    public static void menuFaturas(Scanner scanner) {
        int opc;
        
        do{
            System.out.println("Menu Fatura\n");
            System.out.println("1. Criar");
            System.out.println("2. Listar todas");
            System.out.println("3. Listar em aberto");
            System.out.println("4. Voltar");

            System.out.print("\nDigite a opção desejada: ");
            try{
                opc = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                System.out.println("\n-----Erro de digitação-----\n");
                break;
            }

            switch (opc) {
                case 1:
                    System.out.println("\nDigite a matricula do imovel:");
                    String matricula = scanner.nextLine();

                    Imovel imovel = GestaoImoveis.getImovel(matricula);

                    if(imovel != null) {
                        System.out.println("\nDigite a ultima leitura:");
                        int ultimaLeitura = scanner.nextInt();
                        scanner.nextLine();

                        if (!imovel.getUltimaFatura().isQuitado()) {
                            System.out.println("\nFatura anterior não quitada!");
                            break;
                        }

                        float gasto = imovel.realizarLeitura(ultimaLeitura);
                        
                        if (gasto < 0) {
                            System.out.println("\nLeitura invalida!");
                            break;
                        }
                        Fatura fatura = imovel.getUltimaFatura();

                        GestaoFatura.addFatura(fatura);

                        System.out.println("\nFatura criada com sucesso!");
                        System.out.println(fatura.toString());
                    } else {
                        System.out.println("\nImovel não encontrado!");
                    }
                    break;
                case 2:
                    System.out.println("\nLista de faturas: ");
                    GestaoFatura.listarTodasFaturas();
                    break;
                case 3:
                    System.out.println("\nLista de faturas em aberto: ");
                    GestaoFatura.listarFaturasEmAberto();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("\nEscolha invalida, tente novamente");
                    break;
            }
        }while(true);
        

    }

    public static void menuPagamentos() {
        System.out.println("Menu Pagamento:\n");
        System.out.println("1. Realizar pagamento");
        System.out.println("2. Listar pagamentos");
        System.out.println("3. Listar pagamentos por fatura");
        System.out.println("4. Listar reembolsos");
        System.out.println("5. Listar reembolsos por fatura");

    }

    public static void menuFalha(Scanner scanner) {
        int opc;
        do{

            System.out.println("Menu Falha:\n");
            System.out.println("1. Incluir Falha");
            System.out.println("2. Listar Falhas");
            System.out.println("3. Menu de Reparos");
            System.out.println("0. Voltar");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch(opc){
                case 1:
                    System.out.println("Digite a matricula do imovel:");
                    String matricula = scanner.nextLine();

                    Imovel imovel = GestaoImoveis.getImovel(matricula);

                    if(imovel != null) {
                        System.out.println("Digite a descricao da falha:");
                        String descricao = scanner.nextLine();

                        System.out.println("Digite o tipo da falha:");
                        System.out.println("1- Geração");
                        System.out.println("2- Distribuição");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        switch(tipo){
                            case 1:
                                FalhaGeracao falhaGeracao = new FalhaGeracao(descricao, matricula);
                                imovel.addFalha(falhaGeracao);
                                System.out.println("Falha adicionada com sucesso!");
                                break;
                            case 2:
                                FalhaDistribuicao falhaDistribuicao = new FalhaDistribuicao(descricao, matricula);
                                System.out.println("Digite a descricao do reparo:");
                                descricao = scanner.nextLine();
                                System.out.println("Digite a previsao (em dias):");
                                int previsao = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite a data de inicio (no formato dd/MM/yyyy):");
                                String inputData = scanner.nextLine();

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate dataInicio = LocalDate.parse(inputData, formatter);
                                Reparo reparo = new Reparo(descricao, previsao, dataInicio);
                                falhaDistribuicao.addReparo(reparo);
                                imovel.addFalha(falhaDistribuicao);
                                System.out.println("Falha (distribuição) adicionada com sucesso!");

                                break;
                            default:
                                System.out.println("Tipo de falha invalido!");
                                break;
                        }
                    } else {
                        System.out.println("Imovel não encontrado!");
                    }
                    break;
                case 2:
                    System.out.println("Lista de falhas: ");
                    GestaoImoveis.ListarFalhas();
                    break;
                
                case 3:
                    menuReparos(scanner);
                    break;
                default:
                    return;
            }
        }while(opc != 0);


    }

    public static void menuReparos(Scanner scanner) {
        int opc;
        do{

            System.out.println("Menu Reparo:\n");
            System.out.println("1. Listar em aberto");
            System.out.println("2. Encerrar reparo");
            System.out.println("0. Voltar");
            opc= scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Lista de reparos em aberto: ");
                    GestaoImoveis.ListarReparosEmAberto();
                    break;
                case 2:
                    System.out.println("Digite a matricula do imovel:");
                    String matricula = scanner.nextLine();
                    Imovel imovel = GestaoImoveis.getImovel(matricula);

                    if(imovel != null) {
                        imovel.ListarReparosEmAbertoComID();
                        System.out.println("Digite o ID do reparo:");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("A falha foi resolvida?");
                        System.out.println("1- Sim");
                        System.out.println("2- Não");
                        int opc2 = scanner.nextInt();
                        scanner.nextLine();

                        if(opc2 == 1)
                            imovel.consertarFalha(id);
                        else if(opc2 == 2){

                            imovel.encerraReparo(id);
                            int posicao= imovel.getFalhaByReparo(id);
                            if(posicao != -1){
                                System.out.println("Digite a descricao do novo reparo:");
                                String descricao = scanner.nextLine();
                                System.out.println("Digite a nova previsao (em dias):");
                                int previsao = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Digite a nova data de inicio (no formato dd/MM/yyyy):");
                                String inputData = scanner.nextLine();

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate dataInicio = LocalDate.parse(inputData, formatter);
                                Reparo reparo = new Reparo(descricao, previsao, dataInicio);
                                ((FalhaDistribuicao)imovel.getFalhas().get(posicao)).addReparo(reparo);
                                System.out.println("Reparo adicionado com sucesso!");
                            }
                            
                        }
                        else
                            System.out.println("Opção invalida!");
                        
                    } else {
                        System.out.println("Imovel não encontrado!");
                    }
                    break;
                case 0:
                    return;
                default:
                    return;
               
            }
        }while(opc != 0);

    }
}
