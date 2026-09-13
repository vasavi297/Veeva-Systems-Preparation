/*Find the frequency of each character in a given string.
Input: "programming"
Output: 
p: 1, r: 2, o: 1, g: 2, a: 1, m: 2, i: 1, n: 1
Input: "Hello" 
Output: H: 1, e: 1, l: 2, o: 1
Input: "abcde"
Output: a: 1, b: 1, c: 1, d: 1, e: 1
Input: "aaaaa"
Output: a: 5
Input: "z"
Output: z: 1
Input: "a b c"
Output: ' ': 2, a: 1, b: 1, c: 1
Input: "a!@a#"
Output: a: 2, '!': 1, '@': 1, '#': 1
Input: "ab121\n"
Output: a: 1, b: 1, '1': 2, '2': 1, '\n': 1 */
import java.util.*;
class Freqofeach
{
    public static void freq(String s)
    {
        int n=s.length();
        char[] arr=s.toCharArray();
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Character,Integer>e:hm.entrySet())
        {
            System.out.println(e.getKey()+ ":" +e.getValue());
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        freq(s);
    }
}