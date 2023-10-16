import java.util.*;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * @desc count the maximum number of consecutive heads and tails for a given number of flips, 
 * while checking to see if past records are broken
 */
public class CoinFlip {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //variables
        int recordHeads = 0;
        int recordTails = 0;
        boolean willContinue = true;

        while (willContinue){
            try {
                //reads file for records of past games
                File recordsFile = new File("CoinFlipRecords.txt");
                Scanner myReader = new Scanner(recordsFile);
                recordHeads = Integer.parseInt(myReader.nextLine());
                recordTails = Integer.parseInt(myReader.nextLine());
                myReader.close();
              } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
            int[] newFlip = runFlip();

            //notification if a record is broken
            if (newFlip[0] > recordHeads){
                System.out.println("\nYou set a new record for consecutive heads: " + newFlip[0]);
                System.out.println("The old record for consecutive heads was: " + recordHeads);
                recordHeads = newFlip[0];
            }
            if (newFlip[1] > recordTails){
                System.out.println("\nYou set a new record for consecutive tails: " + newFlip[1]);
                System.out.println("The old record for consecutive tails was: " + recordTails);
                recordTails = newFlip[1];
            }

            //saves records to file
            try{
                PrintWriter printer = new PrintWriter("CoinFlipRecords.txt");
                printer.println(recordHeads + "\n" + recordTails);
                printer.close();
            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }   

            System.out.println("\nWill you continue? y/n");
            if (sc.next().equalsIgnoreCase("n")){
                willContinue = false;
            }
        }
        System.out.println("Thanks for playing!");
    
    }

    public static int[] runFlip(){

        //variables
        int maxHeads = 0;
        int maxTails= 0;
        int countConsecutive = 1;
        int lastFlip = 69;

        //all inputs and outputs will take place in the terminal
        Scanner sc = new Scanner(System.in);
        System.out.println("\nHow Many Times Do You Want to Flip the Coin?");
        int numFlips = sc.nextInt();
        //makes sure user has valid input
        while (numFlips < 1 || numFlips > 1000){
            System.out.println("Error: input invalid | please re-input");
            numFlips = sc.nextInt();
        }
    
        for (int i = 0; i < numFlips; i++){
            //flip is set as 0 or 1 randomly
            //0 = heads
            //1 = tails 
            int flip = (int)Math.floor(Math.random()*2);
            switch(flip){
                case 0: System.out.println("H"); break;
                case 1: System.out.println("T"); break;
            }
            //if record is broken, checks if record is longest in the attempt
            if (flip != lastFlip){
                if (lastFlip == 0 && countConsecutive > maxHeads){
                    maxHeads = countConsecutive;
                }
                else if (lastFlip == 1 && countConsecutive > maxTails){
                    maxTails = countConsecutive;
                }
                countConsecutive = 1;
            }
            //adds count if record is not broken
            else if (flip == lastFlip){
                countConsecutive++;
            }
            //adjusts for the last flip
            if (i==numFlips-1){
                if (flip == 0 && countConsecutive > maxHeads){
                    maxHeads = countConsecutive;
                }
                else if (flip == 1 && countConsecutive > maxTails){
                    maxTails = countConsecutive;
                }
                countConsecutive = 1;
            }
            lastFlip = flip;
        }
    
        //outputs records of game to user
        System.out.println("Highest Number of Consecutive Heads: " + maxHeads);
        System.out.println("Highest Number of Consecutive Tails: " + maxTails);
        
        int[] values = new int[]{maxHeads,maxTails};
        return values;
    }
}