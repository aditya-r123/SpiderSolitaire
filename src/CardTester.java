/*
 * Aditya Rao
 * Period 4
 * 12/3/20
 * Time taken: 2.5 hours (inluding struggling with Arrays), 1.5 hours of actual/productive coding time 
 * This was a pretty fun (part of the solitaire) lab for me. I did not have any difficulties with the Deck 
 * class, since most of the class was already filled in for us. However for the Deck class, it was a different 
 * story. I orginially started off with using Arrays, and everything was going well until I came to the toString() 
 * method where I realized  that it wouldn't look good if I printed out the null values that were in the array, so 
 * I tried to fix this by not printing out the null values. However, this led to so many more issues with my other 
 * methods and fixing them in the other methods led to new issues in the toString(). This is when I decided to change 
 * up my strategy and use ArrayLists instead. Using ArrayLists made the lab much easier for me to use, and I finished 
 * the whole Deck class quite quickly. This was mainly due to ArrayLists not having null values, able change their size 
 * easily, and allows for easy addition/removal of its elements. I am excited to continue towards building a full Solitaire 
 * game in Java with the future parts of this lab! 
 */
public class CardTester
{
    public static void main(String[] args) {
        Card c1 = new Card("3", 3);
        System.out.println(c1.isFaceUp());
        System.out.println(c1);
        c1.setFaceUp(true);
        System.out.println(c1.isFaceUp());
        System.out.println(c1);
        Card c2 = new Card("3", 3);
        System.out.println(c1.equals(c2));
        Card c3 = new Card("3", 7);
        System.out.println(c3.equals(c2));
        Card thisCard = new Card("3", 1);
        Card otherCard = new Card("3", 4);
        System.out.println(thisCard.compareTo(otherCard));
    }
}
