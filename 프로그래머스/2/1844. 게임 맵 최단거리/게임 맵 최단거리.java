import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;

        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[] now;
        
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            now = q.poll();
            if (now[0] == n - 1 && now[1] == m - 1) return maps[n - 1][m - 1];
            
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
                if (maps[nx][ny] == 0) continue;
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[now[0]][now[1]] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        return -1;
    }
}