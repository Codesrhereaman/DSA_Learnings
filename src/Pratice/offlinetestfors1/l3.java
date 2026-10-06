package Pratice.offlinetestfors1;

import java.util.HashMap;
import java.util.Map;

public class l3 {
    static void main() {
        String s = "abcabcbb";
        System.out.println(maxLength(s));
    }


    public static int maxLength(String s) {
        if(s.length()<=1) return s.length();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character,Integer> map  = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(map.get(c)+1,left);
            }
            map.put(c,i);
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;
    }
}
