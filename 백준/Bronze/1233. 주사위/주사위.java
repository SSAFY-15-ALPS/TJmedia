import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int A, B, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 숫자 조합 구하기
        int[] sum = new int[A + B + C + 1];
        for (int a = 1; a <= A; a++) {
            for (int b = 1; b <= B; b++) {
                for (int c = 1; c <= C; c++) {
                    sum[a + b + c]++;
                }
            }
        }

        // 제일 많이 나온 값 찾기
        int max = 0;
        int answer = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > max) {
                max = sum[i];
                answer = i;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }
  }
