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
import java.util.*;
/**
 * Deck.java
 *
 * <code>Deck</code> represents a deck of playing cards.
 */
public class Deck
{
    /** A <code>Deck</code> ArrayList that holds several <code>Card</code>s*/
    private ArrayList<Card> deckOfCards;

    /**
     * Creates a new <code>Deck</code> instance.
     */
    public Deck(){
        deckOfCards = new ArrayList<Card>();
    }

    /**
     * Creates a new <code>Deck</code> instance based on the <code>String</code> parameter.
     */
    public Deck(String str){
        deckOfCards = new ArrayList<Card>();
        int ind = 0;
        for(int i = 0; i<str.length(); i++){
            char curVal = str.charAt(i);
            if(Character.isDigit(curVal)){
                if(str.charAt(i+2)=='t'){
                    Card c = (new Card(Character.toString(curVal), curVal));
                    c.setFaceUp(true);
                    deckOfCards.add(c);
                }else if(str.charAt(i+2)=='f'){
                    Card c = (new Card(Character.toString(curVal), curVal));
                    c.setFaceUp(false);
                    deckOfCards.add(c);
                }
            }else if(curVal == 'A'){
                if(str.charAt(i+2)=='t'){
                    Card c = (new Card(Character.toString(curVal), 1));
                    c.setFaceUp(true);
                    deckOfCards.add(c);
                }else if(str.charAt(i+2)=='f'){
                    Card c = (new Card(Character.toString(curVal), 1));
                    c.setFaceUp(false);
                    deckOfCards.add(c);
                }
            }else if(curVal == 'T'){
                if(str.charAt(i+2)=='t'){
                    Card c = (new Card(Character.toString(curVal), 10));
                    c.setFaceUp(true);
                    deckOfCards.add(c);
                }else if(str.charAt(i+2)=='f'){
                    Card c = (new Card(Character.toString(curVal), 10));
                    c.setFaceUp(false);
                    deckOfCards.add(c);
                }
            }else if(curVal == 'J'){
                if(str.charAt(i+2)=='t'){
                    Card c = (new Card(Character.toString(curVal), 11));
                    c.setFaceUp(true);
                    deckOfCards.add(c);
                }else if(str.charAt(i+2)=='f'){
                    Card c = (new Card(Character.toString(curVal), 11));
                    c.setFaceUp(false);
                    deckOfCards.add(c);
                }
            }else if(curVal == 'Q'){
                if(str.charAt(i+2)=='t'){
                    Card c = (new Card(Character.toString(curVal), 12));
                    c.setFaceUp(true);
                    deckOfCards.add(c);
                }else if(str.charAt(i+2)=='f'){
                    Card c = (new Card(Character.toString(curVal), 12));
                    c.setFaceUp(false);
                    deckOfCards.add(c);
                }
            }else if(curVal == 'K'){
                if(str.charAt(i+2)=='t'){
                    Card c = (new Card(Character.toString(curVal), 13));
                    c.setFaceUp(true);
                    deckOfCards.add(c);
                    
                }else if(str.charAt(i+2)=='f'){
                    Card c = (new Card(Character.toString(curVal), 13));
                    c.setFaceUp(false);
                    deckOfCards.add(c);
                }
            }
            
        }
    }
    
    public  void selectionSort() {
    	
		// Ascending order ----> swapping largest elements to the right
		for (int out = deckOfCards.size() - 1; out >= 1; out--) {
			int biggest = 0;
			for (int i = 1; i <= out; i++) {
				if (deckOfCards.get(i).compareTo(deckOfCards.get(biggest))>0) {
					biggest = i;
				}
			}
			Card temp = deckOfCards.get(biggest);
			deckOfCards.set(biggest, deckOfCards.get(out));
			deckOfCards.set(out, temp);
			
			/*
			
			System.out.println(Arrays.toString(myArrayList));
			Card temp = myArrayList[biggest];
			myArrayList[biggest] = myArrayList[out];
			myArrayList[out] = temp;
			System.out.println(Arrays.toString(myArrayList));
			*/
		}
	}

