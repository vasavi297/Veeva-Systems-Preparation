/*Given an array of size n, find the majority element that appears more than (floor n/2) times.

Input: [1], 
Output: 1


 Input: [4, 4]
Output: 4


 Input: [3, 2, 3]
Output: 3


Input: [2, 2, 1, 1, 2, 2], Output: 2

 Input: [7, 1, 7, 2, 7, 7, 3], Output: 7.

Input: [-5, -5, 2, -5]
Output:-5

 [0, 0, 8, 0, 0],
 Output: 0.

nput: [0, 0, 8, 0, 0], Output: 0. */
import java.util.*;
class Appeared
{
    public static int majority(int[] num)
    {
        int n=num.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        int maj=n/2;
        for(int i=0;i<n;i++)
        {
           hm.put(num[i],hm.getOrDefault(num[i],0)+1);
        }
        for(int i=0;i<n;i++)
        {
        if(hm.get(num[i])>maj)
        return num[i];
        }
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++)
        {
            num[i]=sc.nextInt();
        }
        int ans=majority(num);
        System.out.println(ans);
    }
}