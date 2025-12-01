import java.util.Scanner;
import java.util.Random;

public class PasaLaCalculadora {
    /**
     *
     * @return devuelve la opcion 1 o 2, y vuelve a pedir si no es ninguna de esas
     */
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

    /**
     *
     * @return devuelve el num de jugadores
     */

    public static int getPlyerNumbers(){
        System.out.println("Introduce el numero de jugadores, 2 o 3?");
        Scanner sc = new Scanner(System.in);
        int jugadores =sc.nextInt();
        return jugadores;
    }
    /**
     *
     * @return devuelve el nombre del jugador 1
     */
    public static String getUserName1(){

        System.out.println("Introduce tu nombre, jugador 1: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }
    /**
     *
     * @return devuelve el nombre del jugador 2
     */
    public static String getUserName2(){

        System.out.println("Introduce tu nombre, jugador 2: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }
    /**
     *
     * @return devuelve el nombre del jugador 3
     */
    public static String getUserName3(){

        System.out.println("Introduce tu nombre, jugador 3: ");
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }
    /**
     * Con el -1 nos da un numero entre 11 y 99 sin incluir
     * @return funcion que devuelve el numero maximo
     */
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
     * @param number1 = primer numero
     * @param number2 = segundo numero
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
    /**
     *
     * @return devuelve el numero que el usuario ha introducido por primera vez
     */
    public static int getFirstNumber(){

        System.out.println("Introduce un numero entero del 1 al 9 (incluidos): ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    /**
     *
     * @param firstNumber
     * @return comprueba si el primer numero esta en rango
     */
    public static int checkFirstNumber(int firstNumber){
        while (firstNumber <1 || firstNumber >9){
            System.out.println("El numero está fuera de rango.");
            firstNumber = getFirstNumber();
        }
        return firstNumber;
    }
    /**
     * Enum para los posibles casos al introducir un numero
     */
    public enum ValidationResult {
        SUCCESS,
        OUT_OF_RANGE,
        INVALID_CORDS,
        SAME_AS_LAST_NUMBER,
    }
    /**
     *
     * @param primerNumero el numero que introduce el usuario antes de pasar por esta funcion
     * @param ultimoNumero el ultimo numero almacenado
     * @return devuelve los casos del enum despues de checkearlo
     */
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
    /**
     *
     * @param ultimoNumero el numero resultante de la ultima ejecucion (inicialmente es el primer numero)
     * @return devuelve el resultado de checkear a los dos numeros (comprobado en la funcion anterior)
     * El while true se detiene cuando retornamos algo, por eso lo usamos,
     * si es suceso por ejemplo nos devuelve el numero ya comprobad
     */
    public static int getNumber(int ultimoNumero){

        while (true){

            System.out.println("Introduce un numero entero del 1 al 9 (incluidos): ");
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

        int opcion = getUserInput();
        int players = getPlyerNumbers();

        String name1;
        String name2;
        String name3 = "";

        if (players == 2 ) {
            name1 = getUserName1();
            name2= getUserName2();
        }else{
             name1 = getUserName1();
             name2 = getUserName2();
             name3 = getUserName3();
        }



        while (opcion != 2) {

            if (opcion == 2) {
                System.out.println("Hasta otra!!");
                break;
            }
            //Pedimos al usuario el numero maximo, y el primer numero
            int maxNumber = getMaxNumber();
            System.out.println("El numero maximo es: "+maxNumber);
            //Checkeamos si el primer numero está en rango
            int firstNumberBeforeCheck = getFirstNumber();
            int firstNumber = checkFirstNumber(firstNumberBeforeCheck);
            //Iniciamos lastNumber a 0 total le sumamos el primer numero y el turno inicial a 1
            int lastNumber = 0;
            int total = firstNumber;
            int turno = 1;
            //Este bucle solo terminará cuando el total sea mayor al numero maximo
            //Opción de dos jugadores
            if(players == 2) {
                while (total <= maxNumber) {
                    //Aqui mostraremos toda la información necesaria por pantalla
                    System.out.println("Turno: " + turno);
                    System.out.println("Objetivo del juego: " + maxNumber);
                    System.out.println("Ultimo numero introducido: " + lastNumber);
                    //Para saber de quien es el turno utilizamos el modulo, par jugador 2 impar jugador 1
                    if (turno % 2 == 0) {
                        System.out.println("Turno del jugador: " + name2);
                    } else {
                        System.out.println("Turno del jugador: " + name1);
                    }
                    System.out.println("Total: " + total);
                    //Para el primer turno el numero que comprobamos es el almacenado en firstNumber
                    //luego se usa el ultimo numero ya que al principio vale 0
                    if (turno == 1) {
                        lastNumber = getNumber(firstNumber);
                    } else {
                        lastNumber = getNumber(lastNumber);
                    }

                    turno = turno + 1;
                    if (turno > 1) {
                        total = total + lastNumber;
                    }
                    //Ultimo menu donde mostramos quien ha gando
                    if (maxNumber == total) {
                        if (turno % 2 == 0) {
                            System.out.println("El jugador " + name2 + " ha ganado, blackjack!");
                            System.out.println("llegó a " + total);
                            break;
                        } else {
                            System.out.println("El jugador " + name1 + " ha ganado, blackjack!");
                            System.out.println("llegó a " + total);
                            break;
                        }
                    }
                    if (total > maxNumber) {
                        if (turno % 2 == 0) {
                            System.out.println("El jugador " + name1 + " ha ganado la partida!!");
                            System.out.println("El jugador " + name2 + " se ha pasado\n");
                            break;
                        } else {
                            System.out.println("El jugador " + name2 + " ha ganado la partida!!");
                            System.out.println("El jugador " + name1 + " se ha pasado\n");
                            break;
                        }
                    }
                }
                opcion = getUserInput();
            }
            // Opción de 3 jugadores
            if (players == 3){
                while (total <= maxNumber) {
                    //Aqui mostraremos toda la información necesaria por pantalla
                    System.out.println("Turno: " + turno);
                    System.out.println("Objetivo del juego: " + maxNumber);
                    System.out.println("Ultimo numero introducido: " + lastNumber);
                    //Para saber de quien es el turno utilizamos el modulo, par jugador 2 impar jugador 1
                    if (turno % 3 == 1) {
                        System.out.println("Turno del jugador: " + name1);
                    } else if(turno % 3== 2) {
                        System.out.println("Turno del jugador: " + name2);
                    }else{
                        System.out.println("Turno del jugador: " + name3);
                    }
                    System.out.println("Total: " + total);
                    //Para el primer turno el numero que comprobamos es el almacenado en firstNumber
                    //luego se usa el ultimo numero ya que al principio vale 0
                    if (turno == 1) {
                        lastNumber = getNumber(firstNumber);
                    } else {
                        lastNumber = getNumber(lastNumber);
                    }

                    turno = turno + 1;
                    if (turno > 1) {
                        total = total + lastNumber;
                    }
                    //Ultimo menu donde mostramos quien ha gando
                    if (maxNumber == total) {
                        if (turno % 3 == 1) {
                            System.out.println("El jugador " + name1 + " ha ganado, blackjack!");
                            System.out.println("llegó a " + total);
                            break;
                        } else if(turno % 3== 2) {
                            System.out.println("El jugador " + name2 + " ha ganado, blackjack!");
                            System.out.println("llegó a " + total);
                            break;
                        }else{
                            System.out.println("El jugador " + name3 + " ha ganado, blackjack!");
                            System.out.println("llegó a " + total);
                            break;
                        }
                    }
                    if (total > maxNumber) {
                        if (turno % 3 == 2) {
                            System.out.println("El jugador " + name1 + " ha ganado la partida!!");
                            System.out.println("El jugador " + name2 + " se ha pasado\n");
                            break;
                        } else if (turno % 3 == 0){
                            System.out.println("El jugador " + name2 + " ha ganado la partida!!");
                            System.out.println("El jugador " + name3 + " se ha pasado\n");
                            break;
                        }else{

                            System.out.println("El jugador " + name3 + " ha ganado la partida!!");
                            System.out.println("El jugador " + name1 + " se ha pasado\n");
                            break;

                        }
                    }
                }
                opcion = getUserInput();
            }
        }
    }
}
vjhjh
jkhga