import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int x, y,  z;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        // 방문처리 배열
        int[][][] visited = new int[z][y][x];

        // 익은 토마토 넣을 큐
        Deque<int[]> q = new ArrayDeque<>();
        
        // 토마토 배열 입력 받기
        int[][][] tomato = new int[z][y][x];
        for (int k = 0; k < z; k++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < x; i++) {
                    tomato[k][j][i] = Integer.parseInt(st.nextToken());
                    if (tomato[k][j][i] == 1) {
                        visited[k][j][i] = 1;
                        q.add(new int[] {i, j, k});
                    }
                }
            }
        }

        // 방향 설정
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        while (!q.isEmpty()) {

            // 큐에서 하나 꺼내옴 <- 지금 칸
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int k = curr[2];

            // 인접한 칸 탐색
            for (int d = 0; d < 6; d++) {
                int nx = i + dx[d];
                int ny = j + dy[d];
                int nz = k + dz[d];

                // 인접한 칸이 (배열 안 벗어나고), (벽이 아니고), (방문한 적 없으면)
                if (nx >= 0 && nx < x &&
                       ny >= 0 && ny < y &&
                       nz >= 0 && nz < z &&
                       tomato[nz][ny][nx] != -1 &&
                       visited[nz][ny][nx] == 0) {

                    // 방문처리
                    visited[nz][ny][nx] = visited[k][j][i] + 1;
                    tomato[nz][ny][nx] = 1;
                    // 큐에 넣기
                    q.add(new int[] {nx, ny, nz});
                   }
            }
        }

        // 토마토 다 익었나?
        for (int k = 0; k < z; k++) {
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    if (tomato[k][j][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        
        // 토마토 며칠만에 다 익었나?
        int answer = 0;
        for (int k = 0; k < z; k++) {
            for (int j = 0; j < y; j++) {
                for (int i = 0; i < x; i++) {
                    if (visited[k][j][i] > answer) {
                        answer = visited[k][j][i];
                    }
                }
            }
        }

        // 정답 출력
        System.out.println(answer - 1);
    }
  }