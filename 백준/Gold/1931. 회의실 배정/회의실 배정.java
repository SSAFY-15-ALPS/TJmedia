import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 회의실 입력
        int[][] room = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            room[i][0] = x;
            room[i][1] = y;
        }

        // 끝나는 시간 기준으로 정렬
        Arrays.sort(room, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        // 회의 몇 개인지 세기
        int answer = 1;
        int time = room[0][1];
        for (int i = 1; i < N; i++) {
            if (time > room[i][0]) continue;
            answer++;
            time = room[i][1];
        }

        // 정답 출력
        System.out.println(answer);
    }
}