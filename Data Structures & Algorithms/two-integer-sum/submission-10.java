class Solution {
    public int[] twoSum(int[] nums, int target) {
Map<Integer, Integer> numToIdx = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
int complement = target - nums[i];

            // Проверяем блокнот ЗАДОЛГО до того, как заполнили его целиком
            if (numToIdx.containsKey(complement)) {
                return new int[]{numToIdx.get(complement), i};
            }

            // Если не нашли, записываем текущее число "на будущее"
            numToIdx.put(nums[i], i);
        }


        return new int[]{0};
    }
}
