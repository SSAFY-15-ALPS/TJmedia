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

        // 전깃줄 담는 배열
        int[][] line = new int[N][2];
        // 전깃줄 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        // 0번 인덱스로 정렬
        Arrays.sort(line, (a, b) -> a[0] - b[0]);

        // LIS 구하기
        // dp 배열은 i번째까지 가장 긴 증가 수열
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (line[j][1] < line[i][1] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        // 정답 출력
        System.out.println(N - ans);
    }
}