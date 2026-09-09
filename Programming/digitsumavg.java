/*3.Given an input string like
abcdc112kg45ldy4p9 extract all consecutive integers return their sum and avg
[112 45 4 9]
sum=170 avg=42.5
abc1.2def
o/p:3
    1.5
 */
import java.util.*;
class digitsumavg
{
    static float[] sumavg(String s)
    {
        int n=s.length();
        int sum=0;
        int count=0;
        float avg=0;
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
                if(curr>0)
                {
                    sum+=curr;
                    count++;
                    curr=0;
                }
            }
            if(i==n-1 && curr>0)
            {
                sum+=curr;
                count++;
            }
            
        }
        if(count>0)
        {
            avg=(float)sum/count;
        }
        return new float[] {sum,avg};
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        float ans[]=sumavg(s);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
