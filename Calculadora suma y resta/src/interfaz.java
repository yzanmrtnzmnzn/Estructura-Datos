import java.util.Scanner;
public class interfaz {
    private char c;
    private int a, b;
    public void calculadora(){
        Scanner input = new Scanner(System.in);
        Calculadora calcu = new Calculadora();
        do {
            System.out.println("********CALCULADORA DE SUMAS Y RESTAS********");
            System.out.print("Escribe lo que quieras hacer (+/-)(* para salir): ");
            c = input.next().charAt(0);
            switch (c) {
                case '+':
                    System.out.println("Escribe un numero");
                    a = input.nextInt();
                    System.out.println("Escribe otro numero");
                    b = input.nextInt();
                    calcu.suma(a, b);
                    break;
                case '-':
                    System.out.println("Escribe un numero");
                    a = input.nextInt();
                    System.out.println("Escribe otro numero");
                    b = input.nextInt();
                    calcu.resta(a, b);
                    break;

            }
        } while (c != '*');
    }
}
