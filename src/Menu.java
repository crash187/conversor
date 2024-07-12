import java.io.IOException;
import java.util.Scanner;


public class Menu {
    ConsultaMoneda consultaMoneda = new ConsultaMoneda();


    public void mostrarMenu(){

        Scanner scanner = new Scanner(System.in);
        int seleccion;

        while(true) {
            System.out.println("""
                    
                    1)Dolar ==> Peso Argentino
                    2)Peso Argentino ==> Dolar
                    3)Peso Mexicano ==> Dolar
                    4)Dolar  ==> Peso Mexicano
                    5)Peso Colombiano ==> Peso Mexicano
                    6)Peso Mexicano ==> Euro
                    7)Euro ==> Peso Mexicano               
                    0)SALIR
                    
                    Ingresa una opcion:"""
            );
            seleccion = scanner.nextInt();

            switch(seleccion){

                case 1:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("USD" , "ARS", scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("ARS" , "USD", scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("MXN" , "USD", scanner.nextDouble());
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("USD" , "MXN", scanner.nextDouble());
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("COP" , "MXN", scanner.nextDouble());
                    break;
                case 6:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("MXN" , "EUR", scanner.nextDouble());
                    break;
                case 7:
                    System.out.println("Ingrese la cantidad:  ");
                    realizarConversion("EUR" , "MXN", scanner.nextDouble());
                    break;
                case 0:
                    return;
            }
        }
    }

    private void realizarConversion(String base, String interes , double cantidad) {
        try {
            Moneda moneda = consultaMoneda.requestAPI(base, interes , cantidad);
            if(moneda.conversion_result() != null){
            System.out.println("$" + cantidad +" " + base + " a " + interes + ": " + moneda.conversion_result());
            }else System.out.println("Hubo un error en la conversion");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
    }
}
