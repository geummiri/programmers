import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
       int[] answer = new int[targets.length];
       Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if(map.containsKey(keymap[i].charAt(j))) {
                    Integer nCurrCnt = map.get(keymap[i].charAt(j));
                    if(nCurrCnt > (j+1)) {
                        map.put(keymap[i].charAt(j), j+1);
                        }
                    } else {
                      map.put(keymap[i].charAt(j), j+1);
                }
             }
            }
        for (int i = 0; i < targets.length; i++) {
            int nCnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char alpha = targets[i].charAt(j);
                Integer targetCnt = map.get(alpha);
                if(targetCnt != null) {
                    nCnt += targetCnt;
                } else {
                    nCnt = -1;
                    break;
                }
            }
            answer[i] = nCnt;
        }
        return answer;    
        
    }
}


