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
/**
 * Card.java
 *
 * <code>Card</code> represents a basic playing card.
 */
public class Card implements Comparable<Card>
{
    /** String value that holds the symbol of the <code>Card</code>.
    Examples: "A", "Ace", "10", "Ten", "Wild", "Pikachu"
     */
    private String symbol;

    /** int value that holds the value this <code>Card</code> is worth */
    private int value;

    /** boolean value that determines whether this <code>Card</code> is face up or down */
    private boolean isFaceUp;

    /**
     * Creates a new <code>Card</code> instance.
     *
     * @param symbol A <code>String</code> value representing the symbol of the <code>Card</code>
     * @param value An <code>int</code> value containing the point value of the <code>Card</code>
     */    
    public Card(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    /**
     * Getter method to access this <code>Card</code>'s symbol.
     * 
     * @return This <code>Card</code>'s symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Getter method to access this <code>Card</code>'s value.
     * 
     * @return This <code>Card</code>'s value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to return whether or not this <code>Card</code> is facing up.
     * 
     * @return If this <code>Card</code> is facing up or not.
     */
    public boolean isFaceUp() {
        return isFaceUp;
    }

    /**
     * Setter method to set which direction this <code>Card</code> should face.
     * 
     * @param State a <code>String</code> value representing which direction the <code>Card</code> should face
     */
    public void setFaceUp(boolean state) {
        isFaceUp = state;
    }

    /**
     * Returns the difference between the other <code>Card</code>'s value and this <code>Card</code>'s value.
     *
     * @return This <code>Card</code>'s value minus the other <code>Card</code>'s value
     */
    @Override
    public int compareTo (Card other){
        return this.value-other.value;
    }

    /**
     * Returns whether or not this <code>Card</code>'s value is equal to another <code>Card</code>'s value.
     *  
     *  @return Whether or not this Card is equal to other.
     */
    public boolean equals(Card other) {
        return value==other.value;
    }

    /**
     * Returns this <code>Card</code> as a <code>String</code>.  If the <code>Card</code> is facing down, the <code>Card</code> is represented by "X"
     * is returned. Otherwise if the <code>Card</code> is facing up, the <code>Card</code> is represented by its symbol.
     *
     * @return A <code>String</code> containing the symbol or a <code>String</code> X
     */
    @Override
    public String toString() {
        if(!isFaceUp()){
            return "X";
        }else{
            return getSymbol() ;
        }
    }
}
