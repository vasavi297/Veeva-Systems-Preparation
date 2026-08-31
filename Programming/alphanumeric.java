import java.util.*;
class alphanumeric
{
    public static int numericsum(String s)
    {
        int n=s.length();
        int sum=0;
        int curr=0;
       
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
             curr=curr*10+(ch-'0');
            }
            else
            {
                sum+=curr;
                curr=0;
            }
        }
        sum+=curr;
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int ans=numericsum(s);
        System.out.println(ans);
    }
}