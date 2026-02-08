import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    
    static int N;
    static int max = 0;
    
    // main 함수
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        int[][] first_arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                first_arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 진짜 최대
        int rmax = 0;

        // 네 방향 호출해서 진짜 최대 구하기
        for (int i = 0; i < 4; i++) {
            move(first_arr, 0, i);
            if (max > rmax)
                rmax = max;
        }

        System.out.println(rmax);
        
    }

    // move 함수
    static void move(int[][] arr, int time, int dir) {
        // 5번 움직였으면 최대값 구하고 리턴
        if (time >= 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > max) max = arr[i][j];
                }
            }
            return;
        }

        // 이전 배열 저장
        int[][] before = new int[N][N];
        for (int i = 0; i < N; i++) {
            before[i] = arr[i].clone();
        }

        // arr 변형 시작
        Deque<Integer> emptyIndex = new ArrayDeque<>();
        
        switch (dir) {
            // 왼쪽(dir == 0) 일 때
            case 0:
                for (int i = 0; i < N; i++) {
                    // [1단계] 합치기
                    int x = -1, y = -1, num = 0;
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == 0) continue;
                        
                        if (num == 0) { // 기준값 잡기
                            num = arr[i][j];
                            x = i; y = j;
                        } else if (num == arr[i][j]) { // 합치기
                            arr[x][y] *= 2;
                            arr[i][j] = 0;
                            num = 0;
                        } else { // 다른 숫자면 기준값 갱신
                            num = arr[i][j];
                            x = i; y = j;
                        }
                    }
                    // [2단계] 왼쪽으로 땡기기
                    emptyIndex.clear();
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == 0) {
                            emptyIndex.offer(j);
                        } else if (!emptyIndex.isEmpty()) {
                            int e = emptyIndex.poll();
                            arr[i][e] = arr[i][j];
                            arr[i][j] = 0;
                            emptyIndex.offer(j);
                        }
                    }
                }
                break;
        
            // 오른쪽(dir == 1) 일 때
            case 1:
                for (int i = 0; i < N; i++) {
                    // [1단계] 합치기 (오른쪽부터 탐색)
                    int x = -1, y = -1, num = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (arr[i][j] == 0) continue;
        
                        if (num == 0) {
                            num = arr[i][j];
                            x = i; y = j;
                        } else if (num == arr[i][j]) {
                            arr[x][y] *= 2;
                            arr[i][j] = 0;
                            num = 0;
                        } else {
                            num = arr[i][j];
                            x = i; y = j;
                        }
                    }
                    // [2단계] 오른쪽으로 땡기기
                    emptyIndex.clear();
                    for (int j = N - 1; j >= 0; j--) {
                        if (arr[i][j] == 0) {
                            emptyIndex.offer(j);
                        } else if (!emptyIndex.isEmpty()) {
                            int e = emptyIndex.poll();
                            arr[i][e] = arr[i][j];
                            arr[i][j] = 0;
                            emptyIndex.offer(j);
                        }
                    }
                }
                break;
        
            // 위쪽(dir == 2) 일 때
            case 2:
                for (int j = 0; j < N; j++) {
                    // [1단계] 합치기 (위에서 아래로)
                    int x = -1, y = -1, num = 0;
                    for (int i = 0; i < N; i++) {
                        if (arr[i][j] == 0) continue;
        
                        if (num == 0) {
                            num = arr[i][j];
                            x = i; y = j;
                        } else if (num == arr[i][j]) {
                            arr[x][y] *= 2;
                            arr[i][j] = 0;
                            num = 0;
                        } else {
                            num = arr[i][j];
                            x = i; y = j;
                        }
                    }
                    // [2단계] 위로 땡기기
                    emptyIndex.clear();
                    for (int i = 0; i < N; i++) {
                        if (arr[i][j] == 0) {
                            emptyIndex.offer(i);
                        } else if (!emptyIndex.isEmpty()) {
                            int e = emptyIndex.poll();
                            arr[e][j] = arr[i][j];
                            arr[i][j] = 0;
                            emptyIndex.offer(i);
                        }
                    }
                }
                break;
        
            // 아래쪽(dir == 3) 일 때
            case 3:
                for (int j = 0; j < N; j++) {
                    // [1단계] 합치기 (아래에서 위로)
                    int x = -1, y = -1, num = 0;
                    for (int i = N - 1; i >= 0; i--) {
                        if (arr[i][j] == 0) continue;
        
                        if (num == 0) {
                            num = arr[i][j];
                            x = i; y = j;
                        } else if (num == arr[i][j]) {
                            arr[x][y] *= 2;
                            arr[i][j] = 0;
                            num = 0;
                        } else {
                            num = arr[i][j];
                            x = i; y = j;
                        }
                    }
                    // [2단계] 아래로 땡기기
                    emptyIndex.clear();
                    for (int i = N - 1; i >= 0; i--) {
                        if (arr[i][j] == 0) {
                            emptyIndex.offer(i);
                        } else if (!emptyIndex.isEmpty()) {
                            int e = emptyIndex.poll();
                            arr[e][j] = arr[i][j];
                            arr[i][j] = 0;
                            emptyIndex.offer(i);
                        }
                    }
                }
                break;
        }
        
        // 네 방향 호출
        for (int d = 0; d < 4; d++) {
            move(arr, time + 1, d);
        }
        
        // 백트래킹
        for (int i = 0; i < N; i++) {
            arr[i] = before[i].clone();
        }
    }
  }
