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

    //Función para preguntar por el nombre

    public static String getUserName1(){

        System.out.println("Introduce tu nombre, jugador 1: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        return name;
    }

    public static String getUserName2(){

        System.out.println("Introduce tu nombre, jugador 2: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        return name;
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

    public static boolean getCords(int number1, int number2){


        if (number1 == 1 && (number2 == 2 || number2 == 3 || number2 == 4 || number2 == 7)){
            return true;
        }
        if (number1 == 2 && (number2 == 1 || number2 == 3 || number2 == 5 || number2 == 8)){
            return true;
        }
        if (number1 == 3 && (number2 == 1 || number2 == 2 || number2 == 6 || number2 == 9)){
            return true;
        }
        if (number1 == 4 && (number2 == 5 || number2 == 6 || number2 == 1 || number2 == 7)){
            return true;
        }
        if (number1 == 5 && (number2 == 4 || number2 == 6 || number2 == 2 || number2 == 8)){
            return true;
        }
        if (number1 == 6 && (number2 == 4 || number2 == 5 || number2 == 3 || number2 == 9)){
            return true;
        }
        if (number1 == 7 && (number2 == 8 || number2 == 9 || number2 == 1 || number2 == 4)){
            return true;
        }
        if (number1 == 8 && (number2 == 7 || number2 == 9 || number2 == 2 || number2 == 5)){
            return true;
        }
        if (number1 == 9 && (number2 == 7 || number2 == 8 || number2 == 3 || number2 == 6)){
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

    public static int checkNumber(int number, int ultimoNumero){


        int i;

        if (ultimoNumero != 0 && !(number ==ultimoNumero)){

            if (number<1 && number>9 || !getCords(number, ultimoNumero)){
                if (number<1 && number>9){
                    System.out.println("El numero está fuera de rango. ¡Pierdes el turno!");
                    i = 0;
                    return i;
                }
                if (!getCords(number, ultimoNumero)){
                    System.out.println("El numero no está en la misma fila o columna. ¡Pierdes el turno!");
                    i = 1;
                    return i;
                }
            }
        }
        ultimoNumero = number;
        return ultimoNumero;
    }

    public static boolean checkIfEquals(int number, int ultimoNumero){

        if (number == ultimoNumero){
            System.out.println("No se puede repetir el mismo numero, introducelo de nuevo:");
            return true;
        }else {
            return false;
        }

    }


    public static void main(String[] args) {

        int opcion = -2;

        while (opcion != 2){

            int lastNumber = 0;

            opcion = getUserInput();

            if (opcion == 2){
                break;
            }

            String name1 = getUserName1();
            String name2 = getUserName2();
            int maxNumber = getMaxNumber();
            int firstNumber = getFirstNumber();


           int total = firstNumber;

           int turno = 1;

            //Falla el while, no podemos asignar number a last number

            while (total<= maxNumber){

                int checkFirstNumber = checkNumber(firstNumber,lastNumber);
                while (checkIfEquals(firstNumber, lastNumber)){
                    int number = getFirstNumber();
                    number = lastNumber;
                }


                if (turno%2 == 0){

                    System.out.println("Turno: "+turno);
                    System.out.println("Objetivo del juego: "+maxNumber);
                    System.out.println("Ultimo numero introducido: "+lastNumber);
                    System.out.println("Turno del jugador: "+name2);
                    System.out.println("Total: "+total);

                }else{

                    System.out.println("Turno: "+turno);
                    System.out.println("Objetivo del juego: "+maxNumber);
                    System.out.println("Ultimo numero introducido: "+lastNumber);
                    System.out.println("Turno del jugador: "+name1);
                    System.out.println("Total: "+total);

                }

                int number = getFirstNumber();
                firstNumber = number;
                lastNumber = checkFirstNumber;
                turno = turno + 1;
                total = total + lastNumber ;



            }


        }
    }
}
