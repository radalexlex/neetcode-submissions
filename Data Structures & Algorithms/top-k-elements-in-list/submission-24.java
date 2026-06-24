class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
    
        Map<Integer, Integer> valueToFrequency = new HashMap<>();

        int maxFreq = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            Integer count = valueToFrequency.get(nums[i]);

            count = count == null ? 1 : count + 1;
            valueToFrequency.put(nums[i], count); 
        }

        Map<Integer, List<Integer>> frequencyToValues = new HashMap<>();

        for(Map.Entry<Integer, Integer> e : valueToFrequency.entrySet()) {
            Integer value = e.getKey();
            Integer frequency = e.getValue();

            List<Integer> values = frequencyToValues.computeIfAbsent(frequency, key -> new ArrayList<>());

            values.add(value);
            frequencyToValues.put(frequency, values);
        }

        int frequenciesMet = frequencyToValues.keySet().size();

        Integer[][] bucket = new Integer[frequenciesMet][];
        int counter = 0;

        for(Map.Entry<Integer, List<Integer>> e : frequencyToValues.entrySet()) {
            Integer frequency = e.getKey();
            List<Integer> values = e.getValue();

            bucket[counter++] = values.toArray(new Integer[]{});
        }

        int[] res = new int[k];
        counter = 0;

        for(int i = frequenciesMet - 1; i >= 0; i--) {
            for(int j = 0; j < bucket[i].length; j++) {
                res[counter++] = bucket[i][j];
                if(counter == k) {
                    return res;
                }
            }
        }

        return res;
        
    }
}
