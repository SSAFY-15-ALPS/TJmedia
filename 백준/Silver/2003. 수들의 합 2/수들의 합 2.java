import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터 같은 방향으로
        int left = 0;
        int right = 0;
        int curr = A[0];
        int answer = 0;
        while(right < N || left < N) {
            if (curr == M) {
                answer++;
                curr -= A[left++];
                if (++right == N) break;
                curr += A[right];
            }
            else if (curr < M) {
                if (++right == N) break;
                curr += A[right];
            }
            else curr -= A[left++];

        }

        // 정답 출력
        System.out.println(answer);

    }
  }
