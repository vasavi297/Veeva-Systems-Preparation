/*Given that January 1st of a specific year is a Monday, write code to calculate what day of the week September 14th lands on
 Input Year
2018
  Output
Friday
Input 
2018
Output
Friday*/
import java.util.*;
class SpecificDay
{
    static String dayOfweek(int year)
    {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; 
        }
        int totalDays = 0;
        for (int i = 0; i < 8; i++) { 
            totalDays += daysInMonth[i];
        }
        totalDays += 14; 
        int dayOfWeekIndex = (totalDays - 1) % 7; 
        String[] daysOfWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        return daysOfWeek[dayOfWeekIndex];
    }
    static boolean isLeapYear(int year) 
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        String ans=dayOfweek(year);
        System.out.println(ans);
    }
}