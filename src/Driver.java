/*
 * Aditya Rao
 * Period 4
 * 12/17/20
 * Time taken: 1 hour
 * This was a nice lab for me, as with this part of Solitaire complete, I have a fully 
 * working game! Overall, it was pretty easy for me as everything was outlined well 
 * and broken up into clear steps on the doc. However, I did run into one issue. This 
 * was when I was trying to use the new line character to split up my file writing 
 * into several lines. At first when I tried "/n", I got quite weird results. But 
 * after doing a little bit of research, I found out that the new line character in 
 * java in Windows is "\r\n". After finding and fixing the issue, everything worked! 
 * In the future, I may consider adding extra features, mainly realted to a better UI. 
 * I personally feel that this UI is a bit hard to use, so I was thinking of using 
 * gpdraw to create labeled rectangles that each represent a card
 * 
 *
 */
public class Driver
{
    public static void main(String[] args) {
        new SpiderSolitaire().play();
        
    }
}
