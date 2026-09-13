/*Consider Input leap year or not leap year*/
import java.util.*;
class LeapYear
{
    public static boolean Leap(int year)
    {
        if(year%4==0&&year%100!=0||year%400==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        boolean isLeap=Leap(year);
        System.out.println(isLeap);
    }
}