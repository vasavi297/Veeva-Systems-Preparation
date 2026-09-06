//Given a string and reverse the string inplace

import java.util.*;
class ReverseStringInplace
{
    static String reverse(String s)
    {
        int n=s.length();
        char[] arr=s.toCharArray();
        int j=n-1;
        int i=0;
        while(i<j)
        {
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ans=reverse(s);
        System.out.println(ans);
    }
}