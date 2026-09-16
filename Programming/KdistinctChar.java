/*Longest Substring with At Most K Distinct Characters

Example:
s = "eceba", k = 2
Output: 3 */
import java.util.*;
class KdistinctChar
{
    static int kdistinct(String s,int k)
    {
        int n=s.length();
        int left=0;
        int max=Integer.MIN_VALUE;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()>k)
            {
              char rem=s.charAt(left);
              hm.put(rem,hm.get(rem)-1);
              if(hm.get(rem)==0)
              {
                hm.remove(rem);
              }
              left++;
            }
            max=Math.max(max,i-left+1);
        }
        return max==Integer.MIN_VALUE?0:max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        int ans=kdistinct(s,k);
        System.out.println(ans);
    }
}