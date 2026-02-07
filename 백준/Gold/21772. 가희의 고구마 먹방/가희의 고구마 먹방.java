import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class Main{
    static int max;
    static int R, C, T;
    static char[][] map;
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[] start = new int[2];

        // 배열 입력 받기
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'G') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        max = 0;
        search(start[0], start[1], 0, 0);
        System.out.println(max);

    }

    static void search(int x, int y, int time, int cnt) {
        // 시간 다 지나면 max를 출력
        if (time > T) {
            return;
        }

        // 고구마 있나?
        if (map[x][y] == 'S') {
            if (++cnt > max) {
                max = cnt;
            }
        }
        
        // 방향 설정
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 다음 갈 수 있는 칸 탐색
        for (int k = time; k <= T; k++) {

            // 고구마 먹으면 빈 칸
            boolean isSweet = false;
            if (map[x][y] == 'S') {
                isSweet = true;
                map[x][y] = '.';
            }
            
            for (int d = 0; d < 4; d++){
                if (x + dx[d] >= 0 && x + dx[d] < R
                    && y + dy[d] >= 0 && y + dy[d] < C
                    && map[x + dx[d]][y + dy[d]] != '#') {
                    search(x + dx[d], y + dy[d], k + 1, cnt);
                }
            }

            // 가고 나서 고구마 원복
            if (isSweet) map[x][y] = 'S';
        }
        
    }
  }
