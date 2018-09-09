import java.util.*;
import java.io.*;
import ou.*;
/**
* Class Payroll that models the payroll of a programmer. 
* 
* The class allows you to read and write to a file that
* contains details of the payroll of a programmer/programmers.
*
* @author Sam Lichy
* @version 08/05/18
*/
public class Payroll
{
   private List<Programmer> programmers;

   /**
    * Constructor for objects of class Payroll
    */
   public Payroll()
   {
      this.programmers = new ArrayList<>();
   }
 
   /**
    * Method to compute the pay of a programmer.
    *
    * The method returns the programmer’s grade multiplied
    * by the number of hours they worked.
    */
   public int computePay(Programmer p)
   {
      return (p.getGrade())*(p.getHours());
   }
  
   /**
    * This method will read from the file employees.txt, which
    * can be found in the project folder, and which contains
    * the name, grade and hours worked for each programmer. The 
    * method takes no arguments and returns no value.
    */
   public void readEmployeeData()
   {
      String path = OUFileChooser.getFilename();
      File file = new File(path);
      Scanner bufferedScanner = null;
      BufferedReader bufferedFileReader = null;
 
      try
      {
         bufferedFileReader = new BufferedReader(new FileReader(file));
         String line = bufferedFileReader.readLine();
         String name;
         int grade;
         int hours = 0;
         int hoursPerDay;
         int pay = 0;
        
         while (line != null)
         {
            bufferedScanner = new Scanner(line);
            bufferedScanner.useDelimiter(",");
            name = bufferedScanner.next();
            Programmer newProgrammer = new Programmer(name);
            grade = bufferedScanner.nextInt();
            newProgrammer.setGrade(grade);
           
            for (int i = 0; i < 6; i++)
            {
               hoursPerDay = bufferedScanner.nextInt();
               hours = hours + hoursPerDay;
            }
           
            newProgrammer.setHours(hours);
            pay = computePay(newProgrammer);
            newProgrammer.setPay(pay);
           
            programmers.add(newProgrammer);
           
            line = bufferedFileReader.readLine();
         }
      }
      catch(Exception anException)
      {
         System.out.println("Error: " + anException);
      }
      finally
      {
         try
         {
            bufferedFileReader.close();
         }
         catch (Exception anException)
         {
            System.out.println("Error: " + anException);
         }
      }
   }
  
   /**
    * Method that iterates over programmers, and prints out the string
    * representation of each programmer.
    */
   public void showPayroll()
   {
      for (Programmer programmer: programmers)
      {
         System.out.println(programmer.toString());
      }
   }
   
   /**
    * A method that sorts the receiver's list of programmers from smallest
    * to largest pay. The resulting sorted list will be written to a text
    * file "payrollResults.txt" (saved to the project folder for 
    * Question 4). 
    * 
    */
   public void writePayroll()
   {
      Collections.sort(programmers);
      String pathname = OUFileChooser.getFilename();
      File aFile = new File(pathname);
      BufferedWriter sortedListFile = null;
      try
      {
         sortedListFile = new BufferedWriter(new FileWriter(aFile));
         sortedListFile.write("Account Details (Name, Grade, ID, Hours and Pay)");
         sortedListFile.newLine();
         for(Programmer sortedProgrammers: programmers)
         {
            sortedListFile.write(sortedProgrammers.getName() + "(Grade " + sortedProgrammers.getGrade() + 
                                 ", ID " + sortedProgrammers.getId() + ") Hours " + sortedProgrammers.getHours()
                                 + " Pay " + sortedProgrammers.getPay() + ")");
            sortedListFile.newLine();
         }
         
         sortedListFile.close();
      }
      catch (Exception anException)
      {
      }
   }
}