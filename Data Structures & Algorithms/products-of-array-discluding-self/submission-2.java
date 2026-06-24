class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] multAZ = new int[n];
        int[] multZA = new int[n];
        int[] result = new int[n];

        multAZ[0] = nums[0];        // [1...]
        multZA[n-1] = nums[n-1];    // [...6]    

        for(int i = 1, j = n-2; i < n && j >= 0; i++, j--) {
            multAZ[i] = multAZ[i-1] * nums[i]; // [1...] -> [1,2..] -> [1,2,8.] -> [1,2,8,48]
            multZA[j] = multZA[j+1] * nums[j]; // [...6] -> [..24,6] -> [.48,24,6] -> [48,48,24,6]
        }

        //      -
        // [1,  2,  4,  6] START
        // [1,  2,  8, 48] L-R
        // [48, 48, 24, 6] R-L

        for(int i = 0; i < n; i++) {
            int a = i - 1;
            int b = i + 1;

            if(a < 0) {
                result[i] = multZA[b];
            } else if (b >= n) {
                result[i] = multAZ[a];
            } else {
                result[i] = multAZ[a] * multZA[b];
            }
        }

        return result;

    }
}  
