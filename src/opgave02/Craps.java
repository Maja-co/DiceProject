package opgave02;

public class Craps {
    public static void main(String[] args) {
        playCraps();
    }

    //Metoden for playCraps med hvornår man vinder og taber
    public static void playCraps() {
        int firstRoll = rollDice();
        if (firstRoll == 7 || firstRoll == 11) {
            System.out.println("Du vandt fordi du kastet: " + firstRoll);

        } else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
            System.out.println("Du tabte da du kastet: " + firstRoll);

        } else {
            System.out.println("Point er sat til: " + firstRoll);
            boolean won = rollForPoint(firstRoll);
            if (won) {
                System.out.println("Du vandt ved at rulle dit point igen!");

            } else {
                System.out.println("Du tabte ved at slå en 7'er.");
            }
        }
    }
    //Metode til at fortsætte spillet indtil man vinder eller taber
    public static boolean rollForPoint(int point) {
        int roll;
        do {
            roll = rollDice();
            System.out.println("Du slog: " + roll);
        } while (roll != point && roll != 7);

        return roll == point;
    }

    // Mwtode til terningerne
    public static int rollDice() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        return die1 + die2;
    }
}