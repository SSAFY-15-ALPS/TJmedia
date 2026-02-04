import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[][] dp;
            // num이 0일 때 (num + 1)개 만들면 outOfIndex 오류 남
            if (num == 0) {
                dp = new int[2][2];
            }
            // dp[num]가능 해야하니까 (num + 1)개 선언
            else {
                dp = new int[num + 1][2];
            }
            // 초기값 설정
            dp[0] = new int[] {1, 0};
            dp[1] = new int[] {0, 1};
            // num까지 돌기
            for (int j = 2; j <= num; j++){
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }
            System.out.println(dp[num][0] + " " + dp[num][1]);
        }

    }
  }
