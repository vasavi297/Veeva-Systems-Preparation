import java.util.*;
class sequence
{
    public static boolean Seq(int a[],int b[])
    {
        int n=a.length;
        int m=b.length;
        int i=0;
        int j=0;
        while(i<n&&j<m)
        {
            if(a[i]==b[j])
            {
                j++;
            }
            i++;
        }
        if(j==m)
        return true;
        else
        return false;
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
    int m=sc.nextInt();
    int b[]=new int[m];
    for(int j=0;j<m;j++)
    {
        b[j]=sc.nextInt();
    }
    boolean ans=Seq(a,b);
    System.out.println("Sequence or not "+ans);
   }
}