
/**
 * A program to test if a number is a prime number.
 *
 * @author Luis Castillo
 * @version V1.0
 * @since 10/10/2026
 */
import java.util.Scanner;
public class PrimeNumbers
{
   public static void main(String[] args){
       Scanner keyboard = new Scanner(System.in);
       String again;
       
       do {
           System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
           int number = keyboard.nextInt();
           keyboard.nextLine();
           
           if (number < 2)
               {
               System.out.println(number + " is not a valid entry, it must be 2 or greater");
            }
           else if (testForPrime(number))
            {
             System.out.println(number + " is prime");
            }
           else 
           {
               System.out.println(number + " is not prime");
            }
            
            System.out.print("Enter yes to test another number, no to quit.");
            again = keyboard.nextLine().trim();
             
        } while (again.equalsIgnoreCase("yes"));
                   
        keyboard.close();
            }
               public static boolean testForPrime(int number){
                   if (number < 2){
                       return false;
                   }
                   for (int divisor = 2; divisor <= Math.sqrt(number); divisor++){
                       if (number % divisor == 0){
                           return false;
                       }
                   }
                   return true;
               }
           }