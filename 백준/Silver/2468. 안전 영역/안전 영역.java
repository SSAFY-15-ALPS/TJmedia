import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        int[][] place = new int[N][N];
        int max = 0; // 최고봉
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                if (place[i][j] > max) max = place[i][j];
            }
        }

        // 정답 answer
        int answer = 1;

        // 방문 처리 배열
        boolean[][] visited = new boolean[N][N];

        // 안전지대인가?
        boolean safe;
        // 안전지대 개수
        int cnt = 0;

        for (int rain = 1; rain < max; rain++) {
            // 매 강수량마다 초기화
            safe = false;
            cnt = 0;
            Deque<int[]> q = new ArrayDeque<>();
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (place[i][j] > rain && !visited[i][j]) {
                        // 시작 위치 큐에 넣기
                        q.add(new int[] {i, j});
                        visited[i][j] = true;
                        safe = true;
                        while (!q.isEmpty()) {
                            int[] curr = q.poll();

                            // 방향
                            int[] dx = {1, -1, 0, 0};
                            int[] dy = {0, 0, 1, -1};

                            // 상하좌우 탐색
                            for (int k = 0; k < 4; k++) {
                                int nx = curr[0] + dx[k];
                                int ny = curr[1] + dy[k];
                                // 방문 가능하면 큐에 넣고 방문 처리
                                if (nx >= 0 && nx < N &&
                                        ny >= 0 && ny < N &&
                                        place[nx][ny] > rain && !visited[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                        // 안전지대 개수 세기
                        if (safe) cnt++;
                    }
                }
            }
            if (cnt > answer) answer = cnt;
        }
        // 정답 출력
        System.out.println(answer);
    }
}