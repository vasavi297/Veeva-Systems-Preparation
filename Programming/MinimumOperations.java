/*You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums 
and subtract its value from x.Note that this modifies the array for future operations.
Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.*/
class MinimumOperations {
    public int minOperations(int[] nums, int x) {
    int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int target = totalSum - x;
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int windowSum = 0;
        int maxlen = -1;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            while (windowSum > target) {
                windowSum -= nums[left];
                left++;
            }
            if (windowSum == target) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
        }
        if (maxlen == -1) {
            return -1;
        }
        return nums.length - maxlen;
    }
}
