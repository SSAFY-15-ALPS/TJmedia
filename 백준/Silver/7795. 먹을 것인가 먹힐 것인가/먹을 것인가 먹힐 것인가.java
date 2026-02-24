import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int T, N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            // 생명체 A
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            // 생명체 B
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
    
            // 정렬
            Arrays.sort(A); // 1 1 3 7 8
            Arrays.sort(B); // 1 3 6
    
            // 투포인터 시작
            int a = N - 1;
            int b = M - 1;
            int answer = 0;
            while (a >= 0) {
                if (A[a] > B[b]) {
                    answer += b + 1;
                    a--;
                }
                else {
                    b--;
                    if (b < 0) break;
                }
            }
            System.out.println(answer);
        }
    }
  }
