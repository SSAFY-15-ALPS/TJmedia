import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        // N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        int[][] danji = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                danji[i][j] = str.charAt(j) - '0';
            }
        }

        // 방문처리 배열
        boolean[][] visited = new boolean[N][N];

        // bfs 돌면서 단지 찾기
        Deque<int[]> q = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (danji[i][j] == 1 && visited[i][j] == false) {
                    // cnt 초기화
                    int cnt = 1;
                    // 1이면서 방문 안 한 칸이면 큐에 넣기
                    q.add(new int[] {i, j});
                    visited[i][j] = true;

                    // bfs 시작
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();

                        // 방향 설정
                        int[] dx = {1, -1, 0, 0};
                        int[] dy = {0, 0, 1, -1};

                        // 범위 내에 있고 1이면서 방문 안했으면
                        for (int k = 0; k < 4; k++) {
                            int nx = curr[0] + dx[k];
                            int ny = curr[1] + dy[k];
                            if (nx >= 0 && nx < N &&
                                    ny >= 0 && ny < N &&
                                    danji[nx][ny] == 1 && visited[nx][ny] == false)	{
                                cnt++;
                                q.add(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    // bfs 끝 -> cnt를 answer 배열에 추가
                    if (cnt > 0) answer.add(cnt);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int a: answer) {
            System.out.println(a);
        }

    }
}