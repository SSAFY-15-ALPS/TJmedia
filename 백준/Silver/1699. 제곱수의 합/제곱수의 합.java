import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    static int[] memo;
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // memo 배열 N + 1개 초기화
        memo = new int[N + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        // 정답 출력
        System.out.println(square(N));
    }

    static int square (int num) {
        // 제곱수면 1 리턴
        if (Math.sqrt(num) % 1 == 0) return 1;

        // 이전 메모에 적은 게 있으면 가져오기
        if (memo[num] != Integer.MAX_VALUE) return memo[num];

        // 제곱근 최대값
        int nextMax = (int) Math.sqrt(num);
        // 재귀 호출 횟수
        int next = nextMax;
        while (next > 0) {
            // 현재 계산 값 memo에 저장하면서 최소값 찾기
            int calc = 1 + square(num - (next * next));
            if (calc < memo[num]) memo[num] = calc;
            if (memo[num] == 2) break;
            next--;
        }
        
        // 정답 리턴
        return memo[num];
    }
  }