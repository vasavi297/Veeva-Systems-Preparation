/*Repeating Pairs
You are given a string S consisting of lowercase English letters.
For every two adjacent characters in S, consider the pair they form. For example, the string "abca" contains the pairs "ab", "bc", and "ca".
A pair is called repeating if it appears at least twice in the string.
Your task is to find the number of distinct repeating pairs in S.
Input Format:
The first line contains a string S.
Output Format:
Print a single integer — the number of distinct consecutive character pairs that appear more than once.
Constraints:
1 ≤ |S| ≤ 10^5
S consists only of lowercase English letters.
Sample 1:
Input:
ababcabc
Output:
2
Explanation:
The consecutive pairs are:
ab, ba, ab, bc, ca, ab, bc
The pair "ab" appears 3 times and "bc" appears 2 times.
Therefore, there are 2 distinct repeating pairs.
Sample 2:
Input:
aaaa
Output:
1
Explanation:
The consecutive pairs are:
aa, aa, aa
Only the pair "aa" appears more than once.
Therefore, the answer is 1.*/

import java.util.*;
import java.lang.*;
import java.io.*;

class RepeatingPairs
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if (s == null || s.length() < 2) {
            System.out.println(0);
            return;
        }
        HashMap<String,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length()-1;i++)
        {
            String pair=s.substring(i,i+2);
            hm.put(pair,hm.getOrDefault(pair,0)+1);
        }
        int count=0;
        for(int value:hm.values())
        {
            if(value>1)
            {
                count++;
            }
        }
        System.out.println(count);
	}
}
