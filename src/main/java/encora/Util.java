package encora;

import java.util.Random;

public class Util {

    public static int getNumeroAleatorio() {
        Random random = new Random();

        // Genera un número aleatorio entre 0 y 999
        int randomNumber = random.nextInt(1000);
        System.out.println("Número aleatorio: " + randomNumber);
        return randomNumber;
    }
}