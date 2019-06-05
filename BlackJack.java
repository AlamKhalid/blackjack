import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    static String[] cards = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    // All 12 cards starting from A to King

    static int[] cardsScore = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    // Score of each card in sequence

    static int sumOfPlayer = 0, sumOfDealer = 0, playerWins = 0, dealerWins = 0;
    // Necessary informative variables for the game

    static ArrayList<String> playerCards = new ArrayList<>();
    static ArrayList<String> dealerCards = new ArrayList<>();
    // Two array lists to store card of player and dealer

    static char command;
    // Getting command from the user for action

    static Scanner input = new Scanner(System.in);      // Input from keyboard

    public static void main(String[] args) {

        while (true) {

            getCards();                 // This will get 2 cards for each, at the start of the game


            // Checks if the player has a blackjack which means combination of Ace and either 10,J,Q or K
            if (sumOfPlayer == 21) {
                caseS();
            } else {
                printCards();                                //  This will print the value of those cards
                System.out.print("\n\nEnter command: ");
                command = input.next().charAt(0);

                callSwitch();
            }

            System.out.print("\nEnter 'q' to quit, anything else to play another game: ");
            command = input.next().charAt(0);
            if (command == 'q') {
                printStatus();
                System.exit(0);
            }
            resetAll();
        }
    }

    private static void printStatus() {

        System.out.println("\n\nTotal Score\nDealer wins=" + dealerWins + "\nPlayer wins=" + playerWins);
    }

    private static void resetAll() {

        sumOfPlayer = sumOfDealer = 0;
        command = '\u0000';
        playerCards.removeAll(playerCards);
        dealerCards.removeAll(dealerCards);
    }

    private static void caseH() {

        int val = new Random().nextInt(cards.length - 1);
        playerCards.add(cards[val]);
        sumOfPlayer += cardsScore[val];
        balanceScore('p');

        if (sumOfPlayer > 21) {
            printCards();
            System.out.println("\nPlayer busts.");
        } else if (sumOfPlayer == 21) {
            caseS();
        } else if (sumOfPlayer < 21) {
            printCards();
            System.out.print("\n\nEnter command: ");
            command = input.next().charAt(0);
            callSwitch();
        }
    }

    private static void callSwitch() {

        switch (command) {
            case 'h':
                caseH();
                break;
            case 's':
                caseS();
                break;
            case 'q':
                System.out.println("\nDealer wins.");
                dealerWins++;
                System.exit(0);
        }
    }

    private static void caseS() {

        while (sumOfDealer < 17) {
            int val = new Random().nextInt(cards.length - 1);
            dealerCards.add(cards[val]);
            sumOfDealer += cardsScore[val];
            balanceScore('d');
        }
        if (sumOfDealer > 21) {
            printCards();
            System.out.println("\nDealer busts.");
        } else if (sumOfDealer == 21) {
            printCards();
            if (sumOfPlayer == 21) {
                compareSize();
            } else if (sumOfPlayer < 21) {
                System.out.println("\nDealer wins.");
                dealerWins++;
            }
        } else if (sumOfDealer < 21) {
            printCards();
            if (sumOfPlayer > sumOfDealer) {
                System.out.println("\nPlayer wins");
                playerWins++;
            } else if (sumOfPlayer < sumOfDealer) {
                System.out.println("\nDealer wins");
                dealerWins++;
            } else
                compareSize();
        }
    }

    private static void compareSize() {

        if (playerCards.size() < dealerCards.size()) {
            System.out.println("\nPlayer wins.");
            playerWins++;
        } else if (playerCards.size() > dealerCards.size()) {
            System.out.println("\nDealer wins");
            dealerWins++;
        } else
            System.out.println("\nDraw.");
    }

    private static void getCards() {

        Random random = new Random();
        int val, limit = 2;
        for (int i = 0; i < limit; i++) {
            val = random.nextInt(cards.length - 1);
            playerCards.add(cards[val]);
            sumOfPlayer += cardsScore[val];
            if (sumOfPlayer > 21)
                balanceScore('p');
        }

        if (sumOfPlayer == 21)
            limit = 10;

        for (int i = 0; i < limit; i++) {
            val = random.nextInt(cards.length - 1);
            dealerCards.add(cards[val]);
            sumOfDealer += cardsScore[val];
            if (sumOfDealer > 21)
                balanceScore('d');
            if (limit > 2 && sumOfDealer >= 17)
                break;
        }
    }

    private static void balanceScore(char c) {

        int size = c == 'p' ? playerCards.size() : dealerCards.size();
        for (int i = 0; i < size; i++) {
            if (c == 'p') {
                if (playerCards.get(i) == "A") {
                    sumOfPlayer -= 10;
                    dealerCards.add(i, "A1");
                    return;
                }
            } else {
                if (dealerCards.get(i) == "A") {
                    sumOfDealer -= 10;
                    dealerCards.add(i, "A1");
                    return;
                }

            }
        }
    }

    private static void printCards() {

        System.out.print("\nPlayer's Hand:");
        for (int i = 0; i < playerCards.size(); i++) {
            System.out.print(playerCards.get(i) == "A1" ? " A" : " " + playerCards.get(i));
        }
        System.out.print("\nDealer's Hand:");
        for (int i = 0; i < dealerCards.size(); i++) {
            System.out.print(dealerCards.get(i) == "A1" ? " A" : " " + dealerCards.get(i));
            if (sumOfPlayer < 21 && sumOfDealer < 21 && command != 's') {
                System.out.print(" X");
                break;
            }
        }
    }
}
