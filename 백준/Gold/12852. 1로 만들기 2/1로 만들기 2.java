import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 리스트 배열 만들기
        ArrayList<Integer>[] dp = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            dp[i] = new ArrayList<>();
        }
        // 계산할 숫자 큐
        Deque<Integer> q = new LinkedList<>();
        // 1에서 시작
        int i = 1;
        dp[1].add(1);
        q.offer(1);
        // dp 채우기
        while (dp[N].isEmpty()) {
            // 큐에서 하나 꺼내서
            int curr = q.poll();
            // 1 더해보고
            if (curr + 1 < N + 1 && dp[curr + 1].isEmpty()) {
                dp[curr + 1].addAll(dp[curr]);
                dp[curr + 1].add(curr + 1);
                q.offer(curr + 1);
            }
            // 2 곱해보고
            if (curr * 2 < N + 1 && dp[curr * 2].isEmpty()) {
                dp[curr * 2].addAll(dp[curr]);
                dp[curr * 2].add(curr * 2);
                q.offer(curr * 2);
            }
            // 3 곱해보고
            if (curr * 3 < N + 1 && dp[curr * 3].isEmpty()) {
                dp[curr * 3].addAll(dp[curr]);
                dp[curr * 3].add(curr * 3);
                q.offer(curr * 3);
            }
        }
        // 정답 출력
        System.out.println(dp[N].size() - 1);
        for (int j = dp[N].size() - 1; j >= 0; j--) {
            System.out.print(dp[N].get(j) + " ");
        }
    }
}