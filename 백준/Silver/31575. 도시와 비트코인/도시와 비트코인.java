import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 지도 입력
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 큐 만들기
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        map[0][0] = 2;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            // 방향
            int[] dx = {1, 0};
            int[] dy = {0, 1};

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 갈 수 있으면 큐에 넣기
                if (nx >= 0 && ny >= 0 && nx < M && ny < N &&
                    map[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    map[nx][ny] = 2;
                }
            }
        }

        // 정답 출력
        if (map[M - 1][N - 1] == 2)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}