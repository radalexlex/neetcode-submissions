class Solution {

    public String encode(List<String> strs) {

        if(strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            int len = s.length();

            sb.append(len); 
            sb.append("#");
            sb.append(s);

            // the length ahead method - you give the parser 
            // the exact amount of steps that it will need to take
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        if(str.equals("")) {
            return res;
        }

        // "", "cad", "ba", "" --->  0#3#cad2#ba0#
        //                           0123456789
        int i = 0;

        StringBuilder strSb = new StringBuilder(str);
        StringBuilder futureLen = new StringBuilder();
        StringBuilder currentStr = new StringBuilder();

        while(i < str.length()) {
            char curr = strSb.charAt(i++);
            while(curr != '#') {
                futureLen.append(curr);
                curr = strSb.charAt(i++);
            }
            System.out.println(futureLen.toString());
            int len = Integer.parseInt(futureLen.toString());
            futureLen = new StringBuilder();
        
            res.add(strSb.substring(i, i + len));
            i = i + len;
        }

        return res;
    }
 }
