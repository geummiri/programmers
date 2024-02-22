import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] sum = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i%5]) sum[0]++;
            if(answers[i] == b[i%8]) sum[1]++;
            if(answers[i] == c[i%10]) sum[2]++;
        }


        List<Integer> list = new ArrayList<>();

        int max = Math.max(Math.max(sum[0], sum[1]), sum[2]);
        if(max == sum[0]) list.add(1);
        if(max == sum[1]) list.add(2);
        if(max == sum[2]) list.add(3);
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}