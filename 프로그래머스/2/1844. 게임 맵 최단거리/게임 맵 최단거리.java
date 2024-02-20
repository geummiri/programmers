import java.util.*;

class Solution {
    
   int[] dirRow = {0,1,0,-1};
    int[] dirCol = {-1,0,1,0};
    public int solution(int[][] map) {
        return bfs(map, new boolean[map.length][map[0].length]);
    }
    
    private int bfs(int[][] map, boolean[][] visited) {
        int count = 1;
        int cRow = 0;
        int cCol = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cRow, cCol, count});
        while(!queue.isEmpty()) {
            int[] current = queue.remove();
            cRow = current[0];
            cCol = current[1];
            count = current[2];
            if(cRow==map.length-1 && cCol==map[0].length-1)
                return count;
            visited[cRow][cCol] = true;
            for(int i=0; i<4; i++) {
                int nRow = cRow + dirRow[i];
                int nCol = cCol + dirCol[i];
                if(nRow < 0 || map.length-1 < nRow || nCol < 0 || map[0].length-1 < nCol)
                    continue;
                if(visited[nRow][nCol])
                    continue;
                if(map[nRow][nCol]==0)
                    continue;

                visited[nRow][nCol] = true;
                queue.add(new int[]{nRow, nCol, count+1});
            }
        }
        return -1;
    }
}