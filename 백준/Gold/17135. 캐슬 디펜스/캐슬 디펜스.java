import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N, M, D;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 격자판 배열
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;  j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대로 죽일 수 있는 적의 수
        int max = 0;
        // 현재 궁수 위치에서 죽인 적의 수
        int cnt = 0;
        
        // 궁수 위치 정해줘(조합)
        int[] arch1, arch2, arch3;
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {

                    // 격자판 배열 복사
                    int[][] enemy = new int[N][M];
                    for (int a = 0; a < N; a++) {
                        enemy[a] = map[a].clone();
                    }

                    // 현재 궁수 위치에서 죽인 적의 수 0으로 초기화
                    cnt = 0;
                    
                    for (int depth = N; depth > 0; depth--) {
                        // 궁수 위치 초기화 (매번 한칸씩 앞으로 전진 == 적이 한칸씩 다가옴)
                        arch1 = new int[] {depth, i};
                        arch2 = new int[] {depth, j};
                        arch3 = new int[] {depth, k};

                        int[][] dead = new int[3][2];
    
                        // 어떤 적 쏠래? *3
                        outer:
                        for (int x = 1; x <= D; x++) {
                            for (int y = 1; y <= x; y++) {
                                // 범위 췍
                                if (depth - y >= 0 && i - (x - y) >= 0 &&
                                    enemy[depth - y][i - (x - y)] != 0) { // 적이 있는지 췍
                                    enemy[depth - y][i - (x - y)] = 2;
                                    dead[0] = new int[] {depth - y, i - (x - y)};
                                    break outer;
                                }
                            }
                            for (int y = x - 1; y > 0; y--) {
                                // 범위 췍
                                if (depth - y >= 0 && i + (x - y) < M &&
                                    enemy[depth - y][i + (x - y)] != 0) { // 적이 있는지 췍
                                    enemy[depth - y][i + (x - y)] = 2;
                                    dead[0] = new int[] {depth - y, i + (x - y)};
                                    break outer;
                                }
                            }
                        }
    
                        outer:
                        for (int x = 1; x <= D; x++) {
                            for (int y = 1; y <= x; y++) {
                                // 범위 췍
                                if (depth - y >= 0 && j - (x - y) >= 0 &&
                                    enemy[depth - y][j - (x - y)] != 0) { // 적이 있는지 췍
                                    enemy[depth - y][j - (x - y)] = 2;
                                    dead[1] = new int[] {depth - y, j - (x - y)};
                                    break outer;
                                }
                            }
                            for (int y = x - 1; y > 0; y--) {
                                // 범위 췍
                                if (depth - y >= 0 && j + (x - y) < M &&
                                    enemy[depth - y][j + (x - y)] != 0) { // 적이 있는지 췍
                                    enemy[depth - y][j + (x - y)] = 2;
                                    dead[1] = new int[] {depth - y, j + (x - y)};
                                    break outer;
                                }
                            }
                        }
    
                        outer:
                        for (int x = 1; x <= D; x++) {
                            for (int y = 1; y <= x; y++) {
                                // 범위 췍
                                if (depth - y >= 0 && k - (x - y) >= 0 &&
                                    enemy[depth - y][k - (x - y)] != 0) { // 적이 있는지 췍
                                    enemy[depth- y][k - (x - y)] = 2;
                                    dead[2] = new int[] {depth - y, k - (x - y)};
                                    break outer;
                                }
                            }
                            for (int y = x - 1; y > 0; y--) {
                                // 범위 췍
                                if (depth - y >= 0 && k + (x - y) < M &&
                                    enemy[depth - y][k + (x - y)] != 0) { // 적이 있는지 췍
                                    enemy[depth - y][k + (x - y)] = 2;
                                    dead[2] = new int[] {depth - y, k + (x - y)};
                                    break outer;
                                }
                            }
                        }
    
                        // 찜한 적(2로 표시함) -> 0으로 바꾸면서 개수 세기 
                        for (int[] d: dead) {
                            int x = d[0];
                            int y = d[1];
                            if (enemy[x][y] == 2) {
                                enemy[x][y] = 0;
                                cnt++;
                            }
                        }
                        // System.out.println(i + " " + j + " " + k + ", " + depth + ", " + cnt);
                    }
                    if (cnt > max) max = cnt;
                }
            }
        }
        System.out.println(max);
    }
}