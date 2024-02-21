import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {-1, 0, 1, 0};
    int max = 0;


    class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        Main lab = new Main();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] map = new int[x][y];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        lab.solution(map);
    }

    public void solution(int[][] map) {
        dfs(map, 0);
        System.out.println(max);
    }

    private void dfs(int[][] map, int depth){
        //depth
        //basecase
        if(depth == 3) {
            boolean[][] visited = new boolean[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == 1 || map[i][j] == 2) visited[i][j] = true;
                }
            }
            //벽이 3개가 세워지면 bfs 가기
            bfs(map, visited);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(map, depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void bfs(int[][] array, boolean[][] visited) {

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 2)
                    queue.add(new Point(i,j));
            }
        }

        while(!queue.isEmpty()){
            Point current = queue.remove();
            int cX = current.x;
            int cY = current.y;

            for (int i = 0; i < 4; i++) {
                int nX = cX + dirX[i];
                int nY = cY + dirY[i];
                if(nX < 0 || array.length-1 < nX || nY < 0 ||  array[0].length-1 < nY)
                    continue;
                if(visited[nX][nY])
                    continue;
                if(array[nX][nY]==1 || array[nX][nY]==2)
                    continue;
                visited[nX][nY] = true;
                queue.add(new Point(nX, nY));
            }
        }
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if(!visited[i][j]) count++;
            }
        }
        max = Math.max(max, count);
    }
}
