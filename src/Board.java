/*
 * Aditya Rao
 * Period 4
 * 12/6/20
 * Time taken: 4 hours
 * This was a pretty time taking, but quite rewarding lab. With this part of the lab, I was able to create 
 * an almost fully working solitaire game. Other than what needs to be added in parts 6 and 7 of the future 
 * parts of the solitaire game, I was able to do everything, except for the clear method. I will finish this 
 * up during this week and resubmit. All of the issues that I ran into were eveutually fixed. To test my code 
 * and find the source of the many issues I ran into, I used a combination of the following: built in debugger, 
 * print statements, stepping through my code, and playing testing using the driver. One common theme I notice 
 * with my issues were index of of bounds exceptions, but these were fixed by paying attention to what variables 
 * and indexes loops go through before and after adding/removing/getting an index. I also had to add/refine a couple 
 * of methods in my deck class, since I was not preware that I would need those methods or make changes to them when I 
 * was first creating my deck class.
 * 
 * Edit on 12/7/20 - I'm resubmitting this lab, since I made the clear method work. I used a completely differnt and much simple strategy 
 * with if/else if/else statements to either print out an error, or clear. This only took me 10 minutes to implement. I originally ran 
 * into an index out bounds exception, but I fixed it right away by adding 1 to the source stack value when comparing if it is > that the 
 * size of the stack. 
 * 
 * (Other than the part where I mentioned the clear method not working (it does now :) ), everything else in the original reflection still applies)
 *
 */
import java.util.*;
import javax.swing.*;
import java.io.*;
public class Board
{   
    int numTotalCards;
    //Deck originalOverallDeck;
    //Deck overallDeck;
    //Deck stacksDeck;
    Deck drawPileDeck;
    //Deck finalStacksDeck;
    //Deck copyDeck;
    //Deck remainingDeck;
    //int numCardsInDrawPile;
    //int totalCardsInStacks;

    //int count = 0;
    int numStacks;
    int numDecks;
    private ArrayList<Deck> boardOfDecks;
    /**
     *  Sets up the Board and fills the stacks and draw pile from a Deck
     *  consisting of numDecks Decks.  Here are examples:
     *  
     *  # numDecks     #cards in overall Deck
     *      1          13 (all same suit)
     *      2          26 (all same suit)
     *      3          39 (all same suit)
     *      4          52 (all same suit)
     *      
     *  Once the overall Deck is built, it is shuffled and half the cards
     *  are placed as evenly as possible into the stacks.  The other half
     *  of the cards remain in the draw pile.
     */   

