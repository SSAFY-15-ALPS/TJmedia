import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    
    // 종이 배열
    static int[][] paper = new int[10][10];
    // 정답 색종이 개수 answer
    static int answer = 26;
    // 크기 당 색종이 개수 cnt
    static int[] cnt = new int[] {0, 5, 5, 5, 5, 5};
    
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 종이 입력
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // solve 함수 호출
        solve(0, 0, 0);

        // 1이 남아 있으면 -1
        if (answer == 26) answer = -1;
        // answer 출력
        System.out.println(answer);

    }

    // 좌표 (x, y)를 왼쪽 위 꼭짓점으로 하면서 (N * N) 크기 색종이를 붙일 수 있는지 검사
    static boolean possible(int x, int y, int N) {
        // 가능한?
        boolean possible = true;

        if (x + N > 10 || y + N > 10) return false;

        // 0이 있으면 불가능한
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (paper[x + i][y + j] == 0) possible = false;
            }
        }
        return possible;
    }

    // 좌표 (x, y)를 왼쪽 위 꼭짓점으로 하면서 (N * N) 크기 색종이 붙이기(0으로 만들기)
    static void color(int x, int y, int N) {
        // 범위는 이미 검증 됐으니 0으로 바꾸기만 해
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[x + i][y + j] = 0;
            }
        }
    }

    // 좌표 (x, y)를 왼쪽 위 꼭짓점으로 하면서 (N * N) 크기 색종이 떼기(1로 만들기)
    static void uncolor(int x, int y, int N) {
        // 범위는 이미 검증 됐으니 1로 바꾸기만 해
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[x + i][y + j] = 1;
            }
        }
    }

    static void solve (int x, int y, int depth) {
        // 가망 없음
        if (answer < depth) return;
        
        // 남은 1이 없나?
        boolean end = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j] == 1) {
                    end = false;
                }
            }
        }
        // 다 0이면 리턴
        if (end) {
            // 성공한 depth 중 가장 작은 값 answer에 저장
            if (answer > depth) answer = depth;
            return;
        }
        
        for (int i = x; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // 지금 칸이 1이면
                if (paper[i][j] == 1) {
                    // paper의 모든 칸에 대해서 큰 색종이부터 붙여보기
                    for (int N = 5; N > 0; N--) {
                        // 색종이 붙일 수 있으면 붙여
                        if (cnt[N] > 0 && possible(i, j, N)) {
                            // 붙이기
                            color(i, j, N);
                            cnt[N]--;
                            // 색종이 하나 붙여놓고 0 확정인 칸 건너 뛰고 재귀 호출
                            solve(i, j + 1, depth + 1);
                            // 백트래킹
                            uncolor(i, j, N);
                            cnt[N]++;
                        }
                    }
                    return;
                }
            }
        }
    }
}