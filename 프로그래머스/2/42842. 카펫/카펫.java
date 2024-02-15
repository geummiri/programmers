class Solution {
        public int[] solution(int brown, int yellow) {
        //가로의 길이는 세로의 길이와 같거나 길다.

        int[] answer = new int[2];
        int x = 0;
        int y = 0;

        int sum = brown + yellow;
         for(int i=2; i<=sum/i; i++) {
            x = sum/i;
            y = i;
            if((x-2)*(y-2)==yellow &&((x*2) + (y*2))-4==brown){
            answer[0] = x;
            answer[1] = y;
            }
        }
        return answer;

    }
}