package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    //Disse felter er hvor mange gange der er rullet og den totale sum
    private static int rollCount = 0;
    public static int totalSum = 0;
    public static int sameThrowCounter = 0;
    public static int maxRoll = 0;
    public static int[] valueOccur = new int[6];

    public static void main(String[] args) {
        //Introduktion med regler
        System.out.println("Velkommen til spillet, rul to terning.");
        printRules();
        System.out.println();

        //Starter selve spillet
        playTwoDice();

        //Afslutter spillet
        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");
    }

    //Metode til at udskrive reglerne for spillet
    public static void printRules() {
        System.out.println("____________________________________________________");
        System.out.println("Regler for rul to terning");
        System.out.println("Spilleren ruller to terning, så længe man lyster.");
        System.out.println("____________________________________________________");
    }

    //Metode til at starte spillet
    private static void playTwoDice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Vil du rulle to terninger? ('ja/nej') ");
        String answer = input.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.println("Du rullede " + faces[0] + " og " + faces[1]);
            System.out.println();

            updateStatistics(faces);

            //Spørg spilleren om de vil fortsætte spillet eller stoppe spillet
            System.out.println("Vil du rulle igen? ('ja/nej')");
            answer = input.nextLine();
        }
        printStatistics();
        input.close();
    }

    //Metode til at simulere kast med 2 terninger
    public static int[] rollDice() {
        int[] rollDice = {(int) (Math.random() * 6 + 1), (int) (Math.random() * 6 + 1)};
        return rollDice;
    }

    //Metode til at updatere statestikker
    public static void updateStatistics(int[] faces) {
        rollCount++;
        totalSum += faces[0] + faces[1];
        if (faces[0] == faces[1]) {
            sameThrowCounter++;
        }
        int currentSum = faces[0] + faces[1];
        if (currentSum > maxRoll) {
            maxRoll = currentSum;
        }
        valueOccur[faces[0] - 1]++;
        valueOccur[faces[1] - 1]++;
    }

    //Metode til at udskrive statestikker for spillet når det afsluttes
    public static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-----------");
        System.out.printf("%42s %4d\n", "Antal rul: ", rollCount); //obs på at det er printf (f) er den afgørende faktor for at den virker
        System.out.printf("%42s %4d\n", "Den totale sum af alle kastene: ", totalSum);
        System.out.printf("%42s %4d\n", "Antal gange med samme værdi i samme kast: ", sameThrowCounter);
        System.out.printf("%42s %4d\n", "Største kast i spillet: ", maxRoll);
        // Udskriv antallet af gange hver værdi 1-6 er rullet
        for (int i = 0; i < valueOccur.length; i++) {
            System.out.printf("%42s %4d\n", "Antal " + (i + 1) + "'ere: ", valueOccur[i]);
        }


    }

    //Metode til at udprinte arrayet
    public static void printIntegerArray(int[] list) {
        System.out.print("("); //Obs det er print for at det foregår på den samme linje
        for (int indeks = 0; indeks < list.length - 1; indeks++) {
            System.out.print(list[indeks] + ", ");
        }
        System.out.print(list[list.length - 1]);
        System.out.println(")");
    }
}
