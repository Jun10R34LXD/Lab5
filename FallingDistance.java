
/**
 * A program to calculate the distance fallen in a certain time frame given
 * by the user.
 * @author Luis Castillo
 * @version V1.0
 * @since 10/10/2026
 */
import java.util.Scanner;
public class FallingDistance
{
  public static final double ACCELERATION = 9.8;
  
  public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please enter how many seconds to compute: ");
      int NumOfSecs = keyboard.nextInt();
      
      System.out.println();
      System.out.printf("%-12s%12s%n", "Time(secs)", "Distance(m)");
      System.out.printf("%-12s%12s%n", "==========", "===========");
      
      for (int time = 1; time <= NumOfSecs; time++){
          System.out.printf("%-12d%12.1f%n", time, getDistance(time));
      }
      keyboard.close();
  }
  public static double getDistance(int seconds){
      return 0.5 * ACCELERATION * Math.pow(seconds, 2);
  }
}