import java.util.*;
class RotateArray
{
    public static ArrayList<String>rotate(String[] arr,int k)
    {
        int n=arr.length;
        ArrayList<String>al=new ArrayList<>();
        for(String s:arr)
        {
         if(arr.length==1)
        {
            al.add(s);
        }
        }
        for(int i=0;i<n;i++)
        {
            al.add(arr[(i+k)%n]);
        }
     return al;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next();
        }
        int k=sc.nextInt();
        ArrayList<String>al=rotate(arr,k);
      System.out.println(al);
    }
}
