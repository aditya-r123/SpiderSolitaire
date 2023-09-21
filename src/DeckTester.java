import java.util.*;
public class DeckTester
{
    public static void main(String[] args) {

        Board b = new Board(4, 4);
        Deck d = new Deck();
        String[] symbols = {"2", "A", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for(int i = 0; i<symbols.length; i++){
            Card c = (new Card(symbols[i], values[i]));
            c.setFaceUp(true);
            d.addCardAtIndex(i, c);
             System.out.println(d);
        }
        System.out.println("unsorted deck");
        System.out.println(d);
        d.selectionSort();
        System.out.println("sorted deck");
        System.out.println(d);
        System.out.println("ORIGINAL:");
        System.out.println(d);
        System.out.println("DECK AS STRING:");
        System.out.println(d.deckAsString());
        System.out.println("MAKING DECK AFTER LOOKING AT STRING");
        Deck yay = new Deck(d.deckAsString());
        System.out.println(yay);
        System.out.println("ORIGINAL:");
        System.out.println("First card in deck is " + d.topCardOfDeck() + ", second one is " + d.getCardAtIndex(1));
        System.out.println(d.toString());

        System.out.println("AFTER SHUFFLING:");
        d.shuffle();
        System.out.println(d.toString());

        System.out.println("AFTER EXCLUDING 2-4:");
        d.removeCardsInRange(2, 4);
        System.out.println(d.toString());

        System.out.println("AFTER ONLY INCLUDING 4-8:");
        d.includeOnlyCardsInRange(4, 8);
        System.out.println(d.toString());

        System.out.println("AFTER FACING DOWN 0-2:");
        d.faceDownCardsInRange(0, 2);
        System.out.println(d.toString());

        System.out.println("AFTER REMOVING 3:");
        System.out.println("I just removed the card with symbol " + d.removeCardAtIndex(3));
        System.out.println(d.toString());

        System.out.println("AFTING FACING UP 1-2:");
        d.faceUpCardsInRange(1, 2);
        System.out.println(d.toString());

        System.out.println("AFTER FLIPPING 1-3:");
        d.flipCardsInRange(1, 3);
        System.out.println(d.toString());

        
        System.out.println("AFTER ADDING T TO  2:");
        Card xyz = new Card("T", 10);
        d.addCardAtIndex(2, xyz);
        System.out.println(d.toString());

        System.out.println("AFTER FACING UP 2:");
        d.faceCardAtIndexUpOrDown(2, true);
        System.out.println(d.toString());

        System.out.println("AFTER FLIPPING 2:");
        d.flipCardAtIndex(2);
        System.out.println(d.toString());
        
        d.flipCardAtIndex(0);
         d.flipCardAtIndex(1);
          d.flipCardAtIndex(2); 
          d.flipCardAtIndex(3);
          d.flipCardAtIndex(4);
          
        System.out.println(d.toString());
        System.out.println(d.cutDeck(2));
        
        
        
    }
}
