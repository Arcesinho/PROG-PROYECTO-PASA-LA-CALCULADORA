import java.util.Scanner;
import java.util.Random;

public class PasaLaCalculadora {

    //Funcion de un menu para iniciar o acabar el juego

    public static int getUserInput() {

        System.out.println("Bienvenido al juego, que quieres hacer?\n1: Empezar a jugar\n2: Terminar juego");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        return opcion;
    }

    //Funcion que pide el numero maximo y comprueba si es -1 o no esta en rango

    public static int getMaxNumber() {
        System.out.println("Introduce un numero del 10 al 99 (introduce -1 si quieres un numero aleatorio): ");
        Scanner sc = new Scanner(System.in);
        int maxNumber = sc.nextInt();


        if (maxNumber == -1) {

            Random random = new Random();

            final int MIN = 11;
            final int MAX = 98;

            maxNumber = random.nextInt(MAX - MIN + 1) + MIN;
        }

        while (!(10 < maxNumber && maxNumber < 99) && maxNumber != -1) {
            System.out.println("El numero no esta en rango (10-99) introducelo de nuevo: ");
            Scanner sc2 = new Scanner(System.in);
            maxNumber = sc2.nextInt();
        }

        return maxNumber;
    }


    public static void main(String[] args) {

        int opcion = -2;

        while (opcion != 2){

            opcion = getUserInput();

            if (opcion == 2){
                break;
            }

            int maxNumber = getMaxNumber();
            System.out.println(maxNumber);

        }

    }





}
