import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int D, K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 피보나치 수 구하기(A, B의 계수)
        int[] dp = new int[D];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < D; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // dp[D - 2] * A + dp[D - 1] * B = K 풀기
        int B = K / dp[D - 1] + 1;
        int A = B - 1;
        outer:
        for (; B > 0; B--) {
            for (A = B - 1; A > 0; A--) {
                // System.out.println("중간 점검\n" + A + "\n" + B);
                if (dp[D - 2] * A + dp[D - 1] * B == K) break outer;
            }
        }
        // 정답 출력
        System.out.println(A + "\n" + B);
    }
  }
