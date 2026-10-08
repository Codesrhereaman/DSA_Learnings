package t21_HashMaps;

import java.util.HashMap;
import java.util.Map;

public class l_387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int val = map.getOrDefault(ch,0);
            map.put(ch,val+1);
        }
        for (int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;

    }

    public int firstUniqChar2(String s) {
        int[] freq = new int[256];
        for(char ch:s.toCharArray()){
            freq[ch -'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
