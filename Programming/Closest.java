/*Coding Problems asked previously 

1. In a List or Array of Numbers,To find which number in a list is closest to a target, find the one with the smallest absolute difference.
Test cases
Test case1                                     
Input:
N=6
[9, 11, 5, 3, 25, 18], 
K = 6
Output : 5*/
import java.util.*;
class Closest
{
   public static int closest(int arr[], int K) {
        int ans=arr[0];
        int minDiff=Math.abs(arr[0] - K);

        for (int i=1;i<arr.length;i++) {
            int diff=Math.abs(arr[i] - K);

            if (diff<=minDiff) {
                minDiff=diff;
                ans=arr[i];
            }
        }

        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter k value");
        int K=sc.nextInt();
        int res=closest(arr,K);
        System.out.println("Closest value of k is "+res);
    }
} 
  