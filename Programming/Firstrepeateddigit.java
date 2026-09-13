/*Program: {3, 7, 8, 1, 8, 7}. 
What is the first repeated character? The answer is 8.
 From left to right,8 is repeated after 1, before the second 7. So the answer is 8. */
import java.util.*;
public class Firstrepeateddigit {
    static int repeated(int[] arr)
    {
    HashSet<Integer>hs=new HashSet<>();
    for(int i=0;i<arr.length;i++)
    {
        if(hs.contains(arr[i]))
        {
            return arr[i];
        }
        hs.add(arr[i]);
    }
    return -1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int ans=repeated(arr);
        System.out.println(ans);
    }
}
