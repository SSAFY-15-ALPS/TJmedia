import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, S;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());       

        // 배열 입력 받기
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int answer = N + 1;
        while (right < N || left < N) {
            // 조건 만족 (부분합이 S 초과)
            if (sum > S) {
                // 부분합을 이루는 수열의 길이 len
                int len = right - left + 1;
                if (len < answer) answer = len;
                // 왼쪽 한 칸 땡기기
                sum -= arr[left++];
            }
            // 조건 불만족 (부분합이 S 미만)
            else if (sum < S) {
                // 종료 조건: right가 범위 벗어남
                if (right == N - 1) break;
                // 오른쪽 한 칸 미루기
                sum += arr[++right];
            }
            // 조건 만족 (부분합이 S와 같음)
            else { // sum == S
                // 부분합을 이루는 수열의 길이 len
                int len = right - left + 1;
                if (len < answer) answer = len;
                // 종료 조건: right가 범위 벗어남
                if (right == N - 1) break;
                // 왼쪽 한 칸 땡기고 오른쪽 한 칸 미루기
                sum -= arr[left++];
                sum += arr[++right];
            }
            // 오른쪽이 S보다 큰 값 만나서 멈춰있는 경우 방지
            if (left > right) right++;
        }

        // 정답 출력
        if (answer == N + 1) answer = 0;
        System.out.println(answer);
    }
  }