    public Board(int numStacks, int numDecks) {

        //clear() test #1
        /*
        this.numStacks = numStacks;
        this.numDecks = numDecks;
        boardOfDecks = new ArrayList<Deck>();

        String[] symbols = {"56", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2", "A", "45", "2", "632", "56"};
        int[] values = {56, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 45, 2, 632, 56};
        for(int x = 0; x<numDecks; x++){
        boardOfDecks.add(new Deck());
        for(int i = 0; i<symbols.length; i++){
        Card c = (new Card(symbols[i], values[i]));
        c.setFaceUp(true);
        boardOfDecks.get(x).addCardAtEnd(c);
        }
        }

        System.out.println(boardOfDecks);
        this.clear(3);
        System.out.println(boardOfDecks);
         */

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        this.numStacks = numStacks;
        this.numDecks = numDecks;
        boardOfDecks = new ArrayList<Deck>();

        Deck overallDeck = new Deck();
        drawPileDeck = new Deck();
        Deck remainingDeck = new Deck();
        String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for(int x = 0; x<numDecks; x++){
            for(int i = 0; i<symbols.length; i++){
                Card c = (new Card(symbols[i], values[i]));
                c.setFaceUp(false);
                overallDeck.addCardAtIndex(i, c);
            }
        }
        overallDeck.shuffle();
        int x;
        if(numStacks==0)x=0;
        else x = (int)(Math.ceil((numDecks*13)/numStacks));
        int numOfLastCards = (numDecks*13)/2 - numStacks *(x/2); 
        int len = overallDeck.lengthOfDeck();
        drawPileDeck = overallDeck;
        Deck copyDeck = new Deck();
        copyDeck = overallDeck;
        for(int y = 0; y<numStacks; y++){
            boardOfDecks.add(new Deck());
        }
        for(int n = 0; n<x/2; n++){
            for(int i = 0; i<numStacks; i++){
                boardOfDecks.get(i).addCardAtIndex(0, overallDeck.getNextCard(i));
            }
        }
        for(int i = 0; i<numOfLastCards; i++){
            remainingDeck.addCardAtIndex(i, copyDeck.getCardAtIndex(copyDeck.lengthOfDeck()-numOfLastCards+i));
        }
        if(numDecks%2==0){
            overallDeck.removeCardsInRange(len/2+1, len);
        }else{
            overallDeck.removeCardsInRange(len/2+2, len);
        }
        try{
            for(int i = 0; i<remainingDeck.lengthOfDeck(); i++){
                boardOfDecks.get(i).addCardAtIndex(0, remainingDeck.getCardAtIndex(i));
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("ERROR: Pass in at least one stack if you have 0 decks");
            System.exit(0);
        }
        for(int i = 0; i<boardOfDecks.size(); i++){
            if(numDecks%2==1){
                boardOfDecks.get(i).getCardAtIndex(boardOfDecks.get(i).lengthOfDeck()-1).setFaceUp(true);
            }else{
                boardOfDecks.get(i).getCardAtIndex(boardOfDecks.get(i).lengthOfDeck()-1).setFaceUp(true);
            }
        }

    }

    public void saveToFile(){
        JFileChooser chooser = new JFileChooser(".");
        chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        try{
            FileWriter fw = new FileWriter(file);            
            fw.write(drawPileDeck.deckAsString());            
            System.out.println("Board saved!");
            fw.write("\r\n");
            for(int i = 0; i<numStacks; i++){
                fw.write(boardOfDecks.get(i).deckAsString());
                fw.write("\r\n");
            }
            fw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }      
    }

    public void loadFromFile(){
        JFileChooser chooser = new JFileChooser(".");
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        try{
            Scanner sc = new Scanner(file);
            drawPileDeck = new Deck(sc.nextLine());//works
            for(int i = 0; i<boardOfDecks.size(); i++){
                boardOfDecks.set(i, new Deck(sc.nextLine()));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Moves a run of cards from src to dest (if possible) and flips the
     *  next card if one is available.
     */

    public void makeMove(String symbol, int src, int dest) {
        boolean isAscending = true;
        boolean hasDown = false;
        boolean hasCard = false;
        int i;
        boolean errorDone = false;
        for(i = boardOfDecks.get(src).lengthOfDeck()-1; i>=0; i--){
            if(!boardOfDecks.get(src).getCardAtIndex(i).isFaceUp()){
                hasDown = true;
                if(!errorDone){
                    System.out.println("ERROR: This card doesn't exist");
                    errorDone = true;
                }
                break;
            }
            if(i<boardOfDecks.get(src).lengthOfDeck()-1){
                Card current = boardOfDecks.get(src).getCardAtIndex(i);
                Card previous = boardOfDecks.get(src).getCardAtIndex(i+1);
                if(current.compareTo(previous)!=1){
                    isAscending = false;
                    System.out.println("ERROR: Cards are not in ascending order");
                    break;
                }
            }
            if(boardOfDecks.get(src).getCardAtIndex(i).getSymbol().equals(symbol)){
                hasCard = true;
                break;
            }
        }

        if(isAscending && !hasDown && hasCard){
            Deck add = boardOfDecks.get(src).cutDeck(i);
            if(boardOfDecks.get(dest).lengthOfDeck()==0){
                if(boardOfDecks.get(src).lengthOfDeck()>0){

                    boardOfDecks.get(src).getCardAtIndex(boardOfDecks.get(src).lengthOfDeck()-1).setFaceUp(true);
                    add.sort();
                    for(i = add.lengthOfDeck()-1; i>=0; i--){
                        boardOfDecks.get(dest).addCardAtEnd(add.getCardAtIndex(i));
                    }
                }
            }else if(add.getCardAtIndex(add.lengthOfDeck()-1).compareTo(boardOfDecks.get(dest).getCardAtIndex(boardOfDecks.get(dest).lengthOfDeck()-1))==-1){
                if(boardOfDecks.get(src).lengthOfDeck()>0){
                    boardOfDecks.get(src).getCardAtIndex(boardOfDecks.get(src).lengthOfDeck()-1).setFaceUp(true);
                    add.sort();
                    for(i = add.lengthOfDeck()-1; i>=0; i--){
                        boardOfDecks.get(dest).addCardAtEnd(add.getCardAtIndex(i));
                    }
                }
            }else{
                System.out.println("ERROR: Cannot place card here");
                add.sort();
                for(i = add.lengthOfDeck()-1; i>=0; i--){
                    boardOfDecks.get(src).addCardAtEnd(add.getCardAtIndex(i));
                }
            }

        }else if(!errorDone && !hasCard){
            System.out.println("ERROR: This card doesn't exist");
            errorDone = true;
        }

    }

    /** 
     *  Moves one card onto each stack, or as many as are available
     */
    public void drawCards() {
        if(drawPileDeck.lengthOfDeck()>0){
            int index = 0;
            boolean cont = true;
            for(Deck i : boardOfDecks){ 
                if(i.lengthOfDeck()==0){
                    cont = false;
                    break;
                }
            }
            if(cont){
                for(Deck i : boardOfDecks){   
                    if(drawPileDeck.lengthOfDeck()>0){
                        boardOfDecks.get(index).addCardAtEnd(drawPileDeck.getCardAtIndex(drawPileDeck.lengthOfDeck()-1));
                        boardOfDecks.get(index).getCardAtIndex(boardOfDecks.get(index).lengthOfDeck()-1).setFaceUp(true);
                        drawPileDeck.removeCardAtIndex(drawPileDeck.lengthOfDeck()-1);
                    }
                    index++;
                }
            }
        }else{
            System.out.println("ERROR: No cards available to draw");
        }
    }

    /**
     *  Returns true if all stacks and the draw pile are all empty
     */ 
    public boolean isEmpty() {
        for(int i = 0; i<boardOfDecks.size(); i++){
            if(boardOfDecks.get(i).lengthOfDeck()!=0){
                return false;
            }
        }
        if(drawPileDeck.lengthOfDeck()!=0) return false;
        return true;
    }

    /**
     *  If there is a run of A through K starting at the end of sourceStack
     *  then the run is removed from the game or placed into a completed
     *  stacks area.
     *  
     *  If there is not a run of A through K starting at the end of sourceStack
     *  then an invalid move message is displayed and the Board is not changed.
     */
    public void clear(int sourceStack) { 
        if(sourceStack+1>boardOfDecks.size()||sourceStack<0){
            System.out.println("ERROR: This stack doesn't exist");
        }else if(boardOfDecks.get(sourceStack).lengthOfDeck()<13){
            System.out.println("ERROR: The stack doesn't have enough cards to clear");
        }else{
            int index = 0;
            for(int i = 13; i>0; i--){

                if(!(boardOfDecks.get(sourceStack).getCardAtIndex(index).getValue()==(i))){
                    System.out.println("ERROR: This arrangement of cards cannot be cleared");
                    break;
                }
                if(!(boardOfDecks.get(sourceStack).getCardAtIndex(index).isFaceUp())){
                    System.out.println("ERROR: This arrangement of cards cannot be cleared");
                    break;
                }

                index++;
                if(i==1){
                    System.out.println("Succesful clear");
                    boardOfDecks.get(sourceStack).cutDeck(0);
                }
            }
        }
    }

    /**
     * Prints the board to the terminal window by displaying the stacks, draw
     * pile, and done stacks (if you chose to have them)
     */
    public void printBoard() {

        String result = "";
        int index = 0;
        System.out.println("Stacks:");
        for(Deck i : boardOfDecks){
            System.out.print(index+1 + ": ");
            System.out.print(i);
            if(index!=boardOfDecks.size()-1){
                System.out.print("\n");
            }
            index++;
        }
        for(int i = 0; i<drawPileDeck.lengthOfDeck(); i++){
            drawPileDeck.faceCardAtIndexUpOrDown(i, false);
        }
        System.out.println("\n\nDraw Pile: " + drawPileDeck.lengthOfDeck());
        System.out.println(drawPileDeck);
        System.out.print("\n");

    }
}