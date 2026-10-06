package t21_HashMaps;

public class l28 {
    static void main() {
        System.out.println(strStr("sadbutsad","sad"));
    }

    public static int strStr(String haystack, String needle) {
        int code = needle.hashCode();
        for (int index = 0; index < haystack.length()-needle.length()+1; index++) {
            String str  = haystack.substring(index,index+needle.length());
            if(str.hashCode() == code){
                boolean isMatched = false;
                for (int i = 0; i < needle.length(); i++) {
                    isMatched = haystack.charAt(index+i) == needle.charAt(i);
                    if(!isMatched){
                        break;
                    }
                }
                if (isMatched){
                    return index;
                }
            }
        }
        return -1;
    }
}
