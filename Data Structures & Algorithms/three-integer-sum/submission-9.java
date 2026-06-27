class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // [-1,0,1,2,-1,-4]
        int leftmost = 0;
        int left = 1;
        int right = nums.length - 1;

        List<List<Integer>> resultArrays = new ArrayList<>();

        Arrays.sort(nums);
        
        if((nums[right] == 0 && nums[right - 1] < 0) || (nums[0] == 0 && nums[1] > 0)) {
            return resultArrays;
            // impossible to create a 0 via triplet 
            // if there are not only 0s or different-signed numbers
        }

        // [-4,-1,-1,0,1,2]
        while(leftmost < nums.length - 2) {
            if(!(leftmost - 1 >= 0 && nums[leftmost] == nums[leftmost-1])) {
                while(left < right) {
                    boolean hasDuplicate = false;
                    while(left != leftmost + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        hasDuplicate = true;

                    }
                    while(right + 1 != nums.length && nums[right] == nums[right + 1]) {
                        right--;
                        hasDuplicate = true;
                    }

                    if(hasDuplicate) {
                        continue;
                    }

                    int res = nums[leftmost] + nums[left] + nums[right];

                    if(res == 0) {
                        resultArrays.add(List.of(nums[leftmost] ,nums[left++] ,nums[right--]));
                        // make sure it's not stuck
                    } else if(res > 0) {
                        right--;
                    } else {
                        left++;
                    }
                    
                }
            }
            leftmost++;
            left = leftmost + 1;
            right = nums.length - 1;
        }

        return resultArrays;
    }

  
}


