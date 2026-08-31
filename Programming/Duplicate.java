import java.util.*;
public class Duplicate {
    static ArrayList<Integer> duplicate(int a[])
    {
      int n=a.length;
      HashSet<Integer>hs=new HashSet<>();
      for(int i=0;i<n;i++)
      {
         hs.add(a[i]);
      }
      return new ArrayList<Integer>(hs);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        ArrayList<Integer>res=duplicate(a);
        System.out.println(res);
    }
}
