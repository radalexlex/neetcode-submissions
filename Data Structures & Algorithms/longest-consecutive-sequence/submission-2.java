class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> deduplicatedNums = new HashSet<>();

        Arrays.stream(nums).forEach(e -> {
            deduplicatedNums.add(e);
        });

        Set<Integer> checkedNumbers = new HashSet<>();

        int longestSequence = 0;

        for(Integer i : deduplicatedNums) {
            if(!checkedNumbers.contains(i)) {
                int currentNegSequence = 0; // left elements
                int currentPosSequence = 0; // right elements
                int currentSequence = 1; // middle element

                checkedNumbers.add(i);
                int j = i - 1;

                while(deduplicatedNums.contains(j)) {
                    currentNegSequence++;
                    checkedNumbers.add(j--);
                }

                j = i + 1;

                while(deduplicatedNums.contains(j)) {
                    currentPosSequence++;
                    checkedNumbers.add(j++);
                }

                int currentTotalSequence = 
                    currentSequence
                    + currentNegSequence
                    + currentPosSequence;

                longestSequence = Math.max(longestSequence, currentTotalSequence);
            }
        }

        return longestSequence;

    }
}

    // e+1 - maximum in each sequence
    // o-1 - minimum in each sequence 

        // there must be some maximum e+1
        // there must be some minimum o-1

        //[]

        /*

            1. set of nums - no, there may be duplicates
            2. maybe a set, but then how to we adress duplicates? The duplicates are not counted! 
            Example checked: 

            Input: nums = [0,3,2,5,4,6,1,1]
            Output: 7: 0-1-2-3-4-5-6 = 7; 1-1 does not count

            main question per element - is there a +1 or -1 element anywhere?

            set = 0,3,2,5,4,6,1

            arr = 0,3,2,5,4,6,1,1

            0 +-1 ? yes - go to 1; 1 + 1 ? yes - go to 3

            -2 -1 0 1 2 3

            2 to the minus 
            3 to the plus 
            plus 1 in the middle

        */