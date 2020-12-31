package worker.pay;
import java.io.*;
import java.util.*;

public class WorkerPay
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner File = new Scanner(new File("CS141 Assign14.txt"));                    //scans the file
      
      while(File.hasNextLine())                                                      //runs while there exists a next line
      {
         String line = File.nextLine();                                              //next line passed to variable line
         
         if(line.equals("") == false)                                                //runs if the line isnt blank, else if the line is blank, while loop runs again
         {
            Scanner LineScan = new Scanner(line);                                    //reads the variable line
            
            String name = LineScan.next();                                           //stores name
            double wage = LineScan.nextDouble();                                     //stores wage
           
            int hours = 0;                                                           //initializing values
            while (LineScan.hasNextInt())                                            //runs for all the "next integers"
            {
               hours = hours + LineScan.nextInt();                                   //"next integers" added together to determine their total number of hours
            }
            
            System.out.printf("%s worked for a total of %d hours at $%.2f an "+
            "hour for a gross pay of $%.2f %n", name, hours, wage, (wage*hours)); 
            
            if((wage*hours) >= 400)                                                  //if earned over 400, taxes are 33%, if under, taxes are 25%
            {
               System.out.printf("After 33%% taxes their total net pay should "+
            		   "be %.2f %n%n", ((wage*hours)-((wage*hours)*0.33)));
            }
            else
            {
               System.out.printf("After 25%% taxes their total net pay should "+
            		   "be %.2f %n%n", ((wage*hours)-((wage*hours)*0.25)));
            }
         }
      }
   }
}