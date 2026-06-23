class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // idea is count the letters then
        // after receiving the count group them according to how
        // many letters they have

        Map<Map<Character, Integer>, List<String>> amountsToWords 
            = new HashMap<>(); 

        for(String str : strs) {
        
            Map<Character, Integer> letterAmount = new HashMap<>();

            for(char c : str.toCharArray()) { 
                Integer count = letterAmount.putIfAbsent(c,1);
                if(count != null) {
                    letterAmount.put(c, count + 1);
                }
            }

            if(!amountsToWords.containsKey(letterAmount)) {
                amountsToWords.put(letterAmount, new ArrayList<>());
            }
            
            amountsToWords.get(letterAmount).add(str);
        }

        return amountsToWords.values().stream().toList();

    }
}
