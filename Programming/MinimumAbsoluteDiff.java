import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDiff {
    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>>al=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++)
        {
           int diff=arr[i+1]-arr[i];
           min=Math.min(min,diff);
        }
        for(int i=0;i<n-1;i++)
        {
            int diff=arr[i+1]-arr[i];
            if(diff==min)
            {
                al.add(new ArrayList<>(Arrays.asList(arr[i],arr[i+1])));
            }
        }
        return al;
    }
}

