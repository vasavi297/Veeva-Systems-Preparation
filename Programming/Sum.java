import java.util.*;
public class Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>al=new ArrayList<>();
        Set<List<Integer>>hs=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
           int j=i+1;
           int k=nums.length-1;
           while(j<k)
           {
            int sum=nums[i]+nums[j]+nums[k];
            if(sum==0)
            {
                hs.add(Arrays.asList(nums[i],nums[j],nums[k]));
                k--;
            }
            else if(sum<0)
            {
                j++;
            }
            else
            {
                k--;
            }
        } 
    }
    al.addAll(hs);
    return al;
    }
}
