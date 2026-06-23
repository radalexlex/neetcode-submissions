class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>(); 
        
        int i = 0, j = nums.length - 1;

        for(; i < j; i++, j--) {    
            int a = nums[i];
            int b = nums[j];

            if(a == b || unique.contains(a) || unique.contains(b)) {
                return true;
            }
            
            unique.add(a);
            unique.add(b);
        }
        
        if(nums.length % 2 != 0) {
            return unique.contains(nums[i]);
        }

        return false;
        
    }
}