    /**
     * Returns <code>Deck</code>'s first <code>Card</code>.
     * 
     * @return The <code>Card</code> at index 0 (the first position) in the <code>Deck</code> .
     */
    public Card topCardOfDeck(){
        return deckOfCards.get(0);
    }

    /**
     * Returns the length of the <code>Deck</code>.
     * 
     * @return The number of elements in the <code>Deck</code>
     */
    public int lengthOfDeck(){
        return deckOfCards.size();
    }

    /**
     * Returns the <code>Deck</code>'s <code>Card</code> that is at the given index.
     * 
     * @param index The index at which to get the <code>Card</code> in the <code>Deck</code>
     * @return The <code>Card</code> at the given index in the <code>Deck</code> 
     */
    public Card getCardAtIndex(int index){
        return deckOfCards.get(index);
    }
    
    

    /**
     * Sorts the <code>Deck</code> that the method is called on in ascending order.
     */
    public void sort (){
        Collections.sort(deckOfCards);
    }

    /**
     * Removes and returns a subportion of the the <code>Deck</code> that goes from the give index to the end of the <code>Deck</code>.
     * 
     * @param index The first index of the <code>Card</code> to remove in the <code>Deck</code>
     * @return the new <code>Deck</code> after removing <code>Card</code>s
     */
    public Deck cutDeck(int index){
        Deck d = new Deck();
        int size = lengthOfDeck();
        for(int i = index; i<size; i++){
            d.addCardAtIndex(d.lengthOfDeck()-1, getNextCard(index));
        }
        return d;
    }

    public void addCardAtEnd(Card c){
        deckOfCards.add(c);
    }

    /**
     * Returns and removes the <code>Card</code> at the specified index in the <code>Deck</code>.
     * 
     * @return The <code>Card</code> that was removed
     * @param The index at which to remove the card from the <code>Deck</code>
     */
    public Card getNextCard(int index){
        return deckOfCards.remove(index);
    }

    /**
     * Removes the <code>Deck</code>'s <code>Card</code> that is at the given index.
     * 
     * @param index The index of the <code>Card</code> to remove
     */
    public Card removeCardAtIndex(int index){
        return deckOfCards.remove(index);
    }

    /**
     * Add a <code>Deck</code>'s <code>Card</code> to the given index. If the <code>Deck</code> has no elements/indexes prior to calling this method, the method will place it at the first position in the <code>Deck</code>.
     * 
     * @param index The index of the <code>Card</code> to add
     * @param <code>Card</code>'s The card to add
     */
    public void addCardAtIndex(int index, Card c){
        if(deckOfCards.size()==0){
            deckOfCards.add(0, c);
        }else{
            deckOfCards.add(deckOfCards.size(), c);
        }
    }

    /**
     * Retains all of the <code>Card</code>s in the given range, effectively removing <code>Card</code>s outside of the given range.
     * 
     * @param start The starting index of the range of <code>Card</code>s to keep (inclusive)
     * @param end The ending index of the range of <code>Card</code>s to keep (inclusive)
     * 
     */
    public void includeOnlyCardsInRange(int start, int end){
        ArrayList<Card> deckOfCards2 = new ArrayList<Card>(deckOfCards.subList(start, end+1));
        deckOfCards=deckOfCards2;   
    }

    /**
     * Removes all of the <code>Card</code>s in the given range.
     * 
     * @param start The starting index of the range of <code>Card</code>s to remove (inclusive)
     * @param end The ending index of the range of <code>Card</code>s to remove (inclusive)
     * 
     */
    public ArrayList<Card> removeCardsInRange(int start, int end){
        Iterator<Card> iter = deckOfCards.iterator();
        int i = 0;
        while(iter.hasNext()){
            i++;
            Card x = iter.next(); 
            if (i>=start&&i<=end+1) {
                iter.remove(); 
            }
        }
        return deckOfCards;
    }

    /**
     * Makes the <code>Card</code> at the given index face the specified direction. 
     * @param index The index of the <code>Card</code>s to face a certain way
     * @param up The boolean value that defines which way the card should flip. To face the 
     * <code>Card</code> up, up should be "true". To face the card down up should be "false"
     */

    public void faceCardAtIndexUpOrDown(int index, boolean up){
        deckOfCards.get(index).setFaceUp(up);
    }

