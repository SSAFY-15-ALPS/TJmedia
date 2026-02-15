import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{

    static int n, m;
    // 그림 면적 계산하는 변수 cnt
    static int cnt;
    // 그림 면적 cnt를 기록하는 리스트 answer
    static List<Integer> answer = new ArrayList<>();
    // 도화지 배열
    static int[][] paper;
    // 방문처리
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // paper 입력 받기
        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // paper의 모든 1에 대해서 dfs 호출
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    // dfs 결과 그림의 크기가 0이 아니면 answer에 추가
                    if (cnt != 0) answer.add(cnt);
                }
            }
        }
        
        // 정답 출력
        System.out.println(answer.size());
        Collections.sort(answer);
        if (answer.size() == 0) System.out.println(0);
        else System.out.println(answer.get(answer.size() - 1));

    }

    // dfs 함수 정의
    static void dfs(int x, int y) {
        
        // 방문했던 칸이면 바로 리턴
        if (visited[x][y])
            return;
        
        // 현재 칸 방문 처리 및 그림 크기 +1
        visited[x][y] = true;
        cnt++;

        // 방향 설정
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 상하좌우 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 벗어나지 않으면서 paper가 1이면
            if (nx >= 0 && nx < n &&
                ny >= 0 && ny < m &&
                paper[nx][ny] == 1) {
                // dfs 재귀 호출
                dfs(nx, ny);
                }
        }
        
    }
  }