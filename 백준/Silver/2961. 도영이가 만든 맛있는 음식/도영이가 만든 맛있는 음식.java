import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    // 신, 쓴 초기화
    static int sour = 1, bitter = 0, cnt = 0, start = 0, min, N, sub;
    static int[][] spice;
    
    // 메인함수
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 재료 배열 저장
        spice = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            spice[i][0] = Integer.parseInt(st.nextToken());
            spice[i][1] = Integer.parseInt(st.nextToken());
        }

        // 재료 1개면 바로 |신-쓴| 리턴
        if (N == 1) {
            System.out.println(Math.abs(spice[0][0] - spice[0][1]));
            return;
        }

        // 재료 2개 이상이면 cook 호출
        sour = 1; bitter = 0; cnt = 0; start = 0; min = Math.abs(spice[0][0] - spice[0][1]);
        cook(sour, bitter, cnt, start);

        System.out.println(min);
    }
    
    // cook 함수
    static void cook(int sour, int bitter, int cnt, int start) {
        // 재료 추가했더니 sub이 0!
        if (cnt > 0) {
            if (sour - bitter == 0) {
                min = 0;
                return;
            }
            else {
                sub = Math.abs(sour - bitter);
                if (sub < min) min = sub;
            }
        }

        // 확인 출력
        // System.out.println(cnt + ". sour: " + sour + ", bitter: " + bitter + ", start: " + start);
            
        for (int j = start; j < N; j++) {
            
            // 재료 추가하고 cook 호출
            cook(sour * spice[j][0], bitter + spice[j][1], cnt + 1, j + 1);

        }
    }
  }