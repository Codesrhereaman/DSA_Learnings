package Pratice.recursion;

public class findKthBitInNthBinaryString_ques1545 {
    static void main() {
        System.out.println(findKthBit(4,11));
    }



    static char findKthBit(int n, int k) {
        String s = findString(n).toString();
        System.out.println(s);
        return s.charAt(k-1);
    }

    static StringBuilder findString(int n) {
        if (n == 0) {
            return new StringBuilder();
        }
        if (n == 1) {
            return new StringBuilder("0");
        }
        StringBuilder prev = findString(n - 1);
        StringBuilder sb = new StringBuilder(prev);
        sb.append("1");
        sb.append(reverse(invert(prev)));
        return sb;
    }

    static String reverse(StringBuilder str) {
        return str.reverse().toString();
    }

    static StringBuilder invert(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
            } else {
                sb.setCharAt(i, '0');
            }
        }
        return sb;
    }


}
