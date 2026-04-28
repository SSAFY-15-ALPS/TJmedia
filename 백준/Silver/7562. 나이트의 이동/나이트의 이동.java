import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        // 입력 받기
        int T, N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // 방문 처리
            boolean[][] visited = new boolean[N][N];

            // 몇 번 이동?
            int cnt = 0;
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(startX);
            q.offer(startY);
            q.offer(cnt);
            visited[startX][startY] = true;

            // bfs 돌기
            while (!q.isEmpty()) {
                int currX = q.poll();
                int currY = q.poll();
                int currCnt = q.poll();
                // 일치하면 끝
                if (currX == endX && currY == endY) {
                    System.out.println(currCnt);
                    break;
                }

                int nextCnt = currCnt + 1;

                // 방향
                int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
                int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};

                // 각 방향으로 가
                for (int i = 0; i < 8; i++) {
                    int nx = currX + dx[i];
                    int ny = currY + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        q.offer(nx);
                        q.offer(ny);
                        q.offer(nextCnt);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
