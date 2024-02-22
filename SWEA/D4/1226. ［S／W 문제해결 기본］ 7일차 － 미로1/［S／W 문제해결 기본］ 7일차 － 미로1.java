import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    
	public static void main(String args[]) throws Exception
	{
		 Scanner sc = new Scanner(System.in);

        int[][] maze = new int[16][16];
        for (int k = 0; k <10; k++) {
            int num = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < maze.length; i++){
                String str = sc.nextLine();
                for (int j = 0; j < maze.length; j++)
                    maze[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
                System.out.println();
                System.out.print("#" + num + " " + bfs(maze));
        }
    }

    //상하좌우 움직일수있도록 좌표 설정해주기
   
    public static int bfs(int[][] maze) {
        int[] dirX = {0, 1, 0, -1};
    	int[] dirY = {-1, 0, 1, 0};
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        //return 도착가능 1 노가능 0
        //1 벽은  true
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++)
                if(maze[i][j] == 1) visited[i][j] = true;

        Queue<int[]> queue = new LinkedList<>();

        //1 벽  0 길 2 시작점 3 도착점
        //시작지점 배열에 담아주기
        int x = 0;
        int y = 0;
        for (int i = 0; i < maze.length ; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        //시작점에서 0이 있는곳으로 출발하고 갔던 곳은 가지않기

        queue.add(new int[]{x,y});
        //queue에 넣어서 bfs확인하기
        while(!queue.isEmpty()) {
            int[] curr = queue.remove();
            x = curr[0];
            y = curr[1];
            for (int i = 0; i < 4; i++) {
                int currX = x + dirX[i];
                int currY = y + dirY[i];
                if(maze[currX][currY] == 3) return 1;
                if(visited[currX][currY]) continue;
                if(currX < 0 || maze.length-1 < currX || currY < 0 || maze[0].length-1 < currY) continue;
                if(maze[currX][currY] == 1) continue;
                visited[currX][currY] = true;
                queue.add(new int[]{currX, currY});
            }

        }
        return 0;
    }
}