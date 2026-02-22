import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] mimon;
    static int R, C, T;
    static int ac2;
    
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        mimon = new int[R][C][2];
        
        // 미세먼지 배열 채우기
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                mimon[i][j][0] = Integer.parseInt(st.nextToken());
                // 공기청정기 아래 좌표 (i, 0) -> 위 좌표는 (i - 1, 0)
                if (mimon[i][j][0] == -1) ac2 = i;
            }
        }

        int answer = 0;
        for (int t = 0; t < T; t++) {
            // System.out.println(Arrays.deepToString(mimon));
            // System.out.println("-------------------------------------------------");
            spread();
            
            // System.out.println(Arrays.deepToString(mimon));
            // System.out.println("-------------------------------------------------");
    
            airClean();
            // System.out.println(Arrays.deepToString(mimon));
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += mimon[i][j][0];
            }
        }

        System.out.println(answer + 2);

    }

    // 확산 함수
    static void spread() {
        // mimon 배열 모든 값에 대해서 확산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                
                // 확산 횟수 초기화
                int cnt = 0;
                
                // 현재 칸 미세먼지 양
                int curr = 0;
                if (mimon[i][j][0] != -1) {
                    curr = mimon[i][j][0];
                    mimon[i][j][0] = 0;
                }

                // 네 방향 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 범위 체크, 현재 칸 0 이하면 패스, 다음 칸 공기청정기면 패스
                    if (nx >= 0 && nx < R &&
                        ny >= 0 && ny < C &&
                        curr > 0 && mimon[nx][ny][0] != -1) {
                        // 확산 가능하면 1/5 확산
                        mimon[nx][ny][1] += curr / 5;
                        // 확산 횟수 +1
                        cnt++;
                    }
                }     
                // 원래 칸에 확산되고 남은 미세먼지 저장
                mimon[i][j][1] += curr - ((curr / 5) * cnt);
            }
        }

        // mimon[i][j][1] -> mimon[i][j][0] 이동
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mimon[i][j][0] != -1) {
                    mimon[i][j][0] = mimon[i][j][1];
                    mimon[i][j][1] = 0;
                }
            }
        }
    }

    static void airClean() {
        // 공기청정기 위 칸 x좌표
        int ac1 = ac2 - 1;
        
        // ---------- 위 칸 반시계 공기청정 시작 ----------
        // 공기청정기 바로 위 칸 비우기
        mimon[ac1 - 1][0][0] = 0;
        // 0번 열 ↓
        for (int i = ac1 - 1; i > 0; i--) {
            mimon[i][0][0] = mimon[i - 1][0][0];
        }
        // 0번 행 ←
        for (int j = 0; j < C - 1; j++) {
            mimon[0][j][0] = mimon[0][j + 1][0];
        }
        // (C - 1)번 열 ↑
        for (int i = 0; i < ac1; i++) {
            mimon[i][C - 1][0] = mimon[i + 1][C - 1][0];
        }
        // ac1번 행 →
        for (int j = C - 1; j > 1; j--) {
            mimon[ac1][j][0] = mimon[ac1][j - 1][0];
        }
        // 공기 청정기 바로 오른쪽 칸 비우기
        mimon[ac1][1][0] = 0;
        
        // ---------- 위 칸 반시계 공기청정 끝 ----------

        // ---------- 아래 칸 시계 공기청정 시작 ----------
        // 공기청정기 바로 아래 칸 비우기
        mimon[ac2 + 1][0][0] = 0;
        // 0번 열 ↑
        for (int i = ac2 + 1; i < R - 1; i++) {
            mimon[i][0][0] = mimon[i + 1][0][0];
        }
        // (R - 1)번 행 ←
        for (int j = 0; j < C - 1; j++) {
            mimon[R - 1][j][0] = mimon[R - 1][j + 1][0];
        }
        // (C - 1)번 열↓
        for (int i = R - 1; i > ac2; i--) {
            mimon[i][C - 1][0] = mimon[i - 1][C - 1][0];
        }
        // ac2번 행 →
        for (int j = C - 1; j > 1; j--) {
            mimon[ac2][j][0] = mimon[ac2][j - 1][0];
        }
        // 공기 청정기 바로 오른쪽 칸 비우기
        mimon[ac2][1][0] = 0;
        // ---------- 아래 칸 반시계 공기청정 끝 ----------
    }
  }