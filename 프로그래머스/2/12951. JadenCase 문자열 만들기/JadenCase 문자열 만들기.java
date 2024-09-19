import java.util.*;

class Solution {
    public String solution(String s) {
       String answer = "";
       String[] arr = s.split(" ");
       char ch = s.charAt(s.length()-1);

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String newStr = "";
            
            if(str.equals("")) {
                newStr += "";
                if (i == arr.length - 1) answer += newStr;
                else answer += newStr + " ";
                continue;
            }
            
            Character ch1 = str.charAt(0);
            if (ch1 > 90 && !Character.isDigit(ch1))
                ch1 = Character.toUpperCase(ch1);
            newStr += String.valueOf(ch1);

            for (int k = 1; k < str.length(); k++) {
                Character ch2 = str.charAt(k);
                if(ch2 <= 90)
                    ch2 = Character.toLowerCase(ch2);
                newStr += String.valueOf(ch2);
            }
            answer += newStr + " ";
            }
        
        if(ch == ' ')
            return answer;

        return answer.trim();
    }
}