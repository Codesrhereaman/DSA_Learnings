package t21_HashMaps;

import java.util.*;

public class l_127 {
    static void main() {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(beginWord.equals(endWord)){
            return 0;
        }
        if(!words.contains(endWord)) return 0;
        //using hashset to mark if I had visited the string once or not
        Set<String> visited  = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int ans = 0;

        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for (int i=0; i<size;i++) {
                String current = q.poll();
                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char ch = 'a';ch<='z';ch++){
                        temp[j] = ch;
                        String str = new String(temp);
                        if(str.equals(endWord)) return ans+1;
                        if(words.contains(str) && !visited.contains(str)){
                            visited.add(str);
                            q.offer(str);
                        }
                    }
                }

            }
        }
        return 0;
    }



    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        return helper(beginWord, endWord, wordList);
    }

    public int helper(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();

        if (beginWord.equals(endWord)) {
            return 1;
        }

        q.offer(beginWord);

        int ans = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String previous = q.poll();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String current = it.next();
                    if (doesItDifferByOne(previous, current)) {
                        if (current.equals(endWord)) {
                            return ans + 1;
                        }
                        q.offer(current);
                        it.remove();
                    }
                }
            }

            ans++;
        }

        return 0;
    }

    private boolean doesItDifferByOne(String previous, String current) {
        int diff = 0;
        for (int i = 0; i < previous.length(); i++) {
            if (previous.charAt(i) != current.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}
