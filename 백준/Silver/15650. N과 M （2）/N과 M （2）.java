import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 정답 배열
    static int[] answer;
    // 사용 처리 배열
    static boolean[] used;
    
    public static void main(String[] args) throws IOException {
    
        // 입력 받기
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        answer = new int[M];
        used = new boolean[N + 1];
        
        solve(N, M, 0);
    }
    
    
    public static void solve(int N, int M, int depth) {
        if (depth == M) {
            for (int k = 0; k < answer.length; k++) {
                System.out.print(answer[k] + " ");
            }
            System.out.println("");
            return;
        }

        
        for (int i = 1; i <= N; i++) {
            // 이미 쓴 숫자면 컨티뉴
            if (depth > 0 && used[i]) {
                continue;
            }

            // 오름차순 아니면 컨티뉴
            if (depth > 0 && answer[depth - 1] > i) {
                continue;
            }

            // i를 depth번째 숫자로 선택하고
            answer[depth] = i;
            // i는 사용 처리
            used[i] = true;

            // 그 상태로 다음 depth 호출
            solve(N, M, depth + 1);

            // 백트래킹
            answer[depth] = 0;
            // 사용 안함 처리
            used[i] = false;
        }
    }
}