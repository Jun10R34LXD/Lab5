
/**
 * A program that reads from a file to process grades.
 *
 * @author Luis Castillo
 * @version V1.0
 * @since 10/14/2026
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class GradeProcessing
{
    public static final int SENTINEL = -1;
    
    private static final Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        String inFile = getInFile();
        String outFile = getOutFile();
        
        processFile(inFile, outFile);
        
        System.out.println("Grade processing completed");
        System.out.println("You can retrieve the output file at, " + outFile);
    }
    public static String getInFile() throws IOException
    {
        String inFile;
        boolean found;
        
        do
        {
            System.out.print("Enter the name of the input file (ie input.txt): ");
            inFile = keyboard.nextLine().trim();
            
            File file = new File(inFile);
            found = file.exists() && file.isFile();
            
            if(!found)
            {
                System.out.println("The input file cannot be found. Please try again.");
            }
        } while (!found);
        return inFile;
    }
    public static String getOutFile()
    {
        System.out.print("Enter the name of the output file (ie output.txt): ");
        return keyboard.nextLine().trim();
    }
    public static void processFile(String inFile, String outFile) throws IOException
    {
        Scanner input = new Scanner(new File(inFile));
        PrintWriter output = new PrintWriter(outFile);
        
        int setNumber = 0;
        
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            
            if (line.trim().isEmpty())
            {
                continue;
            }
            setNumber++;
            Scanner lineScanner = new Scanner(line);
            
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
            int count = 0;
            int sum = 0;
            int high = 0;
            int low = 0;
            
            int score = lineScanner.nextInt();
            while (score != SENTINEL)
            {
                if (count == 0)
                {
                    high = score;
                    low = score;
                }
                else
                {
                    if (score > high)
                    {
                        high = score;
                    }
                    if (score < low)
                    {
                        low = score;
                    }
                }
                if (score >= 90)
                {
                    countA++;
                }
                else if (score >= 80)
                {
                    countB++;
                }
                else if (score >= 70)
                {
                    countC++;
                }
                else if (score >= 60)
                {
                    countD++;
                }
                else
                {
                    countF++;
                
            }
            sum += score;
            count++;
            
            score = lineScanner.hasNextInt() ? lineScanner.nextInt() : SENTINEL;
        }
        output.println("set " + setNumber + " of grades calculated");
        
        if (count == 0 )
        {
          output.println("no grades to average");  
        }
        else
        {
            double average = (double) sum / count;
            
            output.println("number of As: " + countA);
            output.println("number of Bs: " + countB);
            output.println("number of Cs: " + countC);
            output.println("number of Ds: " + countD);
            output.println("number of Fs: " + countF);
            output.println("The high score was: " + high);
            output.println("The low score was: " + low);
            output.printf("The avg score is: %.1f%n", average);
        }
        lineScanner.close();
    }
    input.close();
    output.close();
}
}