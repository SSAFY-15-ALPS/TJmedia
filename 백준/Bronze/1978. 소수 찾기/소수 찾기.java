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

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num;
            num = Integer.parseInt(st.nextToken());

            // 소수인가?
            boolean sosu = true;

            // 1은 소수가 아니야
            if (num == 1) sosu = false;
            
            // 2부터 (num / 2)까지 나눗셈 진행
            for (int div = 2; div <= num / 2; div++) {
                // 나누어 떨어지면 소수 아님
                if (num % div == 0) sosu = false;
            }

            // 소수 맞으면 카운팅
            if (sosu) answer++;
        }
        System.out.println(answer);
    }
  }