    /**
     * Flips the <code>Card</code> at the given index. 
     * 
     * @param index The index of the <code>Card</code>s to flip. <code>Card</code>s that were 
     * originally facing up will be faced down, and <code>Card</code>s that were originally 
     * facing down will be faced up.
     */
    public void flipCardAtIndex(int index){
        if(deckOfCards.get(index).isFaceUp()){
            faceCardAtIndexUpOrDown(index, false);
        }else if(!deckOfCards.get(index).isFaceUp()){
            faceCardAtIndexUpOrDown(index, true);
        }
    }

    /**
     * Makes all the <code>Card</code>s in the given range flip over. <code>Card</code>s that
     * were originally facing up will be faced down, and <code>Card</code>s that were 
     * originally facing down will be faced up.
     * 
     * @param start The starting index of the range of <code>Card</code>s to flip (inclusive)
     * @param end The ending index of the range of <code>Card</code>s to flip (inclusive)
     */
    public void flipCardsInRange(int start, int end){
        for(int i = start; i<=end; i++){
            if(deckOfCards.get(i).isFaceUp()){
                faceCardAtIndexUpOrDown(i, false);
            }else if(!deckOfCards.get(i).isFaceUp()){
                faceCardAtIndexUpOrDown(i, true);
            }
        }
    }

    /**
     * Makes all the <code>Card</code>s in the given range face up.
     * 
     * @param start The starting index of the range of <code>Card</code>s to face up (inclusive)
     * @param end The ending index of the range of <code>Card</code>s to face up (inclusive)
     */
    public void faceUpCardsInRange(int start, int end){
        for(int i = start; i<=end; i++){
            deckOfCards.get(i).setFaceUp(true);
        }
    }

    /**
     * Makes all the <code>Card</code>s in the given range face down.
     * 
     * @param start The starting index of the range of <code>Card</code>s to face down (inclusive)
     * @param end The ending index of the range of <code>Card</code>s to face down (inclusive)
     */
    public void faceDownCardsInRange(int start, int end){
        for(int i = start; i<=end; i++){
            deckOfCards.get(i).setFaceUp(false);
        }
    }

    /**
     * Shuffles the <code>Deck</code> by switching each <code>Card</code> in the <code>Deck</code> with another random <code>Card</code>. 
     */
    public void shuffle(){
        for(int i = 0; i<deckOfCards.size(); i++){
            int j = new Random().nextInt(deckOfCards.size());
            Card temp = deckOfCards.get(i);
            deckOfCards.set(i, deckOfCards.get(j));
            deckOfCards.set(j, temp);
        }
    }

    /**
     * Returns the <code>Deck</code> as a <code>String</code>. If the <code>Card</code> is facing down, the <code>Card</code> is represented by "X"
     * is returned. Otherwise if the <code>Card</code> is facing up, the <code>Card</code> is represented by its symbol. Before and after each <code>Card</code> in the <code>Deck</code>, there is a comma followed by a space (, ). At the very beggingins and end of the <code>Deck</code>, there are also square brackets([]])
     * 
     * @return A <code>String</code> containing the <code>Deck</code> of <code>Card</code>s where each <code>Card</code> is seperated by a space
     */
    @Override
    public String toString(){
        String result = "";
        int index = 0;
        result+="[";
        for(Card i : deckOfCards){
            result += i;
            if(index!=deckOfCards.size()-1){
                result += ", ";
            }
            index++;
        }
        result+="]";
        return result;
    }

    /**
     * Returns the <code>Deck</code> as a <code>String</code>. Each <code>Card</code> is represented with its symbol and the direction it is facing
     * 
     * @return A <code>String</code> containing the <code>Deck</code> of <code>Card</code>s where each <code>Card</code> is seperated by a space.
     */
    public String deckAsString(){
        String result = "";
        int index = 0;
        for(Card i : deckOfCards){
            if(i.isFaceUp()) result += i.getSymbol() + " " + "t" ;
            else result += i.getSymbol() + " " + "f" ;

            if(index!=deckOfCards.size()-1){
                result += " ";
            }
            index++;
        }
        return result;
    }
}
