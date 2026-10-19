class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        } else if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] amounts = new int[nums.length+1];

        amounts[0] = 0;
        amounts[1] = nums[0];

        for(int i = 2; i < nums.length+1; i++) {
            amounts[i] = Math.max(amounts[i-1], amounts[i-2] + nums[i-1]);
        }

        return amounts[nums.length];
        

        

        // 0 -> either 1 is the new norm or 2 as next from 0; standing at 2 - I either can get there from 0, or I can skip from 1?.. 
        // I have to allow automatically changing between choosing the house 1 and house 2 strategies, as one may yield more than the other 
        // and the concept is to steal as much as possible..

    }
}
