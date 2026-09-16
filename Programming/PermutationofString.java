/*Permutation in String
Determine whether s2 contains a permutation of s1.
Example:
s1 = "ab"
s2 = "eidbaooo"
Output = true */
import java.util.*;
public class PermutationofString {

    static boolean permutation(String s1, String s2)
{
    int k = s1.length();
    int left = 0;

    HashMap<Character, Integer> hm1 = new HashMap<>();
    HashMap<Character, Integer> hm2 = new HashMap<>();

    for(int i = 0; i < k; i++)
    {
        hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
    }

    for(int i = 0; i < s2.length(); i++)
    {
        char ch = s2.charAt(i);
        hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);

        if(i - left + 1 == k)
        {
            if(hm1.equals(hm2))
            {
                return true;
            }

            char rem = s2.charAt(left);
            hm2.put(rem, hm2.get(rem) - 1);

            if(hm2.get(rem) == 0)
            {
                hm2.remove(rem);
            }

            left++;
        }
    }

    return false;
}

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        boolean ans=permutation(s1,s2);
        System.out.println(ans);
    }
    
}
