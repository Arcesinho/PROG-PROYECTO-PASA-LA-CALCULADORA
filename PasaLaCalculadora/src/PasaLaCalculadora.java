import java.util.Scanner;
import java.util.Random;

public class PasaLaCalculadora {

    //Funcion de un menu para iniciar o acabar el juego

    public static int getUserInput() {

        System.out.println("Bienvenido al juego, que quieres hacer?\n1: Empezar a jugar\n2: Terminar juego");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        while (opcion != 1 && opcion != 2){
            System.out.println("Introduce una opción correcta: ");
            Scanner sc1 = new Scanner(System.in);
            opcion = sc1.nextInt();
        }return opcion;

    }

    //Función para preguntar por el nombre

    public static String getUserName1(){

        System.out.println("Introduce tu nombre, jugador 1: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    public static String getUserName2(){

        System.out.println("Introduce tu nombre, jugador 2: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }
    // jugador 3
    public static String getUserName3(){

        System.out.println("Introduce tu nombre, jugador 3: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    //Funcion que piide el numero maximo y comprueba si es -1 o no esta en rango

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


    /**
     *
     * @param number1
     * @param number2
     * @return devuelve true si el numero 2, el ultimo se encuentra en la misma fila y columna que el 1 y false si no
     */
    public static boolean getCords(int number1, int number2){


        if (number1 == 1 && (number2 == 2 || number2 == 3 || number2 == 4 || number2 == 7)){
            return true;
        }
        else if (number1 == 2 && (number2 == 1 || number2 == 3 || number2 == 5 || number2 == 8)){
            return true;
        }
        else if (number1 == 3 && (number2 == 1 || number2 == 2 || number2 == 6 || number2 == 9)){
            return true;
        }
        else if (number1 == 4 && (number2 == 5 || number2 == 6 || number2 == 1 || number2 == 7)){
            return true;
        }
        else if (number1 == 5 && (number2 == 4 || number2 == 6 || number2 == 2 || number2 == 8)){
            return true;
        }
        else if (number1 == 6 && (number2 == 4 || number2 == 5 || number2 == 3 || number2 == 9)){
            return true;
        }
        else if (number1 == 7 && (number2 == 8 || number2 == 9 || number2 == 1 || number2 == 4)){
            return true;
        }
        else if (number1 == 8 && (number2 == 7 || number2 == 9 || number2 == 2 || number2 == 5)){
            return true;
        }
        else if (number1 == 9 && (number2 == 7 || number2 == 8 || number2 == 3 || number2 == 6)){
            return true;
        }
        else{
            return false;
        }
    }

    public static int getFirstNumber(){

        System.out.println("Introduce un numero del 1 al 9 (incluidos): ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    //Función para comprobar si el numero está en rango y pertenece a la misma fila (calculadora)

    public enum ValidationResult {
        SUCCESS,
        OUT_OF_RANGE,
        INVALID_CORDS,
        SAME_AS_LAST_NUMBER,
    }

    public static ValidationResult checkNumber(int primerNumero, int ultimoNumero){

        if(primerNumero < 1 || primerNumero > 9){
            return ValidationResult.OUT_OF_RANGE;
        }
        if (ultimoNumero == 0) {
            return ValidationResult.SUCCESS;
        }
        if (primerNumero == ultimoNumero) {
            return ValidationResult.SAME_AS_LAST_NUMBER;
        }
        if (!getCords(primerNumero, ultimoNumero)) {
            return ValidationResult.INVALID_CORDS;
        }
        return ValidationResult.SUCCESS;

    }

    public static int getNumber(int ultimoNumero){

        while (true){

            System.out.println("Introduce un numero del 1 al 9 (incluidos): ");
            Scanner sc = new Scanner(System.in);
            int numeroIntroducido  = sc.nextInt();

            ValidationResult resultado = checkNumber(numeroIntroducido, ultimoNumero);

            switch (resultado) {
                case SUCCESS:
                    return numeroIntroducido;

                case OUT_OF_RANGE:
                    System.out.println("Error: El número debe estar entre 1 y 9. Inténtalo de nuevo.");
                    break;

                case SAME_AS_LAST_NUMBER:
                    System.out.println("Error: No puedes introducir el mismo número que el anterior. Inténtalo de nuevo.");
                    break;

                case INVALID_CORDS:
                    System.out.println("Error: El número no está en la misma fila o columna. Inténtalo de nuevo.");
                    break;
            }

        }
    }

    public static void main(String[] args) {

        int opcion = -2;


        while (opcion != 2){

            int lastNumber = 0;

            opcion = getUserInput();

            if (opcion == 2){
                System.out.println("Hasta otra!!");
                break;
            }

            String name1 = getUserName1();
            String name2 = getUserName2();
            // jugador 3
            String name3 = getUserName3();
            int maxNumber = getMaxNumber();
            int firstNumber = getFirstNumber();


           int total = firstNumber;

           int turno = 1;

            while (total<= maxNumber){



                    System.out.println("Turno: "+turno);
                    System.out.println("Objetivo del juego: "+maxNumber);
                    System.out.println("Ultimo numero introducido: "+lastNumber);
                    // 3 jugadores
                    if (turno % 3 == 1)
                        System.out.println("Turno del jugador: " + name1);
                    else if (turno % 3 == 2)
                        System.out.println("Turno del jugador: " + name2);
                    else
                        System.out.println("Turno del jugador: " + name3);

                    System.out.println("Total: "+total);


                if (turno == 1){
                    lastNumber = getNumber(firstNumber);
                }else {
                    lastNumber = getNumber(lastNumber);
                }

                turno = turno + 1;
                if (turno > 1){
                    total = total + lastNumber ;
                }
                if (maxNumber == total){
                    if (turno % 3 == 1) {
                        System.out.println("El jugador " + name1 + " ha ganado, blackjack!");
                        System.out.println("llegó a "+ total);
                        break;
                    } else if (turno % 3 == 2) {
                        System.out.println("El jugador " + name2 + " ha ganado, blackjack!");
                        System.out.println("llegó a "+ total);
                        break;
                    } else {
                        System.out.println("El jugador " + name3 + " ha ganado, blackjack!");
                        System.out.println("llegó a "+ total);
                        break;
                    }

                }
                if (maxNumber< total) {
                    if (turno % 3 == 0) {
                        System.out.println("El jugador " + name3 + " ha ganado la partida!!");
                        System.out.println("Con " + total);
                        break;
                    } else if (turno % 3 == 2) {
                        System.out.println("El jugador " + name1 + " ha ganado la partida!!");
                        System.out.println("Con" + total);
                        break;

                    } else {
                        System.out.println("El jugador " + name2 + " ha ganado la partida!!");
                        System.out.println("Con" + total);
                        break;
                    }


                }


            }


        }
    }
}
// no para al llegar al numero maximo