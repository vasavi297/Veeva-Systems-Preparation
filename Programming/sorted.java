import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class sorted
{
    static ArrayList<Integer> sortedlist (int a[],int b[]) 
    {
       int n=a.length;
       int m=b.length;
       ArrayList<Integer>ans=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
         ans.add(a[i]);
       }
       for(int i=0;i<m;i++)
       {
        ans.add(b[i]);
       }
       Collections.sort(ans);
       return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int b[]=new int[m];
        for(int i=0;i<m;i++)
        {
            b[i]=sc.nextInt();
        }
        ArrayList<Integer> res=sortedlist(a,b);
        System.out.println("Sorted List:" +res);
    }
}