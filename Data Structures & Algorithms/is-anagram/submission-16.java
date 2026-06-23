class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] sOcasions = new int[30];
        int a = Character.getNumericValue('a');

        for(int i = 0; i < s.length(); i++) {
            ++sOcasions[Character.getNumericValue(s.charAt(i)) - a];
            --sOcasions[Character.getNumericValue(t.charAt(i)) - a];
        }

        for(int i = 0; i < sOcasions.length; i++) {
            if(sOcasions[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
