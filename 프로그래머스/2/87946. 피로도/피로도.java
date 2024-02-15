import java.util.*;

class Solution {
      public int solution(int k, int[][] dungeons) {
        int answer = 0;

        boolean[] visit = new boolean[dungeons.length];
        int depth = 0;
        List<Integer> list = new ArrayList<>();

        list = recursion(k, dungeons, answer, depth, visit, list);
        Collections.sort(list);
        return list.get(list.size()-1);
    }
    private List<Integer> recursion(int k, int[][] dungeons, int answer, int depth, boolean[] visit, List<Integer> list) {

        list.add(answer);

        if(depth == dungeons.length) return list;

        for(int j=0; j< dungeons.length; j++) {
                    if (!visit[j]) {
                        if (k >= dungeons[j][0]) {
                            visit[j] = true;
                            recursion(k - dungeons[j][1], dungeons, answer+1, depth + 1, visit, list);
                            visit[j] = false;
                        }
                    }
                }
                 return list;
    }
}