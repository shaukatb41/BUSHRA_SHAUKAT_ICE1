package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1.
 * Modifier: BUSHRA SHAUKAT, 991406234
 * Date Modified: 21/05/2024
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit from 0 to 3
            magicHand[i] = c;
        }

        // Ask the user for card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card number (1-13):");
        int number = scanner.nextInt();
        System.out.println("Pick a suit (Hearts, Diamonds, Clubs, Spades):");
        String suit = scanner.next();

        Card userCard = new Card();
        userCard.setValue(number);
        userCard.setSuit(suit);

        // Search for the user's card in the magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() && c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

        // Add a hard-coded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        // Search for the lucky card in the magic hand
        found = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result for the lucky card
        if (found) {
            System.out.println("You found the lucky card!");
        } else {
            System.out.println("The lucky card is not in the magic hand.");
        }
    }
}
