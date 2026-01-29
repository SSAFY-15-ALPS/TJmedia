import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 토마토 배열 입력, 큐 초기값 입력
        int x = 0, y= 0;
        LinkedList<int[]> queue = new LinkedList<>();
        LinkedList<int[]> queue_copy = new LinkedList<>();
        int[][] tomato = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());    
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    x = i;
                    y = j;
                    queue.offer(new int[] {x, y});
                }
            }
        }

       // 다 익었나
        boolean isFill = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    isFill = false;
                }
            }
        }
        if (isFill) {
            System.out.println(0);
            return;
        }
        
        // 방향 정의
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
    
        // 토마토 익히기
        int day = 0;
        while (!queue.isEmpty()) {
            
            // 큐 복사
            int size = queue.size();
            for (int a = 0; a < size; a++) {
                queue_copy.offer(queue.poll());
            }
            for (int b = 0; b < size; b++) {
                int[] t = queue_copy.poll();
                // System.out.println(Arrays.toString(t));
                // 상하좌우 탐색 후 안 익은 것 큐에 넣기
                for (int k = 0; k < 4; k++) {
                    if (t[0] + dx[k] >= 0 && t[0] + dx[k] < M &&
                        t[1] + dy[k] >= 0 && t[1] + dy[k] < N &&
                        tomato[t[0] + dx[k]][t[1] + dy[k]] == 0) {
                        tomato[t[0] + dx[k]][t[1] + dy[k]] = 1;
                        queue.offer(new int[] {t[0] + dx[k], t[1] + dy[k]});
                    }    
                }
            }
            day++;
            
            // // 확인 출력
            // System.out.println("-----------------------");
            // System.out.println(day);
            // for (int i = 0; i < M; i++) {
            //   System.out.println(Arrays.toString(tomato[i]));
            // }
        }
        // 다 익었나
        boolean isFinish = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    isFinish = false;
                }
            }
        }
        if (isFinish) System.out.println(day-1);
        else System.out.println(-1);
    }
}