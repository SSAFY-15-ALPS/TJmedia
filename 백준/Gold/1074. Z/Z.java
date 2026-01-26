import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    // 배열 풀이(메모리 초과ㅠㅠ)
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st;
    // st = new StringTokenizer(br.readLine());
    // int N = Integer.parseInt(st.nextToken());
    // int r = Integer.parseInt(st.nextToken());
    // int c = Integer.parseInt(st.nextToken());

    // // 초기 dp값
    // int[][] dp_before = {{0, 1}, {2, 3}};

    // // N까지 dp 모두 채우기
    // for (int i=2; i<=N; i++) {
    //   // 사이즈 정하기
    //   int prev = 1 << (i-1);
    //   int curr = 1 << i;
    //   int[][] dp = new int[curr][curr];
      
    //   // 사분면 한개 크기
    //   int size = prev*prev;
      
    //   // 다음 dp 채우기
    //   for (int j=0; j<curr; j++) {
    //     for (int k=0; k<curr; k++) {
    //       // 0,0은 0
    //       if (j == 0 && k == 0) dp[j][k] = 0;
    //       // 기존에 있던 것은 그대로(2사분면)
    //       else if (j < prev && k < prev) dp[j][k] = dp_before[j][k];
    //       // 1사분면
    //       else if (j < prev && k >= prev) dp[j][k] = dp_before[j][k-prev] + size;
    //       // 3사분면
    //       else if (j >= prev && k < prev) dp[j][k] = dp_before[j-prev][k] + (size*2);
    //       // 4사분면
    //       else if (j >= prev && k >= prev) dp[j][k] = dp_before[j-prev][k-prev] + (size*3);
    //     }
    //   }
    //   dp_before = dp.clone();
    // }
    // System.out.println(dp_before[r][c]);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    find(N, r, c);
    System.out.println(answer);
  }

    public static void find(int N, int r, int c) {
    if (N == -1) return;
    
    N--; // N-1 사각형으로 줄이기
    int size = (int) Math.pow(2, N); // N-1 사각형 한 변의 길이
    int area = size*size; // N-1 사각형 면적

    // System.out.printf("size: %d, area: %d, answer: %d \n", size, area, answer);

    if (r < size && c < size) {
      find(N, r, c);
    }
    else if (r < size && c >= size) {
      answer += area;
      find(N, r, c-size);
    }
    else if (r >= size && c < size) {
      answer += area*2;
      find(N, r-size, c);
    }
    else if (r >= size && c >= size) {
      answer += area*3;
      find(N, r-size, c-size);
    }
  }
}
