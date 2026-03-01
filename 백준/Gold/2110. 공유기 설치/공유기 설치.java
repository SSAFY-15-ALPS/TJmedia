import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, C;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 집 위치 배열
        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            home[i] = Integer.parseInt(st.nextToken());
        }
        // 집 배열 정렬
        Arrays.sort(home);

        // 이분탐색
        int left = 0;
        int right = ((home[N - 1] - home[0]) / (C - 1)) + 1;
        int mid = (left + right) / 2;
        int answer = mid;
        while(left <= right) {
            // mid가 공유기 간격을 의미
            mid = (left + right) / 2;
            // 확인 출력
            // System.out.println("right, left, mid: " + right + ", " + left + ", " + mid);
            int cnt = 1;
            int curr = 0;
            int next = 1;
            while (next < N) {
                // 확인 출력
                // System.out.println("curr, next, cnt: " + curr + ", " + next + ", " + cnt);
                if (home[next] - home[curr] < mid) {
                    next++;
                }
                else {
                    cnt++;
                    next++;
                    curr = next - 1;
                }
            }
            
            // 공유기 C개만큼 못 놓았음ㅠ
            if (cnt < C) right = mid - 1;
            // 공유기 C개 이상 놓음!
            else {
                // 현재 개수를 정답에 저장하고
                answer = mid;
                // 개수 늘려보기
                left = mid + 1;
            }

        }
        // 정답 출력
        System.out.println(answer);
    }
}