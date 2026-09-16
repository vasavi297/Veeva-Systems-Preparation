/*Longest Substring Without Repeating Characters

Example:
s = "abcabcbb"
Output: 3 */
import java.util.*;
class Longestsubstring
{
    static int substring(String s)
    {
        int n=s.length();
        int left=0;
        int max=Integer.MIN_VALUE;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>1)
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
        return max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int ans=substring(s);
        System.out.println(ans);
    }
}