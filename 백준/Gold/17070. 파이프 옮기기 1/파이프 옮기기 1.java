import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{

    static int[][] visit;
    static int[][] room;
    static int N;

    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        room = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 칸 마다 경우의 수
        visit = new int[N][N];
        visit[0][1] = 1;
        // 현재 위치
        int[] curr = {0, 1};
        // 현재 상태(가로G, 세로S, 대각선D)
        char status = 'G';
        // dfs 호출
        dfs(status, curr);


        System.out.println(visit[N - 1][N - 1]);
    }

    static void dfs(char status, int[] curr) {
        // 현재 끝 지점 좌표 담을 변수 x, y
        int x = curr[0];
        int y = curr[1];

        // 마지막 칸 도착했으면 리턴
        if (x == N - 1 && y == N - 1)
            return;

        // 가로
        if (status == 'G') {
            // 우로 이동 (y -> y + 1)
            if (y + 1 < N && room[x][y + 1] == 0) {
                visit[x][y + 1]++;
                dfs('G', new int[] {x, y + 1});
            }
            // 우하단으로 이동 (x -> x + 1, y -> y + 1)
            if (x + 1 < N && y + 1 < N &&
                    room[x][y + 1] == 0 && room[x + 1][y] == 0 && room[x + 1][y + 1] == 0) {
                visit[x + 1][y + 1]++;
                dfs('D', new int[] {x + 1, y + 1});
            }
        }
        //세로
        else if (status == 'S') {
            // 하단으로 이동 (x -> x + 1)
            if (x + 1 < N && room[x + 1][y] == 0) {
                visit[x + 1][y]++;
                dfs('S', new int[] {x + 1, y});
            }
            // 우하단으로 이동 (x -> x + 1, y -> y + 1)
            if (x + 1 < N && y + 1 < N &&
                    room[x][y + 1] == 0 && room[x + 1][y] == 0 && room[x + 1][y + 1] == 0) {
                visit[x + 1][y + 1]++;
                dfs('D', new int[] {x + 1, y + 1});
            }
        }
        // 대각선
        else {
            // 우로 이동 (y -> y + 1)
            if (y + 1 < N && room[x][y + 1] == 0) {
                visit[x][y + 1]++;
                dfs('G', new int[] {x, y + 1});
            }
            // 하단으로 이동 (x -> x + 1)
            if (x + 1 < N && room[x + 1][y] == 0) {
                visit[x + 1][y]++;
                dfs('S', new int[] {x + 1, y});
            }
            // 우하단으로 이동 (x -> x + 1, y -> y + 1)
            if (x + 1 < N && y + 1 < N &&
                    room[x][y + 1] == 0 && room[x + 1][y] == 0 && room[x + 1][y + 1] == 0) {
                visit[x + 1][y + 1]++;
                dfs('D', new int[] {x + 1, y + 1});
            }
        }
    }
}