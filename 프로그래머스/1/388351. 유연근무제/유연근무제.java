import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
       int answer = 0;
               for (int i = 0; i < schedules.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {

                int time = schedules[i] + 10;
                int min = time % 100;
                if (min >= 60) {
                    time = time - min;
                    min = min - 60;
                    time += (100 + min);
                }
                if ((startday+j) % 7 != 6 && (startday+j) % 7 != 0) {
                    if (timelogs[i][j] > time)
                        break;
                }
                if (j == 6)
                    answer++;
            }
        }
        return answer;
    }
}