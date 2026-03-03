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

        // 용액 입력 받기
        int[] sol = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(sol);
        
        // 투 포인터 세팅
        int left = 0;
        int right = sol.length - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        // 투 포인터 시작
        while (left < right) {
            // 합
            int sum = sol[left] + sol[right];
            // 합이 min보다 작으면 업데이트
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer = new int[] {sol[left], sol[right]};
            }
            // 0보다 크면 오른쪽 떙기고
            if (sum > 0) right--;
            // 0보다 작으면 왼쪽 땡기고
            else if (sum < 0) left++;
            // 0이면 바로 리턴
            else {
                answer = new int[] {sol[left], sol[right]};   
                break;
            }
        }

        // 정답 출력
        System.out.println(answer[0] + " " + answer[1]);
    }
  }