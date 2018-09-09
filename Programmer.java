import java.util.*;
/**
 * Class Programmer - Models a programmer
 *
 * @author M250 Course Team
 * @version Version 1
 */
public class Programmer implements Comparable<Programmer>
{
   private int id;      // programmer's id
   private String name; // programmer's name
   private int grade;   // Determines pay; 1, 2 or 3
   private int pay;     // total pay in gold coins
   private int hours;   // total hours worked
   private static int nextId = 1;

   /**
    * Constructor for objects of class programmer
    */
   public Programmer(String aName)
   {
      super();
      this.name = aName;
      this.id = nextId;
      nextId++;
   }

   public int getId()
   {
      return this.id;
   }

   public String getName()
   {
      return name;
   }

   public int getGrade()
   {
      return grade;
   }

   public void setGrade(int aGrade)
   {
      if (aGrade >= 1 && aGrade <= 3)
      {
         this.grade = aGrade;
      }
      else
      {
         throw new IllegalArgumentException("The grade " + aGrade + " does not exist");
      }
   }

   public int getPay()
   {
      return pay;
   }

   public void setPay(int pay)
   {
      this.pay = pay;
   }

   public int getHours()
   {
      return hours;
   }

   public void setHours(int hours)
   {
      this.hours = hours;
   }
   
   /**
    * Method for the Programmer class to return a string describing
    * each programmer
    */
   @Override
   public String toString()
   {
      return this.name + " " + "(Grade " + this.grade + ", ID " + this.id + ") Hours "
             + this.hours + " Pay " + (this.getGrade()*this.getHours());
   }
   
   /**
    * A method to check the ordering of two Programmer
    * objects by using the value of each Programmer's pay.
    */
   @Override
   public int compareTo(Programmer programmer)
   {
      return (this.getPay() - programmer.getPay());
      
   }
}
