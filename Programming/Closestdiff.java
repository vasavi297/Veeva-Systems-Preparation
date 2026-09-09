/*2.Given array of n integers find distance of any two closest numbers in the above array
n=5		n=2		n=3             n=3		n=2				n=2				n=5			n=4			[]
[5,2,3,4,1]	[10,20]		[30,10,20]	[-3,-10,-5]	[2147483647 -2147483648]	[2147483647 2147483648]		1 100 2 200 3		[10 100 1000 10000]	o/p:-1
o/p=1 		O/P=10		o/p=10		o/p=2		o/p=				o/p=1				o/p=1			o/p=90
 */
import java.util.*;
class Closestdiff
{
    static int closest(int arr[])
    {
        int n=arr.length;
        long diff=Integer.MAX_VALUE;
        TreeSet<Integer>ts=new TreeSet<>();
        for(int i=0;i<n;i++)
        {
            ts.add(arr[i]);
        }
        if(ts.size()<2)
        {
            return -1;
        }
        long curr=ts.first();
        while(true)
        {
            Integer next=ts.higher((int)curr);
            if(next==null)
            {
                break;
            }
            diff=Math.min(diff,Math.abs(curr-next));
            curr=next;
        }

        return (int)diff;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(closest(arr));
    }
}