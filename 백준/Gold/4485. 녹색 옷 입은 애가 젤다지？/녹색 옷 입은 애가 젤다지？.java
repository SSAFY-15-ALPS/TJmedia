import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int rupee = 0;

    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            // 종료 조건
            if (N == 0) break;

            // 맵 입력
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for  (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 방문배열, 루피 초기화
            visited = new boolean[N][N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  a[2] - b[2]);

            // 시작하는 칸
            pq.offer(new int[]{0, 0, map[0][0]});
            visited[0][0] = true;

            // 다익스트라 시작
            while (!pq.isEmpty()) {
                // 하나 뽑고
                int[] curr = pq.poll();
                int x = curr[0];
                int y = curr[1];
                int point = curr[2];
                // 마지막 칸 도착하면 리턴
                if (x == N - 1 && y == N - 1) {
                    rupee = point;
                    break;
                }

                // 방향
                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0, -1, 1};

                // 4방향 탐색
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                        pq.offer(new int[]{nx, ny, point + map[nx][ny]});
                        visited[nx][ny] = true;
                    }
                }
            }
            System.out.println("Problem " + ++cnt + ": " + rupee);
        }
    }
}
