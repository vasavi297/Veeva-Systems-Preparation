/*3.Given 2 strings S and T,Now check is T can be formed as subsequence of S by cyclically incrementing characters of S atmost once.

EX: S =ABC    	T = AD
O/P: TRUE

EX: S=ZC  		T=AD
O/P: TRUE*/
import java.util.*;
public class CyclicIncrement {
    static boolean increment(String s,String t)
    {
        int i=0;
        int j=0;
        while(i<s.length()&&j<t.length())
        {
            char ch=s.charAt(i);
            char ch1=t.charAt(j);
            char base=Character.isUpperCase(ch)?'A':'a';
            char next=(char)(base+(ch-base+1)%26);
            if(ch==ch1||ch1==next)
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j==t.length();
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        System.out.println(increment(s,t));
    }
}
