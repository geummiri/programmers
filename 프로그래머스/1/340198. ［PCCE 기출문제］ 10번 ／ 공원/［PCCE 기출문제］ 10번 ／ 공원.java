import java.util.*;

class Solution {
    
    public int solution(int[] mats, String[][] park) {
        int answer= 0;
        int rows = park.length;
        int cols = park[0].length;
        int maxSize = -1;

        Arrays.sort(mats);

        for (int m = mats.length-1; m >= 0 ; m--) {
            boolean bool = false;
            for (int i = 0; i <= rows-mats[m]; i++) {
                for (int j = 0; j <= cols-mats[m]; j++) {
                    boolean allMinusOne = true;

                    for (int x = i; x < i + mats[m]; x++) {
                        for (int y = j; y < j + mats[m]; y++) {
                            if (!park[x][y].equals("-1")) {
                                allMinusOne = false;
                                break;
                            }
                        }
                        if (!allMinusOne) break;
                    }
                    if (allMinusOne){
                        bool = true;
                        break;
                    }
                }
                if(bool) break;
            }
            if(bool){
                maxSize = mats[m];
                break;
            }
        }
        return maxSize;
    }
}