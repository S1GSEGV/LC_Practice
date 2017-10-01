class Solution {
    
    public int findHelper(int[] nums, int Sum, int start) {
        if(start == nums.length) {
            if(Sum == 0)
                return 1;
            else
                return 0;
        }
            
        int left = findHelper(nums, Sum - nums[start], start + 1);
        int right = findHelper(nums, Sum + nums[start], start + 1);
        
        return left + right;
        
        
    }
    public int findTargetSumWays(int[] nums, int S) {
        return findHelper(nums, S, 0);
    }
}