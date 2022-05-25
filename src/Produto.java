import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Produto {

    private static DoubleSummaryStatistics resumo;

    public static void main(String[] args) throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
            System.out.flush();

        try (Scanner leitor = new Scanner(System.in)) {
            List<Estoque> lista_estoque = new ArrayList<>();
            List<Vendas> lista_vendas = new ArrayList<>();
           
                int opcao = 0;
                boolean Encontrei = false;
                Estoque ProdBuscando = null;
                String nomeProd;
              
                
        
                do { 
                    System.out.println("-------------------------------------");
                    System.out.println("  #########  MENU PRINCIPAL #########");
                    System.out.println("-------------------------------------");
                    System.out.println("1 - Incluir produto");
                    System.out.println("2 - Consultar produto");
                    System.out.println("3 - Listagem de produtos");
                    System.out.println("4 - Vendas por período - detalhado");
                    System.out.println("5 - Realizar venda");
                    System.out.println("0 - Sair");
                    System.out.print("OPÇÃO: => ");
                    opcao = leitor.nextInt();

                    switch (opcao) {

                        case 0: {
                            System.out.println("-------------------------------------");
                            System.out.println(" xx SISTEMA ENCERRADO VOLTE SEMPRE xx");
                            System.out.println("-------------------------------------");
                            System.exit(0);
                        }
                        case 1: {

                            if (System.getProperty("os.name").contains("Windows"))
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            else
                                System.out.print("\033[H\033[2J");
                            System.out.flush();

                            Estoque estoque = new Estoque();

                            System.out.println("-------------------------------------");
                            System.out.println("###### 1º  INCLUIR O PRODUTO #######");
                            System.out.println("-------------------------------------");

                            System.out.println(" O código anterior é : ( " + lista_estoque.size() + " )");

                            System.out.print(" Digite o codigo do PRODUTO: => ");
                            estoque.setCodigo(leitor.nextInt());

                            System.out.print(" Digite o nome do PRODUTO: => ");
                            estoque.setNome(leitor.next());

                            System.out.print(" Digite a quantidade do PRODUTO: => ");
                            estoque.setQuant(leitor.nextInt());

                            System.out.print(" Digite o valor do PRODUTO: => R$ ");
                            estoque.setValor(leitor.nextDouble());

                            lista_estoque.add(estoque);

                            System.out.println("-------------------------------------");
                            System.out.println(" xx Produto cadastrado com sucesso! xx");
                            System.out.println("-------------------------------------");
                            System.out.println("OPÇÃO: => ");
                            System.out.println(" Rolar para cima. Resumo do PRODUTO Incluido!!");
                            System.out.println(" Rolar para baixo. Acesse o menu!!");
                            System.out.println("");
                            System.out.println("");

                            break;

                        }

                        case 2:{
                            
                            leitor.nextLine();
                            System.out.print("Qual o nome do PRODUTO que você procura? => ");
                            nomeProd = leitor.nextLine();
                    
                            Encontrei = false;
                            ProdBuscando = null;
                    
                            for (Estoque item : lista_estoque) {
                            if ( item.getNome().equalsIgnoreCase( nomeProd ) ) {

                            Encontrei = true;
                            ProdBuscando = item;

                                } 
                            }
                            if (System.getProperty("os.name").contains("Windows"))
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            else
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                            if (Encontrei) {

                            System.out.println("-------------------------------------------");
                            System.out.println("###########  PRODUTO CONSULTADO ###########");
                            System.out.println("-------------------------------------------");
                            System.out.println("");
                            System.out.println("Resultado da pesquisa");
                            System.out.println("----------------------------------------------------------");
                            System.out.print(ProdBuscando);
                            } else {

                            System.out.println("-------------------------------------------------");
                            System.out.println("  ###########    PRODUTO CONSULTADO   ###########");
                            System.out.println("-------------------------------------------------");
                            System.out.println(" ####  O produto procurado não foi encontrado ####");
                            System.out.println("-------------------------------------------------");
                            System.out.println("####  Consulte a opção (3) do menu! ####");
                            System.out.println("-------------------------------------------------");
                     
                                }
                            
                            System.out.println("");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Pressione ENTER para continuar...");
                            leitor.nextLine(); 
                    
                            break; 
                        }    

                        case 3: {
                            if (System.getProperty("os.name").contains("Windows"))
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            else

                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            System.out.println("-------------------------------------------");
                            LocalDate hoje = LocalDate.now();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            System.out.println( "DATA DE HOJE: " + dtf.format(hoje) );

                            System.out.println("######### 3º LISTAGEM DE PRODUTOS #########");
                            System.out.println("-------------------------------------------");

                            if (lista_estoque.isEmpty()) {
                                System.out.println("Lista vazia use a opção (1) para fazer o seu cadastro...");

                            } else {
                                
                            System.out.printf("%s %20s %20s %30s\n", "Código", " Nome do Produto ", "Valor Unitário","Quantidade de Estoque");
                            System.out.println("--------------------------------------------------------------------------------");
                            for (Estoque p : lista_estoque) {
                                System.out.printf( "%d %24s %22s %30d\n", p.getCodigo(), p.getNome(), p.getValor(), p.getQuant() );
                            }
                            System.out.println("--------------------------------------------------------------------------------");
                            resumo = lista_estoque.stream()
                            .collect(Collectors.summarizingDouble(Estoque::getValor));
                            System.out.println("# RESUMO:");
                            System.out.printf("Valor Médio  %.2f - Valor Maximo %.2f - Valor Minimo %.2f \n",resumo.getAverage(), resumo.getMax(),  resumo.getMin());
                            
                            }

                            System.out.println("---------------------------------------------");
                            System.out.println(" Digite uma Opção para continuar...");
                            System.out.println("---------------------------------------------");
        
                            break;

                        }

                        case 4: {

                            if (System.getProperty("os.name").contains("Windows"))
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            else
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.println("----------------------------------------------");
                                LocalDate hoje = LocalDate.now();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                System.out.println( "DATA DE HOJE: " + dtf.format(hoje) );

                                
                                System.out.println("###### 4º VENDAS POR PERÍODO - DETALHADO ######");
                                System.out.println("-----------------------------------------------");
                                System.out.println(" Periodo de emissão : ( " + dtf.format(hoje) + " a " + dtf.format(hoje)  + ")");
                                System.out.println("-----------------------------------------------");

                            if (lista_vendas.isEmpty()) {
                                System.out.println("Lista vazia use a opção (5) para fazer a sua venda...");

                            } else {
                                
                                System.out.printf("%s %25s %25s %20s\n", " Data ", " Nome do Produto ","Quantidade de Vendida" ,"Valor de Venda" ,"Valor total5");
                                System.out.println("--------------------------------------------------------------------------------");
                                for (Vendas p : lista_vendas) {
                                    System.out.printf( "%s %24s %22d %30.2f\n", p.getDataVendida(), p.getProVendido(), p.getQuantVendida(), p.getPreco() );
                                }
                                System.out.println("--------------------------------------------------------------------------------");
                                DoubleSummaryStatistics resumo = lista_vendas.stream()
                                .collect(Collectors.summarizingDouble(Vendas::getPreco));
                                System.out.println("# RESUMO:");
                                System.out.printf("Valor Médio  %.2f - Valor Maximo %.2f - Valor Minimo %.2f \n",resumo.getAverage(), resumo.getMax(),  resumo.getMin());
                            }
                                System.out.println("---------------------------------------------");
                                System.out.println(" Digite uma Opção para continuar...");
                                System.out.println("---------------------------------------------");
        
                            break;

                        }

                        case 5: {
                            if (System.getProperty("os.name").contains("Windows"))
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            else
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                Vendas venda = new Vendas();
                                
                                System.out.println("-------------------------------------------");
                                System.out.println("#########  5º   REALIZR VENDAS    #########");
                                System.out.println("-------------------------------------------");
                                

                                System.out.println(" Você tem na lista de venda : ( " + lista_vendas.size() + " ) Produto Vendido");

                                System.out.println("######## DIGITE A DATA DA VENDA #######");

                                leitor.nextLine();
                                System.out.print("DIGITE A DATA (Dia/Mes/Ano) - (dd/MM/yyyy): => ");            
                                venda.setDataVendida(leitor.nextLine());

                                System.out.println(" Digite o nome do produto...");
                                venda.setProVendido(leitor.nextLine());

                                System.out.println(" Digite a quantidade vendida...");
                                venda.setQuantVendida(leitor.nextInt());

                                System.out.println(" Digite o valor do produto...");
                                venda.setPreco(leitor.nextDouble());

                                lista_vendas.add(venda);

                            break;

                        }

                        default: {
                                System.out.println("-------------------------------------------");
                                System.out.println("#########    OPÇAO INVALIDA!!!!    #########");
                                System.out.println("--------------------------------------------");


                        }
                    }
                } while (opcao != 6);
            }
            
        }
    }

    