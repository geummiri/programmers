import java.util.*;
class Solution {
    int cnt = 0;
    int temp = 0;
        public int solution(String word) {
        recursion(word, "");
        return cnt;
    }

     private void recursion(String word, String str) {

        String[] words = {"A", "E", "I", "O", "U"};

        if (word.equals(str)) {
            cnt = temp;
            return;
        }
        if (words.length == str.length()) return;

        for (int i = 0; i < words.length; i++) {
            temp++;
            recursion(word, str + words[i]);
        }
    }
}
