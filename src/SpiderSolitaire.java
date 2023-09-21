/*
 * Aditya Rao
 * Period 4
 * 12/10/20
 * Time taken: 1 hour
 * This was a pretty simple lab for me. Essentially, my process to find bugs was just playing
 * the game, and sometimes entering invalid commands. When something unexpected printed out or 
 * there was an exception, I changed the code in either the Solitaire class or the Board class 
 * to make it work. The changes I made in the Solitaire class were try and catch blocks to catch 
 * any exceptions, and printing out error messages. In the Board class, I editted my code's 
 * variables/loops, or added additional/modified error messages (I had most of the error messages 
 * done previously). Compared to the Board class which I spent a long time on, this was much easier 
 * and quicker for me, since I did not have to write any new classes/methods or make huge changes 
 * to my code.
 * 
 * Based on what I have tested, everything works. If I there is an error I did 
 * not find, sorry about that, but I don't have a ton of time to play/test my game (because of 
 * studying for finals). Hope the grader understands :D, thanks)
 *
 */

import java.util.*;

public class SpiderSolitaire
{
    /** Number of stacks on the board **/
    public final int NUM_STACKS = 7;

    /** Number of complete decks used in this game.  A 1-suit deck, which is the
     *  default for this lab, consists of 13 cards (Ace through King).
     */
    public final int NUM_DECKS = 4;

    /** A Board contains stacks and a draw pile **/
    private Board board;

    /** Used for keyboard input **/
    private Scanner input;

    public SpiderSolitaire()
    {
        // Start a new game with NUM_STACKS stacks and NUM_DECKS of cards
        board = new Board(NUM_STACKS, NUM_DECKS);
        input = new Scanner(System.in); 
    }

    /** Main game loop that plays games until user wins or quits **/
    public void play() {

        board.printBoard();
        boolean gameOver = false; 

        while(!gameOver) {
            System.out.println("\nCommands:");
            System.out.println("   move [card] [source_stack] [destination_stack]");
            System.out.println("   draw");
            System.out.println("   clear [source_stack]");
            System.out.println("   restart");
            System.out.println("   save");
             System.out.println("   load");
            System.out.println("   quit");
            System.out.print(">");

            String command = input.next();
            if (command.equals("move")) {
                String symbol = input.next();

                try{
                    int sourceStack = input.nextInt();
                    int destinationStack = input.nextInt();
                    board.makeMove(symbol, sourceStack - 1, destinationStack - 1);
                    input.nextLine();
                }catch(InputMismatchException e){
                    input.nextLine();
                    System.out.println("ERROR: Invalid command");

                }catch (IndexOutOfBoundsException e){
                    input.nextLine();
                    System.out.println("ERROR: This stack doesn't exist");

                }
                
                

            }
            else if (command.trim().equals("draw")) {
                board.drawCards();
                
            }
            else if (command.equals("clear")) {

                try{
                    int sourceStack = input.nextInt();
                    board.clear(sourceStack - 1);
                    input.nextLine();
                }
                catch(InputMismatchException e){
                    input.nextLine();
                    System.out.println("ERROR: Invalid command");
                }
            }
            else if (command.trim().equals("restart")) {
                System.out.print('\u000C');
                board = new Board(NUM_STACKS, NUM_DECKS);
            }
            else if (command.trim().equals("quit")) {
                System.out.print('\u000C');
                System.out.println("Goodbye! Thanks for playing!");
                System.exit(0);
            }
            else if (command.trim().equals("save")) {           
                board.saveToFile();     
            }
            else if (command.trim().equals("load")) {           
                board.loadFromFile();     
            }
            else {
                System.out.println("ERROR: Invalid command");
            }
            
            board.printBoard();
            //System.out.println("------------------------------------------------------------------------------------------");
            //input.nextLine();
            
            // If all stacks and the draw pile are clear, you win!
            if (board.isEmpty()) {
                gameOver = true;
            }
            
        }
        System.out.print('\u000C');
        System.out.println("Congratulations!  You win!");
    }
}
