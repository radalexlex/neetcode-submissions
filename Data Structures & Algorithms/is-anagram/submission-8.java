class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int a = Character.getNumericValue('a'); 
        int[] sOcasions = new int [30];
        int[] tOcasions = new int [30];
// 114 - 97 = 17 = 1
// 97 - 97 = 0
        for(int i = 0; i < s.length(); i++) {
            ++sOcasions[Character.getNumericValue(s.charAt(i)) - a];
            ++tOcasions[Character.getNumericValue(t.charAt(i)) - a];
        }

        for(int i = 0; i < sOcasions.length; i++) {
            if(sOcasions[i] != tOcasions[i]) {
                return false;
            }
        }

        return true;
    
    }
}
