class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length <= 1) {
            return false;
        } else {
            Arrays.sort(nums);
            for(int i = 0, j = 1; j < nums.length; i++, j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}