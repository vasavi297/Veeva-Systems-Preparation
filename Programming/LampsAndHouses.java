import java.util.*;
class LampsAndHouses
{
    static int radius(int[] h,int[] l)
    {
        int n=h.length;
        int m=l.length;
        int maxdistance=0;
        Arrays.sort(h);
        Arrays.sort(l);
        int j=0;
        for(int i=0;i<n;i++)
        {
            while(j<m-1 && l[j]<h[i])
            {
                j++;
            }
            if(j==0)
            {
                maxdistance=Math.max(maxdistance,Math.abs(l[j]-h[i]));
            }
            else
            {
                maxdistance=Math.max(maxdistance,Math.min(Math.abs(l[j]-h[i]),Math.abs(l[j-1]-h[i])));
            }
        }
        return maxdistance;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int h[]=new int[n];
        int l[]=new int[m];
        for(int i=0;i<n;i++)
        {
            h[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            l[i]=sc.nextInt();
        }
        System.out.println(radius(h,l));
    }
}