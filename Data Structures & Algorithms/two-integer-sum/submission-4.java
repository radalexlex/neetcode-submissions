class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxToNumber = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            idxToNumber.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++) {
            Integer oppositeIdx = idxToNumber.get(target - nums[i]);
            if(oppositeIdx != null && oppositeIdx != i) {
                return new int[]{i,oppositeIdx};
            } 
        }

        return new int[]{0};
    }
}
