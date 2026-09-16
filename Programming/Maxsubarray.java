/*Maximum Sum Subarray of Size K
Given an array and integer k, find the maximum sum of any contiguous subarray of size k.

Example:
arr = [2, 1, 5, 1, 3, 2], k = 3
Output: 9 */
import java.util.*;
class Maxsubarray
{
    static int maxsum(int[] arr,int k)
    {
        int n=arr.length;
        int left=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
           sum+=arr[i];
           if(i-left+1==k)
           {
            max=Math.max(max,sum);
            sum-=arr[left];
            left++;
           }
        }
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int ans=maxsum(arr,k);
        System.out.println(ans);
    }
}