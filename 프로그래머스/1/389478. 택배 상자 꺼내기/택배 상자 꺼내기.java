import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int count = 1;
        int index = this.index(n, w);
        int[][] array = new int[index][w];
        for (int i = 0; i<index; i++) {
            if (i % 2 == 0){//왼쪽 -> 오른쪽
                for (int j = 0; j < w; j++) {
                    array[i][j] = count++;
                }
            } else { //오른쪽 -> 왼쪽
                for (int j = w-1; j >= 0 ; j--) {
                    array[i][j] = count++;
                }
            }
        }
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < w; j++) {
                if(num == array[i][j]){
                    if(n >= array[index-1][j]){
                        answer = index - i;
                    } else
                        answer = index - i - 1;
                }
            }
        }
     return answer;
    }
     public int index (int n , int m){
        int answer = n/m;
        if(n%m!= 0)
            answer++;
        return answer;
    }
}