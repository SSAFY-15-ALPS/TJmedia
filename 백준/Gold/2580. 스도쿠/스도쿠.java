import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스도쿠 채우기
        int[][] sudoku = new int[9][9];
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                // 입력이 0이면 emtpy 배열에 추가
                if (sudoku[i][j] == 0) empty.add(new int[]{i, j});
            }
        }
        
        solve(sudoku, empty, 0, empty.size());
        
    }

    static void solve(int[][] sudoku, List<int[]> empty, int depth, int maxDepth) {
        // 빈 칸 다 채웠으면 배열 출력
        if (depth >= maxDepth) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf(sudoku[i][j] + " ");
                }
                System.out.println("");
            }
            System.exit(0);
        }

        // 예시 출력
        // System.out.println("-------" + depth + ", " + Arrays.toString(empty.get(depth)) + "-------");
        // for (int i = 0; i < 9; i++) {
        //     for (int j = 0; j < 9; j++) {
        //         System.out.printf(sudoku[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("-----------" + "끝" + "-----------");
        
        // 빈 칸 하나 불러오기
        int i = empty.get(depth)[0];
        int j = empty.get(depth)[1];

        // 빈 칸 채우기 로직 시작 ------------------------------------
        outer:
        for (int num = 1; num <= 9; num++) {
            // 가로(column) 췍
            for (int c = 0; c < 9; c++) {
                if (sudoku[c][j] == 0) continue; // 0일 때는 컨티뉴
                else {
                    // 가로줄에 같은 값이 있다면
                    if (sudoku[c][j] == num) {
                        // 다음 숫자로 넘어가기
                        continue outer;
                    }
                }
            }
            // 세로(row) 췍
            for (int r = 0; r < 9; r++) {
                if (sudoku[i][r] == 0) continue; // 0일 때는 컨티뉴
                else {
                    // 세로줄에 같은 값이 있다면
                    if (sudoku[i][r] == num) {
                        // 다음 숫자로 넘어가기
                        continue outer;
                    }
                }
            }
            // 네모칸 췍
            int iSqr = i / 3;
            int jSqr = j / 3;
            for (int x = iSqr * 3; x < iSqr * 3 + 3; x++) {
                for (int y = jSqr * 3; y < jSqr * 3 + 3; y++) {
                    if (sudoku[x][y] == 0) continue;
                    else {
                        if (sudoku[x][y] == num) {
                            continue outer;
                        }
                    }
                }
            }

            // 같은 숫자가 없음!! -> 빈 칸에 들어갈 숫자 찾았다
            sudoku[i][j] = num;
        // 빈 칸 채우기 로직 끝 ------------------------------------
        
            // 다음 칸 호출
            solve(sudoku, empty, depth + 1, maxDepth);

            // 백트래킹
            sudoku[i][j] = 0;
        }
    }
}