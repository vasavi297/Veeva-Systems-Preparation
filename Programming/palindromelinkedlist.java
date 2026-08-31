import java.util.*;
public class palindromelinkedlist {
    static boolean isPalindrome(int[] arr) 
    {
        LinkedList<Integer>ll=new LinkedList<>();
        for(int i=0;i<arr.length;i++)
        {
            ll.add(arr[i]);
        }
        int start=0;
        int end=ll.size()-1;
        while(start<end)
        {
            if(!ll.get(start).equals(ll.get(end)))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
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
        boolean res=isPalindrome(arr);
        if(res)
        {
            System.out.println("The Linked List is Palindrome");
        }
        else
        {
            System.out.println("The Linked List is Not Palindrome");
        }
    }
    
}
