import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Data {
    public static void main(String[] args) throws InterruptedException, IOException {
        if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    else
        System.out.print("\033[H\033[2J");
        System.out.flush();

    Scanner scanner = new Scanner(System.in);

    LocalDate hoje = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println( "DATA DE HOJE: " + dtf.format(hoje) );


        Locale locale = Locale.getDefault();
        System.out.println(locale);  

    // LocalDateTime hoje2 = LocalDateTime.now();
    // DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss a");
    // System.out.println("HORARIO DE HOJE: " + dtf2.format(hoje2));
    try {
        // leitura da String
        System.out.print("DIGITE A DATA (dd/MM/yyyy) ou ENTER para pegar a data atual: ");            
        String data1String = scanner.nextLine();
        
        if (data1String.equals("")) {
            // Apresentar a data automatica
            System.out.println( LocalDate.now().format(dtf) );
        } else {
            // Converter String em Data de forma formatada
            LocalDate data1LocalDate = LocalDate.parse(data1String, dtf); 
            // Apresentar a data formata em outro padrão
            System.out.println( data1LocalDate.format(dtf) );
        }


    } catch (Exception e) {
        // System.out.println( "ERRO: O formato correto é (dd/MM/yyyy)" );
        //System.out.println( e.getMessage() );
        if( e.getMessage().contains("DayOfMonth") ){
            System.out.println("DIA INCORRETO 1-31");    
        } else if( e.getMessage().contains("MonthOfYear") ){
            System.out.println("MES INCORRETO 1-12");   
        } else{
            System.out.println("ANO INCORRETO 1-12");  
        }
    } finally {
        scanner.close();
    }
    
    }
}