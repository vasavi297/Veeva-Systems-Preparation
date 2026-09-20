
/*Reverse Degree of a String
Given a string s, calculate its reverse degree.
The reverse degree is calculated as follows:
For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
Sum these products for all characters in the string.
Return the reverse degree of s.
Example 1:
Input: s = "abc"
Output: 148 */
class Reversedegreeofstring
{
    
    public int reverseDegree(String s) {
        int res=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int val='z'-s.charAt(i)+1;
            res+=(i+1)*val;
        }
        return res;
    }
}
