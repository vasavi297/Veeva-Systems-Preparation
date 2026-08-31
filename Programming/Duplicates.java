import java.util.*;
class Duplicates
{
    static ArrayList<Integer> findDuplicates(int arr[],int n)
    {
       ArrayList<Integer>al=new ArrayList<>();
       HashMap<Integer,Integer>hm=new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
          hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
       }
       for(int key:hm.keySet())
       {
          if(hm.get(key)==2)
          {
            al.add(key);
          }
       }
       return al;
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
        ArrayList<Integer>res=findDuplicates(arr,n);
        System.out.println("The Duplicate Elements are : "+res);
    }
}