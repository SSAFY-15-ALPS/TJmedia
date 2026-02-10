import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        boolean[][] visited = new boolean[N][N];    
        
        solve(N, visited, 0);

        System.out.println(cnt);
    }

    static void solve(int N, boolean[][] visited, int depth) {
        // N개의 퀸을 모두 놓았으면 cnt++하고 리턴
        if (depth >= N) {
            cnt++;
            return;
        }

        // 퀸 놓을 수 있는지 검사하는 로직 시작---------------
        int i = depth;
        outer:
        for (int j = 0; j < N; j++) {
            // 공격할 수 없는 위치인가
            // 세로 탐색
            for (int k = 0; k < i; k++) {
                if (visited[k][j]) {
                    continue outer;
                }
            }
            // 좌상향 대각선 탐색
            int c = i, r = j;
            
            while (c >= 0 && r >= 0) {
                if (visited[c][r]) {
                    continue outer;
                }
                c--;
                r--;
            }
            // 우상향 대각선 탐색
            c = i; r = j;
            while (c >= 0 && r < N) {
                if (visited[c][r]) {
                    continue outer;
                }
                c--;
                r++;
            }
        // 퀸 놓을 수 있는지 검사하는 로직 끝---------------
        
            // 놓을 수 있는(공격할 수 없는) 위치다!! -> 방문처리
            visited[i][j] = true;

            // 다음 퀸 호출
            solve(N, visited, depth + 1);

            // 백트래킹
            visited[i][j] = false;
        }
        
    }
}