import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        // 입력 받기
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        int[] arr = new int[N*N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i*N + j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정렬
        Arrays.sort(arr);

        // 뒤에서 N번째 수 출력
        System.out.println(arr[arr.length-N]);   
    }
  }
