/*Given a string separated by camel case letter as delimeter find number of words
OneTwoThreeFour
o/p:4*/

import java.util.*;
class Camelcase
{
    static int count(String s)
    {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==Character.toUpperCase(s.charAt(i)))
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int ans=count(s);
        System.out.println(ans);
    }
}

